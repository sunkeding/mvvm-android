package com.keding.mvvm_android_demo.livedataandviewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.keding.mvvm_android_demo.R;

/**
 * @author: skd
 * @date 2019/4/1
 * @Desc LiveData+ViewModel实践
 */
public class LiveDataActivity extends AppCompatActivity {
    TimeViewModel timeViewModel;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        tv = findViewById(R.id.tv);
        timeViewModel = ViewModelProviders.of(this).get(TimeViewModel.class);
        subscribe();
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                tv.setText(String.valueOf(aLong));
            }
        };

        timeViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}
