package com.example.yanx.login.presenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.yanx.bean.LoginBean;
import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.MyApplication;
import com.example.yanx.login.LoginContrct;
import com.example.yanx.login.model.LoginModel;
import com.example.yanx.login.view.LoginActivity;
import com.tencent.mmkv.MMKV;

import java.lang.reflect.Type;
import java.util.HashMap;

public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel> implements LoginContrct.ILoginPresenter {



    @Override
    public void login(String name, String pasd, boolean isSavaPasd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",pasd);
        mModel.login("auth/login",map, new ICallBack<LoginBean>() {
            @Override
            public void success(LoginBean bean) {
                MMKV mmkv = MMKV.defaultMMKV();

                if (bean.getData().getCode()==200){
                    if (!isSavaPasd){
                        bean.getData().setToken("233");
                    }
                    MyApplication.LOGIN_BEAN=bean;
                    mView.loginSuccess();
                    mmkv.encode("data",bean.getData());
                }else {
                    mView.loginFailure("账号密码错误");
                }
            }

            @Override
            public void failure(String error) {

            }
        });
    }


}
