package com.keding.mvvm_android_demo.databinding.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.keding.mvvm_android_demo.R;
import com.keding.mvvm_android_demo.bean.WeatherResponse;
import com.keding.mvvm_android_demo.databinding.ActivityRxBinding;
import com.leoao.net.api.ApiInfo;
import com.leoao.net.rxjava.RxHttpEmitter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.leoao.net.api.ContentTypeEnum.FORM;

/**
 * @author: skd
 * @date 2019/4/8
 * @Desc RxActivity
 */
public class RxActivity extends Activity {
    private String TAG = "RxActivity";
    ActivityRxBinding activityRxBinding;
    private RVAdapter adapter;
    private List<WeatherResponse.HeWeatherBean> list;
    private String KEY = "45dd25f63300445e967b461d2037e4f9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRxBinding = DataBindingUtil.setContentView(this, R.layout.activity_rx);
        list = new ArrayList<>();
        activityRxBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RVAdapter(this);
        activityRxBinding.rv.setAdapter(adapter);
        adapter.setData(list);
        activityRxBinding.srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getWeather("CN101030100");
            }
        });
        getWeather("CN101020300");
        activityRxBinding.srl.setRefreshing(true);

    }

    private void getWeather(String cityId) {

        ApiInfo apiInfo = new ApiInfo();
        apiInfo.setThirdPrtyUrl("http://guolin.tech/api/weather?cityid=" + cityId + "&key=" + KEY);
        apiInfo.setContentType(FORM);
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("q", "装逼");
        RxHttpEmitter.getInstance()
                .get(apiInfo, null, WeatherResponse.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<WeatherResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("RxActivity", "onSubscribe");
                    }

                    @Override
                    public void onNext(WeatherResponse response) {
                        Log.d("RxActivity", "onNext");
//                        String msg = response.getHeWeather().get(0).getMsg();
//                        Log.d("RxActivity", "msg:" + msg);

                        //绑定非列表数据
                        activityRxBinding.setWeather(response.getHeWeather().get(0));

                        adapter.setData(response.getHeWeather());


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("RxActivity", "onError");

                    }

                    @Override
                    public void onComplete() {
                        Log.d("RxActivity", "onComplete");
                        activityRxBinding.srl.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                activityRxBinding.srl.setRefreshing(false);
                            }
                        },500);


                    }
                });
    }


}
