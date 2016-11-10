package com.jx3.yanqijs.jx3equipment.data;

import com.google.gson.Gson;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanqijs on 2016/11/3.
 */

public class InitChooseData {
    private List<BaseEquipmentModel> datas = new ArrayList<>();

    private static InitChooseData initChooseData;

    public static InitChooseData getInstance() {
        if (initChooseData == null) {
            initChooseData = new InitChooseData();
        }
        return initChooseData;
    }

    public String initData() {

        BaseEquipmentModel baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100001;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖刀";
        baseEquipmentModel.equipmentScore = 2290;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "武器";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100002;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖囊";
        baseEquipmentModel.equipmentScore = 1145;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "暗器";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100003;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖帽";
        baseEquipmentModel.equipmentScore = 1717;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "帽子";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100004;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖衣";
        baseEquipmentModel.equipmentScore = 1908;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "衣服";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100005;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖带";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "腰带";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100006;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖护腕";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "护腕";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100007;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖裤";
        baseEquipmentModel.equipmentScore = 1908;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "下装";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100008;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖鞋";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "鞋子";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        //--------------------------------------------
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100001;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖刀";
//        baseEquipmentModel.equipmentScore = 2290;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "武器";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "破防";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100002;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖囊";
//        baseEquipmentModel.equipmentScore = 1145;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "暗器";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "破防";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100003;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖帽";
//        baseEquipmentModel.equipmentScore = 1717;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "帽子";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "会心";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100004;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖衣";
//        baseEquipmentModel.equipmentScore = 1908;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "衣服";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "破防";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100005;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖带";
//        baseEquipmentModel.equipmentScore = 1336;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "腰带";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "会心";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100006;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖护腕";
//        baseEquipmentModel.equipmentScore = 1336;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "护腕";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "破防";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100007;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖裤";
//        baseEquipmentModel.equipmentScore = 1908;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "下装";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "会心";
//        datas.add(baseEquipmentModel);
//        baseEquipmentModel = new BaseEquipmentModel();
//        baseEquipmentModel.pId = 100008;
//        baseEquipmentModel.equipmentName = "相思锦年·萧栖鞋";
//        baseEquipmentModel.equipmentScore = 1336;
//        baseEquipmentModel.qualityRank = 1060;
//        baseEquipmentModel.from = "竞技场";
//        baseEquipmentModel.part = "鞋子";
//        baseEquipmentModel.school = "霸刀";
//        baseEquipmentModel.stand = "破防";
//        datas.add(baseEquipmentModel);
        Gson gson = new Gson();
        return gson.toJson(datas);
    }

    public List<BaseEquipmentModel> getData() {
        return datas;
    }
}
