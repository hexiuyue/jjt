package com.guoshi.module_home.seek;

import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.fadai.particlesmasher.ParticleSmasher;
import com.fadai.particlesmasher.SmashAnimator;
import com.guoshi.baselib.Myaplication;
import com.guoshi.baselib.api.http.RetrofitFactory;
import com.guoshi.baselib.api.http.base.BaseObserver;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.db.HistoryDao;
import com.guoshi.baselib.entity.module_home.Products;
import com.guoshi.baselib.layout.LoadDataLayout;
import com.guoshi.baselib.route.ModuleHomeUtlis;
import com.guoshi.baselib.utils.ClassicsFooter;
import com.guoshi.baselib.utils.SignUtil;
import com.guoshi.baselib.utils.StatusBarUtil;
import com.guoshi.baselib.view.CustomToast;
import com.guoshi.module_home.BR;
import com.guoshi.module_home.R;
import com.guoshi.module_home.adapter.MvvmCommonAdapter;
import com.guoshi.module_home.databinding.ActivitySeekBinding;
import com.guoshi.baselib.entity.History;
import com.guoshi.baselib.entity.Seek;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：首页搜索界面
 */
@Route(path = ModuleHomeUtlis.HOME_SEEK)
public class SeekActivity extends BaseActivity implements View.OnClickListener {
    private ActivitySeekBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_seek);
        StatusBarUtil.setStatusBarLightMode(this);
        initview();
        load();
