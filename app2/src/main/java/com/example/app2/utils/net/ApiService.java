package com.example.app2.utils.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * @创建时间 2020/12/17 20:40
 */
public interface ApiService {
    @GET
    Observable<ResponseBody> getBannerData(@Url String url);
}
