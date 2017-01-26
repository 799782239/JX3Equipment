package com.jx3.yanqijs.jx3equipment.operate;

import com.jx3.yanqijs.jx3equipment.model.BaseResponseModel;
import com.jx3.yanqijs.jx3equipment.model.M;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanqijs on 2016/11/16.
 */

public interface BaseOperateImp {
    @GET("phptest/asd.php")
    Observable<M> getTest(@Query("skuIds") String sk, @Query("type") String type);

    @GET("phptest/EquipmentList.php")
    Observable<BaseResponseModel> getListData(@Query("part") String part, @Query("min") String min, @Query("max") String max);
}
