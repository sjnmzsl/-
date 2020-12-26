package com.example.mylibrary.base;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.ArrayList;

public abstract class BaseDelegateAdapter<T> extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    protected Activity activity;
    protected LayoutHelper layoutHelper;
    protected ArrayList<T> list;

    public BaseDelegateAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<T> list) {
        this.activity = activity;
        this.layoutHelper = layoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }
}
