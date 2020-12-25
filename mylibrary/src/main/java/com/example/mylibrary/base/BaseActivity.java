package com.example.mylibrary.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.api.ICallBack;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements ICallBack {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        addPresenter();
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected void addPresenter() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class type = (Class) actualTypeArguments[0];
        try {
            Log.e("TAG", "addPresenter:");
            mPresenter = (P) type.newInstance();
            mPresenter.addView(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    protected abstract int getLayout();
}
