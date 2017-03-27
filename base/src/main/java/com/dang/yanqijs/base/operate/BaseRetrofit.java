package com.dang.yanqijs.base.operate;

import com.dang.yanqijs.base.application.BaseApplication;
import com.dang.yanqijs.base.utils.Constant;
import com.dang.yanqijs.base.utils.LoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yanqijs on 2017/3/20.
 */

public class BaseRetrofit {
    private static BaseRetrofit mBaseRetrofit;
    private int connectTime = 30;//超时时间

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;

    public static BaseRetrofit getInstance() {
        if (mBaseRetrofit == null) {
            mBaseRetrofit = new BaseRetrofit();
        }
        return mBaseRetrofit;
    }

    public BaseRetrofit() {
        mOkHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new LoggingInterceptor())
                .retryOnConnectionFailure(true)
                .connectTimeout(connectTime, TimeUnit.SECONDS)
//                .cache(cache())
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
}
