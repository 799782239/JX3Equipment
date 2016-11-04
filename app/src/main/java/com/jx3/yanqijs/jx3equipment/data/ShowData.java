package com.jx3.yanqijs.jx3equipment.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanqijs on 2016/11/4.
 */

public class ShowData {

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    Map<String, String> map;

    public class DetailData {
        public String title;
        public String contentl;
    }
}
