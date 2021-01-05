package com.example.yanx.home.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseDelegateAdapter;
import com.example.yanx.R;
import com.example.yanx.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class CategoryListDTOAdapter extends BaseDelegateAdapter<HomeBean.DataDTO.CategoryListDTO> {


    public CategoryListDTOAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.CategoryListDTO> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_recy_category, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataDTO.CategoryListDTO bean = list.get(position);
        List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = bean.getGoodsList();
        ViewHoler vh = (ViewHoler) holder;
        vh.tvTitle.setText(bean.getName());

//        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(activity);
//        vh.recyCategory.setLayoutManager(virtualLayoutManager);
//        //设置回收池
//        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
//        recycledViewPool.setMaxRecycledViews(0,8);
//        vh.recyCategory.setRecycledViewPool(recycledViewPool);
//        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
//        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager);
//        adapter.addAdapter(new DelegateAdapter.Adapter() {
//            @Override
//            public LayoutHelper onCreateLayoutHelper() {
//                return gridLayoutHelper;
//            }
//
//            @NonNull
//            @Override
//            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(activity).inflate(R.layout.item_newgoods, parent, false);
//                return new newViewHoler(view);
//            }
//
//            @Override
//            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//                HomeBean.DataDTO.CategoryListDTO.GoodsListDTO bean = goodsList.get(position);
//                newViewHoler vh= (newViewHoler) holder;
//                Glide.with(activity).load(bean.getList_pic_url()).into(vh.imaNewgoods);
//                vh.tvNameNewgoods.setText(bean.getName());
//                vh.tvPriceNewgoods.setText("￥"+bean.getRetail_price());
//            }
//
//            @Override
//            public int getItemCount() {
//                return goodsList.size();
//            }
//
//
//            class newViewHoler extends RecyclerView.ViewHolder {
//                private TextView tvPriceNewgoods;
//                private TextView tvNameNewgoods;
//                private ImageView imaNewgoods;
//                public newViewHoler(@NonNull View itemView) {
//                    super(itemView);
//                    imaNewgoods = (ImageView) itemView.findViewById(R.id.ima_newgoods);
//                    tvNameNewgoods = (TextView) itemView.findViewById(R.id.tv_name_newgoods);
//                    tvPriceNewgoods = (TextView) itemView.findViewById(R.id.tv_price_newgoods);
//                }
//            }
//
//        });
//        vh.recyCategory.setAdapter(adapter);


        vh.recyCategory.setLayoutManager(new GridLayoutManager(activity,2));
        vh.recyCategory.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(activity).inflate(R.layout.item_newgoods, parent, false);
                return new newViewHoler(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                HomeBean.DataDTO.CategoryListDTO.GoodsListDTO bean = goodsList.get(position);
                newViewHoler vh= (newViewHoler) holder;
                Glide.with(activity).load(bean.getList_pic_url()).into(vh.imaNewgoods);
                vh.imaNewgoods.setBackgroundColor(0xffE4E1E1);
                vh.tvNameNewgoods.setText(bean.getName());
                vh.tvPriceNewgoods.setText("￥"+bean.getRetail_price());
            }

            @Override
            public int getItemCount() {
                return goodsList.size();
            }


            class newViewHoler extends RecyclerView.ViewHolder {
                private TextView tvPriceNewgoods;
                private TextView tvNameNewgoods;
                private ImageView imaNewgoods;
                public newViewHoler(@NonNull View itemView) {
                    super(itemView);
                    imaNewgoods = (ImageView) itemView.findViewById(R.id.ima_newgoods);
                    tvNameNewgoods = (TextView) itemView.findViewById(R.id.tv_name_newgoods);
                    tvPriceNewgoods = (TextView) itemView.findViewById(R.id.tv_price_newgoods);
                }
            }

        });


    }




    class ViewHoler extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private RecyclerView recyCategory;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            recyCategory = itemView.findViewById(R.id.recy_category);
        }
    }


}
