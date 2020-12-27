package com.example.yanx.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseDelegateAdapter;
import com.example.yanx.R;
import com.example.yanx.bean.HomeBean;

import java.util.ArrayList;

public class NewGoodsListDTOAdapter extends BaseDelegateAdapter<HomeBean.DataDTO.NewGoodsListDTO> {


    public NewGoodsListDTOAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.NewGoodsListDTO> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_newgoods, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataDTO.NewGoodsListDTO bean = list.get(position);
        ViewHolder vh= (ViewHolder) holder;
        Glide.with(activity).load(bean.getList_pic_url()).into(vh.imaNewgoods);
        vh.tvNameNewgoods.setText(bean.getName());
        vh.tvPriceNewgoods.setText("￥"+bean.getRetail_price());
        vh.tvPriceNewgoods.setTextColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imaNewgoods;
        private TextView tvNameNewgoods;
        private TextView tvPriceNewgoods;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                imaNewgoods = (ImageView) itemView.findViewById(R.id.ima_newgoods);
                tvNameNewgoods = (TextView)itemView. findViewById(R.id.tv_name_newgoods);
                tvPriceNewgoods = (TextView) itemView.findViewById(R.id.tv_price_newgoods);

        }
    }
}
