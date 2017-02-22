package com.jx3.yanqijs.jx3equipment.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.jx3.yanqijs.jx3equipment.activity.BaseActivity;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by yanqijs on 2017/2/3.
 */

public class DefaultSubscriber<T> extends Subscriber<T> {
    private Context mContext;
    private String text;

    public DefaultSubscriber(Context mContext) {
        this.mContext = mContext;
    }

    public boolean setShowToast() {
        return true;
    }

    public boolean setShowLoading() {
        return true;
    }

    @Override
    public void onCompleted() {
        if (setShowLoading())
            ((BaseActivity) mContext).CloseLoadingProgress();
    }

    @Override
    public void onError(Throwable e) {
        Log.i("BaseOperateError", e.toString());
        if (e instanceof ConnectException) {
            text = "请检查是否联网";
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            try {
                text = httpException.response().errorBody().string();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e instanceof SocketTimeoutException) {
            text = "访问超时";
        } else {
            text = e.getMessage();
        }
        if (setShowLoading())
            ((BaseActivity) mContext).CloseLoadingProgress();
        if (setShowToast())
            BaseToast.getInstance(mContext).showToast(text);
    }

    @Override
    public void onNext(T obj) {
        if (setShowLoading())
            ((BaseActivity) mContext).CloseLoadingProgress();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (setShowLoading())
            ((BaseActivity) mContext).ShowLoadingProgress();
    }
}
