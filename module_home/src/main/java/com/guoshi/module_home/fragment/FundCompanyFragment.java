package com.guoshi.module_home.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guoshi.baselib.api.http.RetrofitFactory;
import com.guoshi.baselib.api.http.base.BaseObserver;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.entity.fund.Company;
import com.guoshi.baselib.evenbus.MyEvenbus;
import com.guoshi.baselib.layout.LoadDataLayout;
import com.guoshi.baselib.utils.ClassicsFooter;
import com.guoshi.baselib.utils.SignUtil;
import com.guoshi.baselib.view.CustomToast;
import com.guoshi.module_home.BR;
import com.guoshi.module_home.R;
import com.guoshi.module_home.adapter.MvvmCommonAdapter;
import com.guoshi.module_home.databinding.FragmentFundCompanyBinding;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collection;
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
 * 文件描述：搜索基金公司界面
 */
public class FundCompanyFragment extends Fragment {
    private FragmentFundCompanyBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_fund_company, container, false);
        initview();
        return binding.getRoot();
    }

    private void initview(){
        binding.ldl.setBindView(binding.lv);

        //基金公司
        binding.fundCompanyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        binding.fundCompanyRecyclerView.setNestedScrollingEnabled(false);

        binding.SmartRefresh.setRefreshHeader(new ClassicsHeader(getActivity()));
        binding.SmartRefresh.setRefreshFooter(new ClassicsFooter(getActivity()));
        binding.SmartRefresh.setEnableRefresh(false);
        binding.SmartRefresh.setEnableLoadMore(true);
        binding.SmartRefresh.setEnableAutoLoadMore(false);
        binding.SmartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageIndex++;
                load();

            }
        });
        binding.ldl.setRefreshListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setKey(KEY);
            }
        });
    }
    private String KEY="1";
    private MvvmCommonAdapter fundcompanyMvvmCommonAdapter;
    private List<Company> publicCompanies;
    public void setKey(String key){
        KEY=key;
        pageIndex=1;
        if(publicCompanies!=null){
            publicCompanies.clear();
        }
        load();
    }
    private int pageIndex=1;
    private int totalPage;
    private void load(){
        if(pageIndex==1){
            binding.ldl.showLoading("努力加载中");
        }
        String timestamp= BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("keyword",KEY);
        map.put("timestamp",timestamp);
        map.put("pageIndex",pageIndex);
        map.put("pageSize",HttpConfig.pageSize);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        map.put("sign",sign);
        Observable observable= RetrofitFactory.getInstence(getActivity())
                .API()
                .publicFunds_moreCompanys(map);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        map.clear();
                        if(t.getStatus()==1){
                            totalPage=t.getTotalPage();
                            if(publicCompanies==null){
                                publicCompanies=new ArrayList<>();
                            }
                            if(t.getData()!=null&&((Collection<? extends Company>) t.getData()).size()>0){
                                publicCompanies.addAll((Collection<? extends Company>) t.getData());
                            }
                            if(publicCompanies.size()>0){
                                if(fundcompanyMvvmCommonAdapter==null){
                                    fundcompanyMvvmCommonAdapter=new MvvmCommonAdapter(
                                            publicCompanies, BR.publiccompany, getActivity(),R.layout.public_company_item,KEY);
                                    binding.fundCompanyRecyclerView.setAdapter(fundcompanyMvvmCommonAdapter);
                                    fundcompanyMvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int position){
                                            //点击搜索按钮将搜索内容加入数据库
                                            EventBus.getDefault().post(new MyEvenbus("addhistory",KEY));
                                        }
                                    });
                                }else{
                                    fundcompanyMvvmCommonAdapter.setKET(KEY);
                                }
                                if(totalPage>pageIndex){
                                    binding.SmartRefresh.finishLoadMore(0,true,false);
                                }else{
                                    binding.SmartRefresh.finishLoadMore(0,true,true);
                                }
                                binding.ldl.showSuccess();
                            }else{
                                binding.ldl.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金公司。"
                                        ,KEY, new LoadDataLayout.SetImgCallBack() {
                                            @Override
                                            public void setImg(ImageView img) {
                                                Glide.with(getActivity())
                                                        .load(R.mipmap.oknull)
                                                        .into(img);
                                            }
                                        });
                            }
                        }else{
                            CustomToast.showToast(getActivity(),t.getMessage());
                        }
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        binding.ldl.showError("网络异常，点击重新加载");
                        map.clear();
                    }
                });

    }
}
