package com.jx3.yanqijs.jx3equipment.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int LayoutId() {
        return R.layout.activity_main;
    }

    //
//    @OnClick({R.id.btn_head, R.id.btn_cloth, R.id.btn_arms, R.id.btn_belt, R.id.btn_hand, R.id.btn_hidden_arms
//            , R.id.btn_necklace, R.id.btn_pants, R.id.btn_shoe, R.id.btn_ring_1, R.id.btn_ring_2})
//    public void sumbit(TextView view) {
//        switch (view.getId()) {
//            case R.id.btn_head:
//                view.setText("aaa");
//                break;
//            default:
//                view.setText("bbbbb");
//                break;
//        }
//
//    }
    @OnClick(R.id.btn_head)
    public void sumbit(TextView view) {
        view.setText("aaaa");
    }
}
