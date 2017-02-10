package com.jx3.yanqijs.jx3equipment.event;

import com.jx3.yanqijs.jx3equipment.data.ResultData;
import com.jx3.yanqijs.jx3equipment.model.ShowModel;

import java.util.List;

/**
 * Created by yanqijs on 2017/1/17.
 */

public class ShowResultEvent {
    public List<ShowModel> result;

    public ShowResultEvent(List<ShowModel> showModels) {
        this.result = showModels;
    }

}
