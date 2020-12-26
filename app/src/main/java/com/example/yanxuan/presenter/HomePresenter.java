package com.example.yanxuan.presenter;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanxuan.bean.HomeBean;
import com.example.yanxuan.model.HomeModel;
import com.example.yanxuan.view.HomeActivity;

public class HomePresenter extends BasePresenter<HomeActivity,HomeModel> {

    @Override
    public void get(String url) {
        mModel.get(url, new ICallBack<HomeBean>() {
            @Override
            public void success(HomeBean bean) {
                mView.success(bean);
            }

            @Override
            public void failure(String error) {
                mView.failure(error);
            }
        });
    }

    public HomePresenter() {
        mModel=new HomeModel();
    }
}
