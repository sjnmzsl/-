package com.example.yanx.mvp.BuyShopping;

import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BasePresenter;
import com.example.yanx.bean.AddCartBean;
import com.example.yanx.bean.BuyShoppingBean;
import com.example.yanx.bean.LoginBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.model.HomeFraModel;
import com.example.yanx.utils.JudgeHelper;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class BuyShoppingPresenter extends BasePresenter<BuyShoppingActivity, HomeFraModel>  implements BaseContract.IPresenter {

    @Override
    public void get(String url) {
        mModel.getData(url, new ICallBack<BuyShoppingBean>() {
            @Override
            public void success(BuyShoppingBean bean) {
                mView.getSuccess(bean);
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }

    //添加至购物车
    @Override
    public void post(HashMap<String, String> heads, String url, HashMap<String, String> map) {
        HashMap<String, String> headsEmpty = JudgeHelper.getInstance().isHeadsEmpty(heads);

        mModel.postData(headsEmpty,url,map,new ICallBack<AddCartBean>(){
            @Override
            public void success(AddCartBean bean) {
                if (bean.getErrno()==0){
                    mView.addCartSuccess(bean);
                }else {
                    mView.getFailure("添加至购物车失败");
                }
            }

            @Override
            public void failure(String error) {
                mView.getFailure(error);
            }
        });
    }


}
