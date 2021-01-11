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
import com.example.yanx.bean.CartBean;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private ArrayList<CartBean.DataDTO.CartListDTO> list;



    public CartAdapter(Activity activity, ArrayList<CartBean.DataDTO.CartListDTO> list) {
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

    private boolean isAllSelete=false;
    public void setAllSelete(boolean allSelete) {
        isAllSelete = allSelete;
    }

    private int options;
    public interface OnClickListener{
        void setAllPrice(int price,boolean isAdd);
        void allSelete(boolean isAllSelete);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);

        ViewHolder vh= (ViewHolder) holder;
        CartBean.DataDTO.CartListDTO bean = list.get(position);
        Glide.with(activity).load(bean.getList_pic_url()).into(vh.imaHeadCart);
        vh.tvTitleCart.setText(bean.getGoods_name());
        String price = bean.getMarket_price();
        Integer number = bean.getNumber();

        vh.tv_pric_cart.setText("￥"+price);
        vh.tv_count_cart.setText(number+"");
        vh.tv_setCount.setText(bean.getNumber()+"");

        if (isAllSelete){
            vh.cbOption.setChecked(true);
        }

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
                    options++;
                }else {
                    options--;
                    bean.setDelete(false);
                }

                //如果选中的数量等于集合长度，那么全选
                if(options==list.size()){
                    onClickListener.allSelete(true);
                }else {
                    onClickListener.allSelete(false);
                }

            }
        });

        addAndRemoveListener(vh,bean);
    }

    private void addAndRemoveListener(ViewHolder vh, CartBean.DataDTO.CartListDTO bean) {
        vh.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number = bean.getNumber()+1;
                bean.setNumber(number);

                //修改总价
                int price = Integer.valueOf(bean.getMarket_price());
                onClickListener.setAllPrice(price,true);

                //修改数量
                vh.tv_setCount.setText(number+"");

            }
        });
        vh.tvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number = bean.getNumber() - 1;
                if (number < 0) {
                    number = 0;
                }

                //修改总价
                int price = Integer.valueOf(bean.getMarket_price());
                onClickListener.setAllPrice(price,false);


                //修改数量
                bean.setNumber(number);
                vh.tv_setCount.setText(number+"");
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
        private TextView tv_setCount;
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
            tv_setCount = (TextView)  itemView.findViewById(R.id.tv_setCount);
            tv_count_cart = (TextView)  itemView.findViewById(R.id.tv_count_cart);
            tvRemove = (TextView)  itemView.findViewById(R.id.tv_remove);
        }


    }
}
