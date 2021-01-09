package com.example.yanx.adapter;

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

public class BrandListDTOAdapter extends BaseDelegateAdapter<HomeBean.DataDTO.BrandListDTO> {

    public BrandListDTOAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.BrandListDTO> list) {
        super(activity, layoutHelper, list);
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position==0){
//            return 0;
//        }
//        return 1;
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=null;
//        if (viewType==0){
//            view=LayoutInflater.from(activity).inflate(R.layout.item_title,parent,false);
//        }else {
            view = LayoutInflater.from(activity).inflate(R.layout.item_brand, parent, false);
//        }
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHoder vh= (ViewHoder) holder;
//        if (position!=0){
            HomeBean.DataDTO.BrandListDTO bean = list.get(position);
            Glide.with(activity).load(bean.getNew_pic_url()).into(vh.imaBackBrand);
            vh.tvFloorPriceBrand.setText(bean.getFloor_price()+"元起");
            vh.tvNameBrand.setText(bean.getName());
//        }
//        else {
//            vh.tv_title.setText("品牌制造提供商");
//
//        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    class ViewHoder extends RecyclerView.ViewHolder {
        private ImageView imaBackBrand;

        private TextView tvNameBrand;
        private TextView tvFloorPriceBrand;
//        private final TextView tv_title;

        public ViewHoder(@NonNull View convertView) {
            super(convertView);
            imaBackBrand = (ImageView) convertView.findViewById(R.id.ima_back_brand);
            tvNameBrand = (TextView) convertView.findViewById(R.id.tv_name_brand);
            tvFloorPriceBrand = (TextView) convertView.findViewById(R.id.tv_floorPrice_brand);
//            tv_title = convertView.findViewById(R.id.tv_title);
        }


    }
}
