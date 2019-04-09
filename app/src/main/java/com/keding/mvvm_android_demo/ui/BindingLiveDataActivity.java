package com.keding.mvvm_android_demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.keding.mvvm_android_demo.R;

/**
 * @author: skd
 * @date 2019/4/1
 * @Desc BindingLiveDataActivity
 */
public class BindingLiveDataActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_bindinglivedata);
    }
}
