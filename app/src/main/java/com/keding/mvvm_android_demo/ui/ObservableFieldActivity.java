package com.keding.mvvm_android_demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        //事件绑定别忘记了这句代码
        activityObservablefieldBinding.setUserpresent(new UserPresenter());
    }

    /**
     * 修改属性值，观察控件变化
     */
    public void change(View view) {

        student.setName("999");
        student.setScore(9000L);

    }
    /**
     * 修改控件值，观察属性变化
     */
    public void change2(View view) {
        TextView tv_change=findViewById(R.id.tv_change);
        tv_change.setText("修改后的名字");
        Log.d("ObservableFieldActivity", "student.name:" + student.name.get());
    }


    // View的点击事件
    public class UserPresenter{
        public void showToast(Student student){
            Toast.makeText(ObservableFieldActivity.this, "short click:"+student.name.get(), Toast.LENGTH_SHORT).show();
        }

        public void showToast2(Student student) {
            Toast.makeText(ObservableFieldActivity.this, "long click:" + student.name.get(), Toast.LENGTH_SHORT).show();
        }
    }
}
