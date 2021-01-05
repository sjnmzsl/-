package com.example.yanx.start.presenter;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.LoginBean;
import com.example.yanx.bean.TokenBean;
import com.example.yanx.start.StartPageContrct;
import com.example.yanx.start.model.StartPageModel;
import com.example.yanx.start.view.StartPageActivity;
import com.tencent.mmkv.MMKV;


import java.util.HashMap;

public class StartPagePresenter extends BasePresenter<StartPageActivity, StartPageModel> implements StartPageContrct.IStartPagePresenter {

    @Override
    public void refreshToken() {
        MMKV mmkv = MMKV.defaultMMKV();
        HashMap<String, String> heads = new HashMap<>();
        LoginBean.DataDTO data = mmkv.decodeParcelable("data", LoginBean.DataDTO.class);
        if (data!=null){
            if (!data.getToken().equals("233")){
                String token = data.getToken();
                heads.put("X-Nideshop-Token",token);
                mModel.getNewToken(heads, "auth/refreshToken", null, new ICallBack<TokenBean>() {
                    @Override
                    public void success(TokenBean bean) {
                        if (bean.getErrno()==0){
                            data.setToken(bean.getData());
                            mmkv.encode("data",data);
                            mView.refreshToken();
                        }else {
                            mView.failure();
                        }
                    }
                    @Override
                    public void failure(String error) {
                        mView.failure();
                    }
                });
            }
        }


    }
}
