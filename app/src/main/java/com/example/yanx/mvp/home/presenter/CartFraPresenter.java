package com.example.yanx.mvp.home.presenter;

import android.util.Log;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.AddCartBean;
import com.example.yanx.bean.DeleteCartBean;
import com.example.yanx.bean.CartBean;
import com.example.yanx.mvp.home.model.HomeFraModel;
import com.example.yanx.mvp.home.fragment.CartFragment;
import com.example.yanx.utils.JudgeHelper;

import java.util.HashMap;

public class CartFraPresenter extends BasePresenter<CartFragment, HomeFraModel>   {



//   请求购物车数据
    public void post(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        HashMap<String, String> hashMap = JudgeHelper.getInstance().isHeadsEmpty(heads);
        mModel.postData(hashMap,url,map,new ICallBack<CartBean>(){

            @Override
            public void success(CartBean bean) {
                if (bean.getErrno()==0){
                    mView.getSuccess(bean);
                    Log.e("TAG", "购物车数据请求成功"+bean.getData().getCartList().toString());

                }else {
                    Log.e("TAG", "购物车数据请求失败");
                }
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }


    //删除购物车数据
    public void deleteCart(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        HashMap<String, String> headsEmpty = JudgeHelper.getInstance().isHeadsEmpty(heads);

        mModel.postData(headsEmpty,url,map,new ICallBack<DeleteCartBean>(){

            @Override
            public void success(DeleteCartBean bean) {
                if (bean.getErrno()==0){
                    mView.upData();
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

    //添加购物车数据
    public void addCart(HashMap<String, String> heads, String url, HashMap<String, String> map,boolean isUpData) {
        HashMap<String, String> headsEmpty = JudgeHelper.getInstance().isHeadsEmpty(heads);

        mModel.postData(headsEmpty,url,map,new ICallBack<AddCartBean>(){

            @Override
            public void success(AddCartBean bean) {
                if (bean.getErrno()==0){
                    Log.i("TAG","成功添加至购物车----------"+ bean.getData().getCartList().toString());
                }else {
                    mView.getFailure("添加失败--"+bean.getErrmsg());
                }

                if (isUpData){
                    mView.initData();
                }
            }

            @Override
            public void failure(String error) {
                mView.getFailure("添加失败--"+error);
            }
        });


    }
}
