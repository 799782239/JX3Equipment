package com.jx3.yanqijs.jx3equipment.adapter;

import android.content.Context;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;
import com.jx3.yanqijs.jx3equipment.model.ShowModel;

/**
 * Created by yanqijs on 2016/11/4.
 */

public class GeneralEquipmentAdapter extends BaseRecyclerAdapter<ShowModel> {
    /**
     * 构造方法不希望用户直接操作adapter中data数据,防止发生data被多个对象引用，要添加数据可通过{@link #add(Object),#addAll(List)}
     *
     * @param context
     * @param onRecyclerImp
     */
    public GeneralEquipmentAdapter(Context context, RecyclerImp onRecyclerImp) {
        super(context, onRecyclerImp);
    }

    @Override
    public void init(BaseRecyclerHelper helper, int position, ShowModel item) {
        helper.setText(R.id.item_title, item.key);
        helper.setText(R.id.item_content, item.value);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.item_equipment_detail;
    }

    @Override
    protected void setOnRecyclerImp(RecyclerImp onRecyclerImp) {

    }

    @Override
    protected void setFooter(boolean isFooter, int totalCount, int perCount) {

    }
}
