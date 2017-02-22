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

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.adapter.EquipmentAdapter;
import com.jx3.yanqijs.jx3equipment.adapter.GeneralEquipmentAdapter;
import com.jx3.yanqijs.jx3equipment.data.InitChooseData;
import com.jx3.yanqijs.jx3equipment.data.InitEquipmentData;
import com.jx3.yanqijs.jx3equipment.data.ResultData;
import com.jx3.yanqijs.jx3equipment.imp.RecyclerImp;
import com.jx3.yanqijs.jx3equipment.model.BaseEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.GeneralEquipmentModel;
import com.jx3.yanqijs.jx3equipment.model.ShowModel;
import com.jx3.yanqijs.jx3equipment.rxevent.ObservableData;
import com.jx3.yanqijs.jx3equipment.event.ShowResultEvent;
import com.jx3.yanqijs.jx3equipment.utils.DefaultSubscriber;
import com.jx3.yanqijs.jx3equipment.utils.RxBus;
import com.jx3.yanqijs.jx3equipment.view.EquipmentView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
    private GeneralEquipmentAdapter mShowAdapter;

    private List<BaseEquipmentModel> data = new ArrayList<>();
    private List<BaseEquipmentModel> datas = new ArrayList<>();
    private List<ShowModel> showData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initChooseAdapter();
        mShowAdapter = new GeneralEquipmentAdapter(mContext, new RecyclerImp() {
            @Override
            public void OnItemClick(View view, int position) {

            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mShowAdapter);

    }

    private void initData() {
        InitChooseData.getInstance().initData();
        InitEquipmentData.getInstance().initData();
    }

    private void initChooseAdapter() {
        mEquipmentAdapter = new EquipmentAdapter(mContext, new RecyclerImp() {
            @Override
            public void OnItemClick(View view, int position) {
                closeChoose();
                Subscription subscription = ObservableData.getInstance().getEquipmentData(mEquipmentAdapter.getData(position).pId + "")
                        .subscribe(new DefaultSubscriber<GeneralEquipmentModel>(mContext) {
                            @Override
                            public void onNext(GeneralEquipmentModel obj) {
                                super.onNext(obj);
                                ResultData.getInstance().add(obj);
                                ResultData.getInstance().calculateTotal();
                                showData.clear();
                                RxBus.getInstance().post(new ShowResultEvent(ResultData.getInstance().toShow()));
                            }

                            @Override
                            public boolean setShowLoading() {
                                return false;
                            }
                        });
                addSubscription(subscription);
//                GeneralEquipmentModel generalEquipmentModel = InitEquipmentData.getInstance().find(mEquipmentAdapter.getData(position).pId);
//                ResultData.getInstance().add(generalEquipmentModel);

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
    public void sumbit(EquipmentView view) {
        shadowRelativeLayout.setVisibility(View.VISIBLE);
        ObjectAnimator chooseRecyclerAnimator = ObjectAnimator.ofFloat(shadowRelativeLayout, "alpha", 0f, 1f);
        ObjectAnimator chooseInAnimator = ObjectAnimator.ofFloat(chooseRecyclerView, "translationY", -1000, 0);
        chooseRecyclerAnimator.setDuration(500);
        switch (view.getId()) {
            case R.id.btn_head:
                mEquipmentAdapter.removeAll();
//                mEquipmentAdapter.addAll(get("帽子"));
                ObservableData.getInstance().getData(view.hideName, "10", "30")
                        .subscribe(new DefaultSubscriber<List<BaseEquipmentModel>>(this) {
                            @Override
                            public void onNext(List<BaseEquipmentModel> obj) {
                                super.onNext(obj);
                                mEquipmentAdapter.addAll(obj);
                            }

                            @Override
                            public boolean setShowLoading() {
                                return false;
                            }
                        });
                break;
            case R.id.btn_cloth:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("衣服"));
                break;
            case R.id.btn_arms:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("武器"));
                break;
            case R.id.btn_belt:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("腰带"));
                break;
            case R.id.btn_shoe:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("鞋子"));
                break;
            case R.id.btn_hand:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("护腕"));
                break;
            case R.id.btn_pants:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("下装"));
                break;
            case R.id.btn_hidden_arms:
                mEquipmentAdapter.removeAll();
                mEquipmentAdapter.addAll(get("暗器"));
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


    public List<BaseEquipmentModel> get(String tag) {
        datas = InitChooseData.getInstance().getData();
        data.clear();
        for (BaseEquipmentModel temp : datas) {
            if (tag.equals(temp.part))
                data.add(temp);
        }
        return data;

    }

    @Override
    protected Subscription subscribeEvents() {
        return RxBus.getInstance().toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        if (o instanceof ShowResultEvent) {
                            mShowAdapter.removeAll();
                            mShowAdapter.addAll(((ShowResultEvent) o).result);
                        }
                    }
                })
                .subscribe(RxBus.defaultSubscriber());
    }
}
