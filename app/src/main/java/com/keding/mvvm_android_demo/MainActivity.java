package com.keding.mvvm_android_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.keding.mvvm_android_demo.bean.UserInfo;
import com.keding.mvvm_android_demo.livedata.LiveDataActivity;
import com.keding.mvvm_android_demo.ui.BaseObservableActivity;
import com.keding.mvvm_android_demo.ui.ObservableFieldActivity;

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
}
