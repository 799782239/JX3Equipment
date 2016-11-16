package com.jx3.yanqijs.jx3equipment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jx3.yanqijs.jx3equipment.R;

import retrofit2.Retrofit;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://p.3.cn/")
                .addConverterFactory(GsonConverterFactory.create())
    }
}
