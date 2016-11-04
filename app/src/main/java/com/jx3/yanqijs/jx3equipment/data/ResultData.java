package com.jx3.yanqijs.jx3equipment.data;

/**
 * Created by yanqijs on 2016/11/4.
 */

public class ResultData {
    private static ResultData resultData;

    public static ResultData getInstance() {
        if (resultData == null) {
            resultData = new ResultData();
        }
        return resultData;
    }
}
