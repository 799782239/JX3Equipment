package com.jx3.yanqijs.jx3equipment.rxevent;

import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.M;

import java.util.List;

import rx.Observable;

/**
 * Created by yanqijs on 2016/12/13.
 */

public interface ObservableContract {
    //    Observable<GeneralEquipmentModel> getEquipment(int id);
//    Observable<M> getJdId(String id, String type);
    Observable<M> getJdId();

    Observable<List<BaseEquipmentModel>> getData(String part, String min, String max);

    Observable<GeneralEquipmentModel> getEquipmentData(String pid);
}
