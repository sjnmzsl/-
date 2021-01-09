package com.example.yanx.mvp.home.fragment;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylibrary.base.BaseFragment;
import com.example.yanx.R;
import com.example.yanx.bean.DeleteCartBean;
import com.example.yanx.bean.ShoppingCartBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.adapter.CartAdapter;
import com.example.yanx.mvp.home.presenter.CartFraPresenter;

import java.util.ArrayList;
import java.util.HashMap;


public class CartFragment extends BaseFragment<CartFraPresenter>
        implements  View.OnClickListener {

    private RecyclerView recyShoppingCart;
    private LinearLayout linShoppingCart;
    private CheckBox cbSelectAllShoppingCart;
    private TextView tvPriceAllShoppingCart;
    private TextView tvSetShoppingCart;
    private Button btBuybuybuy;
    private ArrayList<ShoppingCartBean.DataDTO.CartListDTO> list;
    private CartAdapter adapter;
    private FragmentActivity activity;


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    protected int getLayouId() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void initData() {
        list.clear();
        mPresenter.post(null,"cart/index",null);

    }

    @Override
    protected void initView() {
        activity = getActivity();
        recyShoppingCart = (RecyclerView) view.findViewById(R.id.recy_ShoppingCart);
        linShoppingCart = (LinearLayout) view.findViewById(R.id.lin_ShoppingCart);
        cbSelectAllShoppingCart = (CheckBox) view.findViewById(R.id.cb_SelectAll_ShoppingCart);
        tvPriceAllShoppingCart = (TextView) view.findViewById(R.id.tv_PriceAll_ShoppingCart);
        tvSetShoppingCart = (TextView) view.findViewById(R.id.tv_setShoppingCart);
        btBuybuybuy = (Button) view.findViewById(R.id.bt_buybuybuy);

        //recy展示要购买的商品
        list = new ArrayList<>();
        adapter = new CartAdapter(activity,list);
        recyShoppingCart.setLayoutManager(new LinearLayoutManager(activity));
        recyShoppingCart.setAdapter(adapter);

        tvSetShoppingCart.setOnClickListener(this::onClick);
        btBuybuybuy.setOnClickListener(this::onClick);
    }


    public void deleteSuccess() {
        initData();
    }

//    @Override
    public void getSuccess(ShoppingCartBean bean) {
        list.addAll(bean.getData().getCartList());
        adapter.notifyDataSetChanged();

    }

//    @Override
    public void getFailure(String error) {
        Log.e(TAG, " CartFragment"+error);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_setShoppingCart:
                if (tvSetShoppingCart.getText().toString().equals("编辑")){
                    tvSetShoppingCart.setText("完成");
                    btBuybuybuy.setText("删除所选");
                    adapter.setShowVt(false);
                    adapter.notifyDataSetChanged();
                }else {
                    tvSetShoppingCart.setText("编辑");
                    btBuybuybuy.setText("下单");
                    adapter.setShowVt(true);
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.bt_buybuybuy:
                if (btBuybuybuy.getText().toString().equals("删除所选")){
                    StringBuffer st=new StringBuffer();
                    for (ShoppingCartBean.DataDTO.CartListDTO dto : list) {
                        if (dto.isDelete()){
                            st.append(dto.getProduct_id()+",");
                        }
                    }
                    HashMap<String, String> map = new HashMap<>();
                    map.put("productIds",st.toString());
                    mPresenter.deleteCart(null,"cart/delete",map);

                }else {

                }
                break;
        }
    }
}