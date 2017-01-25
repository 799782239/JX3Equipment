package com.jx3.yanqijs.jx3equipment.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.jx3.yanqijs.jx3equipment.R;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by yanqijs on 2016/10/27.
 */

public abstract class BaseActivity extends Activity {

    public Context mContext;
    private CompositeSubscription mSubscriptions;
    private View mLoadingView;
    private boolean isLoadingShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(LayoutId());
        //绑定butterknife
        ButterKnife.bind(this);
        addSubscription(subscribeEvents());
    }

    public abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubscriptions != null) {
            mSubscriptions.clear();
        }
    }

    protected Subscription subscribeEvents() {
        return null;
    }

    protected void addSubscription(Subscription subscription) {
        if (subscription == null) return;
        if (mSubscriptions == null) {
            mSubscriptions = new CompositeSubscription();
        }
        mSubscriptions.add(subscription);
    }

    public void ShowLoadingProgress() {
        if (mLoadingView == null && !BaseActivity.this.isFinishing()) {
            mLoadingView = View.inflate(mContext, R.layout.progress_loading_layout, null);
            ((ViewGroup) getWindow().getDecorView()).addView(mLoadingView
                    , new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                            , ViewGroup.LayoutParams.MATCH_PARENT));
        } else {
            if (mLoadingView.getVisibility() == View.GONE) {
                mLoadingView.setVisibility(View.VISIBLE);
            }
        }
        isLoadingShow = true;
    }

    public void CloseLoadingProgress() {
        if (!BaseActivity.this.isFinishing()
                && mLoadingView != null
                && isLoadingShow) {
            ((ViewGroup) getWindow().getDecorView()).removeView(mLoadingView);
            mLoadingView = null;//loading一般就使用一次，直接回收~
        }
    }
}
