package com.example.yanx.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.example.mylibrary.base.BaseDelegateAdapter;
import com.example.yanx.R;

import java.util.ArrayList;

public class TitleAdapter extends BaseDelegateAdapter<String> {

    public TitleAdapter(Activity activity, LayoutHelper layoutHelper, ArrayList<String> list) {
        super(activity, layoutHelper, list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_title, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tv_title = holder.itemView.findViewById(R.id.tv_title);
        tv_title.setText(list.get(0));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
