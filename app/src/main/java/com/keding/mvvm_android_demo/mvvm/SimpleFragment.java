package com.keding.mvvm_android_demo.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.bean.WeatherResponse;
import com.keding.mvvm_android_demo.databinding.FragmentSimpleBinding;
import com.keding.mvvm_android_demo.databinding.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: skd
 * @date 2019/4/9
 * @Desc SimpleFragment
 */
public class SimpleFragment extends Fragment {
    FragmentSimpleBinding fragmentSimpleBinding;

    WeatherViewModel viewModel;
    List<WeatherResponse.HeWeatherBean> list;
    private RVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSimpleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_simple, container, false);
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        init();
        viewModel.fetchData("CN101020300");
        bindData(viewModel);
        return fragmentSimpleBinding.getRoot();
    }

    private void init() {
        list = new ArrayList<>();
        fragmentSimpleBinding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RVAdapter(getActivity());
        fragmentSimpleBinding.rv.setAdapter(adapter);
        adapter.setData(list);
        fragmentSimpleBinding.srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.fetchData("CN101030100");
                stopRefresh();
            }
        });
        fragmentSimpleBinding.srl.setRefreshing(true);


    }

    private void stopRefresh() {
        fragmentSimpleBinding.srl.postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentSimpleBinding.srl.setRefreshing(false);
            }
        }, 500);
    }

    private void bindData(WeatherViewModel viewModel) {
        viewModel.getLiveData().observe(getActivity(), new Observer<WeatherResponse>() {
            @Override
            public void onChanged(@Nullable WeatherResponse response) {
                //观测数据改变
                fragmentSimpleBinding.setWeather(response.getHeWeather().get(0));
                adapter.setData(response.getHeWeather());
                stopRefresh();
            }
        });
    }
}
