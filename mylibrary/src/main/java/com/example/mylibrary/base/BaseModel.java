package com.example.mylibrary.base;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.utils.RetrofitHelper;

public abstract class BaseModel {
    public  <T> void get(String url,ICallBack<T> iCallBack){
        RetrofitHelper.getInstance().get(iCallBack);
    }
}