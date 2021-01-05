package com.example.yanx.home.adapter;

import android.app.Activity;
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

public class HotGoodsListDTOAdapter extends BaseDelegateAdapter<HomeBean.DataDTO.HotGoodsListDTO> {



    public HotGoodsListDTOAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.HotGoodsListDTO> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_hotgoods, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataDTO.HotGoodsListDTO bean = list.get(position);
        ViewHoler vh= (ViewHoler) holder;
        Glide.with(activity).load(bean.getList_pic_url()).into(vh.imaHotgoods);
        vh.tvNameHotgoods.setText(bean.getName());
        vh.tvTextHotgoods.setText(bean.getGoods_brief());
        vh.tvPriceHotgoods.setText("￥"+bean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHoler extends RecyclerView.ViewHolder {
        private ImageView imaHotgoods;
        private TextView tvNameHotgoods;
        private TextView tvTextHotgoods;
        private TextView tvPriceHotgoods;
        public ViewHoler(@NonNull View convertView) {
            super(convertView);
                imaHotgoods = (ImageView) convertView.findViewById(R.id.ima_hotgoods);
                tvNameHotgoods = (TextView) convertView.findViewById(R.id.tv_name_hotgoods);
                tvTextHotgoods = (TextView) convertView.findViewById(R.id.tv_text_hotgoods);
                tvPriceHotgoods = (TextView) convertView.findViewById(R.id.tv_price_hotgoods);

        }
    }
}
