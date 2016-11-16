package com.jx3.yanqijs.jx3equipment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;

/**
 * Created by yanqijs on 2016/11/16.
 */

public interface operate {
    @GET("prices/mgets")
    Call<String> getTest(@Part("skuIds") String sk, @Part("type") String type);
}
