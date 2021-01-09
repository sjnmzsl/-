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

import com.bumptech.glide.Glide;
import com.example.yanx.mvp.BuyShopping.BuyShoppingActivity;
import com.example.yanx.R;
import com.example.yanx.bean.Details_DataBean;

import java.util.ArrayList;

public class Details_DataAdapter extends RecyclerView.Adapter<Details_DataAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Details_DataBean.DataDTO.DataDT> list;

    public Details_DataAdapter(Activity activity, ArrayList<Details_DataBean.DataDTO.DataDT> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_newgoods, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Details_DataBean.DataDTO.DataDT bean = list.get(position);
        Glide.with(activity).load(bean.getList_pic_url()).into(holder.imaNewgoods);
        holder.tvNameNewgoods.setText(bean.getName());
        holder.tvPriceNewgoods.setText("￥"+bean.getRetail_price());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, BuyShoppingActivity.class);
                Integer id = bean.getId();
                intent.putExtra("id",id+"" );
                activity.startActivity(intent);
            }
        });
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
            tvNameNewgoods = (TextView) itemView.findViewById(R.id.tv_name_newgoods);
            tvPriceNewgoods = (TextView) itemView.findViewById(R.id.tv_price_buyShopping);
        }
    }
}
