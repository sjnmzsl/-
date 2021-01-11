package com.example.mylibrary.utils;

import android.util.Log;

import com.example.mylibrary.api.ApiService;
import com.example.mylibrary.api.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LoggingMXBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public  class RetrofitHelper {
    private static volatile RetrofitHelper retrofitHelper;
    private final ApiService apiService;

    public static RetrofitHelper getInstance() {
        if (retrofitHelper==null){
            synchronized (RetrofitHelper.class){
                if (retrofitHelper==null){
                    retrofitHelper=new RetrofitHelper();
                }
            }
        }
        return retrofitHelper;
    }
    private RetrofitHelper(){
        apiService = new Retrofit.Builder()
                .baseUrl(ApiService.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }
    public <T> void get(String url,ICallBack<T> callBack){
        apiService.get(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type= actualTypeArguments[0];
                            T bean = new Gson().fromJson(json, type);
                            callBack.success(bean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.failure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public <T> void post(Map<String,String> heads, String url, Map<String,String> map, ICallBack<T> icallBack){
        if (heads==null){
            heads=new HashMap<>();
        }
        if (map==null){
            map=new HashMap<>();
        }
        apiService.post(heads,url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        Type[] interfaces = icallBack.getClass().getGenericInterfaces();
                        Type[] typeArguments = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                        Type type = typeArguments[0];
                        try {
                            String json = responseBody.string();
                            T bean = new Gson().fromJson(json, type);

                            icallBack.success(bean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        icallBack.failure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}


