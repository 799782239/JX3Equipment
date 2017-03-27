package com.jx3.yanqijs.jx3equipment.rxevent;

import com.dang.yanqijs.base.rxevent.BaseObservableData;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.dang.yanqijs.base.operate.BaseOperate;
import com.jx3.yanqijs.jx3equipment.operate.BaseOperateImp;
import com.jx3.yanqijs.jx3equipment.operate.Operate;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class ObservableData extends BaseObservableData implements ObservableContract {


    @Override
    public Observable<M> getJdId(String id, String type) {
        BaseOperateImp baseOperateImp = new Operate().getOperate();
        return baseOperateImp.getTest(id, type).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public Observable<List<BaseEquipmentModel>> getData(String part, String min, String max) {
        return new Operate().getOperate().getListData(part, min, max)
                .compose(this.<List<BaseEquipmentModel>>applySchedulers());
    }

    @Override
    public Observable<GeneralEquipmentModel> getEquipmentData(String pid) {
        return new Operate().getOperate().getEquipmentData(pid)
                .compose(this.<GeneralEquipmentModel>applySchedulers());
    }
}
