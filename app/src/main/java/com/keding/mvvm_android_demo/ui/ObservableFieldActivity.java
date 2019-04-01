package com.keding.mvvm_android_demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.bean.Student;
import com.keding.mvvm_android_demo.databinding.ActivityObservablefieldBinding;

/**
 * @author: skd
 * @date 2019/4/1
 * @Desc ObservableFieldActivity
 */
public class ObservableFieldActivity extends Activity {
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_observablefield);
        ActivityObservablefieldBinding activityObservablefieldBinding = DataBindingUtil.setContentView(this, R.layout.activity_observablefield);
        student = new Student("skd", 200L);
        activityObservablefieldBinding.setStudent(student);
    }

    public void change(View view) {

        student.setName("999");
        student.setScore(9000L);

    }
}
