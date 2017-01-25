package com.jx3.yanqijs.jx3equipment.operate;

import android.util.Log;

import com.jx3.yanqijs.jx3equipment.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class BaseOperate {
    private final static String TAG = "BaseOperate";
    private int connectTime = 30;

    public BaseOperate() {
        LoggingInterceptor interceptor = new LoggingInterceptor();
//        interceptor.setLevel(LoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(connectTime, TimeUnit.SECONDS)
//                .addNetworkInterceptor(authorizationInterceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.191.1/")
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private Cache cache() {
        final File baseDir = BaseApplication.getInstance().getExternalCacheDir();
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

    class LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.i(TAG, "BaseOperate:" + request.url() + "");
//            chain.connection();
            //加验证头
//            Request.Builder requestBuilder = originalRequest.newBuilder()
//                    //Basic Authentication,也可用于token验证,OAuth验证
//                    .header("Authorization", basic)
//                    .header("Accept", "application/json")
//                    .method(originalRequest.method(), originalRequest.body());
            Response response = chain.proceed(request);
//            Log.i(TAG, "BaseOperate:" + response.body().string() + "");
//设置缓存
//            Response.Builder responseBuilder =
//                    //Cache control设置缓存
//                    originalResponse.newBuilder().header("Cache-Control", cacheControl);
            return response;
        }
    }
}
