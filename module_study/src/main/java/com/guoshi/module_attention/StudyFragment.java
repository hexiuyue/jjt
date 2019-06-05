package com.guoshi.module_attention;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.module_attention.databinding.FragmentStudyBinding;


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：关注fragment
 */
public class StudyFragment extends Fragment implements View.OnClickListener {
    private FragmentStudyBinding binding;
    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_study, container, false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            binding.wdln.setPadding(0, BaseActivity.getstatusbar(getActivity()),0,0);
        }
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
//        if (i == R.id.intohome) {
//            ARouter.getInstance().build(ModuleHomeUtlis.test).navigation();
//        }
    }
}
