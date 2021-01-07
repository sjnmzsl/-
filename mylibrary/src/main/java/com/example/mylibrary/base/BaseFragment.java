package com.example.mylibrary.base;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.locks.Lock;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{
    protected P mPresenter;
    protected View view;

    @Override
    public  void onCreate(@Nullable Bundle savedInstanceState) {
        addPresenter();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayouId(), container,false);
        initView();
        initData();
        return view;
    }



    private  void addPresenter() {
        Type genType = BaseFragment.this.getClass().getGenericSuperclass();
        Log.e("aaa", genType+"");

        ParameterizedType parameterizedType = (ParameterizedType) genType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        Class type = (Class) actualTypeArguments[0];

        try {

            mPresenter = (P) type.newInstance();
            mPresenter.addView(BaseFragment.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    protected abstract int getLayouId();

    protected abstract void initData();

    protected abstract void initView();
}
