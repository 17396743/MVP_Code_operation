package com.example.myapplication22.utils.net;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * @创建时间 2020/12/17 18:38
 */
public interface ApiService {
    @GET
    Observable<ResponseBody> getBannerData(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> getPost(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> getPostPar(@Url String url, @FieldMap HashMap<String,String> map);
}
