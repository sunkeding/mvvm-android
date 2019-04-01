package com.keding.mvvm_android_demo.bean;

import android.databinding.ObservableField;

/**
 * @author: skd
 * @date 2019/4/1
 * @Desc Student
 */
public class Student {
    public ObservableField<String> name;

    public Student(String name, Long score) {
        this.name = new ObservableField<>(name);
        this.score = new ObservableField<>(score);
    }


    public void setName(String name) {
        this.name.set(name);
    }


    public void setScore(Long score) {
        this.score.set(score);

    }

    public ObservableField<Long> score;
}
