package com.dang.yanqijs.base.rxevent;

import com.dang.yanqijs.base.model.BaseResponseModel;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yanqijs on 2017/3/17.
 */

public class BaseObservableData {
    private static BaseObservableData mData;

    public static BaseObservableData getInstance() {
        if (mData == null) {
            mData = new BaseObservableData();
        }
        return mData;
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
     * 对网络接口返回的Response进行分割操作{@link BaseResponseModel<T>},{@link BaseResponseModel#errorCode}为错误码，
     * {@link BaseResponseModel#errorMessage}为错误信息，{@link BaseResponseModel#data}为需要的数据。
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
     * 自定义异常，当接口返回的{@link BaseResponseModel#errorCode}不为{1}时，需要跑出此异常
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
}
