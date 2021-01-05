package com.example.yanx;

import android.app.Application;

import com.example.yanx.bean.LoginBean;
import com.tencent.mmkv.MMKV;

public class MyApplication extends Application {

    public static LoginBean LOGIN_BEAN;

    @Override
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);
    }


}
