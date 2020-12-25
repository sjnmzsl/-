package com.example.yanxuan.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mylibrary.base.BaseActivity;
import com.example.yanxuan.R;
import com.example.yanxuan.adapter.BannerAdapter;
import com.example.yanxuan.bean.HomeBean;
import com.example.yanxuan.presenter.HomePresenter;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity<HomePresenter> {

    private RecyclerView recyHoem;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banns;
    private BannerAdapter bannerAdapter;


    @Override
    protected void initData() {
        mPresenter.get("index");
    }

    @Override
    protected void initView() {
        recyHoem = (RecyclerView) findViewById(R.id.recy_Hoem);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);

        recyHoem.setLayoutManager(layoutManager);

        //设置回收池
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,8);
        recyHoem.setRecycledViewPool(recycledViewPool);
        setBanneAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private void setBanneAdapter() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        ArrayList<HomeBean.DataDTO.BannerDTO> banns = new ArrayList<>();
        bannerAdapter = new BannerAdapter(this, singleLayoutHelper, banns);
        bannerAdapter.getItemCount();
    }



    @Override
    public void success(Object bean) {

    }

    @Override
    public void failure(String error) {

    }
}