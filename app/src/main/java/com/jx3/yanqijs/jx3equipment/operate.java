package com.jx3.yanqijs.jx3equipment;

import com.jx3.yanqijs.jx3equipment.model.M;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanqijs on 2016/11/16.
 */

public interface Operate {
    @GET("prices/mgets")
    Observable<List<M>> getTest(@Query("skuIds") String sk, @Query("type") String type);
}
