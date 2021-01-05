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

    public static Object  ob = new Object();

    private  void addPresenter() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob){
                    add();
                }
            }
        }).start();
    }

    private synchronized void add() {
        Type genType = BaseFragment.this.getClass().getGenericSuperclass();
        Log.e("aaa", genType+"");
//        String name = genType.getClass().getName();
//        Log.e("bbc", "名"+name);
//        String name1 = genType.getClass().getTypeName();
//        Log.e("bbc", "类型名"+name1);
//        String name2 = genType.getClass().getSimpleName();
//        Log.e("bbc", "Simple名"+name2);
//        String name3 = genType.getClass().getCanonicalName();
//        Log.e("bbc", "Canonical名"+name3);




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
