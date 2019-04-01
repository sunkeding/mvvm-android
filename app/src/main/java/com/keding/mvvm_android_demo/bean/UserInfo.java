package com.keding.mvvm_android_demo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

/**
 * @author: skd
 * @date 2019/4/1
 * @Desc UserInfo
 */
public class UserInfo extends BaseObservable implements Serializable {
    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyChange();
    }

    @Bindable
    public String name;
    @Bindable
    public int age;
}