//        adduser();
    }
    private HistoryDao historyDao;
    private SearchView searchView;

    private String KEY="";
    private void initview(){
        binding.ldl.setBindView(binding.SmartRefresh);
        binding.ldlpublic.setBindView(binding.publicRecyclerView);
        binding.ldlprivate.setBindView(binding.privateRecyclerView);
        binding.ldlbank.setBindView(binding.bankRecyclerView);
        historyDao= Myaplication.getInstances().getDaoSession().getHistoryDao();
        searchView=binding.seektop.findViewById(R.id.SearchView);
        binding.seektop.findViewById(R.id.seekback).setOnClickListener(this);
        binding.seektop.findViewById(R.id.seektopview).setVisibility(View.VISIBLE);
        binding.seektop.findViewById(R.id.alltop).setVisibility(View.GONE);
        binding.intopubliclist.setOnClickListener(this);
        binding.intoprivatelist.setOnClickListener(this);
        //搜索框文字设置
        EditText editText = searchView.findViewById(R.id.search_src_text);
        editText.setTextSize(14);
        //点击删除历史搜索
        binding.historydelete.setOnClickListener(this);
        //搜索框右边图标设置
        ImageView closeViewIcon = searchView.findViewById(R.id.search_close_btn);
        closeViewIcon.setImageDrawable(ContextCompat
                .getDrawable(this,R.mipmap.souclear));
        //去除下划线
        searchView.findViewById(R.id.search_plate).setBackground(null);
        searchView.findViewById(R.id.submit_area).setBackground(null);
        //搜索框内容变化监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //点击搜索按钮将搜索内容加入数据库
                for (History history : historyList) {
                    if(history.getContent().equals(s)){
                        historyDao.delete(history);
                        break;
                    }
                }
                History history=new History();
                history.setContent(s);
                history.setType(0);
                historyDao.insert(history);
                inithistorydata();
                //确认搜索搜索词用于列表关键字变红
                KEY=s;
                if(!"".equals(KEY)&&KEY!=null){//有搜索内容时
                    loadseek();
                }else{//无搜索内容时
                    binding.ldl.setVisibility(View.GONE);
                    binding.resouview.setVisibility(View.VISIBLE);
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {//搜索框内容变化时
                KEY=s;
                if(!"".equals(KEY)&&KEY!=null){
                    loadseek();
                }else{
                    binding.ldl.setVisibility(View.GONE);
                    binding.resouview.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        //热门搜索RecyclerView
        binding.HotRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.HotRecyclerView.setNestedScrollingEnabled(false);
        //历史搜索
        binding.historyHotRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.historyHotRecyclerView.setNestedScrollingEnabled(false);
        inithistorydata();

        //搜索成功+联动搜索
        //公募基金
        binding.publicRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        binding.publicRecyclerView.setNestedScrollingEnabled(false);

        //私募基金
        binding.privateRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        binding.privateRecyclerView.setNestedScrollingEnabled(false);

        //银行理财
        binding.bankRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL, false));
        binding.bankRecyclerView.setNestedScrollingEnabled(false);

        binding.SmartRefresh.setRefreshHeader(new ClassicsHeader(this));
        binding.SmartRefresh.setRefreshFooter(new ClassicsFooter(this));
        binding.SmartRefresh.setEnableRefresh(false);//关闭刷新
        binding.SmartRefresh.setEnableLoadMore(true);//打开加载
        binding.SmartRefresh.setEnableAutoLoadMore(false);//是否启用列表惯性滑动到底部时自动加载更多
        binding.SmartRefresh.finishLoadMoreWithNoMoreData();//完成加载并标记没有更多数据


        binding.seekokview.setOnTouchListener(new View.OnTouchListener() {//隐藏输入法
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        BaseActivity.hidenInputMethod(SeekActivity.this);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        BaseActivity.hidenInputMethod(SeekActivity.this);
                        break;
                }
                return false;
            }
        });

        binding.ldl.setRefreshListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadseek();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        binding.seektop.setFocusable(true);
        binding.seektop.setFocusableInTouchMode(true);
        binding.seektop.requestFocus();
    }

    private void initsouok(){
        if(products.getPublicFunds()!=null&&products.getPublicFunds().size()>0){
            if(publicMvvmCommonAdapter==null){
                publicMvvmCommonAdapter=new MvvmCommonAdapter(
                        products.getPublicFunds(), BR.publicobj,SeekActivity.this,R.layout.public_item,KEY);
                binding.publicRecyclerView.setAdapter(publicMvvmCommonAdapter);
                publicMvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //加入历史搜索
                        for (History history : historyList) {
                            if(history.getContent().equals(KEY)){
                                historyDao.delete(history);
                                break;
                            }
                        }
                        History history=new History();
                        history.setContent(KEY);
                        history.setType(0);
                        historyDao.insert(history);
                        inithistorydata();
                    }
                });
            }else{
                publicMvvmCommonAdapter.setKET(KEY);
            }
            if(products.getPublicFunds().size()<5){
                binding.intopubliclist.setVisibility(View.GONE);
            }else{
                binding.intopubliclist.setVisibility(View.VISIBLE);
            }
            binding.ldlpublic.showSuccess();
        }else{
            binding.ldlpublic.showEmpty("抱歉，未找到与“" + KEY + "”相关的公募产品",
                    KEY,null);
            binding.intopubliclist.setVisibility(View.GONE);
        }

        if(products.getPrivateFunds()!=null&&products.getPrivateFunds().size()>0){
            if(privateMvvmCommonAdapter==null){
                privateMvvmCommonAdapter=new MvvmCommonAdapter(
                        products.getPrivateFunds(), BR.privateobj,SeekActivity.this,R.layout.private_item,KEY);
                binding.privateRecyclerView.setAdapter(privateMvvmCommonAdapter);
                privateMvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //加入历史搜索
                        for (History history : historyList) {
                            if(history.getContent().equals(KEY)){
                                historyDao.delete(history);
                                break;
                            }
                        }
                        History history=new History();
                        history.setContent(KEY);
                        history.setType(0);
                        historyDao.insert(history);
                        inithistorydata();
                    }
                });
            }else{
                privateMvvmCommonAdapter.setKET(KEY);
            }
            if(products.getPrivateFunds().size()<5){
                binding.intoprivatelist.setVisibility(View.GONE);
            }else{
                binding.intoprivatelist.setVisibility(View.VISIBLE);
            }
            binding.ldlprivate.showSuccess();
        }else{
            binding.ldlprivate.showEmpty("抱歉，未找到与“" + KEY + "”相关的私募产品",
                    KEY,null);
            binding.intoprivatelist.setVisibility(View.GONE);
        }
        if(products.getBankProducts()!=null&&products.getBankProducts().size()>0){
            if(backProductsadapter==null){
                backProductsadapter=new MvvmCommonAdapter(
                        products.getBankProducts(),BR.backproduct,SeekActivity.this,R.layout.back_product_item,KEY);
                binding.bankRecyclerView.setAdapter(backProductsadapter);
                backProductsadapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        addhistory();
                    }
                });
            }else{
                backProductsadapter.setKET(KEY);
            }
            if(products.getBankProducts().size()<5){
                binding.bankgengduo.setVisibility(View.GONE);
            }else{
                binding.bankgengduo.setVisibility(View.VISIBLE);
            }
            binding.ldlbank.showSuccess();
        }else{
            binding.ldlbank.showEmpty("抱歉，未找到与“" + KEY + "”相关的银行产品",
                    KEY,null);
            binding.bankgengduo.setVisibility(View.GONE);
        }


    }
    private List<Seek> seekList;
    private MvvmCommonAdapter hotmvvmCommonAdapter;
    private List<History> historyList=new ArrayList<>();
    private MvvmCommonAdapter historymvvmCommonAdapter;
    private void inithistorydata(){
        historyList.clear();
        List<History> historys=historyDao.queryBuilder()
                .where(HistoryDao.Properties.Type.eq(0))
                .orderDesc(HistoryDao.Properties.Id)
                .limit(9)
                .list();
        historyList.addAll(historys);
        if(historyList.size()==0){
            binding.historylin.setVisibility(View.GONE);
        }else{
            binding.historylin.setVisibility(View.VISIBLE);
            binding.historyHotRecyclerView.setVisibility(View.VISIBLE);
            if(historymvvmCommonAdapter==null){
                historymvvmCommonAdapter=new MvvmCommonAdapter(historyList, BR.history,this,R.layout.history_item);
                binding.historyHotRecyclerView.setAdapter(historymvvmCommonAdapter);
                historymvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        searchView.setQuery(historyList.get(position).getContent(),true);
                    }
                });
            }else{
                historymvvmCommonAdapter.notifyDataSetChanged();
            }
            if(smasher!=null){
                smasher.reShowView(binding.historylin);
            }
        }
    }
    private List<History> filterhistory;
    private List<History> filter(List<History> strings,String text){
        filterhistory=new ArrayList<>();
        for (History word:strings){
            if (word.getContent().contains(text))
                filterhistory.add(word);
        }
        return filterhistory;
    }
    private MvvmCommonAdapter publicMvvmCommonAdapter;
    private MvvmCommonAdapter privateMvvmCommonAdapter;
    private MvvmCommonAdapter backProductsadapter;
    ParticleSmasher smasher;
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.seekback) {
            if(binding.ldl.getVisibility()==View.VISIBLE){
                BaseActivity.hidenInputMethod(SeekActivity.this);
                searchView.setQuery("",false);
            }else{
                finish();
                outacvivity(SeekActivity.this);
            }
        }else if(i==R.id.intopubliclist){
            addhistory();
            ARouter.getInstance()
                    .build(ModuleHomeUtlis.PUBLIC_LIST)
                    .withString("key",KEY)
                    .withTransition(R.anim.slide_right_in,R.anim.slide_left_out)
                    .navigation();
        }else if(i==R.id.intoprivatelist){
            addhistory();
            ARouter.getInstance()
                    .build(ModuleHomeUtlis.PRIVATE_LIST)
                    .withString("key",KEY)
                    .withTransition(R.anim.slide_right_in,R.anim.slide_left_out)
                    .navigation();
        }else if(i==R.id.historydelete){
            smasher=new ParticleSmasher(this);
            // 默认为爆炸动画
            smasher.with(binding.historylin)
                    .setStyle(SmashAnimator.STYLE_EXPLOSION)    // 设置动画样式
                    .setDuration(500)                     // 设置动画时间
                    .setStartDelay(300)                    // 设置动画前延时
                    .setHorizontalMultiple(2)              // 设置横向运动幅度，默认为3

                    .setVerticalMultiple(2)                // 设置竖向运动幅度，默认为4
                    .addAnimatorListener(new SmashAnimator.OnAnimatorListener() {
                        @Override
                        public void onAnimatorStart() {
                            super.onAnimatorStart();
                            // 回调，动画开始
                        }
                        @Override
                        public void onAnimatorEnd() {
                            super.onAnimatorEnd();
                            // 回调，动画结束
                            binding.historylin.setVisibility(View.GONE);
                            historyDao.deleteAll();
                            historyList.clear();
                            historymvvmCommonAdapter.notifyDataSetChanged();
                        }
                    })
                    .start();

        }
    }


    @Override
    public void onBackPressed() {
        if(binding.ldl.getVisibility()==View.VISIBLE){
            searchView.setQuery("",false);
        }else{
            finish();
            outacvivity(this);
        }
    }

    private Products products;
    private void loadseek(){
        binding.ldl.setVisibility(View.VISIBLE);
        binding.resouview.setVisibility(View.GONE);
        binding.ldl.showLoading("努力加载中...");
        String timestamp=BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("keyword",KEY);
        map.put("timestamp",timestamp);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        map.put("sign",sign);
        Observable observable1= RetrofitFactory.getInstence(SeekActivity.this).API()
                .mainPage_search(map)
                .compose(this.<BaseEntity>setThread());
        observable1
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        map.clear();
                        if(t.getStatus()==1){
                            if(t.getData()==null){
                                binding.ldl.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金产品",
                                        KEY,
                                        new LoadDataLayout.SetImgCallBack() {
                                    @Override
                                    public void setImg(ImageView img) {
                                        Glide.with(SeekActivity.this)
                                                .load(R.mipmap.oknull)
                                                .into(img);
                                    }
                                });
                            }else{
                                if(products==null){
                                    products= (Products) t.getData();
                                }else{
                                    if(((Products) t.getData()).getPublicFunds()==null&&
                                            ((Products) t.getData()).getPrivateFunds()==null&&
                                            ((Products) t.getData()).getBankProducts()==null){
                                        binding.ldl.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金产品",
                                                KEY,
                                                new LoadDataLayout.SetImgCallBack() {
                                                    @Override
                                                    public void setImg(ImageView img) {
                                                        Glide.with(SeekActivity.this)
                                                                .load(R.mipmap.oknull)
                                                                .into(img);
                                                    }
                                                });
                                        return;
                                    }else{
                                        products.getBankProducts().clear();
                                        products.getPrivateFunds().clear();
                                        products.getPublicFunds().clear();
                                        if(((Products) t.getData()).getBankProducts()!=null){
                                            products.getBankProducts().addAll(((Products) t.getData()).getBankProducts());
                                        }
                                        if(((Products) t.getData()).getPrivateFunds()!=null){
                                            products.getPrivateFunds().addAll(((Products) t.getData()).getPrivateFunds());
                                        }
                                        if(((Products) t.getData()).getPublicFunds()!=null){
                                            products.getPublicFunds().addAll(((Products) t.getData()).getPublicFunds());
                                        }
                                    }
                                }
                                initsouok();
                                binding.ldl.showSuccess();
                            }
                        }else{
                            CustomToast.showToast(SeekActivity.this,t.getMessage());
                        }
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        map.clear();
                        binding.ldl.showError("网络异常，点击重新加载");
                    }
                });
    }

    private void load(){
        String timestamp=BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("timestamp",timestamp);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        map.put("sign",sign);
        Observable observable1= RetrofitFactory.getInstence(SeekActivity.this).API()
                .mainPage_hotSearch(map)
                .compose(this.<BaseEntity>setThread());
        observable1
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        map.clear();
                        if(t.getStatus()==1){
                            if(seekList==null){
                                seekList=new ArrayList<>();
                            }
                            seekList.addAll((List<Seek>)t.getData());
                            hotmvvmCommonAdapter=new MvvmCommonAdapter(seekList, BR.seek,
                                    SeekActivity.this,R.layout.seek_item);
                            binding.HotRecyclerView.setAdapter(hotmvvmCommonAdapter);
                        }else{
                            CustomToast.showToast(SeekActivity.this,t.getMessage());

                        }
                    }
                    @Override

                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        map.clear();
                    }
                });
    }

    private void addhistory(){
        //加入历史搜索
        for (History history : historyList){
            if(history.getContent().equals(KEY)){
                historyDao.delete(history);
                break;
            }
        }
        History history=new History();
        history.setContent(KEY);
        history.setType(0);
        historyDao.insert(history);
        inithistorydata();
    }

//    private void adduser(){
//        JSONObject object=new JSONObject();
//        try {
//            object.put("name","knight");
//            object.put("age",30);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        String json=object.toString();
//        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);
//        Observable observable1= RetrofitFactory.getInstence(SeekActivity.this).API()
//                .adduser(requestBody)
//                .compose(this.<BaseEntity>setThread());
//        observable1
//                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
//                .subscribe(new BaseObserver<Object>(){
//                    @Override
//                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
//
//                    }
//                    @Override
//                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//                    }
//                });
//    }
}
