package com.keding.mvvm_android_demo.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.databinding.ActivityMvvmBinding;

/**
 * @author: skd
 * @date 2019/4/9
 * @Desc MvvmActiviy
 */
public class MvvmActiviy extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        getSupportFragmentManager().beginTransaction().add(R.id.content, new SimpleFragment()).commitAllowingStateLoss();
    }
}
