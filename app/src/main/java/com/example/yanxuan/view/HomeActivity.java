package com.example.yanxuan.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mylibrary.base.BaseActivity;
import com.example.yanxuan.R;
import com.example.yanxuan.adapter.BannerAdapter;
import com.example.yanxuan.bean.HomeBean;
import com.example.yanxuan.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.LinkedList;

public class HomeActivity extends BaseActivity<HomePresenter> {

    private RecyclerView recyHoem;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banns;
    private BannerAdapter bannerAdapter;


    @Override
    protected void initData() {
        mPresenter.get("");
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

        //添加适配器
        LinkedList<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        adapters.add(bannerAdapter);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
        recyHoem.setAdapter(delegateAdapter);
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
        HomeBean homeBean= (HomeBean) bean;
        HomeBean.DataDTO data = homeBean.getData();
        banns.addAll(data.getBanner());

    }

    @Override
    public void failure(String error) {

    }
}