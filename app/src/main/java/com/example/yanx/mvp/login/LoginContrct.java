package com.example.yanx.mvp.login;

import com.example.mylibrary.api.ICallBack;

import java.util.Map;

public class LoginContrct {

    public interface ILoginView{
        void loginSuccess();
        void loginFailure(String error);
    }
    public interface ILoginPresenter{
        void login(String name,String pasd,boolean isSavaPasd);
    }
    public interface ILoginModel{
        <T>void login(String url, Map<String,String> map, ICallBack<T> iCallBack);
    }
}
