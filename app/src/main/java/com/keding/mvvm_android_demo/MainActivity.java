package com.keding.mvvm_android_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.keding.mvvm_android_demo.bean.UserInfo;
import com.keding.mvvm_android_demo.databinding.BaseObservableActivity;
import com.keding.mvvm_android_demo.databinding.ObservableFieldActivity;
import com.keding.mvvm_android_demo.databinding.adapter.RxActivity;
import com.keding.mvvm_android_demo.livedataandviewmodel.LiveDataActivity;
import com.keding.mvvm_android_demo.livedataandviewmodel.lifecycle.TestLifecycleActivity;
import com.keding.mvvm_android_demo.livedatabus.FirstActivity;
import com.keding.mvvm_android_demo.mvvm.MvvmActiviy;

public class MainActivity extends AppCompatActivity {

    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gotoBaseObservable(View view) {
        startActivity(new Intent(this, BaseObservableActivity.class));
    }

    public void gotoObservableField(View view) {
        startActivity(new Intent(this, ObservableFieldActivity.class));

    }

    public void gotoLiveData(View view) {
        startActivity(new Intent(this, LiveDataActivity.class));
    }

    public void gotoRxAct(View view) {
        startActivity(new Intent(this, RxActivity.class));

    }

    public void gotoMvvmAct(View view) {
        startActivity(new Intent(this, MvvmActiviy.class));

    }

    public void gotoLiveDataBusAct(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }

    public void gotoLifecycleAct(View view) {
        startActivity(new Intent(this, TestLifecycleActivity.class));

    }
}
