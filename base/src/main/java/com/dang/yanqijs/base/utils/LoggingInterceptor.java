package com.dang.yanqijs.base.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yanqijs on 2017/3/20.
 */

public class LoggingInterceptor implements Interceptor {
    private final static String TAG = "BaseOperate";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.i(TAG, "BaseOperate:" + request.url() + "");
        Request newRequest = new Request.Builder()
                .url(request.url())
                .headers(request.headers())
                .build();
//            chain.connection();
        //加验证头
//            Request.Builder requestBuilder = originalRequest.newBuilder()
//                    //Basic Authentication,也可用于token验证,OAuth验证
//                    .header("Authorization", basic)
//                    .header("Accept", "application/json")
//                    .method(originalRequest.method(), originalRequest.body());
        Log.i(TAG, "BaseOperate:" + newRequest.url() + "");
        Response response = chain.proceed(newRequest);
//        if (WebStatusUtils.isConnectWeb()) {
//            int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
//            response.newBuilder()
//                    .header("Cache-Control", "public, max-age=" + maxAge)
//                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                    .build();
//            Log.i(TAG, "response:" + response + "");
//        } else {
//            int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
//            response.newBuilder()
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                    .removeHeader("Pragma")
//                    .build();
//            Log.i(TAG, "responseCache:" + response + "");
//        }

        return response;
    }
}
