package com.guoshi.module_home;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.route.BaseLibUtlis;
import com.guoshi.baselib.route.ModuleHomeUtlis;
import com.guoshi.baselib.utils.Utils;
import com.guoshi.module_home.databinding.FragmentHomeBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        binding.bankFinancing.setOnClickListener(this);
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
            Utils.showShareDialog(getActivity(),this);
        }else if(i==R.id.wx){
            Utils.share(getActivity(),"分享title","分享内容",
                    "https://www.baidu.com",
                    "http://img.i-banmei.com/inviteShareShowPic.png",
                    "wx");
        }else if(i==R.id.wxp){
            Utils.share(getActivity(),"分享title","分享内容",
                    "https://www.baidu.com",
                    "http://img.i-banmei.com/inviteShareShowPic.png",
                    "wxp");
        }else if(i==R.id.qq){
            Utils.share(getActivity(),"分享title","分享内容",
                    "https://www.baidu.com",
                    "http://img.i-banmei.com/inviteShareShowPic.png",
                    "qq");
        }else if(i==R.id.qqk){
            Utils.share(getActivity(),"分享title","分享内容",
                    "https://www.baidu.com",
                    "http://img.i-banmei.com/inviteShareShowPic.png",
                    "qqk");
        }else if(i==R.id.bank_financing){
//            Bitmap bitmap=shotScrollView(binding.wdln);
//            saveBitmap(getActivity(),bitmap);
        }
    }
//    public static Bitmap shotScrollView(ScrollView scrollView) {
//        int h = 0;
//        Bitmap bitmap = null;
//        for (int i = 0; i < scrollView.getChildCount(); i++) {
//            h += scrollView.getChildAt(i).getHeight();
//            scrollView.getChildAt(i).setBackgroundColor(Color.parseColor("#ffffff"));
//        }
//        Log.d("实际高度", "实际高度:" + h);
//        Log.d("实际高度", " 高度:" + scrollView.getHeight());
//        bitmap = Bitmap.createBitmap(scrollView.getWidth(), h, Bitmap.Config.ARGB_8888);
//        final Canvas canvas = new Canvas(bitmap);
//        canvas.drawColor(Color.WHITE);
//        scrollView.getChildAt(0).draw(canvas);
//        return bitmap;
//    }
//    private void saveBitmap(Context context, Bitmap bitmap){
//        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//        String bitName=format.format(new Date())+".JPEG";
//        final String fileName ;
//        File file ;
//        if(Build.BRAND .equals("Xiaomi") ){ // 小米手机
//            fileName = Environment.getExternalStorageDirectory().getPath()+"/DCIM/"+bitName ;
//        }else{  // Meizu 、Oppo
//            fileName = Environment.getExternalStorageDirectory().getPath()+"/DCIM/"+bitName ;
//        }
//        file = new File(fileName);
//
//        if(file.exists()){
//            file.delete();
//        }
//        FileOutputStream out;
//        try{
//            out = new FileOutputStream(file);
//            // 格式为 JPEG，照相机拍出的图片为JPEG格式的，PNG格式的不能显示在相册中
//            if(bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out))
//            {
//                out.flush();
//                out.close();
//
//
//                // 插入图库
//                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), bitName, null);
//            }
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        // 发送广播，通知刷新图库的显示
//        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + fileName)));
//        Toast.makeText(context, "图片保存图库成功", Toast.LENGTH_LONG).show();
//    }

}

