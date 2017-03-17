package com.jx3.yanqijs.jx3equipment.operate;

import com.dang.yanqijs.base.operate.BaseAddImpOperate;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class Operate extends BaseAddImpOperate<BaseOperateImp> {

    @Override
    public Class<BaseOperateImp> setOperateImp() {
        return BaseOperateImp.class;
    }

    @Override
    public BaseOperateImp getOperate() {
        return super.getOperate();
    }
}
