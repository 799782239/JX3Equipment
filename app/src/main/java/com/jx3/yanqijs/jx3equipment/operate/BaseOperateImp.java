package com.jx3.yanqijs.jx3equipment.operate;

import com.dang.yanqijs.base.model.BaseResponseModel;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.M;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanqijs on 2016/11/16.
 */

public interface BaseOperateImp {
    @GET("phptest/asd.php")
    Observable<M> getTest(@Query("skuIds") String sk,
                          @Query("type") String type);

    @GET("phptest/equipment_list.php")
    Observable<BaseResponseModel<List<BaseEquipmentModel>>> getListData(@Query("part") String part,
                                                                        @Query("min") String min,
                                                                        @Query("max") String max);

    @GET("phptest/equipment_search.php")
    Observable<BaseResponseModel<GeneralEquipmentModel>> getEquipmentData(@Query("pid") String pid);
}
