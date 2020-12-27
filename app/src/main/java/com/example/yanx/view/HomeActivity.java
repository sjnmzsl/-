package com.example.yanx.view;

import android.graphics.Color;
import android.graphics.Rect;
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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.adapter.BannerAdapter;
import com.example.yanx.adapter.BrandListDTOAdapter;
import com.example.yanx.adapter.CategoryListDTOAdapter;
import com.example.yanx.adapter.ChannelDTOAdapter;
import com.example.yanx.adapter.HotGoodsListDTOAdapter;
import com.example.yanx.adapter.NewGoodsListDTOAdapter;
import com.example.yanx.adapter.TitleAdapter;
import com.example.yanx.adapter.TopicListDTOAdapter;
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
    private TitleAdapter titleAdapter;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newGoodsListDTOs;
    private NewGoodsListDTOAdapter newGoodsListDTOAdapter;
    private TitleAdapter titleAdapter1;
    private TitleAdapter 品牌制造商直供;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOs;
    private HotGoodsListDTOAdapter hotGoodsListDTOAdapter;
    private TitleAdapter titleAdapter2;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOs;
    private TopicListDTOAdapter topicListDTOAdapter;
    private TitleAdapter titleAdapter3;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> categoryListDTOs;
    private CategoryListDTOAdapter categoryListDTOAdapter;


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
        titleAdapter = setSingleAdapter("品牌制造商直供");
        setBrandListDTOAdapter(); //制造商
        titleAdapter1 = setSingleAdapter("周一周四，新品首发");
        setNewGoodsListDTOAdapter(); //新品页面
        titleAdapter2 = setSingleAdapter("人气推荐");
        setHotGoodsListDTOAdapter();
        titleAdapter3 = setSingleAdapter("专题精选");
        setTopicListDTOAdapter();
        setCategoryListDTOAdapter();



        //添加适配器
        delegateAdapter = new DelegateAdapter(layoutManager);

        delegateAdapter.addAdapter(searchBoxAdapter);
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(channelDTOAdapter);
        delegateAdapter.addAdapter(titleAdapter);
        delegateAdapter.addAdapter(brandListDTOAdapter);
        delegateAdapter.addAdapter(titleAdapter1);
        delegateAdapter.addAdapter(newGoodsListDTOAdapter);
        delegateAdapter.addAdapter(titleAdapter2);
        delegateAdapter.addAdapter(hotGoodsListDTOAdapter);
        delegateAdapter.addAdapter(titleAdapter3);
        delegateAdapter.addAdapter(topicListDTOAdapter);
        delegateAdapter.addAdapter(categoryListDTOAdapter);
        recyHoem.setAdapter(delegateAdapter);
    }

    private void setCategoryListDTOAdapter() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setMargin(0,10,0,0);
        categoryListDTOs = new ArrayList<>();
        categoryListDTOAdapter = new CategoryListDTOAdapter(this, linearLayoutHelper, categoryListDTOs);
    }

    private void setTopicListDTOAdapter() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setBgColor(Color.WHITE);
        topicListDTOs = new ArrayList<>();
        topicListDTOAdapter = new TopicListDTOAdapter(this, singleLayoutHelper, topicListDTOs);
    }

    private void setHotGoodsListDTOAdapter() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setBgColor(Color.WHITE);
//        linearLayoutHelper.setMargin(0,0,0,10);
        hotGoodsListDTOs = new ArrayList<>();
        hotGoodsListDTOAdapter = new HotGoodsListDTOAdapter(this,linearLayoutHelper,hotGoodsListDTOs);
    }

    private void setNewGoodsListDTOAdapter() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setBgColor(Color.WHITE);
        newGoodsListDTOs = new ArrayList<>();
        newGoodsListDTOAdapter = new NewGoodsListDTOAdapter(this,gridLayoutHelper,newGoodsListDTOs);
    }

    private TitleAdapter setSingleAdapter(String st) {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setBgColor(Color.WHITE);
        singleLayoutHelper.setMargin(0,10,0,0);
        ArrayList<String> titles = new ArrayList<>();
        titles.add(st);
        return new TitleAdapter(this,singleLayoutHelper,titles);
    }

    private void setBrandListDTOAdapter() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
//        gridLayoutHelper.setPadding(1,1,1,1);
//        gridLayoutHelper.setAspectRatio(2);
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
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setBgColor(Color.WHITE);
        columnLayoutHelper.setItemCount(5);
        columnLayoutHelper.setPadding(10,0,10,0);
//        columnLayoutHelper.setMargin(0,0,0,15);

//        columnLayoutHelper.setAspectRatio(6);
        columnLayoutHelper.setWeights(new float[]{22,22,22,22,22});
        ChannelDTOs = new ArrayList<>();
        channelDTOAdapter = new ChannelDTOAdapter(this, columnLayoutHelper, ChannelDTOs);
    }

    private void setSearchBoxAdapter() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setBgColor(Color.WHITE);
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
//                    Typeface typeface = Typeface.createFromAsset(getAssets(), "sk.ttf");
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


        newGoodsListDTOs.addAll(data.getNewGoodsList());
        newGoodsListDTOAdapter.notifyDataSetChanged();

        hotGoodsListDTOs.addAll(data.getHotGoodsList());
        hotGoodsListDTOAdapter.notifyDataSetChanged();


        topicListDTOs.addAll(data.getTopicList());
        topicListDTOAdapter.notifyDataSetChanged();

        categoryListDTOs.addAll(data.getCategoryList());
        categoryListDTOAdapter.notifyDataSetChanged();

        delegateAdapter.notifyDataSetChanged();

    }

    @Override
    public void failure(String error) {

    }
}