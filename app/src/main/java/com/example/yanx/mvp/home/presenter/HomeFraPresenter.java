package com.example.yanx.mvp.home.presenter;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.HomeBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.model.HomeFraModel;
import com.example.yanx.mvp.home.fragment.HomeFragment;

import java.util.HashMap;

public class HomeFraPresenter extends BasePresenter<HomeFragment, HomeFraModel>  implements BaseContract.IPresenter {



    @Override
    public void get(String url) {
        mModel.getData(url, new ICallBack<HomeBean>() {
            @Override
            public void success(HomeBean bean) {
                Log.e("TAG", "登录结果"+bean.getErrmsg());
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

    }


}
