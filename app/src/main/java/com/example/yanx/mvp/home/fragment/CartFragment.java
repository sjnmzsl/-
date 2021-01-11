package com.example.yanx.mvp.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylibrary.base.BaseFragment;
import com.example.yanx.R;
import com.example.yanx.bean.CartBean;
import com.example.yanx.adapter.CartAdapter;
import com.example.yanx.mvp.home.presenter.CartFraPresenter;

import java.util.ArrayList;
import java.util.HashMap;


public class CartFragment extends BaseFragment<CartFraPresenter>
        implements  View.OnClickListener {

    private RecyclerView recyShoppingCart;
    private LinearLayout linShoppingCart;
    private CheckBox cb_AllSelect;
    private TextView tv_AllPrice;
    private TextView tvSetShoppingCart;
    private Button btBuybuybuy;
    private ArrayList<CartBean.DataDTO.CartListDTO> list;
    private CartAdapter adapter;
    private FragmentActivity activity;

    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayouId(), container,false);
        initView();
        initListener();
        return view;
    }

    private void initListener() {
        adapter.setOnClickListener(new CartAdapter.OnClickListener() {
            @Override
            public void setAllPrice(int price, boolean isAdd) {
                //获取当前价格
                int newPrice;
                StringBuffer sb = new StringBuffer(tv_AllPrice.getText().toString());
                StringBuffer delete = sb.delete(0, 1);
                Integer money = Integer.valueOf(String.valueOf(delete));
                //增删修改价格
                if (isAdd){
                    newPrice = money + price;
                }else {
                    newPrice = money - price;
                }
                tv_AllPrice.setText("￥"+newPrice);
            }

            @Override
            public void allSelete(boolean isAllSelete) {
                if (isAllSelete){
                    cb_AllSelect.setChecked(true);  //全选按钮设为选中
                    adapter.setAllSelete(true);
                }else {
                    cb_AllSelect.setChecked(false);  //全选按钮设为选中
                    adapter.setAllSelete(false);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    protected int getLayouId() {
        return R.layout.fragment_cart;
    }

    @Override
    public void initData() {
        list.clear();
        mPresenter.post(null,"cart/index",null);
    }

    @Override
    protected void initView() {
        activity = getActivity();
        recyShoppingCart = (RecyclerView) view.findViewById(R.id.recy_ShoppingCart);
        linShoppingCart = (LinearLayout) view.findViewById(R.id.lin_ShoppingCart);
        cb_AllSelect = (CheckBox) view.findViewById(R.id.cb_AllSelect_ShoppingCart);
        tv_AllPrice = (TextView) view.findViewById(R.id.tv_AllPrice_ShoppingCart);
        tvSetShoppingCart = (TextView) view.findViewById(R.id.tv_setShoppingCart);
        btBuybuybuy = (Button) view.findViewById(R.id.bt_buybuybuy);

        //recy展示要购买的商品
        list = new ArrayList<>();
        adapter = new CartAdapter(activity,list);
        recyShoppingCart.setLayoutManager(new LinearLayoutManager(activity));
        recyShoppingCart.setAdapter(adapter);

        tvSetShoppingCart.setOnClickListener(this::onClick);
        btBuybuybuy.setOnClickListener(this::onClick);
        cb_AllSelect.setOnClickListener(this::onClick);
    }




    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden){
            initData();
        }
        super.onHiddenChanged(hidden);
    }

    public void getSuccess(CartBean bean) {
        int allPrice = 0;
        for (CartBean.DataDTO.CartListDTO dto : bean.getData().getCartList()) {
            Double money = Double.valueOf(String.valueOf(dto.getMarket_price()));
            allPrice+=money*dto.getNumber();
        }
        tv_AllPrice.setText("￥"+allPrice);


        list.addAll(bean.getData().getCartList());
        adapter.notifyDataSetChanged();

    }

    public void getFailure(String error) {
        Log.e(TAG, " 购物车数据"+error);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_setShoppingCart:
                if (tvSetShoppingCart.getText().toString().equals("编辑")){
                    //切换编辑界面
                    tvSetShoppingCart.setText("完成");
                    btBuybuybuy.setText("删除所选");
                    adapter.setShowVt(false);
                    adapter.notifyDataSetChanged();
                }else {
                    //变回正常界面
                    tvSetShoppingCart.setText("编辑");
                    btBuybuybuy.setText("下单");
                    adapter.setShowVt(true);

                    //清空购物车-->重新上传，最后一个数据刷新
                    clearCart();

                }
                break;
            case R.id.bt_buybuybuy:
                //买买买按钮
                deleteShopping();
                break;

            case R.id.cb_AllSelect_ShoppingCart:
                if (cb_AllSelect.isChecked()){
                    adapter.setAllSelete(true);
                    adapter.notifyDataSetChanged();
                }else {
                    adapter.setAllSelete(false);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    private void clearCart() {
        HashMap<String, String> map = new HashMap<>();
        String st = "";
        for (CartBean.DataDTO.CartListDTO bean : list) {
            st += bean.getProduct_id() + ",";
        }

        map.put("productIds",st);
        mPresenter.deleteCart(null,"cart/delete",map);
    }

    public void upData() {
        for (int i = 0; i < list.size(); i++) {
            CartBean.DataDTO.CartListDTO bean = list.get(i);
            if (bean.getNumber()==0){
                continue;
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("goodsId",bean.getGoods_id()+"");
            map.put("number",bean.getNumber()+"");
            map.put("productId",bean.getProduct_id()+"");

            //判断是否是最后一个上传数据，以此刷新
            if (i==list.size()-1){
                mPresenter.addCart(null,"cart/add",map,true);
            }else {
                mPresenter.addCart(null,"cart/add",map,false);

            }
        }
    }


    public void deleteShopping() {
        //如果当前页面是为了删除
        if (btBuybuybuy.getText().toString().equals("删除所选")){
            StringBuffer st=new StringBuffer();
            //循环判断获取要删除的商品id
            for (CartBean.DataDTO.CartListDTO dto : list) {
                //判断删除标记
                if (dto.isDelete()){
                    st.append(dto.getProduct_id()+",");
                }
            }
            //拼接查询参数调用接口删除
            HashMap<String, String> map = new HashMap<>();
            map.put("productIds",st.toString());
            mPresenter.deleteCart(null,"cart/delete",map);
//            initData();
        }else {

        }
    }


}