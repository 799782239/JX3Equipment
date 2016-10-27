package com.jx3.yanqijs.jx3equipment.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;


/**
 * Created by yanqijs on 2016/3/7.
 */
public class BaseRecyclerHelper extends RecyclerView.ViewHolder implements View.OnClickListener {

    private SparseArray<View> mViews;
    private View itemView;
    private RecyclerImp mRecyclerImp;

    public BaseRecyclerHelper(View itemView, RecyclerImp mRecyclerImp) {
        super(itemView);
        this.itemView = itemView;
        mViews = new SparseArray<>();
        this.mRecyclerImp = mRecyclerImp;
        //设置点击事件
        itemView.setOnClickListener(this);
    }

    private <T extends View> T getView(int ViewId) {
        View view = mViews.get(ViewId);
        if (view == null) {
            view = itemView.findViewById(ViewId);
            mViews.put(ViewId, view);
        }
        return (T) view;
    }
    //-------------------设置view方法---------------------------

    public void setText(int ViewId, CharSequence value) {
        TextView textView = getView(ViewId);
        textView.setText(value);
    }

    public void setVisible(int ViewId, int type) {
        View view = getView(ViewId);
        view.setVisibility(type);
    }

    //--------------------设置事件监听----------------------------
    public void setOnClick(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
    }

    public void onClick(int viewId) {
        if (mRecyclerImp != null) {
            View view = getView(viewId);
            mRecyclerImp.OnItemClick(view, getAdapterPosition());
        }
    }

    @Override
    public void onClick(View v) {
        mRecyclerImp.OnItemClick(v, getAdapterPosition());
    }

}
