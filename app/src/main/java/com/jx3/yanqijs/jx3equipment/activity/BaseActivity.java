package com.jx3.yanqijs.jx3equipment.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import butterknife.ButterKnife;


/**
 * Created by yanqijs on 2016/10/27.
 */

public abstract class BaseActivity extends Activity {

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(LayoutId());
        ButterKnife.bind(this);
    }

    public abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
