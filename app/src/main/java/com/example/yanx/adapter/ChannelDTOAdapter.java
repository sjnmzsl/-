package com.example.yanx.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.yanx.R;
import com.example.yanx.bean.HomeBean;
import com.example.yanx.mvp.home.activity.WebActivity;

import java.util.ArrayList;

public class ChannelDTOAdapter extends DelegateAdapter.Adapter<ChannelDTOAdapter.ViewHolder> {
    private Activity activity;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> list;

    public ChannelDTOAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.ChannelDTO> list) {
        this.activity = activity;
        this.layoutHelper = layoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_channe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeBean.DataDTO.ChannelDTO bean = list.get(position);
        Glide.with(activity).load(bean.getIcon_url()).into(holder.ima_channe);
        holder.tv_desc.setText(bean.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, WebActivity.class);
                intent.putExtra("url",bean.getUrl());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView ima_channe;
        private final TextView tv_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ima_channe = itemView.findViewById(R.id.ima_channe);
            tv_desc = itemView.findViewById(R.id.tv_desc_channe);
        }
    }
}
