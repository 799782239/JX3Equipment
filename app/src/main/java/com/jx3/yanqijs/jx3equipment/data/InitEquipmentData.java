package com.jx3.yanqijs.jx3equipment.data;

import com.google.gson.Gson;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanqijs on 2016/11/3.
 */

public class InitEquipmentData {
    private List<GeneralEquipmentModel> datas = new ArrayList<>();
    HashMap<String, Object> map = new HashMap<String, Object>();

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
        baseEquipmentModel.constitution = 396;
        baseEquipmentModel.attribute = 110;
        baseEquipmentModel.attack = 335;
        baseEquipmentModel.special = 0;
        baseEquipmentModel.specialEffect = 0;
        baseEquipmentModel.broken = 281;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 83;
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
        baseEquipmentModel.constitution = 198;
        baseEquipmentModel.attribute = 55;
        baseEquipmentModel.attack = 56;
        baseEquipmentModel.special = 0;
        baseEquipmentModel.specialEffect = 0;
        baseEquipmentModel.broken = 140;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 41;
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
        baseEquipmentModel.outDefense = 69;
        baseEquipmentModel.innerDefense = 56;
        baseEquipmentModel.constitution = 297;
        baseEquipmentModel.attribute = 83;
        baseEquipmentModel.attack = 84;
        baseEquipmentModel.special = 149;
        baseEquipmentModel.specialEffect = 62;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 62;
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
        baseEquipmentModel.outDefense = 87;
        baseEquipmentModel.innerDefense = 69;
        baseEquipmentModel.constitution = 330;
        baseEquipmentModel.attribute = 92;
        baseEquipmentModel.attack = 93;
        baseEquipmentModel.special = 0;
        baseEquipmentModel.specialEffect = 0;
        baseEquipmentModel.broken = 234;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 69;
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
        baseEquipmentModel.outDefense = 43;
        baseEquipmentModel.innerDefense = 35;
        baseEquipmentModel.constitution = 231;
        baseEquipmentModel.attribute = 64;
        baseEquipmentModel.attack = 65;
        baseEquipmentModel.special = 116;
        baseEquipmentModel.specialEffect = 48;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 48;
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
        baseEquipmentModel.outDefense = 61;
        baseEquipmentModel.innerDefense = 49;
        baseEquipmentModel.constitution = 231;
        baseEquipmentModel.attribute = 64;
        baseEquipmentModel.attack = 65;
        baseEquipmentModel.special = 0;
        baseEquipmentModel.specialEffect = 0;
        baseEquipmentModel.broken = 164;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 48;
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
        baseEquipmentModel.outDefense = 78;
        baseEquipmentModel.innerDefense = 62;
        baseEquipmentModel.constitution = 330;
        baseEquipmentModel.attribute = 92;
        baseEquipmentModel.attack = 93;
        baseEquipmentModel.special = 165;
        baseEquipmentModel.specialEffect = 69;
        baseEquipmentModel.broken = 0;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 69;
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
        baseEquipmentModel.outDefense = 43;
        baseEquipmentModel.innerDefense = 35;
        baseEquipmentModel.constitution = 231;
        baseEquipmentModel.attribute = 64;
        baseEquipmentModel.attack = 65;
        baseEquipmentModel.special = 0;
        baseEquipmentModel.specialEffect = 0;
        baseEquipmentModel.broken = 164;
        baseEquipmentModel.hit = 0;
        baseEquipmentModel.wushuang = 0;
        baseEquipmentModel.resistSpecial = 0;
        baseEquipmentModel.resistAttack = 48;
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

    public Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }


        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }
}
