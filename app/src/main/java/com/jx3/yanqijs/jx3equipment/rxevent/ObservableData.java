package com.jx3.yanqijs.jx3equipment.rxevent;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.jx3.yanqijs.jx3equipment.activity.BaseActivity;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.BaseResponseModel;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.jx3.yanqijs.jx3equipment.operate.BaseOperate;
import com.jx3.yanqijs.jx3equipment.operate.BaseOperateImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class ObservableData implements ObservableContract {

    private static ObservableData mData;

    public static ObservableData getInstance() {
        if (mData == null) {
            mData = new ObservableData();
        }
        return mData;
    }

    public static class DefaultSub extends Subscriber<Object> {
        private Context mContext;
        public JsonObject mObj;

        public DefaultSub(Context context) {
            this.mContext = context;
        }

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.i("BaseOperateError", e.toString());
            ((BaseActivity) mContext).CloseLoadingProgress();
        }

        @Override
        public void onNext(Object obj) {
            ((BaseActivity) mContext).CloseLoadingProgress();
        }

        @Override
        public void onStart() {
            super.onStart();
            ((BaseActivity) mContext).ShowLoadingProgress();
        }
    }

    protected <T> Observable.Transformer<BaseResponseModel<T>, T> applySchedulers() {
//        return (Observable.Transformer<BaseResponseModel<T>, T>) transformer;
        return (Observable.Transformer<BaseResponseModel<T>, T>) transformer;
    }

    Observable.Transformer transformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(new Func1() {
                        @Override
                        public Object call(Object o) {
                            return flatResponse((BaseResponseModel<Object>) o);
                        }
                    });
        }
    };

    /**
     * 对网络接口返回的Response进行分割操作
     *
     * @param response
     * @param <T>
     * @return
     */
    public <T> Observable<T> flatResponse(final BaseResponseModel<T> response) {
        return Observable.create(new Observable.OnSubscribe<T>() {

            @Override
            public void call(Subscriber<? super T> subscriber) {
                if (response.isSuccess()) {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(response.data);
                    }
                } else {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(new APIException(response.errorCode, response.errorMessage));
                    }
                    return;
                }

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }

            }
        });
    }

    /**
     * 自定义异常，当接口返回的{@link Response#code}不为{@link Constant#OK}时，需要跑出此异常
     * eg：登陆时验证码错误；参数为传递等
     */
    public static class APIException extends Exception {
        public String code;
        public String message;

        public APIException(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    @Override
    public Observable<M> getJdId(String id, String type) {
        BaseOperateImp baseOperateImp = BaseOperate.getInstance().getOperate();
        return baseOperateImp.getTest(id, type).subscribeOn(Schedulers.io());
//                .flatMap(new Func1<List<M>, Observable<M>>() {
//            @Override
//            public Observable<M> call(List<M> ms) {
//                return Observable.from(ms);
//            }
//        });
    }


    @Override
    public Observable<List<BaseEquipmentModel>> getData(String part, String min, String max) {
        return BaseOperate.getInstance().getOperate().getListData(part, min, max)
                .compose(this.<List<BaseEquipmentModel>>applySchedulers());
    }
}
