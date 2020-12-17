package com.example.app2.utils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @创建时间 2020/12/17 20:41
 */
public class RetrofitUtils implements INetWorkInterface{
    private static RetrofitUtils retrofitUtils;
    private final ApiService apiService;

    private RetrofitUtils(){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(URLConstant.BANNERURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = build.create(ApiService.class);
    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils == null){
            synchronized(RetrofitUtils.class){
                if (retrofitUtils == null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <B> void get(String url, INetCallBack<B> callBack) {
        apiService
                .getBannerData(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            Gson gson = new Gson();
                            B result = gson.fromJson(string, t);
                            callBack.onBean(result);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
