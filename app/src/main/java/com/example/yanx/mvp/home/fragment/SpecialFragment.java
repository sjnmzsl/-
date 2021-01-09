package com.example.yanx.mvp.home.fragment;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibrary.base.BaseFragment;
import com.example.yanx.R;
import com.example.yanx.bean.SpecialBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.adapter.SpecialRecyAdapter;
import com.example.yanx.mvp.home.presenter.SpecialFraPresenter;
import com.example.yanx.mvp.home.activity.HomeActivity;

import java.util.ArrayList;

/**
 * 主页第二页的专题页
 */

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