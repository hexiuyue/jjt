package com.guoshi.baselib.web;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guoshi.baselib.R;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.databinding.ActivityWebViewBinding;
import com.guoshi.baselib.route.BaseLibUtlis;
import com.guoshi.baselib.utils.StatusBarUtil;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/16
 * 文件描述：统一webview
 */
@Route(path = BaseLibUtlis.WEBVIEW)
public class WebViewActivity extends BaseActivity implements View.OnClickListener {
    private ActivityWebViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarLightMode(this);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_web_view);
        initview();
    }
    private String url="https://view.inews.qq.com/w/WXN20190611002025020?refer=nwx&bat_id=1109043838&cur_pos=3&openid=o04IBANy6jAyshaGba8HVzXwOzDU&groupid=1560228624&msgid=3";
    private boolean isGoBack = false;
    private boolean isFirst = true;
    private ImageView iamgeView;
    private void initview(){
        binding.webviewtop.findViewById(R.id.topviews).setVisibility(View.GONE);
        // 设置setWebChromeClient对象
        binding.webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(!isGoBack){//回退不显示进度条
                    if(newProgress==100){
                        binding.progressbar.setVisibility(View.GONE);//加载完网页进度条消失
                    }
                    else{
                        binding.progressbar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                        binding.progressbar.setProgress(newProgress);//设置进度值
                    }
                }
                if (isFirst) {
                    return; //刚进入页面不需要模拟效果，app自己有
                }
                if(newProgress==100){
                    //加载完毕，显示webview 隐藏imageview
                    view.setVisibility(View.VISIBLE);
                    if (iamgeView != null){
                        iamgeView.setVisibility(View.GONE);
                    }
                    //页面进入效果的动画
                    Animation translate_in = AnimationUtils.loadAnimation(
                            WebViewActivity.this, R.anim.slide_right_in);
                    Animation translate_out = AnimationUtils.loadAnimation(
                            WebViewActivity.this, R.anim.slide_left_out);
                    //页面退出的动画
                    if (isGoBack){
                        translate_in = AnimationUtils.loadAnimation(
                                WebViewActivity.this, R.anim.slide_left_in);
                        translate_out = AnimationUtils.loadAnimation(
                                WebViewActivity.this, R.anim.slide_right_out);
                    }
                    translate_in.setFillAfter(true);
                    translate_in.setDetachWallpaper(true);
                    translate_out.setFillAfter(true);
                    translate_out.setDetachWallpaper(true);
//                     开启动画
                    if(null!=iamgeView){
                        iamgeView.startAnimation(translate_out);
                    }
                    view.startAnimation(translate_in);
                    //动画结束后，移除imageView
                    translate_out.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            if(null!=iamgeView){
                                binding.root.removeView(iamgeView);
                                iamgeView=null;
                                isGoBack = false;
                            }
                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {


                        }
                    });
                }else {
                    view.setVisibility(View.GONE);//先隐藏webview
                    //url没加载好之前，隐藏webview，在主布局中，加入imageview显示当前页面快照
                    if(null==iamgeView){
                        iamgeView=new ImageView(WebViewActivity.this);
                        view.setDrawingCacheEnabled(true);
                        Bitmap bitmap=view.getDrawingCache();
                        if(null!=bitmap){
                            Bitmap b= Bitmap.createBitmap(bitmap);
                            iamgeView.setImageBitmap(b);
                        }
                        binding.root.addView(iamgeView);
                    }
                }
            }
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                ((TextView)binding.webviewtop.findViewById(R.id.alltext)).setText(title);

            }
        });
        binding.webview.addJavascriptInterface(new WebViewActivity.WebAppAndroid(this), "android");
        //声明WebSettings子类
        WebSettings webSettings = binding.webview.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(false); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(false); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setDomStorageEnabled(true); // 开启 DOM storage 功能("utf-8");//设置编码格式
        //使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        binding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url2) {
                isFirst = false;
                view.loadUrl(url2);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // 接受所有网站的证书
            }
        });


        binding.webviewtop.findViewById(R.id.baseback).setOnClickListener(this);

        binding.webview.loadUrl(url);
    }



    public class WebAppAndroid {
        Context mContext;

        public WebAppAndroid(Context context) {
            this.mContext = context;
        }

        @JavascriptInterface
        public void showToast(String id){

        }
    }

    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && binding.webview.canGoBack()) {
            isGoBack = true;
            binding.webview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        } else {
            this.finish();
            outacvivity(WebViewActivity.this);
        }
        return false;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.baseback) {
            if (binding.webview.canGoBack()) {
                isGoBack = true;
                binding.webview.goBack(); //goBack()表示返回WebView的上一页面
            } else {
                this.finish();
                outacvivity(WebViewActivity.this);
            }
        }
    }
}
