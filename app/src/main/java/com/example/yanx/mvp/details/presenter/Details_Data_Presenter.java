package com.example.yanx.mvp.details.presenter;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.Details_DataBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.details.DetailsDataFragment;
import com.example.yanx.mvp.home.model.HomeFraModel;

import java.util.HashMap;

/**
 * 这是分类页面----具体详情页的具体数据
 */

public class Details_Data_Presenter extends BasePresenter<DetailsDataFragment, HomeFraModel> implements
        BaseContract.IPresenter {

    @Override
    public void get(String url) {
        mModel.getData(url, new ICallBack<Details_DataBean>() {
            @Override
            public void success(Details_DataBean bean) {
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
        mModel.postData(heads,url,map,new ICallBack<Details_DataBean>(){

            @Override
            public void success(Details_DataBean bean) {
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }


}