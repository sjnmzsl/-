package com.example.yanx.mvp.home.presenter;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.DeleteCartBean;
import com.example.yanx.bean.ShoppingCartBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.model.HomeFraModel;
import com.example.yanx.mvp.home.fragment.CartFragment;
import com.example.yanx.utils.JudgeHelper;

import java.util.HashMap;

public class CartFraPresenter extends BasePresenter<CartFragment, HomeFraModel>   {

//    @Override
//    public void get(String url) {
//
//    }

//    @Override
    public void post(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        HashMap<String, String> hashMap = JudgeHelper.getInstance().isHeadsEmpty(heads);
        mModel.postData(hashMap,url,map,new ICallBack<ShoppingCartBean>(){

            @Override
            public void success(ShoppingCartBean bean) {
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }


    public void deleteCart(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        HashMap<String, String> headsEmpty = JudgeHelper.getInstance().isHeadsEmpty(heads);

        mModel.postData(headsEmpty,url,map,new ICallBack<DeleteCartBean>(){

            @Override
            public void success(DeleteCartBean bean) {
                if (bean.getErrno()==0){
                    mView.deleteSuccess();
                }else {
                    mView.getFailure("删除失败"+bean.getErrno()+"---"+bean.getErrmsg());
                }
            }

            @Override
            public void failure(String error) {
                mView.getFailure("删除失败--"+error);
            }
        });
    }
}
