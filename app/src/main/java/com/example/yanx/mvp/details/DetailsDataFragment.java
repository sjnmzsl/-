package com.example.yanx.mvp.details;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.example.mylibrary.base.BaseFragment;
import com.example.yanx.R;
import com.example.yanx.adapter.Details_DataAdapter;
import com.example.yanx.bean.Details_DataBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.details.presenter.Details_Data_Presenter;

import java.util.ArrayList;

/**
 * 这是分类页面---->具体详情页的具体数据
 */

public class DetailsDataFragment extends BaseFragment<Details_Data_Presenter>
implements BaseContract.IView<Details_DataBean> {


    private RecyclerView recy;
    private FragmentActivity activity;
    private Details_DataAdapter adapter;
    private ArrayList<Details_DataBean.DataDTO.DataDT> list;
    private String TAG="TAG";



    @Override
    protected int getLayouId() {
        return R.layout.fragment_details_data;
    }

    @Override
    protected void initData() {
        String id = getArguments().getString("id");
        Log.e(TAG, "收到id--------"+id );
        mPresenter.get("goods/list?categoryId="+id+"&page=1&size=100");
    }

    @Override
    protected void initView() {
        activity = getActivity();
        recy = view.findViewById(R.id.recy_Details_Data);
        recy.setLayoutManager(new GridLayoutManager(activity,2));
        list = new ArrayList<>();
        adapter = new Details_DataAdapter(activity,list);
        recy.setAdapter(adapter);
    }


    @Override
    public void getSuccess(Details_DataBean bean) {
        list.addAll(bean.getData().getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getFailure(String error) {
        Log.e(TAG, "商品详细分类页详细数据"+error );
    }
}