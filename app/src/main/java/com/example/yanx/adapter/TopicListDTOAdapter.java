package com.example.yanx.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseDelegateAdapter;
import com.example.yanx.R;
import com.example.yanx.bean.HomeBean;

import java.util.ArrayList;

public class TopicListDTOAdapter extends BaseDelegateAdapter<HomeBean.DataDTO.TopicListDTO> {

    public TopicListDTOAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.TopicListDTO> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_recy_topic, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerView recy = holder.itemView.findViewById(R.id.recy_topic);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL, false);
        recy.setLayoutManager(linearLayoutManager);
        recy.setAdapter(new RecyclerView.Adapter() {

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(activity).inflate(R.layout.item_topic, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder vh= (ViewHolder) holder;
                if (position==0){
                    vh.itemView.setPadding(12,0,4,0);
                }else if (position==list.size()-1){
                    vh.itemView.setPadding(6,0,12,0);
                }else {
                    vh.itemView.setPadding(6,0,6,0);
                }
                HomeBean.DataDTO.TopicListDTO bean = list.get(position);
                Glide.with(activity).load(bean.getItem_pic_url()).into(vh.imaTopic);
                vh.tvNameTopic.setText(bean.getTitle());
                vh.tvTextTopic.setText(bean.getSubtitle());
                vh.tvPriceTopic.setText("￥"+bean.getPrice_info());
                vh.tvPriceTopic.setTextColor(Color.RED);
            }

            @Override
            public int getItemCount() {
                return list.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder {
                private TextView tvTextTopic;
                private TextView tvPriceTopic;
                private TextView tvNameTopic;
                private ImageView imaTopic;

                public ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    imaTopic = (ImageView) itemView.findViewById(R.id.ima_topic);
                    tvNameTopic = (TextView)itemView.findViewById(R.id.tv_name_topic);
                    tvPriceTopic = (TextView) itemView.findViewById(R.id.tv_price_topic);
                    tvTextTopic = (TextView) itemView.findViewById(R.id.tv_text_topic);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
