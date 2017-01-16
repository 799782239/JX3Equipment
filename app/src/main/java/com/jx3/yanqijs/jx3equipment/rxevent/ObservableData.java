package com.jx3.yanqijs.jx3equipment.rxevent;

import com.jx3.yanqijs.jx3equipment.BaseOperate;
import com.jx3.yanqijs.jx3equipment.BaseOperateImp;
import com.jx3.yanqijs.jx3equipment.model.M;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class ObservableData implements ObservableContract {

    private static ObservableData mData;

    public static ObservableData getInstance() {
        if (mData == null) {
            mData = new ObservableData();
        }
        return mData;
    }

    @Override
    public Observable<M> getJdId(String id, String type) {
        BaseOperateImp baseOperateImp = BaseOperate.getInstance().getOperate(BaseOperateImp.class);
        return baseOperateImp.getTest(id, type);
//                .flatMap(new Func1<List<M>, Observable<M>>() {
//            @Override
//            public Observable<M> call(List<M> ms) {
//                return Observable.from(ms);
//            }
//        });
    }
}
