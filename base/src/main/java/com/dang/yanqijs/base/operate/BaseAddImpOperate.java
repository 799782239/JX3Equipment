package com.dang.yanqijs.base.operate;

/**
 * Created by yanqijs on 2017/3/17.
 */

public abstract class BaseAddImpOperate<T> extends BaseOperate<T> {
    public abstract Class<T> setOperateImp();

    public BaseAddImpOperate() {
        super();
        object = setOperateImp();
    }

    @Override
    public T getOperate() {
        return super.getOperate();
    }
}
