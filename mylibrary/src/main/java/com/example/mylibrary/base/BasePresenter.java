package com.example.mylibrary.base;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.Url;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V mView;
    protected M mModel;
    public void addView(V view){
        mView=view;
    }

    public BasePresenter() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class actualTypeArgument = (Class) actualTypeArguments[1];
        try {
            mModel = (M) actualTypeArgument.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }



}
