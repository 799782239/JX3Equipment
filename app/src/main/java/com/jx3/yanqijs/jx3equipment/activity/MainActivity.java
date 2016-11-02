package com.jx3.yanqijs.jx3equipment.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.adapter.EquipmentAdapter;
import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_head)
    TextView textView;
    @BindView(R.id.attribute_recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.choose_recycler)
    RecyclerView chooseRecyclerView;
    @BindView(R.id.choose_shadow)
    RelativeLayout shadowRelativeLayout;

    private EquipmentAdapter mEquipmentAdapter;
    private List<BaseEquipmentModel> datas = new ArrayList<>();
    private List<BaseEquipmentModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initChooseAdapter();

    }

    private void initChooseAdapter() {
        mEquipmentAdapter = new EquipmentAdapter(mContext, new RecyclerImp() {
            @Override
            public void OnItemClick(View view, int position) {
                mEquipmentAdapter.getData(position);
                closeChoose();
            }
        });
        chooseRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        chooseRecyclerView.addItemDecoration(new DividerItemDecoration(
                mContext, DividerItemDecoration.VERTICAL));
        chooseRecyclerView.setAdapter(mEquipmentAdapter);
    }

    @Override
    public int LayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.btn_head, R.id.btn_cloth, R.id.btn_arms, R.id.btn_belt, R.id.btn_hand, R.id.btn_hidden_arms
            , R.id.btn_necklace, R.id.btn_pants, R.id.btn_shoe, R.id.btn_ring_1, R.id.btn_ring_2, R.id.btn_trinketry})
    public void sumbit(TextView view) {
        shadowRelativeLayout.setVisibility(View.VISIBLE);
        ObjectAnimator chooseRecyclerAnimator = ObjectAnimator.ofFloat(shadowRelativeLayout, "alpha", 0f, 1f);
        ObjectAnimator chooseInAnimator = ObjectAnimator.ofFloat(chooseRecyclerView, "translationY", -1000, 0);
        chooseRecyclerAnimator.setDuration(500);
        switch (view.getId()) {
            case R.id.btn_head:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("帽子"));
                break;
            default:
                view.setText("bbbbb");
                break;
        }
        AnimatorSet set = new AnimatorSet();
        set.play(chooseInAnimator).with(chooseRecyclerAnimator);
        set.start();
    }

    @OnClick(R.id.choose_shadow)
    public void shadow() {
        closeChoose();
    }

    private void closeChoose() {
        ObjectAnimator chooseRecyclerAnimator = ObjectAnimator.ofFloat(shadowRelativeLayout, "alpha", 1f, 0f);
        ObjectAnimator chooseInAnimator = ObjectAnimator.ofFloat(chooseRecyclerView, "translationY", 0, 2000);
        chooseRecyclerAnimator.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                shadowRelativeLayout.setVisibility(View.GONE);
            }
        });
        set.play(chooseInAnimator).with(chooseRecyclerAnimator);
        set.start();
    }

    private String initData() {

        BaseEquipmentModel baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100001;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖刀";
        baseEquipmentModel.equipmentScore = 2290;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "武器";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100002;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖囊";
        baseEquipmentModel.equipmentScore = 1145;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "暗器";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100003;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖帽";
        baseEquipmentModel.equipmentScore = 1717;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "帽子";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100004;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖衣";
        baseEquipmentModel.equipmentScore = 1908;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "衣服";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100005;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖带";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "腰带";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100006;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖护腕";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "护腕";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100007;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖裤";
        baseEquipmentModel.equipmentScore = 1908;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "下装";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "会心";
        datas.add(baseEquipmentModel);
        baseEquipmentModel = new BaseEquipmentModel();
        baseEquipmentModel.pId = 100008;
        baseEquipmentModel.equipmentName = "相思锦年·萧栖鞋";
        baseEquipmentModel.equipmentScore = 1336;
        baseEquipmentModel.qualityRank = 1060;
        baseEquipmentModel.from = "竞技场";
        baseEquipmentModel.part = "鞋子";
        baseEquipmentModel.school = "霸刀";
        baseEquipmentModel.stand = "破防";
        datas.add(baseEquipmentModel);
        Gson gson = new Gson();
        return gson.toJson(datas);
    }

    public List<BaseEquipmentModel> get(String tag) {

        data.clear();
        for (BaseEquipmentModel temp : datas) {
            if (tag.equals(temp.part))
                data.add(temp);
        }
        return data;

    }
}
