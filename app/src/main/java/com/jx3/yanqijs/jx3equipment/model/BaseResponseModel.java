package com.jx3.yanqijs.jx3equipment.model;

/**
 * Created by yanqijs on 2017/1/25.
 *
 * @param <T> 数据请求返回的数据结构
 */

public class BaseResponseModel<T> {
    public String errorCode;
    public String errorMessage;
    public T data;

    public boolean isSuccess() {
        return errorCode.equals("1");
    }
}
