package com.example.mylibrary.base;

import com.example.mylibrary.api.ICallBack;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.http.GET;
import retrofit2.http.Url;

public abstract class BasePresenter<V extends BaseActivity,M extends BaseModel>  {
    protected V mView;
    protected M mModel;
    protected void addView(V view){
        mView=view;
    }

    public BasePresenter() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Type actualTypeArgument = actualTypeArguments[1];
        try {
            mModel = (M) actualTypeArgument.getClass().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

    public abstract void get(String url);

}