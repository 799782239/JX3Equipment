package com.dang.yanqijs.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jx3.yanqijs.jx3equipment.BaseApplication;

/**
 * Created by yanqijs on 2017/3/16.
 */

public class WebStatusUtils {
    public static boolean isConnectWeb() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) BaseApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mConnectivityManager != null) {
            NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
            if (mConnectivityManager.getActiveNetworkInfo() != null
                    && info.isConnected()) {
                return true;
            }
        }
        return false;
    }
}
