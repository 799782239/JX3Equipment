package com.jx3.yanqijs.jx3equipment.rxevent;

import com.jx3.yanqijs.jx3equipment.BaseOperate;
import com.jx3.yanqijs.jx3equipment.Operate;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;

import rx.Observable;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class ObservableData implements ObservableContract {
    @Override
    public Observable<GeneralEquipmentModel> getEquipment(int id) {
        BaseOperate.getInstance().getOperate(Operate.class);
        return;
    }
}
