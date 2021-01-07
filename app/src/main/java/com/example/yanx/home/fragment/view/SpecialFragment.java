package com.example.yanx.home.fragment.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibrary.api.ICallBack;
import com.example.mylibrary.base.BaseFragment;
import com.example.yanx.R;
import com.example.yanx.bean.SpecialBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.home.adapter.SpecialRecyAdapter;
import com.example.yanx.home.fragment.presenter.HomeFraPresenter;
import com.example.yanx.home.fragment.presenter.SpecialFraPresenter;
import com.example.yanx.home.view.HomeActivity;

import java.util.ArrayList;
import java.util.Map;


public class SpecialFragment extends BaseFragment<SpecialFraPresenter> implements BaseContract.IView<SpecialBean> {


    private RecyclerView recySpecial;
    private HomeActivity activity;
    private VirtualLayoutManager virtualLayoutManager;
    private DelegateAdapter delegateAdapter;
    private ArrayList<SpecialBean.DataDTO.DataDT> list;
    private SpecialRecyAdapter specialRecyAdapter;
    private int page;



    public void setItemListener(){
        specialRecyAdapter.setOnClickItemListener(new SpecialRecyAdapter.OnClickItemListener() {
            @Override
            public void topPage() {


                --page;
                if (page==1){
                    page=1;
                    specialRecyAdapter.setTopPageState();
                }

//                //如果上一页是第一页，那么不刷新
//                if (page==0){
//                    page=1;
//                    specialRecyAdapter.setTopPageState();
//                    return;
//                }
                list.clear();
                initData();
            }

            @Override
            public void down() {
                page++;
                initData();
            }
        });
    }

    @Override
    protected int getLayouId() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initData() {
        mPresenter.get("topic/list?page="+page+"&size=10");
    }

    @Override
    protected void initView() {
        activity = (HomeActivity) getActivity();
        recySpecial = (RecyclerView) view.findViewById(R.id.recy_Special);
        virtualLayoutManager = new VirtualLayoutManager(activity);
        recySpecial.setLayoutManager(virtualLayoutManager);
        //设置回收池
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,8);
        recySpecial.setRecycledViewPool(recycledViewPool);


        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(4);
        list = new ArrayList<>();
        specialRecyAdapter = new SpecialRecyAdapter(activity, linearLayoutHelper, list);
        delegateAdapter.addAdapter(specialRecyAdapter);
        recySpecial.setAdapter(delegateAdapter);


        setItemListener();

    }


    @Override
    public void getSuccess(SpecialBean bean) {
        page=bean.getData().getCurrentPage();

        list.addAll(bean.getData().getData());
        specialRecyAdapter.notifyDataSetChanged();


    }

    @Override
    public void getFailure(String error) {
        Log.e("TAG", "special "+ error);
    }
}