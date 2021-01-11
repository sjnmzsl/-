package com.example.yanx.mvp.home.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.bean.BuyShoppingBean;
import com.example.yanx.mvp.home.fragment.CartFragment;
import com.example.yanx.mvp.home.presenter.HomeFraPresenter;
import com.example.yanx.mvp.home.fragment.DirectoryFragment;
import com.example.yanx.mvp.home.fragment.HomeFragment;
import com.example.yanx.mvp.home.fragment.SpecialFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<HomeFraPresenter> implements View.OnClickListener {


    private androidx.appcompat.widget.Toolbar toobHome;
    private android.widget.FrameLayout fralayoutHome;
    private android.widget.RadioGroup rbgroup;
    private android.widget.RadioButton rbHomeFra;
    private android.widget.RadioButton rbSpecial;
    private android.widget.RadioButton rbInfo;
    private android.widget.RadioButton raCart;
    private android.widget.RadioButton rbMy;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private FragmentManager fragmentManager;
    private DirectoryFragment directoryFragment;
    private CartFragment cartFragment;

    @Override
    protected void initData() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        fragmentManager = getSupportFragmentManager();
        directoryFragment = new DirectoryFragment();
        cartFragment = new CartFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fralayout_Home,homeFragment)
                .add(R.id.fralayout_Home,specialFragment)
                .add(R.id.fralayout_Home,directoryFragment)
                .add(R.id.fralayout_Home, cartFragment)
                .show(homeFragment)
                .hide(specialFragment)
                .hide(directoryFragment)
                .hide(cartFragment)
                .commit();
    }

    @Override
    protected void onResume() {
        //根据传入的页数选择显示那个页面
        int page = getIntent().getIntExtra("page", -1);
        switch (page){
            case 3:
//                raCart.setSelected(true);
//                raCart.setChecked(true);
//                raCart.setPressed(true);
//                raCart.setClickable(true);
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .hide(directoryFragment)
                        .show(cartFragment)
                        .commit();
                break;
        }
        super.onResume();
    }

    @Override
    protected void initView() {

        toobHome = (Toolbar) findViewById(R.id.toob_Home);
        setSupportActionBar(toobHome);
        fralayoutHome = (FrameLayout) findViewById(R.id.fralayout_Home);
        rbgroup = (RadioGroup) findViewById(R.id.rbgroup_HomeFra);
        rbHomeFra = (RadioButton) findViewById(R.id.rb_HomeFra);
        rbSpecial = (RadioButton) findViewById(R.id.rb_special);
        rbInfo = (RadioButton) findViewById(R.id.rb_directroy);
        raCart = (RadioButton) findViewById(R.id.rb_Cart);
        rbMy = (RadioButton) findViewById(R.id.rb_my);

        rbHomeFra.setOnClickListener(this);
        rbSpecial.setOnClickListener(this);
        rbInfo.setOnClickListener(this);
        raCart.setOnClickListener(this);
        rbMy.setOnClickListener(this);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_HomeFra:
                fragmentManager.beginTransaction()
                        .show(homeFragment)
                        .hide(specialFragment)
                        .hide(directoryFragment)
                        .hide(cartFragment)
                        .commit();
                break;
            case R.id.rb_special:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .show(specialFragment)
                        .hide(directoryFragment)
                        .hide(cartFragment)
                        .commit();
                break;
            case R.id.rb_directroy:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .show(directoryFragment)
                        .hide(cartFragment)
                        .commit();
                break;
            case R.id.rb_Cart:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .hide(directoryFragment)
                        .show(cartFragment)
                        .commit();
                break;
            case R.id.rb_my:
//                fragmentManager.beginTransaction()
//                        .show(homeFragment)
//                        .hide(specialFragment)
//                        .hide(directoryFragment)
//                        .show(cartFragment)
//                        .commit();
                break;

        }
    }
}