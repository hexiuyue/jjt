package com.guoshi.baselib.api.http;




import com.guoshi.baselib.api.http.bean.ABean;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.URLConfig;
import com.guoshi.baselib.entity.Seek;
import com.guoshi.baselib.entity.fund.FundManger;
import com.guoshi.baselib.entity.module_home.Products;
import com.guoshi.baselib.entity.module_home.PublicSeek;
import com.guoshi.baselib.entity.fund.Placement;
import com.guoshi.baselib.entity.fund.Company;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：API接口
 */
public interface APIFunction {
    @FormUrlEncoded
    @POST(URLConfig.login_token_url)//@FieldMap
    Call<String> loginByToken(@Query("mobile") String mobile, @Query("token") String cookie);
    //上传单张图片
    @POST("服务器地址")
    Observable<Object> imageUpload(@Part() MultipartBody.Part img);
    //上传多张图片
    @POST("服务器地址")
    Observable<Object> imagesUpload(@Part() List<MultipartBody.Part> imgs);


    /**
     * 首页热门搜索内容接口
     * @return
     */
//    @POST(URLConfig.mainPage_hotSearch)
//    Observable<BaseEntity<List<ABean>>> mainPage_hotSearch(@Body RequestBody requestBody);
    /**
     * 首页热门搜索内容接口
     * @return
     */
    @GET(URLConfig.mainPage_hotSearch)
    Observable<BaseEntity<List<Seek>>> mainPage_hotSearch(@QueryMap Map<String,Object> map);

    /**
     * 首页搜索
     * @return
     */
    @GET(URLConfig.mainPage_search)
    Observable<BaseEntity<Products>> mainPage_search(@QueryMap Map<String,Object> map);

    /**
     * 更多银行理财列表接口（带加载）
     * @return
     */
    @GET(URLConfig.mainPage_moreBankProducts)
    Observable<BaseEntity<List<ABean>>> mainPage_moreBankProducts(@QueryMap Map<String,Object> map);

    /**
     * 更多私募基金列表接口（带加载）
     * @return
     */
    @GET(URLConfig.mainPage_morePrivateFunds)
    Observable<BaseEntity<List<Placement>>> mainPage_morePrivateFunds(@QueryMap Map<String,Object> map);

    /**
     * 更多公募基金列表接口（带加载）
     * @return
     */
    @GET(URLConfig.mainPage_morePublicFunds)
    Observable<BaseEntity<List<Placement>>> mainPage_morePublicFunds(@QueryMap Map<String,Object> map);

    /**
     * 公募发现接口
     * @return
     */
    @GET(URLConfig.publicFunds_find)
    Observable<BaseEntity<List<Seek>>> publicFunds_find(@QueryMap Map<String,Object> map);

    /**
     * 公募搜索基金公司接口（带加载）
     * @return
     */
    @GET(URLConfig.publicFunds_moreCompanys)
    Observable<BaseEntity<List<Company>>> publicFunds_moreCompanys(@QueryMap Map<String,Object> map);

    /**
     * 公募搜索基金经理接口（带加载）
     * @return
     */
    @GET(URLConfig.publicFunds_moreManagers)
    Observable<BaseEntity<List<FundManger>>> publicFunds_moreManagers(@QueryMap Map<String,Object> map);

    /**
     * 公募搜索基金产品接口（带加载）
     * @return
     */
    @GET(URLConfig.publicFunds_moreProducts)
    Observable<BaseEntity<List<Placement>>> publicFunds_moreProducts(@QueryMap Map<String,Object> map);

    /**
     * 公募搜索接口
     * @return
     */
    @GET(URLConfig.publicFunds_search)
    Observable<BaseEntity<PublicSeek>> publicFunds_search(@QueryMap Map<String,Object> map);

    /**
     * 加入自选与关注接口
     * @return
     */
    @POST(URLConfig.publicFunds_attention)
    Observable<BaseEntity<String>> publicFunds_attention(@Body RequestBody requestBody);

    /**
     *
     */
    @POST(URLConfig.mainPage_optional)
    Observable<BaseEntity<String>> mainPage_optional(@Body RequestBody requestBody);

//    /**
//     *
//     */
//    @POST(URLConfig.adduser)
//    Observable<BaseEntity<String>> adduser(@Body RequestBody requestBody);
}
