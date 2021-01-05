package com.example.yanx.start.model;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.RetrofitHelper;
import com.example.yanx.start.StartPageContrct;

import java.util.Map;

public class StartPageModel extends BaseModel implements StartPageContrct.IStartPageModel {

    @Override
    public void getNewToken(Map<String, String> heads, String url, Map<String, String> map, ICallBack iCallBack) {
        RetrofitHelper.getInstance().postLogin(heads,url,map,iCallBack);
    }
}
