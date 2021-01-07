package com.example.yanx.home.fragment.presenter;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.DetailsDataBean;
import com.example.yanx.bean.DirectroyBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.home.fragment.coutract.DirectroyContract;
import com.example.yanx.home.fragment.model.DirectroyModel;
import com.example.yanx.home.fragment.view.DirectoryFragment;

import java.util.Map;

public class DirectroyPresenter extends BasePresenter<DirectoryFragment, DirectroyModel>
        implements DirectroyContract.IDirectroyPresenter {


    @Override
    public void getData(String url) {
        mModel.getData(url, new ICallBack<DetailsDataBean>() {
            @Override
            public void success(DetailsDataBean bean) {
                mView.getData(bean);
                Log.e("TAG", "目录对应数据解析成功" );
            }

            @Override
            public void failure(String error) {
                Log.e("TAG", "目录对应数据解析失败"+error );
            }
        });
    }

    @Override
    public void getDirectroy() {
        mModel.getData("catalog/index?id=1005000", new ICallBack<DirectroyBean>() {
            @Override
            public void success(DirectroyBean bean) {
                mView.getDirectroy(bean);
            }

            @Override
            public void failure(String error) {
                Log.e("TAG", "目录数据解析失败"+error );
            }
        });
    }
}
