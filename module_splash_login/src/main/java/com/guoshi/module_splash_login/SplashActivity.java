package com.guoshi.module_splash_login;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.route.MainUtlis;
import com.guoshi.baselib.route.ModuleSplashLoginUtlis;
/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：启动页
 */
@Route(path = ModuleSplashLoginUtlis.Splash)
public class SplashActivity extends BaseActivity {

    private static final int  WHAT_DELAY=0x11;// 启动页的延时跳转
    private static final int  DELAY_TIME=1000;// 延时时间

//     创建Handler对象，处理接收的消息
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case WHAT_DELAY:// 延时3秒跳转
                     goHome();
                     break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 调用handler的sendEmptyMessageDelayed方法
        handler.sendEmptyMessageDelayed(WHAT_DELAY, DELAY_TIME);
    }
    /**
     * 跳转到主页面
     */
    private void goHome(){
        ARouter.getInstance()
                .build(MainUtlis.MAIN)
                .withTransition(R.anim.slide_right_in, R.anim.slide_left_out)
                .navigation();
        finish();
    }
}
