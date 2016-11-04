package com.jx3.yanqijs.jx3equipment.adapter;

import android.content.Context;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.data.ShowData;
import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;

import java.util.Map;

/**
 * Created by yanqijs on 2016/11/4.
 */

public class GeneralEquipmentAdapter extends BaseRecyclerAdapter<ShowData.DetailData> {
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
    public void init(BaseRecyclerHelper helper, int position, ShowData.DetailData item) {
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
