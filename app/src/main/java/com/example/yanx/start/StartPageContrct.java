package com.example.yanx.start;

import com.example.mylibrary.api.ICallBack;

import java.lang.ref.Reference;
import java.util.Map;

public class StartPageContrct {

    public interface IStartPageView{
       void refreshToken();
       void failure();
    }
    public interface IStartPagePresenter{
        void refreshToken();
    }
    public interface IStartPageModel{
        void getNewToken(Map<String,String> heads,String url,Map<String,String> map,ICallBack iCallBack);
    }
}
