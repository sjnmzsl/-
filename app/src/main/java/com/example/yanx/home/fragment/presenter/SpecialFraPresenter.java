package com.example.yanx.home.fragment.presenter;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.HomeBean;
import com.example.yanx.bean.SpecialBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.home.fragment.model.HomeFraModel;
import com.example.yanx.home.fragment.view.HomeFragment;
import com.example.yanx.home.fragment.view.SpecialFragment;

import java.util.Map;

public class SpecialFraPresenter extends BasePresenter<SpecialFragment, HomeFraModel>  implements BaseContract.IPresenter {




    @Override
    public void get(String url) {
        mModel.getData(url, new ICallBack<SpecialBean>() {
            @Override
            public void success(SpecialBean bean) {
                Log.e("TAG", "SpecialFraPresenter"+bean.getErrmsg());
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }

    @Override
    public void post(Map<String, String> heads, String url, Map<String, String> map) {

    }
}
