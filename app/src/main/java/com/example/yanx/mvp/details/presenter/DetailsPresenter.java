package com.example.yanx.mvp.details.presenter;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.Details_TabBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.model.HomeFraModel;
import com.example.yanx.mvp.details.DetailsActivity;

import java.util.HashMap;

public class DetailsPresenter extends BasePresenter<DetailsActivity, HomeFraModel>  implements BaseContract.IPresenter {

    @Override
    public void get(String url) {
        mModel.getData(url, new ICallBack<Details_TabBean>() {
            @Override
            public void success(Details_TabBean bean) {
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }

    @Override
    public void post(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        mModel.postData(heads,url,map,new ICallBack<Details_TabBean>(){

            @Override
            public void success(Details_TabBean bean) {
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }
}
