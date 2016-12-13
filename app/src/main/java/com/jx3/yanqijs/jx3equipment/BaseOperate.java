package com.jx3.yanqijs.jx3equipment;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class BaseOperate {
    public BaseOperate() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://p.3.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static BaseOperate mBaseOperate;
    private Retrofit mRetrofit;

    public static BaseOperate getInstance() {
        if (mBaseOperate == null) {
            mBaseOperate = new BaseOperate();
        }
        return mBaseOperate;
    }

    public Object getOperate(Class<Operate> object) {
        Class<Object> operate = mRetrofit.create((object);
        return operate;
    }

}
