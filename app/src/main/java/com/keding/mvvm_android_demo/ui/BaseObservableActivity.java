package com.keding.mvvm_android_demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.bean.UserInfo;
import com.keding.mvvm_android_demo.databinding.ActivityBaseobservableBinding;

/**
 * @author: skd
 * @date 2019/4/1
 * @Desc BaseObservableActivity
 */
public class BaseObservableActivity extends Activity {
    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_baseobservable);
        ActivityBaseobservableBinding activityBaseobservableBinding = DataBindingUtil.setContentView(this, R.layout.activity_baseobservable);
        userInfo = new UserInfo();
        userInfo.name = "skd";
        userInfo.age = 13;
        activityBaseobservableBinding.setUserInfo(userInfo);
    }

    public void changeName(View view) {
        userInfo.setName("sss");
        userInfo.setAge(200);
    }
}
