package com.guoshi.module_home;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.route.BaseLibUtlis;
import com.guoshi.baselib.route.ModuleHomeUtlis;
import com.guoshi.baselib.utils.Utils;
import com.guoshi.module_home.databinding.FragmentHomeBinding;


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：首页fragment
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            binding.wdln.setPadding(0, BaseActivity.getstatusbar(getActivity()),0,0);
        }

        initview();
        return binding.getRoot();
    }


    private void initview(){
        binding.homes.setOnClickListener(this);
        binding.cemetery.setOnClickListener(this);
        binding.privatePlacement.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.homes) {
//            ARouter.getInstance()
//                    .build(ModuleHomeUtlis.HOME_SEEK)
//                    .withTransition(R.anim.slide_right_in, R.anim.slide_left_out)
//                    .navigation();
            ARouter.getInstance()
                    .build(BaseLibUtlis.WEBVIEW)
                    .withTransition(R.anim.slide_right_in,R.anim.slide_left_out)
                    .navigation();
        }else if(i==R.id.cemetery){
            ARouter.getInstance()
                    .build(ModuleHomeUtlis.PUBLIC_MAIN)
                    .withTransition(R.anim.slide_right_in, R.anim.slide_left_out)
                    .navigation();
        }else if(i==R.id.private_placement){
            Utils.share(getActivity(),"分享title","分享内容",
                    "https://www.baidu.com",
                    "http://img.i-banmei.com/inviteShareShowPic.png",
                    "qq");
        }
    }
}

