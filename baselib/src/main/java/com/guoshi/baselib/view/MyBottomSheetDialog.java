package com.guoshi.baselib.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/6/10
 * 文件描述：自定义BottomSheetDialog主要解决沉浸式状态栏变色问题
 */
public class MyBottomSheetDialog extends BottomSheetDialog {

    public MyBottomSheetDialog(@NonNull Context context) {
        super(context);
    }

    public MyBottomSheetDialog(@NonNull Context context, int theme) {
        super(context, theme);
    }

    protected MyBottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenHeight = getScreenHeight(getContext());
        int dialogHeight = screenHeight ;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
