package com.keding.mvvm_android_demo.livedatabus;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.keding.mvvm_android_demo.R;

/**
 * @author: skd
 * @date 2019/4/9
 * @Desc FirstActivity
 */
public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_first);
        LiveEventBus.get()
                .with("key_name", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(FirstActivity.this, "收到消息：" + s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void jump(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
