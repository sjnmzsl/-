package com.example.yanx.home.fragment.view;

import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseFragment;
import com.example.yanx.R;
import com.example.yanx.bean.DetailsDataBean;
import com.example.yanx.bean.DirectroyBean;
import com.example.yanx.home.adapter.DirectroyRecyAdapter;
import com.example.yanx.home.fragment.coutract.DirectroyContract;
import com.example.yanx.home.fragment.presenter.DirectroyPresenter;
import com.example.yanx.home.view.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class DirectoryFragment extends BaseFragment<DirectroyPresenter> implements DirectroyContract.IDirectroyView {


    private EditText edSearch;
    private VerticalTabLayout tabDirectroy;
    private ImageView imaBanner;
    private TextView tvTitleDirectroy;
    private RecyclerView recyDirectroy;
    private HomeActivity activity;
    private ArrayList<DetailsDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> dataList;
    private DelegateAdapter delegateAdapter;
    private DirectroyRecyAdapter directroyRecyAdapter;
    private int pageId=1005000;  //点击目录加载对应数据的id

    @Override
    protected int getLayouId() {
        return R.layout.fragment_directory;
    }

    @Override
    protected void initData() {
        mPresenter.getDirectroy();
        mPresenter.getData("catalog/current?id="+pageId);

    }

    @Override
    protected void initView() {
        activity = (HomeActivity) getActivity();
        edSearch = (EditText) view.findViewById(R.id.ed_search);
        tabDirectroy = (VerticalTabLayout) view.findViewById(R.id.tab_directroy);
        imaBanner = (ImageView) view.findViewById(R.id.ima_banner);
        tvTitleDirectroy = (TextView)view. findViewById(R.id.tv_title_directroy);
        recyDirectroy = (RecyclerView) view.findViewById(R.id.recy_directroy);

        //设置网格布局
        dataList = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);

        gridLayoutHelper.setPadding(10,30,10,30);
        gridLayoutHelper.setMargin(10,30,10,30);
        directroyRecyAdapter = new DirectroyRecyAdapter(activity, gridLayoutHelper, dataList);

//        设置回收池
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,9);
        recyDirectroy.setRecycledViewPool(recycledViewPool);

        //设置布局管理器及适配器
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(activity);
        recyDirectroy.setLayoutManager(virtualLayoutManager);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(directroyRecyAdapter);
        recyDirectroy.setAdapter(delegateAdapter);
    }




    @Override
    public void getData(DetailsDataBean bean) {
        dataList.clear();
        dataList.addAll(bean.getData().getCurrentCategory().getSubCategoryList());
        directroyRecyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        Toast.makeText(activity, "运行", Toast.LENGTH_SHORT).show();
        directroyRecyAdapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void getDirectroy(DirectroyBean bean) {
        List<DirectroyBean.DataDTO.CategoryListDTO> categoryList = bean.getData().getCategoryList();
        for (DirectroyBean.DataDTO.CategoryListDTO listDTO : categoryList) {
            tabDirectroy.addTab(new QTabView(activity).setTitle(new ITabView.TabTitle.Builder()
                    .setContent(listDTO.getName())
                    .build()));
        }
        tabDirectroy.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                DirectroyBean.DataDTO.CategoryListDTO dto = categoryList.get(position);
                mPresenter.getData("catalog/current?id="+dto.getId());

                delegateAdapter.notifyDataSetChanged();

                Glide.with(activity).load(dto.getWap_banner_url()).into(imaBanner);
                tvTitleDirectroy.setText(dto.getFront_desc());
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }
}