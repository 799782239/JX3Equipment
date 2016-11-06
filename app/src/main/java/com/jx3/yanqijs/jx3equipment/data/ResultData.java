package com.jx3.yanqijs.jx3equipment.data;

import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanqijs on 2016/11/4.
 */

public class ResultData {
    private static ResultData resultData;

    private GeneralEquipmentModel mData = new GeneralEquipmentModel();
    private List<GeneralEquipmentModel> mDatas = new ArrayList<>();

    public static ResultData getInstance() {
        if (resultData == null) {
            resultData = new ResultData();
        }
        return resultData;
    }

    public void add(GeneralEquipmentModel generalEquipmentModel) {
        if (mDatas.size() == 0) {
            mDatas.add(generalEquipmentModel);
            return;
        }
        for (int i = 0; i < mDatas.size(); i++) {
            if (mDatas.get(i).part.equals(generalEquipmentModel.part)) {
                mDatas.remove(i);
                break;
            }
        }
        mDatas.add(generalEquipmentModel);
    }

    public List<GeneralEquipmentModel> getmDatas() {
        return mDatas;
    }

    public void calculateTotal() {
        mData = null;
        mData = new GeneralEquipmentModel();
        if (mDatas.size() == 0)
            return;
        for (GeneralEquipmentModel temp : mDatas) {
            mData.equipmentScore += temp.equipmentScore;
            mData.stand += temp.stand;
            mData.money += temp.money;
            mData.outDefense += temp.outDefense;
            mData.innerDefense += temp.innerDefense;
            mData.constitution += temp.constitution;
            mData.attribute += temp.attribute;
            mData.attack += temp.attack;
            mData.special += temp.special;
            mData.specialEffect += temp.specialEffect;
            mData.broken += temp.broken;
            mData.hit += temp.hit;
            mData.wushuang += temp.wushuang;
            mData.resistSpecial += temp.resistSpecial;
            mData.resistAttack += temp.resistAttack;
            mData.weiwangxiaohao += temp.weiwangxiaohao;
            mData.banggongxiaohao += temp.banggongxiaohao;
            mData.xiayixiaohao += temp.xiayixiaohao;
        }
    }

    public GeneralEquipmentModel getmData() {
        return mData;
    }
}
