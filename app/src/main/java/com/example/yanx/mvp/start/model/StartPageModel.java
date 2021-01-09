package com.example.yanx.mvp.start.model;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.RetrofitHelper;
import com.example.yanx.mvp.start.StartPageContrct;

import java.util.Map;

public class StartPageModel extends BaseModel implements StartPageContrct.IStartPageModel {

    @Override
    public void getNewToken(Map<String, String> heads, String url, Map<String, String> map, ICallBack iCallBack) {
        RetrofitHelper.getInstance().post(heads,url,map,iCallBack);
    }
}
