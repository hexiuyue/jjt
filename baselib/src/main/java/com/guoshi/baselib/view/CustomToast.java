package com.guoshi.baselib.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.guoshi.baselib.R;


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/20.
 * 文件描述：自定义Toast
 */
public class CustomToast {
    private static TextView mTextView;
    private static Toast toastStart;

    public static void showToast(Context context, String message) {
        if(toastStart!=null){
            toastStart.cancel();
        }
        //加载Toast布局
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
        //初始化布局控件
        mTextView = (TextView) toastRoot.findViewById(R.id.toast_text);
        //为控件设置属性
        mTextView.setText(message);
        //Toast的初始化
        toastStart = new Toast(context);
        //获取屏幕高度
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        //Toast的Y坐标是屏幕高度的1/3，不会出现不适配的问题
        toastStart.setGravity(Gravity.BOTTOM, 0, height / 2);
        toastStart.setDuration(Toast.LENGTH_SHORT);
        toastStart.setView(toastRoot);
        toastStart.show();
    }
}
