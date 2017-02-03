package com.jx3.yanqijs.jx3equipment.utils;

import android.content.Context;
import android.util.Log;

import com.jx3.yanqijs.jx3equipment.activity.BaseActivity;

import rx.Subscriber;

/**
 * Created by yanqijs on 2017/2/3.
 */

public class DefaultSubscriber<T> extends Subscriber<T> {
    private Context mContext;

    public DefaultSubscriber(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCompleted() {
        ((BaseActivity) mContext).CloseLoadingProgress();
    }

    @Override
    public void onError(Throwable e) {
        Log.i("BaseOperateError", e.toString());
        ((BaseActivity) mContext).CloseLoadingProgress();
    }

    @Override
    public void onNext(T obj) {
        ((BaseActivity) mContext).CloseLoadingProgress();
    }

    @Override
    public void onStart() {
        super.onStart();
        ((BaseActivity) mContext).ShowLoadingProgress();
    }
}
