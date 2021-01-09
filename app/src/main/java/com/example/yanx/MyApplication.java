package com.example.yanx;

import android.app.Application;

import com.example.yanx.bean.LoginBean;
import com.tencent.mmkv.MMKV;

public class MyApplication extends Application {

    public static LoginBean LOGIN_BEAN;
    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
        MMKV.initialize(this);
    }


}
