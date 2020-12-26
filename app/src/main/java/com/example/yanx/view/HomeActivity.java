package com.example.yanx.view;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.adapter.BannerAdapter;
import com.example.yanx.adapter.BrandListDTOAdapter;
import com.example.yanx.adapter.ChannelDTOAdapter;
import com.example.yanx.bean.HomeBean;
import com.example.yanx.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<HomePresenter> {

    private RecyclerView recyHoem;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banns;
    private BannerAdapter bannerAdapter;
    private DelegateAdapter delegateAdapter;
    private androidx.appcompat.widget.Toolbar toobHome;
    private DelegateAdapter.Adapter searchBoxAdapter;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> ChannelDTOs;
    private ChannelDTOAdapter channelDTOAdapter;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brandListDTOs;
    private BrandListDTOAdapter brandListDTOAdapter;


    @Override
    protected void initData() {
        mPresenter.get("index");
    }

    @Override
    protected void initView() {
        recyHoem = (RecyclerView) findViewById(R.id.recy_Hoem);
        toobHome = (Toolbar) findViewById(R.id.toob_Home);
        setSupportActionBar(toobHome);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);

        recyHoem.setLayoutManager(layoutManager);

        //设置回收池
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,8);
        recyHoem.setRecycledViewPool(recycledViewPool);

        setSearchBoxAdapter(); //搜索框
        setBanneAdapter();      //轮播图
        setChannelDTOAdapter(); //小图标
        setSingleAdapter("品牌制造商直供");
        setBrandListDTOAdapter(); //制造商


        //添加适配器
        delegateAdapter = new DelegateAdapter(layoutManager);
        delegateAdapter.addAdapter(searchBoxAdapter);
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(channelDTOAdapter);
        delegateAdapter.addAdapter(brandListDTOAdapter);
        recyHoem.setAdapter(delegateAdapter);
    }

    private void setSingleAdapter(String st) {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        new 
    }

    private void setBrandListDTOAdapter() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);

//        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position==0){
//                    return 6;
//                }
//                return 3;
//            }
//        });
//        gridLayoutHelper.setBgColor(R.color.qinhui);
        brandListDTOs = new ArrayList<>();
        brandListDTOAdapter = new BrandListDTOAdapter(this, gridLayoutHelper, brandListDTOs);


    }

    private void setChannelDTOAdapter() {
        int range=20;
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setItemCount(5);
        columnLayoutHelper.setMargin(range,5,range,range);
        columnLayoutHelper.setPadding(range,range,range,range);
//        columnLayoutHelper.setAspectRatio(6);
        columnLayoutHelper.setWeights(new float[]{20,20,20,20,20});
        ChannelDTOs = new ArrayList<>();
        channelDTOAdapter = new ChannelDTOAdapter(this, columnLayoutHelper, ChannelDTOs);
    }

    private void setSearchBoxAdapter() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        searchBoxAdapter = new DelegateAdapter.Adapter() {
            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return singleLayoutHelper;
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.item_searchbox, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder vh= (ViewHolder) holder;
                vh.ed_search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            @Override
            public int getItemCount() {
                return 1;
            }

            class ViewHolder extends RecyclerView.ViewHolder{
                private final EditText ed_search;

                public ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    ed_search = itemView.findViewById(R.id.ed_search);
//                    Typeface typeface = Typeface.createFromAsset(getAssets(), "STXINWEI.TTF");
//                    ed_search.setTypeface(typeface);
                }
            }
        };
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private void setBanneAdapter() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();

        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        banns = new ArrayList<>();
        bannerAdapter = new BannerAdapter(this, singleLayoutHelper, banns);
    }



    @Override
    public void success(Object bean) {
        HomeBean homeBean= (HomeBean) bean;

        HomeBean.DataDTO data = homeBean.getData();
        banns.addAll(data.getBanner());
        bannerAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.ChannelDTO> channel = data.getChannel();
        ChannelDTOs.addAll(channel);
        channelDTOAdapter.notifyDataSetChanged();

        brandListDTOs.addAll(data.getBrandList());
        brandListDTOAdapter.notifyDataSetChanged();


        delegateAdapter.notifyDataSetChanged();

    }

    @Override
    public void failure(String error) {

    }
}