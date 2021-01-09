package com.example.yanx.mvp.home.presenter;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.SpecialBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.model.HomeFraModel;
import com.example.yanx.mvp.home.fragment.SpecialFragment;

import java.util.HashMap;

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
    public void post(HashMap<String, String> heads, String url, HashMap<String, String> map) {

    }


}
