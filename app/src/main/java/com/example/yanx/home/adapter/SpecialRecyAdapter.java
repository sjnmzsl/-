package com.example.yanx.home.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    public  Button downPage;
    public  Button topPage;
    public int isinitTopPage =1;

    public SpecialRecyAdapter(Activity activity, LayoutHelper layoutHelper,
                              ArrayList<SpecialBean.DataDTO.DataDT> list) {
        super(activity, layoutHelper, list);
    }


    @Override
    public int getItemViewType(int position) {
        if (position==list.size()){
            return 1;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType==1){
            view = LayoutInflater.from(activity).inflate(R.layout.item_turn_page, parent, false);
        }else {
            view = LayoutInflater.from(activity).inflate(R.layout.item_special, parent, false);
        }
        return new ViewHoler(view);
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    public interface OnClickItemListener{
        void topPage();
        void down();
    }
    private OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public void setTopPageState(){
        topPage.setEnabled(false);
    }
    public void setDownPageState(){
        downPage.setEnabled(false);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHoler vh= (ViewHoler) holder;
        if (position==list.size()){
            if (isinitTopPage ==1){
                isinitTopPage++;
                setTopPageState();
            }
            topPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemListener.topPage();
                    downPage.setEnabled(true);
                }
            });
            downPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemListener.down();
                    topPage.setEnabled(true);
                }
            });
        }else {
            SpecialBean.DataDTO.DataDT bean = list.get(position);
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

    }

    public class ViewHoler extends RecyclerView.ViewHolder{

        private final ImageView ima;
        private final TextView tvSpecial;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            ima = itemView.findViewById(R.id.ima_special);
            tvSpecial = itemView.findViewById(R.id.tv_special);
            topPage = itemView.findViewById(R.id.bt_topPage);
            downPage = itemView.findViewById(R.id.bt_downPage);
        }
    }
}
