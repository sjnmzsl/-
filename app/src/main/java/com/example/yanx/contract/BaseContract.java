package com.example.yanx.contract;

import com.example.mylibrary.api.ICallBack;

import java.util.Map;

public class BaseContract {

    public interface IView<T>{
        void  getSuccess(T bean);
        void getFailure(String error);
    }
    public interface IPresenter{
        void get( String url);
        void post(Map<String,String> heads, String url, Map<String,String> map);
    }
    public interface IModel{
        void get(Map<String,String> heads, String url, Map<String,String> map, ICallBack iCallBack);
        void post(Map<String,String> heads, String url, Map<String,String> map, ICallBack iCallBack);
    }
}
