package com.example.yanx.login.model;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.RetrofitHelper;
import com.example.yanx.login.LoginContrct;

import java.util.Map;

public class LoginModel extends BaseModel implements LoginContrct.ILoginModel {


    @Override
    public <T> void login(String url, Map<String, String> map, ICallBack<T> iCallBack) {
        RetrofitHelper.getInstance().postLogin(null,url,map,iCallBack);
    }
}
