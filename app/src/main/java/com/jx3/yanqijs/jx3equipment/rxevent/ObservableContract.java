package com.jx3.yanqijs.jx3equipment.rxevent;

import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.M;

import rx.Observable;

/**
 * Created by yanqijs on 2016/12/13.
 */

public interface ObservableContract {
    //    Observable<GeneralEquipmentModel> getEquipment(int id);
    Observable<M> getJdId(String id, String type);
}
