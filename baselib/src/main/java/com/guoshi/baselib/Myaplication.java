package com.guoshi.baselib;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.guoshi.baselib.db.DaoMaster;
import com.guoshi.baselib.db.DaoSession;
import com.mob.MobSDK;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/9
 * 文件描述：
 */
public class Myaplication extends Application {
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    public static Myaplication instances;
    @Override
    public void onCreate() {
        super.onCreate();
        instances=this;
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(instances); // 尽可能早，推荐在Application中初始化
        CrashReport.initCrashReport(getApplicationContext(), "9cf7ad23d4", true);
        setdatabase();
        MobSDK.init(instances);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }

    public static Myaplication getInstances(){
        return instances;
    }

    /**
     * 设置greenDAO
     */
    private void setdatabase(){
        helper=new DaoMaster.DevOpenHelper(this,"jjt-db",null);
        db=helper.getWritableDatabase();
        daoMaster=new DaoMaster(db);
        daoSession=daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
