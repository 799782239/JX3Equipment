package com.jx3.yanqijs.jx3equipment.operate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.jx3.yanqijs.jx3equipment.BaseApplication;
import com.jx3.yanqijs.jx3equipment.model.BaseResponseModel;
import com.jx3.yanqijs.jx3equipment.utils.Constant;
import com.jx3.yanqijs.jx3equipment.utils.WebStatusUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class BaseOperate {
    private final static String TAG = "BaseOperate";
    private int connectTime = 30;//超时时间

    public BaseOperate() {
        LoggingInterceptor interceptor = new LoggingInterceptor();
//        interceptor.setLevel(LoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(connectTime, TimeUnit.SECONDS)
                .cache(cache())
//                .addNetworkInterceptor(authorizationInterceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 设置缓存
     *
     * @return
     */
    private Cache cache() {
        final File baseDir = new File(BaseApplication.getInstance().getExternalCacheDir(), "response");
        return new Cache(baseDir, 10 * 1024 * 1024);
    }


    private static BaseOperate mBaseOperate;

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;

    public static BaseOperate getInstance() {
        if (mBaseOperate == null) {
            mBaseOperate = new BaseOperate();
        }
        return mBaseOperate;
    }

    public BaseOperateImp getOperate(Class<BaseOperateImp> object) {
        BaseOperateImp baseOperateImp = mRetrofit.create(object);
        return baseOperateImp;
    }

    public BaseOperateImp getOperate() {
        BaseOperateImp baseOperateImp = mRetrofit.create(BaseOperateImp.class);
        return baseOperateImp;
    }

    /**
     * 加入通用参数
     *
     * @return
     */
    private String getBaseParams() {
        StringBuffer str = new StringBuffer();
        str.append("&udid=" + "123");
        return str.toString();
    }

    /**
     * 拦截器
     */
    private class LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.i(TAG, "BaseOperate:" + request.url() + "");
            Request newRequest = new Request.Builder()
                    .url(request.url() + getBaseParams())
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
            if (WebStatusUtils.isConnectWeb()) {
                int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .build();
                Log.i(TAG, "response:" + response + "");
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
                Log.i(TAG, "responseCache:" + response + "");
            }
            return response;
        }
    }
}
