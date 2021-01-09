package com.example.yanx.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yanx.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;

import com.example.yanx.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdapter extends DelegateAdapter.Adapter<BannerAdapter.ViewHolder> {

    private Activity activity;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBean.DataDTO.BannerDTO> list;

    public BannerAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.BannerDTO> list) {
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
        View view = LayoutInflater.from(activity).inflate(R.layout.item_banner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.banner.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBean.DataDTO.BannerDTO bean= (HomeBean.DataDTO.BannerDTO) path;
                        String image_url = bean.getImage_url();
                        StringBuffer url = new StringBuffer(image_url).insert(4, "s");
                        Glide.with(context).load(image_url).into(imageView);
                    }
                })
                .start();

    }

    @Override
    public int getItemCount() {
        return 1;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Banner banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner_item);
        }

    }
}
