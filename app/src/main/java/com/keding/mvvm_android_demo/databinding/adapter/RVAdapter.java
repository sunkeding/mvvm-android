package com.keding.mvvm_android_demo.databinding.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.bean.WeatherResponse;
import com.keding.mvvm_android_demo.databinding.ItemRvBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: skd
 * @date 2019/4/9
 * @Desc RVAdapter
 * <p>
 * binding类是根据xml布局文件的名字生成的
 * activity_main.xml->ActivityMainBinding
 * activity_item.xml->ActivityItemBinding
 * splash_test.xml->SplashTestBinding
 */
public class RVAdapter extends RecyclerView.Adapter {

    private List<WeatherResponse.HeWeatherBean> list = new ArrayList<>();
    Activity activity;

    public RVAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //正常写法
//        View inflate = inflater.inflate((R.layout.item_rv, viewGroup, false);
//        return new WeatherHolder(inflate);

        //databind写法
        ItemRvBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_rv, viewGroup, false);
        return new WeatherHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (list == null || list.get(position) == null) {
            return;
        }
        WeatherHolder weatherHolder = (WeatherHolder) viewHolder;
        //绑定数据
        weatherHolder.itemRvBinding.setWeather(list.get(position));
        //绑定点击事件
        weatherHolder.itemRvBinding.setClickevent(new RVAdapterClick());
    }

    @Override
    public int getItemCount() {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<WeatherResponse.HeWeatherBean> data) {
        if (data == null || data.isEmpty()) {
            return;
        }
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    static class WeatherHolder extends RecyclerView.ViewHolder {
        ItemRvBinding itemRvBinding;

        public WeatherHolder(ItemRvBinding rvBinding) {
            super(rvBinding.getRoot());
            this.itemRvBinding = rvBinding;
        }

    }

    public class RVAdapterClick {
        public void itemClick(WeatherResponse.HeWeatherBean weatherBean) {
            Toast.makeText(activity, "条目点击:" + weatherBean.getMsg(), Toast.LENGTH_SHORT).show();
        }

        public void buttonClick(WeatherResponse.HeWeatherBean weatherBean) {
            Toast.makeText(activity, "按钮点击:" + weatherBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }
}
