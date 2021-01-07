package com.example.yanx.home.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.home.fragment.presenter.HomeFraPresenter;
import com.example.yanx.home.fragment.view.DirectoryFragment;
import com.example.yanx.home.fragment.view.HomeFragment;
import com.example.yanx.home.fragment.view.SpecialFragment;

public class HomeActivity extends BaseActivity<HomeFraPresenter> implements View.OnClickListener {


    private androidx.appcompat.widget.Toolbar toobHome;
    private android.widget.FrameLayout fralayoutHome;
    private android.widget.RadioGroup rbgroup;
    private android.widget.RadioButton rbHomeFra;
    private android.widget.RadioButton rbSpecial;
    private android.widget.RadioButton rbInfo;
    private android.widget.RadioButton rbShoppingCart;
    private android.widget.RadioButton rbMy;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private FragmentManager fragmentManager;
    private DirectoryFragment directoryFragment;

    @Override
    protected void initData() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        fragmentManager = getSupportFragmentManager();
        directoryFragment = new DirectoryFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fralayout_Home,homeFragment)
                .add(R.id.fralayout_Home,specialFragment)
                .add(R.id.fralayout_Home,directoryFragment)
                .setMaxLifecycle(directoryFragment, Lifecycle.State.CREATED)
                .show(homeFragment)
                .hide(specialFragment)
                .hide(directoryFragment)
                .commit();

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
        rbShoppingCart = (RadioButton) findViewById(R.id.rb_ShoppingCart);
        rbMy = (RadioButton) findViewById(R.id.rb_my);

        rbHomeFra.setOnClickListener(this);
        rbSpecial.setOnClickListener(this);
        rbInfo.setOnClickListener(this);
        rbShoppingCart.setOnClickListener(this);
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
                        .commit();
                break;
            case R.id.rb_special:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .show(specialFragment)
                        .hide(directoryFragment)
                        .commit();
                break;
            case R.id.rb_ShoppingCart:

                break;
            case R.id.rb_directroy:
                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(specialFragment)
                        .show(directoryFragment)
                        .setMaxLifecycle(directoryFragment, Lifecycle.State.RESUMED)
                        .commit();
                break;
            case R.id.rb_my:

                break;

        }
    }
}