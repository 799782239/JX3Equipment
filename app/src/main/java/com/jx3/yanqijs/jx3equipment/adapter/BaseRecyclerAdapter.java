package com.jx3.yanqijs.jx3equipment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;

import java.util.ArrayList;
import java.util.List;

/**
 * recyclerView 基础类，便于快速创建recycler
 * 集成后只需要设置layout，以及view事件即可
 * <p>
 * <p>
 * Created by yanqijs on 2016/3/7.
 *
 * @param <T> 数据类型
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHelper> {

    private List<T> mDatas;
    protected List<View> mFooter = new ArrayList<>();
    protected List<View> mHeader = new ArrayList<>();
    private BaseRecyclerHelper mViewHolder;
    protected Context context;
    protected boolean isFooter = false;

    protected int totalCount;
    protected int perCount;


    protected RecyclerImp onRecyclerImp;

    /**
     * 构造方法不希望用户直接操作adapter中data数据,防止发生data被多个对象引用，要添加数据可通过{@link #add(Object),#addAll(List)}
     *
     * @param context
     * @param onRecyclerImp
     */
    public BaseRecyclerAdapter(Context context, RecyclerImp onRecyclerImp) {
        this.mDatas = new ArrayList<>();
        this.context = context;
        this.onRecyclerImp = onRecyclerImp;
    }

    @Override
    public BaseRecyclerHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                //注意item加载，要写parent，不然item最外层布局不生效
                mViewHolder = new BaseRecyclerHelper(LayoutInflater.from(context).inflate(getLayoutID(), parent, false), onRecyclerImp);
                break;
            case 1:
                mViewHolder = new BaseRecyclerHelper(mFooter.get(0), onRecyclerImp);
                break;
        }
        return mViewHolder;
//        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHelper holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                init(holder, position, mDatas.get(position));
                break;
            case 1:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position > mDatas.size() - mHeader.size()) {
            return 1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
//        super.getItemCount();
//        return mDatas.size()+super.getItemCount();
        return mDatas.size();
    }

    //--------------------添加数据-------------------------

    public void addAll(List<T> datas) {
        this.mDatas.clear();
        this.mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void add(T data) {
        this.mDatas.add(data);
        notifyDataSetChanged();
    }
    //----------------------------添加底部------------------------

    public void addFooter(View view) {
        mFooter.clear();
        mFooter.add(view);
        notifyDataSetChanged();
    }

    public void removeFooter() {
        mFooter.clear();
        notifyDataSetChanged();
    }

    //----------------------------添加头部------------------------
    public void addHeader(View view) {
        mHeader.clear();
        mHeader.add(view);
        notifyDataSetChanged();
    }

    public void removeHeader() {
        mHeader.clear();
        notifyDataSetChanged();
    }

    //---------------------得到数据------------------------------
    public T getData(int position) {
        return this.mDatas.get(position);
    }


    //-----------------------删除数据-----------------------
    public void remove(int position) {
        this.mDatas.remove(position);
    }

    public void removeAll() {
        this.mDatas.clear();
    }

    //----------------------实现item构建的方法--------------------------

    public abstract void init(BaseRecyclerHelper helper, int position, T item);

    //-------------------------得到item布局----------------------------------

    protected abstract int getLayoutID();

    protected abstract void setOnRecyclerImp(RecyclerImp onRecyclerImp);

    protected abstract void setFooter(boolean isFooter, int totalCount, int perCount);

}
