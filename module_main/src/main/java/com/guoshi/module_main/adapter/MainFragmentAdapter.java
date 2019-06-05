package com.guoshi.module_main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：主界面viewpaget适配器
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    public MainFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list){
        super(fm);
        this.list=list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
