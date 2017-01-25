package com.jx3.yanqijs.jx3equipment.adapter;

import android.content.Context;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;

/**
 * Created by yanqijs on 2016/10/28.
 */

public class EquipmentAdapter extends BaseRecyclerAdapter<BaseEquipmentModel> {
    public EquipmentAdapter(Context context, RecyclerImp onRecyclerImp) {
        super(context, onRecyclerImp);
    }

    @Override
    public void init(BaseRecyclerHelper helper, int position, BaseEquipmentModel item) {
        helper.setText(R.id.text_name, item.equipmentName);
        helper.setText(R.id.text_stand, item.stand);
        String temp = String.format("%.0f", item.qualityRank);
        helper.setText(R.id.text_quality_rank, temp);
        helper.setText(R.id.from, item.from);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.item_equipment_choose;
    }

    @Override
    protected void setOnRecyclerImp(RecyclerImp onRecyclerImp) {

    }

    @Override
    protected void setFooter(boolean isFooter, int totalCount, int perCount) {

    }
}
