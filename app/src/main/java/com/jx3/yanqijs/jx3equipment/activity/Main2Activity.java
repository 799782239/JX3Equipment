package com.jx3.yanqijs.jx3equipment.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.jx3.yanqijs.jx3equipment.rxevent.ObservableData;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.text);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://p.3.cn/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        final Operate operate = retrofit.create(Operate.class);
//        operate.getTest("J_3133811", "1")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<List<M>>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.i("main", "complete");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.i("main", "error:" + e.toString());
//                    }
//
//                    @Override
//                    public void onNext(List<M> ms) {
//                        Log.i("main", "next");
//                        textView.setText(ms.get(0).getId());
//                    }
//                });
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
                        textView.setText(m.getId());
                    }
                });
    }
}
