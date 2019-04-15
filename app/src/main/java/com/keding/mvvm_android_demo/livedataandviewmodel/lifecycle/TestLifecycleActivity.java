package com.keding.mvvm_android_demo.livedataandviewmodel.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.livedatabus.FirstActivity;

/**
 * @author: skd
 * @date 2019/4/11
 * @Desc 生命周期相关
 */
public class TestLifecycleActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TestLifecycleActivity", "onStart:" + getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("TestLifecycleActivity", "onStop:" + getLifecycle().getCurrentState().toString());

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TestLifecycleActivity", "onPause:" + getLifecycle().getCurrentState().toString());

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TestLifecycleActivity", "onRestart:" + getLifecycle().getCurrentState().toString());

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlife);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestLifecycleActivity.this, FirstActivity.class));
            }
        });
        Log.d("TestLifecycleActivity", "onCreate:" + getLifecycle().getCurrentState().toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TestLifecycleActivity", "onResume:" + getLifecycle().getCurrentState().toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TestLifecycleActivity", "onDestroy:" + getLifecycle().getCurrentState().toString());

    }
}
