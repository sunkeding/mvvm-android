package com.keding.mvvm_android_demo.livedatabus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.keding.mvvm_android_demo.R;

/**
 * @author: skd
 * @date 2019/4/9
 * @Desc FirstActivity
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_two);
    }

    public void sendMessage(View view) {
        LiveEventBus.get()
                .with("key_name")
                .postValue("我是来自SecondActivity的消息");
    }
}
