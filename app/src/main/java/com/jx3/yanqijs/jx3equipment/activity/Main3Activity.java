package com.jx3.yanqijs.jx3equipment.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.jx3.yanqijs.jx3equipment.rxevent.ObservableData;
import com.jx3.yanqijs.jx3equipment.utils.DefaultSubscriber;

import butterknife.BindView;
import rx.Subscription;

public class Main3Activity extends BaseActivity {
    @BindView(R.id.text)
    TextView mTextView;
    @BindView(R.id.btn)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mTextView= (TextView) findViewById(R.id.text);
//        mButton= (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subscription subscription = new ObservableData().getJdId("3133811", "1")
                        .subscribe(new DefaultSubscriber<M>(mContext) {
                            @Override
                            public void onNext(M obj) {
                                super.onNext(obj);
                                mTextView.setText(obj.name);
                            }
                        });
                addSubscription(subscription);
            }
        });


    }


    @Override
    public int LayoutId() {
        return R.layout.activity_main3;
    }
}
