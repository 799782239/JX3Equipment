package com.dang.yanqijs.base.application;

import android.app.Application;

/**
 * Created by yanqijs on 2017/1/19.
 */

public class BaseApplication extends Application {
    private static BaseApplication mApp;

    public static BaseApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
}
