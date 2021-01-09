package com.example.yanx.mvp.start.view;

import android.content.Intent;

import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.mvp.home.activity.HomeActivity;
import com.example.yanx.mvp.login.view.LoginActivity;
import com.example.yanx.mvp.start.StartPageContrct;
import com.example.yanx.mvp.start.presenter.StartPagePresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class StartPageActivity extends BaseActivity<StartPagePresenter>
        implements StartPageContrct.IStartPageView {


    private Disposable subscribe;
    private Intent intent;

    @Override
    protected void initData() {
        mPresenter.refreshToken();
    }

    @Override
    protected void initView() {
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (aLong == 5) {
                            //5秒后默认未登录过（未记住密码）跳转至loginActivity
                            failure();
                        }
                    }
                });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    public void refreshToken() {
        intent = new Intent(StartPageActivity.this, HomeActivity.class);
        staIntent();
    }

    @Override
    public void failure() {
        intent = new Intent(StartPageActivity.this, LoginActivity.class);
        staIntent();
    }

    private void staIntent() {
        startActivity(intent);
        subscribe.dispose();
        finish();
    }
}