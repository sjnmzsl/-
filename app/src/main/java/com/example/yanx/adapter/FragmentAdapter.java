package com.example.yanx.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fraList;
    private ArrayList<String> tabList;

    public FragmentAdapter(@NonNull FragmentManager fm,ArrayList<Fragment> fraList,
                           ArrayList<String> tabList) {
        super(fm);
        this.fraList=fraList;
        this.tabList=tabList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fraList.get(position);
    }

    @Override
    public int getCount() {
        return fraList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
