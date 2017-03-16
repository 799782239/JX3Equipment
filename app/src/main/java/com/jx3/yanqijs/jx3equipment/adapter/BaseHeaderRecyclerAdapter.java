package com.jx3.yanqijs.jx3equipment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanqijs on 2017/2/28.
 */

public class BaseHeaderRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerHelper> {
    private static final int HEADER_VIEW_TYPE = -0x100;
    private static final int FOOTER_VIEW_TYPE = -0x101;
    private List<Object> mHeaderData;
    private List<Object> mFooterData;

    @Override
    public BaseRecyclerHelper onCreateViewHolder(ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case HEADER_VIEW_TYPE:
//                return new BaseRecyclerHelper(get);
//            case FOOTER_VIEW_TYPE:
//                return new BaseRecyclerHelper();
//            case
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHelper holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mHeaderData.size() + mFooterData.size();
    }

    public void addHeader(View view, Object data) {
        mHeaderData.add(data);
    }
}
