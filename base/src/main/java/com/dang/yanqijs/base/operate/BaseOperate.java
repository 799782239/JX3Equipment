package com.dang.yanqijs.base.operate;

/**
 * Created by yanqijs on 2016/12/13.
 */

public class BaseOperate<T> {
    public Class<T> object;


    public T getOperate() {
        T baseOperateImp = BaseRetrofit.getInstance().getRetrofit().create(object);
        return baseOperateImp;
    }

}
