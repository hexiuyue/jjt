package com.guoshi.baselib.api.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.guoshi.baselib.api.http.bean.BaseEntity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Call;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：拦截器工具类
 */
public class InterceptorUtil {
    public static String TAG = "InterceptorUtil";
    private static String Token = "";
    public final static Charset UTF8 = Charset.forName("UTF-8");

    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.w(TAG, "log: " + message);
            }

        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }
    /**
     * token验证的拦截器
     * @return
     */
    public static Interceptor tokenInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                String s= response.body().string();
                //处理返回的数据我这创建了一个BaseEntity来将数据转化为对象
                BaseEntity bean = JSON.parseObject(s, BaseEntity.class);
                if(bean.getStatus()==104){//token失效

                }
                return chain.proceed(request);
            }
        };

    }

    /**
     * token验证的拦截器1
     * @return
     */
    public static void tokenInterceptor1(){
        new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拿到请求体,并添加header携带上token
                Request mRequest = chain.request().newBuilder()
                        .addHeader("Token", Token)
                        .build();
                //拿到响应体
                Response mResponse = chain.proceed(mRequest);

                if (mResponse.code()==401){
//                    //重新获取新token
//                    //这用了一个特殊接口来获取新的Token
//                    Call<String> call = RetrofitFactory.getInstence().API().loginByToken("123456", Token);
//                    //拿到请求体
//                    Request tokenRequest = call.request();
//                    //获取响应体
//                    Response tokenResponse = chain.proceed(tokenRequest);
//                    //我这假设新的token是在header里返回的
//                    //我们拿到新的token头
//                    List<String> listHeader = tokenResponse.headers().values("Token");
//                    if (listHeader != null) {
//                        //重新赋值到新的token
//                        Token = listHeader.get(0);
//                    }
//
//                    //这是只需要替换掉之前的token重新请求接口就行了
//                    Request newRequest = mRequest.newBuilder()
//                            .header("Token", Token)
//                            .build();
//                    return chain.proceed(newRequest);
                }
                return mResponse;
            }
        };
    }
}
