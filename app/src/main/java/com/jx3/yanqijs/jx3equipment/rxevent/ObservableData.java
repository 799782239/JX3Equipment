package com.jx3.yanqijs.jx3equipment.rxevent;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jx3.yanqijs.jx3equipment.activity.BaseActivity;
import com.jx3.yanqijs.jx3equipment.model.BaseArrayOperateModel;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.jx3.yanqijs.jx3equipment.operate.BaseOperate;
import com.jx3.yanqijs.jx3equipment.operate.BaseOperateImp;

import rx.Observable;
import rx.Subscriber;
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
        public JsonArray mArrayObj;
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
            BaseArrayOperateModel arrayDatas = null;
            if (obj instanceof BaseArrayOperateModel) {
                arrayDatas = (BaseArrayOperateModel) obj;
            }
            ((BaseActivity) mContext).CloseLoadingProgress();

            if (!arrayDatas.errorCode.equals("0")) {
                Toast.makeText(mContext, arrayDatas.errorMessage + "", Toast.LENGTH_SHORT).show();
                return;
            }
            mArrayObj = arrayDatas.data;
        }

        @Override
        public void onStart() {
            super.onStart();
            ((BaseActivity) mContext).ShowLoadingProgress();
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
    public Observable<BaseArrayOperateModel> getListData(String part, String min, String max) {
        return BaseOperate.getInstance().getOperate().getListData(part, min, max);
    }
}
