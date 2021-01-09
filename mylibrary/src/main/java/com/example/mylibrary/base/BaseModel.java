package com.example.mylibrary.base;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.utils.RetrofitHelper;

import java.util.HashMap;

public abstract class BaseModel {
    public  <T> void getData(String url, ICallBack<T> iCallBack){
        RetrofitHelper.getInstance().get(url,iCallBack);
    }

    public  <T> void postData(HashMap<String,String> heads,String url,HashMap<String,String> map, ICallBack<T> iCallBack){
        RetrofitHelper.getInstance().post(heads,url,map,iCallBack);
    }
}
