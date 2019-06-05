package com.guoshi.module_home.public_placement;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guoshi.baselib.api.http.RetrofitFactory;
import com.guoshi.baselib.api.http.base.BaseObserver;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.entity.Seek;
import com.guoshi.baselib.entity.fund.Placement;
import com.guoshi.baselib.route.ModuleHomeUtlis;
import com.guoshi.baselib.utils.SignUtil;
import com.guoshi.baselib.utils.StatusBarUtil;
import com.guoshi.baselib.view.CustomToast;
import com.guoshi.module_home.BR;
import com.guoshi.module_home.R;
import com.guoshi.module_home.adapter.MvvmCommonAdapter;
import com.guoshi.module_home.databinding.ActivityPublicListBinding;
import com.guoshi.module_home.seek.SeekActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.guoshi.baselib.utils.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：公募搜索列表
 */
@Route(path = ModuleHomeUtlis.PUBLIC_LIST)
public class PublicListActivity extends BaseActivity implements View.OnClickListener {
    private ActivityPublicListBinding binding;
    @Autowired
    public String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarLightMode(this);
        ARouter.getInstance().inject(this);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_public_list);
        initview();
        load();
    }
    private MvvmCommonAdapter mvvmCommonAdapter;
    private void initview(){
        binding.publiclisttop.findViewById(R.id.baseback).setOnClickListener(this);
        ((TextView)binding.publiclisttop.findViewById(R.id.alltext)).setText("公募基金列表");
        binding.publicListRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        binding.publicListRecyclerView.setNestedScrollingEnabled(false);


        binding.SmartRefresh.setRefreshHeader(new ClassicsHeader(this));
        binding.SmartRefresh.setRefreshFooter(new ClassicsFooter(this));
        binding.SmartRefresh.setEnableRefresh(false);//关闭刷新
        binding.SmartRefresh.setEnableLoadMore(true);//打开加载
        binding.SmartRefresh.setEnableAutoLoadMore(false);
        binding.SmartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageIndex++;
                load();
            }
        });
    }
    private List<Placement> placementList;
    @Override
    public void onBackPressed(){
        finish();
        outacvivity(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.baseback){
            finish();
            outacvivity(PublicListActivity.this);
        }
    }
    private int pageIndex=1;
    private int totalPage;
    private void  load(){
        String timestamp=BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("timestamp",timestamp);
        map.put("keyword",key);
        map.put("pageIndex",pageIndex);
        map.put("pageSize",HttpConfig.pageSize);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        map.put("sign",sign);
        Observable observable1= RetrofitFactory.getInstence(PublicListActivity.this).API()
                .mainPage_morePublicFunds(map)
                .compose(this.<BaseEntity>setThread());
        observable1
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        map.clear();
                        if(t.getStatus()==1){
                            totalPage=t.getTotalPage();
                            if(placementList==null){
                                placementList=new ArrayList<>();
                            }
                            if(t.getData()!=null&&((List<Placement>) t.getData()).size()>0){
                                placementList.addAll((List<Placement>) t.getData());
                            }else{
                                binding.SmartRefresh.finishLoadMore(0,true,true);
                                return;
                            }
                            if(placementList.size()>0){
                                if(mvvmCommonAdapter==null){
                                    mvvmCommonAdapter=new MvvmCommonAdapter(
                                            placementList, BR.publicobj, PublicListActivity.this,R.layout.public_item);
                                    binding.publicListRecyclerView.setAdapter(mvvmCommonAdapter);
                                }else{
                                    mvvmCommonAdapter.notifyDataSetChanged();
                                }
                            }
                        }else{
                            CustomToast.showToast(PublicListActivity.this,t.getMessage());
                        }
                        if(pageIndex<totalPage){
                            binding.SmartRefresh.finishLoadMore(0,true,false);
                        }else{
                            binding.SmartRefresh.finishLoadMore(0,true,true);
                        }

                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        map.clear();
                    }
                });
    }
}
