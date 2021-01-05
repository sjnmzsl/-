package com.example.yanx.home.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
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
import com.example.yanx.bean.SpecialBean;

import java.util.ArrayList;

public class SpecialRecyAdapter extends BaseDelegateAdapter<SpecialBean.DataDTO.DataDT> {


    public SpecialRecyAdapter(Activity activity, LayoutHelper layoutHelper,
                              ArrayList<SpecialBean.DataDTO.DataDT> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_special, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SpecialBean.DataDTO.DataDT bean = list.get(position);
        ViewHoler vh= (ViewHoler) holder;
        Glide.with(activity).load(bean.getScene_pic_url()).into(vh.ima);

        String title = bean.getTitle();
        String subtitle = bean.getSubtitle();
        String price = bean.getPrice_info();
        SpannableString spannableString = new SpannableString(title+"\n"+subtitle+"\n"+price);

        int sta=0;
        int end=title.length();
        //包头不包尾,第一行标题方正苏体

        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(25);
        StyleSpan styleSpan = new StyleSpan(R.font.kaiti);
        spannableString.setSpan(absoluteSizeSpan,sta,end,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan,sta,end,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //第二行方正楷体
        sta=end+1;
        end+=subtitle.length()+1;
        StyleSpan styleSpan1 = new StyleSpan(R.font.fzst);
        spannableString.setSpan(styleSpan1,sta,end,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        //价格红色字体
        sta=end+1;
        end+=price.toString().length()+1;
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        spannableString.setSpan(colorSpan, sta,end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


        vh.tvSpecial.setText(spannableString);

    }

    public class ViewHoler extends RecyclerView.ViewHolder{

        private final ImageView ima;
        private final TextView tvSpecial;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            ima = itemView.findViewById(R.id.ima_special);
            tvSpecial = itemView.findViewById(R.id.tv_special);
        }
    }
}
