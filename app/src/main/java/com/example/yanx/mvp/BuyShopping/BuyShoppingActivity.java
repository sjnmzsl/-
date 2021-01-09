package com.example.yanx.mvp.BuyShopping;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.bean.AddCartBean;
import com.example.yanx.bean.BuyShoppingBean;
import com.example.yanx.bean.LoginBean;
import com.example.yanx.contract.BaseContract;
import com.example.yanx.mvp.home.activity.HomeActivity;
import com.tencent.mmkv.MMKV;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.HashMap;
import java.util.List;

public class BuyShoppingActivity extends BaseActivity<BuyShoppingPresenter>
        implements BaseContract.IView<BuyShoppingBean>, View.OnClickListener {



    private Banner bannerBuyShopping;
    private TextView tvNameBuyShopping;
    private TextView tvPriceBuyShopping;

    private ImageView imaCollect;
    private ImageView imaCart;
    private TextView tvNowBuy;
    private TextView tvAddCart;
    private TextView tvCountBuyShopping;

    private static int count;
    private BuyShoppingBean.DataDTO data;
    private List<BuyShoppingBean.DataDTO.ProductListDTO> productList;


    @Override
    protected int getLayout() {
        return R.layout.activity_buy_shopping;
    }

    @Override
    protected void initData() {
        String id = getIntent().getStringExtra("id");
        mPresenter.get("goods/detail?id="+id);
    }

    @Override
    protected void initView() {


        bannerBuyShopping = (Banner) findViewById(R.id.banner_BuyShopping);
        tvNameBuyShopping = (TextView) findViewById(R.id.tv_name_buyShopping);
        tvPriceBuyShopping = (TextView) findViewById(R.id.tv_price_buyShopping);

        imaCollect = (ImageView) findViewById(R.id.ima_collect);
        imaCart = (ImageView) findViewById(R.id.ima_cart);
        tvNowBuy = (TextView) findViewById(R.id.tv_nowBuy);
        tvAddCart = (TextView) findViewById(R.id.tv_addCart);
        tvCountBuyShopping = (TextView) findViewById(R.id.tv_count_buyShopping);

        imaCollect.setOnClickListener(this::onClick);
        tvAddCart.setOnClickListener(this::onClick);
        imaCart.setOnClickListener(this::onClick);


    }


    public void addCartSuccess(AddCartBean addCartBean){
        AddCartBean.DataDTO.CartTotalDTO data = addCartBean.getData().getCartTotal();
        Integer integer = data.getCheckedGoodsCount();
        tvCountBuyShopping.setText(integer+"");
    }

    @Override
    public void getSuccess(BuyShoppingBean bean) {
        BuyShoppingBean.DataDTO data = bean.getData();
        productList = data.getProductList();
        List<BuyShoppingBean.DataDTO.GalleryDTO> gallery = data.getGallery();

        bannerBuyShopping.setImages(gallery)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BuyShoppingBean.DataDTO.GalleryDTO gallery= (BuyShoppingBean.DataDTO.GalleryDTO) path;
                        Glide.with(context).load(gallery.getImg_url()).into(imageView);
                    }
                })
                .start();
        BuyShoppingBean.DataDTO.InfoDTO info = data.getInfo();
        tvNameBuyShopping.setText(info.getName());
        tvPriceBuyShopping.setText("￥"+info.getUnit_price());
    }

    @Override
    public void getFailure(String error) {
        Log.e(TAG, "购买商品数据"+error );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ima_collect:
                imaCollect.setSelected(!imaCollect.isSelected());
                break;
            case R.id.tv_addCart:
                HashMap<String, String> map = new HashMap<>();
                BuyShoppingBean.DataDTO.ProductListDTO dto = productList.get(0);
                map.put("goodsId",dto.getGoods_id()+"");
                map.put("number","1");
                map.put("productId",dto.getId()+"");
                mPresenter.post(null,"cart/add",map);
                break;
            case R.id.ima_cart:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("page",3);
                startActivity(intent);
                break;
        }
    }
}