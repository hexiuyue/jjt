package com.guoshi.baselib.api.http;


import android.content.Context;

import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：Retrofit
 */
public class RetrofitFactory {

    private static RetrofitFactory mRetrofitFactory;

    private static APIFunction mAPIFunction;
    private RetrofitFactory(Context context){
        OkHttpClient mOkHttpClient=new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME, TimeUnit.MILLISECONDS)
                .readTimeout(HttpConfig.HTTP_TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(HttpConfig.HTTP_TIME, TimeUnit.MILLISECONDS)
//                .addInterceptor(InterceptorUtil.tokenInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type","application/json;charset=UTF-8")//添加头部
                                .addHeader("AppVersion", BaseActivity.getVerName(context))//添加版本名称
                                .addHeader("AppToken", "ssToken")//添加Token
                                .addHeader("HostType", "android")//添加设备类型
                                .addHeader("OsVersion", BaseActivity.getbrand())//添加手机型号 厂家系统版本
                                .addHeader("PhoneModel", BaseActivity.getrelease())//添加系统版本
                                .build();
                        return chain.proceed(request);

                    }
                })
//                .addNetworkInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return null;
//                    }
//                })
                .build();
        Retrofit mRetrofit=new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build();
        mAPIFunction=mRetrofit.create(APIFunction.class);
    }

    public static RetrofitFactory getInstence(Context context){
        if (mRetrofitFactory==null){
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null)
                    mRetrofitFactory = new RetrofitFactory(context);
            }

        }
        return mRetrofitFactory;
    }
    public APIFunction API(){
        return mAPIFunction;
    }
}
