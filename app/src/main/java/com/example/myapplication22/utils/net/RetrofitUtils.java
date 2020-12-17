package com.example.myapplication22.utils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @创建时间 2020/12/17 18:32
 */
public class RetrofitUtils implements INetWorkInterface {

    public static RetrofitUtils retrofitUtils;
    private final ApiService apiService;

    private RetrofitUtils() {
        OkHttpClient build = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }



    @Override
    public <T> void get(String url, INetCallBack<T> callBack) {
        apiService.getBannerData(url)
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

                            T result = gson.fromJson(string, t);

                            callBack.success(result);
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

    @Override
    public <T> void post(String url, INetCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack) {

    }
}
