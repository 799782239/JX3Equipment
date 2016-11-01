package com.jx3.yanqijs.jx3equipment.activity;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;


/**
 * Created by yanqijs on 2016/10/27.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        ButterKnife.bind(this);
    }

    public abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
