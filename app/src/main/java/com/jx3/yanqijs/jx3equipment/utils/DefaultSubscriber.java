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
        if (e instanceof ConnectException) {
            Toast.makeText(mContext, "请检查是否联网", Toast.LENGTH_SHORT).show();
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            try {
                String errorBody = httpException.response().errorBody().string();
                //TODO: parse To JSON Obj

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e instanceof SocketTimeoutException) {
            Toast.makeText(mContext, "访问超时", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
