package com.example.yanx.mvp.home.presenter;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.DirectroyDataBean;
import com.example.yanx.bean.DirectroyBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.fragment.DirectoryFragment;
import com.example.yanx.mvp.home.model.HomeFraModel;

import java.util.HashMap;

public class DirectroyPresenter extends BasePresenter<DirectoryFragment, HomeFraModel>
        implements BaseContract.IPresenter {


    @Override
    public void get(String url) {
        mModel.getData(url, new ICallBack<DirectroyDataBean>() {
            @Override
            public void success(DirectroyDataBean bean) {
                mView.getData(bean);
            }

            @Override
            public void failure(String error) {
                Log.e("TAG", "目录对应数据解析失败"+error );
            }
        });
    }

    @Override
    public void post(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        mModel.getData("catalog/index?id=1005000", new ICallBack<DirectroyBean>() {
            @Override
            public void success(DirectroyBean bean) {
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                Log.e("TAG", "目录数据解析失败"+error );
            }
        });
    }
}
