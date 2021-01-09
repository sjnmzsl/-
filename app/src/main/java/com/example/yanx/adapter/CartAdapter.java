package com.example.yanx.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yanx.R;
import com.example.yanx.bean.ShoppingCartBean;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private ArrayList<ShoppingCartBean.DataDTO.CartListDTO> list;

    public CartAdapter(Activity activity, ArrayList<ShoppingCartBean.DataDTO.CartListDTO> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }


    private boolean isShowVt=true;

    public void setShowVt(boolean showVt) {
        isShowVt = showVt;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh= (ViewHolder) holder;
        ShoppingCartBean.DataDTO.CartListDTO bean = list.get(position);
        Glide.with(activity).load(bean.getList_pic_url()).into(vh.imaHeadCart);
        vh.tvTitleCart.setText(bean.getGoods_name());
        vh.tv_pric_cart.setText("￥"+bean.getMarket_price());

        vh.tv_count_cart.setText(bean.getNumber()+"");
        if (isShowVt){
            vh.vtCart.setVisibility(View.GONE);
            vh.cbOption.setVisibility(View.GONE);
            vh.tv_count_cart.setVisibility(View.VISIBLE);
        }else {
            vh.vtCart.setVisibility(View.VISIBLE);
            vh.cbOption.setVisibility(View.VISIBLE);
            vh.tv_count_cart.setVisibility(View.GONE);
        }

        vh.cbOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vh.cbOption.isChecked()){
                    bean.setDelete(true);
                }else {
                    bean.setDelete(false);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private CheckBox cbOption;
        private ImageView imaHeadCart;
        private TextView tvTitleCart;
        private TextView tv_pric_cart;
        private LinearLayout vtCart;
        private TextView tvAdd;
        private TextView tvCount;
        private TextView tv_count_cart;
        private TextView tvRemove;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cbOption = (CheckBox) itemView.findViewById(R.id.cb_option);
            imaHeadCart = (ImageView)  itemView.findViewById(R.id.ima_head_cart);
            tvTitleCart = (TextView)  itemView.findViewById(R.id.tv_title_cart);
            tv_pric_cart = (TextView)  itemView.findViewById(R.id.tv_pric_cart);
            vtCart = (LinearLayout) itemView. findViewById(R.id.vt_cart);
            tvAdd = (TextView)  itemView.findViewById(R.id.tv_add);
            tvCount = (TextView)  itemView.findViewById(R.id.tv_count);
            tv_count_cart = (TextView)  itemView.findViewById(R.id.tv_count_cart);
            tvRemove = (TextView)  itemView.findViewById(R.id.tv_remove);
        }


    }
}
