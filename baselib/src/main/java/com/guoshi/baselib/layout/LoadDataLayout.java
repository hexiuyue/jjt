package com.guoshi.baselib.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoshi.baselib.R;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：界面状态切换layout
 */

public class LoadDataLayout extends FrameLayout {

    private Context context;

    /**
     * 绑定显示数据的控件
     */
    private View bindView;

    /**
     * 空数据时的布局
     */
    private View emptyView;
    private ImageView emptyImg;
    private TextView emptyTv;
    private int emptyImgId;
    private String emptyString;
    /**
     * 错误时的布局
     */
    private View errorView;
    private ImageView errorImg;
    private TextView errorTv;
    private int errorImgId;
    private String errorString;
    /**
     * 数据加载时的布局
     */
    private View loadingView;
    private ImageView loadingImg;
    private TextView loadingTv;
    private int loadingImgId;
    private String loadingString;

    public LoadDataLayout(Context context) {
        this(context, null);
    }

    public LoadDataLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadDataLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //居中
        params.gravity = Gravity.CENTER;

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LoadDataLayout, 0, 0);

        /**
         * 数据为空的布局
         */
        int emptyLayoutId = array.getResourceId(R.styleable.LoadDataLayout_ldl_empty_layout, R.layout.default_layout_empty);
        emptyImgId = array.getResourceId(R.styleable.LoadDataLayout_ldl_empty_img, 0);
        emptyString = array.getString(R.styleable.LoadDataLayout_ldl_empty_tv);
        //获取空布局View
        emptyView = View.inflate(context, emptyLayoutId, null);

        if (emptyLayoutId == R.layout.default_layout_empty) {//如果是自带的布局
            emptyImg = (ImageView) emptyView.findViewById(R.id.empty_img);
            emptyTv = (TextView) emptyView.findViewById(R.id.empty_tv);
        }
        addView(emptyView, params);
        /**
         * 数据错误时的布局
         */
        int errorLayoutId = array.getResourceId(R.styleable.LoadDataLayout_ldl_error_layout, R.layout.default_layout_error);
        errorImgId = array.getResourceId(R.styleable.LoadDataLayout_ldl_error_img, 0);
        errorString = array.getString(R.styleable.LoadDataLayout_ldl_error_tv);
        errorView = View.inflate(context, errorLayoutId, null);

        if (errorLayoutId == R.layout.default_layout_error) {//如果是自带的布局
            errorImg = (ImageView) errorView.findViewById(R.id.error_img);
            errorTv = (TextView) errorView.findViewById(R.id.error_tv);
        }

        addView(errorView, params);

        /**
         * 数据加载时的布局
         */
        int loadingLayoutId = array.getResourceId(R.styleable.LoadDataLayout_ldl_loading_layout, R.layout.default_layout_loading);
        loadingImgId = array.getResourceId(R.styleable.LoadDataLayout_ldl_loading_img, 0);
        loadingString = array.getString(R.styleable.LoadDataLayout_ldl_loading_tv);
        loadingView = View.inflate(context, loadingLayoutId, null);

        if (loadingLayoutId == R.layout.default_layout_loading) {//如果是自带的布局
            loadingImg = (ImageView) loadingView.findViewById(R.id.loading_img);
//设置图片旋转动画
            Animation animation= AnimationUtils.loadAnimation(context,R.anim.anim_circle_rotate);
            LinearInterpolator interpolator=new LinearInterpolator();
            animation.setInterpolator(interpolator);
            loadingImg.startAnimation(animation);
            loadingTv = (TextView) loadingView.findViewById(R.id.loading_tv);
        }
        addView(loadingView, params);

        array.recycle();
        setGoneAll();

    }

    /**
     * 隐藏全部
     */
    private void setGoneAll() {
        emptyView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
    }

    /**
     * @param s 提示文字
     * @param callBack 设置图片回调接口
     */
    public void showEmpty(String s, SetImgCallBack callBack) {
        if(loadingImgId == 0){
            loadingImg.clearAnimation();
        }
        if (bindView != null) {
            bindView.setVisibility(GONE);
        }
        if (emptyTv != null) {
            if (!TextUtils.isEmpty(s)) {
                emptyTv.setText(s);
            } else if (!TextUtils.isEmpty(emptyString)) {
                emptyTv.setText(emptyString);
            }
        }
        if (emptyImg != null) {
            if (emptyImgId != 0) {
                emptyImg.setImageResource(emptyImgId);
                emptyImg.setVisibility(VISIBLE);
            }
            if (callBack != null) {
                callBack.setImg(emptyImg);
                emptyImg.setVisibility(VISIBLE);
            }
            if (emptyImgId == 0 && callBack == null){
                emptyImg.setVisibility(GONE);
            }
        }
        setGoneAll();
        emptyView.setVisibility(VISIBLE);
    }
    /**
     * @param s 提示文字
     * @param KEY 特殊字体
     * @param callBack 设置图片回调接口
     */
    public void showEmpty(String s,String KEY, SetImgCallBack callBack) {
        if(loadingImgId == 0){
            loadingImg.clearAnimation();
        }
        if (bindView != null) {
            bindView.setVisibility(GONE);
        }
        if (emptyTv != null) {
            if (!TextUtils.isEmpty(s)) {
                ForegroundColorSpan span = new ForegroundColorSpan(context.getResources().getColor(R.color.red));//要显示的颜色
                SpannableStringBuilder builder = new SpannableStringBuilder(s);
                int index = s.indexOf(KEY);//从第几个匹配上
                if(index!=-1){//有这个关键字用builder显示
                    builder.setSpan(span, index, index+KEY.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    emptyTv.setText(builder);
                }else{//没有则直接显示
                    emptyTv.setText(s);
                }
            } else if (!TextUtils.isEmpty(emptyString)) {
                emptyTv.setText(emptyString);
            }
        }
        if (emptyImg != null) {
            if (emptyImgId != 0) {
                emptyImg.setImageResource(emptyImgId);
                emptyImg.setVisibility(VISIBLE);
            }
            if (callBack != null) {
                callBack.setImg(emptyImg);
                emptyImg.setVisibility(VISIBLE);
            }
            if (emptyImgId == 0 && callBack == null){
                emptyImg.setVisibility(GONE);
            }
        }
        setGoneAll();
        emptyView.setVisibility(VISIBLE);
    }
    /**
     * 设置显示文字
     * @param s 提示文字
     */
    public void showEmpty(String s) {
        showEmpty(s, null);
    }
    /**
     * 设置图片
     * @param callBack 设置图片回调接口
     */
    public void showEmpty(SetImgCallBack callBack){
        showEmpty(null,callBack);
    }

    /**
     * 显示默认样式
     */
    public void showEmpty() {
        showEmpty(null,null);
    }

    /**
     * 显示错误布局
     *
     * @param s
     * @param callBack
     */
    public void showError(String s, SetImgCallBack callBack) {
        if(loadingImgId == 0){
            loadingImg.clearAnimation();
        }
        if (bindView != null) {
            bindView.setVisibility(GONE);
        }

        if (errorTv != null) {
            if (!TextUtils.isEmpty(s)) {
                errorTv.setText(s);
            } else if (!TextUtils.isEmpty(errorString)) {
                errorTv.setText(errorString);
            }
        }

        if (errorImg != null) {
            if (errorImgId != 0) {
                errorImg.setImageResource(errorImgId);
                errorImg.setVisibility(VISIBLE);
            }
            if (callBack != null) {
                callBack.setImg(errorImg);
                errorImg.setVisibility(VISIBLE);
            }

            if (errorImgId == 0 && callBack == null){
                errorImg.setVisibility(GONE);
            }

        }

        setGoneAll();
        errorView.setVisibility(VISIBLE);
    }

    public void showError(String s) {
        showError(s, null);
    }

    public void showError(SetImgCallBack callBack){
        showError(null,callBack);
    }

    public void showError() {
        showError(null,null);
    }

    public void showSuccess() {
        if (bindView != null) {
            bindView.setVisibility(View.VISIBLE);
        }
        setGoneAll();
    }

    /**
     * 显示加载布局
     *
     * @param s
     * @param callBack
     */
    public void showLoading(String s, SetImgCallBack callBack,boolean istext) {
        if (bindView != null) {
            bindView.setVisibility(GONE);
        }
        if (loadingTv != null) {
            if (!TextUtils.isEmpty(s)) {
                loadingTv.setText(s);
            } else if (!TextUtils.isEmpty(loadingString)) {
                loadingTv.setText(loadingString);
            }
        }
        if (loadingImg != null) {
            if (loadingImgId != 0) {
                loadingImg.setImageResource(loadingImgId);
                loadingImg.setVisibility(VISIBLE);
            }
            if (callBack != null) {
                callBack.setImg(loadingImg);
                loadingImg.setVisibility(VISIBLE);
            }

            if (loadingImgId == 0 && callBack == null && istext){
                loadingImg.setVisibility(GONE);
            }
        }
        setGoneAll();
        loadingView.setVisibility(VISIBLE);
    }

    public void showLoading(String s) {
        showLoading(s, null,false);
    }

    public void showLoading(SetImgCallBack callBack) {
        showLoading(null,callBack,false);
    }

    public void showLoading(String s,SetImgCallBack callBack) {
        showLoading(s,callBack,false);
    }
    public void showLoading(String s,boolean istext) {
        showLoading(s,null,istext);
    }
    public void showLoading() {
        showLoading(null,null,false);
    }
    public interface SetImgCallBack {
        void setImg(ImageView img);
    }

    /**
     * 设置点击屏幕重新加载数据
     *
     * @param listener
     */
    public void setRefreshListener(OnClickListener listener) {
//        emptyView.setOnClickListener(listener);
        errorView.setOnClickListener(listener);
    }

    /**
     * 设置显示数据的View
     *
     * @param view
     */
    public void setBindView(View view) {
        this.bindView = view;
    }

}
