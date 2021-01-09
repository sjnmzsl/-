package com.example.yanx.mvp.login.model;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.RetrofitHelper;
import com.example.yanx.mvp.login.LoginContrct;

import java.util.Map;

public class LoginModel extends BaseModel implements LoginContrct.ILoginModel {


    @Override
    public <T> void login(String url, Map<String, String> map, ICallBack<T> iCallBack) {
        RetrofitHelper.getInstance().post(null,url,map,iCallBack);
    }
}
