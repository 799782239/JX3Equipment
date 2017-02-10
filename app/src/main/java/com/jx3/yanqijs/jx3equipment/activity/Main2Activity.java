package com.jx3.yanqijs.jx3equipment.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.jx3.yanqijs.jx3equipment.rxevent.ObservableData;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Main2Activity extends BaseActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = (TextView) findViewById(R.id.text);
        ObservableData.getInstance().getJdId("J_3133811", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<M>() {
                    @Override
                    public void onCompleted() {
                        Log.i("main", "complete");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(M m) {
                        textView.setText(m.id);
                    }
                });
    }

    @Override
    public int LayoutId() {
        return R.layout.activity_main2;
    }

}
