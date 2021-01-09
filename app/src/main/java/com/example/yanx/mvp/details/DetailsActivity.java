package com.example.yanx.mvp.details;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.bean.Details_TabBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.adapter.FragmentAdapter;
import com.example.yanx.mvp.details.presenter.DetailsPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 *
 * 第三页目录--->点击目录进入分类具体详情（本类）
 */
public class DetailsActivity extends
        BaseActivity<DetailsPresenter> implements BaseContract.IView<Details_TabBean> {

    private TabLayout tabDetails;
    private ViewPager vp;
    private String TAG="TAG";
    private ArrayList<Fragment> fraList;
    private ArrayList<String> tabList;
//    private int index;


    @Override
    protected int getLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void initData() {
        String id = getIntent().getStringExtra("id");
//        index = getIntent().getIntExtra("index",0);

        mPresenter.get("goods/category?id="+id);
    }

    @Override
    protected void initView() {
        tabDetails = (TabLayout) findViewById(R.id.tab_details);
        vp = (ViewPager) findViewById(R.id.vp_details);
    }


    @Override
    public void getSuccess(Details_TabBean bean) {
        fraList = new ArrayList<>();
        tabList = new ArrayList<>();
        for (Details_TabBean.DataDTO.BrotherCategoryDTO dto : bean.getData().getBrotherCategory()) {

            DetailsDataFragment fragment = new DetailsDataFragment();
            Bundle bundle = new Bundle();
            Integer id = dto.getId();
            bundle.putString("id",id+"");
            fragment.setArguments(bundle);

            fraList.add(fragment);
            tabList.add(dto.getName());
        }
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fraList, tabList);
        vp.setAdapter(adapter);
        tabDetails.setupWithViewPager(vp);
//        vp.setCurrentItem(index);4
    }

    @Override
    public void getFailure(String error) {
        Log.e(TAG, "商品分类详情页"+error );
    }
}