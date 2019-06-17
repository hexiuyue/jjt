package com.guoshi.baselib.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.guoshi.baselib.R;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：activity父类
 */
public class BaseActivity extends FragmentActivity {
    public <T> ObservableTransformer<T,T> setThread(){
       return new ObservableTransformer<T,T>() {
            @Override
            public ObservableSource<T>  apply(Observable<T>  upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    public static int getstatusbar(Context context){
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static void inacvivity(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }

    public static void outacvivity(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }

    /**
     * //获取系统时间的13位的时间戳
     * @return
     */
    public static String getTime() {
        long time = System.currentTimeMillis();
        String str = String.valueOf(time);
        return str;
    }
    /**
     * 获取版本名称
     *
     * @param context
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        if (context != null) {
            try {
                verName = context.getPackageManager().getPackageInfo(
                        "com.guoshi.jjt", 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("msg", e.getMessage());
            }
        }
        return verName;
    }

    /**
     * 获取手机型号 厂家系统版本
     */
    public static String getbrand() {
        String brand = android.os.Build.MODEL + "    " + android.os.Build.BRAND;
        return brand;
    }

    /**
     * 获取手机系统版本
     */
    public static String getrelease() {
        String brand = android.os.Build.VERSION.RELEASE;
        return brand;
    }

    //隐藏输入法
    public static void hidenInputMethod(Context context) {
        if(((Activity) context).getCurrentFocus()!=null){
            ((InputMethodManager) ((Activity) context).getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    ((Activity) context).getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
