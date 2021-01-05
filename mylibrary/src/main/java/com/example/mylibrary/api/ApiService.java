package com.example.mylibrary.api;

import android.net.Uri;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
     String BASEURL="https://cdplay.cn/api/";
//    https://cdplay.cn/api/auth/login

    @GET()
    Observable<ResponseBody> get(@Url String url);

    @GET
    Observable<ResponseBody> get(@Url String url,@QueryMap Map map);



    @POST
    @FormUrlEncoded
    Observable<ResponseBody> post(@HeaderMap Map<String,String> heads,
                                  @Url String url,
                                  @FieldMap Map<String, String> map);
}
