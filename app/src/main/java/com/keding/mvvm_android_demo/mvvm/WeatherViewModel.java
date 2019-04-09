package com.keding.mvvm_android_demo.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.keding.mvvm_android_demo.bean.WeatherResponse;
import com.leoao.net.api.ApiInfo;
import com.leoao.net.rxjava.RxHttpEmitter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.leoao.net.api.ContentTypeEnum.FORM;

/**
 * @author: skd
 * @date 2019/4/9
 * @Desc WeatherViewModel
 */
public class WeatherViewModel extends ViewModel {
    private String KEY = "45dd25f63300445e967b461d2037e4f9";

    private MutableLiveData<WeatherResponse> liveData = new MutableLiveData<>();

    public MutableLiveData<WeatherResponse> getLiveData() {
        return liveData;
    }

    public void fetchData(String cityId) {
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
                    }

                    @Override
                    public void onNext(WeatherResponse response) {
                        //绑定非列表数据
                        liveData.setValue(response);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
