package com.example.yanx.home.fragment.presenter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.HomeBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.home.fragment.model.HomeFraModel;
import com.example.yanx.home.fragment.view.HomeFragment;
import com.example.yanx.home.view.HomeActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

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
    public void post(Map<String, String> heads, String url, Map<String, String> map) {

    }
}
