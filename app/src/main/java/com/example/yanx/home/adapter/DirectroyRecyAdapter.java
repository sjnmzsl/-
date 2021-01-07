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
import com.example.yanx.bean.DetailsDataBean;

import java.util.ArrayList;

public class DirectroyRecyAdapter extends
        BaseDelegateAdapter<DetailsDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> {

    public DirectroyRecyAdapter(Activity activity, LayoutHelper layoutHelper,
                                ArrayList<DetailsDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_special, parent, false);
        return new DirectroyRecyAdapter.ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHoder vh= (ViewHoder) holder;
        DetailsDataBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO bean = list.get(position);
        Glide.with(activity).load(bean.getWap_banner_url()).into(vh.imaSpecial);
        vh.tvSpecial.setText(bean.getName());
    }



    class ViewHoder extends RecyclerView.ViewHolder {
        private ImageView imaSpecial;
        private TextView tvSpecial;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            imaSpecial = (ImageView) itemView.findViewById(R.id.ima_special);
            tvSpecial = (TextView) itemView.findViewById(R.id.tv_special);
        }


    }
}
