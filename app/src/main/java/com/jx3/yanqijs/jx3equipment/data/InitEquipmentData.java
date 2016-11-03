package com.jx3.yanqijs.jx3equipment.data;

import com.google.gson.Gson;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanqijs on 2016/11/3.
 */

public class InitEquipmentData {
    private List<GeneralEquipmentModel> datas = new ArrayList<>();

    private static InitEquipmentData initEquipmentData;

    public static InitEquipmentData getInstance() {
        if (initEquipmentData == null) {
            initEquipmentData = new InitEquipmentData();
        }
        return initEquipmentData;
    }

    public String initData() {

        GeneralEquipmentModel baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100001;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖刀";
        baseEquipmentModel.equipmentScore = 2290;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "武器";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100002;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖囊";
        baseEquipmentModel.equipmentScore = 1145;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "暗器";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100003;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖帽";
        baseEquipmentModel.equipmentScore = 1717;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "帽子";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100004;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖衣";
        baseEquipmentModel.equipmentScore = 1908;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "衣服";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100005;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖带";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "腰带";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100006;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖护腕";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "护腕";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100007;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖裤";
        baseEquipmentModel.equipmentScore = 1908;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "下装";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new GeneralEquipmentModel();
        baseEquipmentModel.pId = 100008;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖鞋";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "鞋子";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        baseEquipmentModel.money = 1075;
        baseEquipmentModel.outDefense = 0;
        baseEquipmentModel.innerDefense = 0;
        baseEquipmentModel.constitution = 214;
        baseEquipmentModel.attribute = 59;
        baseEquipmentModel.attack = 60;
        baseEquipmentModel.special = 107;
        baseEquipmentModel.specialEffect = 45;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 45;
        baseEquipmentModel.xiaohao = "威望|50400";
        datas.add(baseEquipmentModel);
        Gson gson = new Gson();
        return gson.toJson(datas);
    }

    public List<GeneralEquipmentModel> getData() {
        return datas;
    }

    public GeneralEquipmentModel find(int pId) {
        for (GeneralEquipmentModel generalEquipmentModel : datas) {
            if (generalEquipmentModel.pId == pId) {
                return generalEquipmentModel;
            }
        }
        return null;
    }
}
