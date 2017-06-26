package com.jx3.yanqijs.jx3equipment.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;
import com.jx3.yanqijs.jx3equipment.model.M;
import com.jx3.yanqijs.jx3equipment.rxevent.ObservableData;
import com.jx3.yanqijs.jx3equipment.utils.MySubscriber;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import butterknife.BindView;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;

public class Main3Activity extends BaseActivity {
    @BindView(R.id.text)
    TextView mTextView;
    @BindView(R.id.btn)
    Button mButton;

    private BufferedReader in = null;
    private BufferedWriter out = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mTextView= (TextView) findViewById(R.id.text);
//        mButton= (Button) findViewById(R.id.btn);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Socket socket = new Socket("120.24.231.171", 80);
//                    InputStream inputStream = socket.getInputStream();
//                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                    String line;
//                    StringBuffer stringBuffer = new StringBuffer();
//                    while ((line = bufferedReader.readLine()) != null) {
//                        stringBuffer.append(line);
//                    }
//                    Log.i("netResult", stringBuffer.toString());
//                    bufferedReader.close();
//                    socket.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subscription subscription = new ObservableData().getJdId()
                        .subscribe(new MySubscriber<M>(mContext) {
                            @Override
                            public void onNext(M obj) {
                                super.onNext(obj);
                                mTextView.setText(obj.a);
                            }
                        });
                addSubscription(subscription);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Socket socket=new Socket("120.24.231.171",80);
//                            socket.setSoTimeout(20*1000);
////                            Socket socket = new Socket();
////                            socket.connect(new InetSocketAddress("120.24.231.171", 80));
//                            in = new BufferedReader(new InputStreamReader(socket
//                                    .getInputStream()));
//                            out = new BufferedWriter(new OutputStreamWriter(
//                                    socket.getOutputStream()));
////                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                            String line;
//                            StringBuffer stringBuffer = new StringBuffer();
//                            while ((line = in.readLine()) != null) {
//                                stringBuffer.append(line);
//                            }
//                            Log.i("netResult", in.toString());
////                            bufferedReader.close();
//                            socket.close();
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();

            }
        });


    }


    @Override
    public int LayoutId() {
        return R.layout.activity_main3;
    }
}
