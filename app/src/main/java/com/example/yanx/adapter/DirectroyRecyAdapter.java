package com.example.yanx.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
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
import com.example.yanx.bean.DirectroyDataBean;
import com.example.yanx.mvp.details.DetailsActivity;


import java.util.ArrayList;

public class DirectroyRecyAdapter extends
        BaseDelegateAdapter<DirectroyDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> {

    public DirectroyRecyAdapter(Activity activity, LayoutHelper layoutHelper,
                                ArrayList<DirectroyDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_newgoods, parent, false);
        return new DirectroyRecyAdapter.ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHoder vh= (ViewHoder) holder;
        DirectroyDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO bean = list.get(position);
        Glide.with(activity).load(bean.getWap_banner_url()).into(vh.imaSpecial);
        vh.tvSpecial.setText(bean.getName());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailsActivity.class);
                intent.putExtra("id",bean.getId()+"");
                activity.startActivity(intent);
            }
        });
    }



    class ViewHoder extends RecyclerView.ViewHolder {
        private ImageView imaSpecial;
        private TextView tvSpecial;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            imaSpecial = (ImageView) itemView.findViewById(R.id.ima_newgoods);
            tvSpecial = (TextView) itemView.findViewById(R.id.tv_name_newgoods);
        }


    }
}
