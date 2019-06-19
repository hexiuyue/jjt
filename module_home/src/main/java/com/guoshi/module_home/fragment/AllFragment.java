package com.guoshi.module_home.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guoshi.baselib.api.http.RetrofitFactory;
import com.guoshi.baselib.api.http.base.BaseObserver;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.base.BaseFragment;
import com.guoshi.baselib.entity.module_home.Products;
import com.guoshi.baselib.entity.module_home.PublicSeek;
import com.guoshi.baselib.evenbus.MyEvenbus;
import com.guoshi.baselib.layout.LoadDataLayout;
import com.guoshi.baselib.utils.SignUtil;
import com.guoshi.baselib.view.CustomToast;
import com.guoshi.module_home.BR;
import com.guoshi.module_home.R;
import com.guoshi.module_home.adapter.MvvmCommonAdapter;
import com.guoshi.module_home.databinding.FragmentAllBinding;
import com.guoshi.module_home.seek.SeekActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：搜索全部界面
 */
public class AllFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAllBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_all, container, false);
        initview();
        return binding.getRoot();
    }

    private void initview(){
        binding.ldl.setBindView(binding.seekokview);

        binding.porduct.setOnClickListener(this);
        binding.company.setOnClickListener(this);
        binding.fundmanger.setOnClickListener(this);
        //基金成品
        binding.fundPorductRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        binding.fundPorductRecyclerView.setNestedScrollingEnabled(false);
        //基金公司
        binding.fundCompanyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        binding.fundCompanyRecyclerView.setNestedScrollingEnabled(false);
        //基金经理
        binding.fundFundmangerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        binding.fundFundmangerRecyclerView.setNestedScrollingEnabled(false);
        binding.seekokview.setOnTouchListener(new View.OnTouchListener() {//隐藏输入法
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        BaseActivity.hidenInputMethod(getActivity());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        BaseActivity.hidenInputMethod(getActivity());
                        break;
                }
                return false;
            }
        });
        binding.ldl.setRefreshListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setKey(KEY);
            }
        });
    }

    private void initdata(){
        if(publicSeek.getFunds()!=null&&publicSeek.getFunds().size()>0){
            if(publicMvvmCommonAdapter==null){
                publicMvvmCommonAdapter=new MvvmCommonAdapter(
                        publicSeek.getFunds(), BR.publicobj, getActivity(),R.layout.public_item,KEY);
                binding.fundPorductRecyclerView.setAdapter(publicMvvmCommonAdapter);
                publicMvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //点击搜索按钮将搜索内容加入数据库
                        EventBus.getDefault().post(new MyEvenbus("addhistory",KEY));
                    }
                });
            }else{
                publicMvvmCommonAdapter.setKET(KEY);
            }
            binding.ldlporduct.showSuccess();
        }else{
            binding.ldlporduct.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金产品。",KEY,null);
            binding.porduct.setVisibility(View.GONE);
        }

        if(publicSeek.getCompanys()!=null&&publicSeek.getCompanys().size()>0){
            if(fundcompanyMvvmCommonAdapter==null){
                fundcompanyMvvmCommonAdapter=new MvvmCommonAdapter(
                        publicSeek.getCompanys(), BR.publiccompany, getActivity(),R.layout.public_company_item,KEY);
                binding.fundCompanyRecyclerView.setAdapter(fundcompanyMvvmCommonAdapter);
                fundcompanyMvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //点击搜索按钮将搜索内容加入数据库
                        EventBus.getDefault().post(new MyEvenbus("addhistory",KEY));
                    }
                });
            }else{
                fundcompanyMvvmCommonAdapter.setKET(KEY);
            }
            binding.ldlcompany.showSuccess();
        }else{
            binding.ldlcompany.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金公司。",KEY,null);
            binding.company.setVisibility(View.GONE);
        }

        if(publicSeek.getManagers()!=null&&publicSeek.getManagers().size()>0){
            if(fundMangersMvvmCommonAdapter==null){
                fundMangersMvvmCommonAdapter=new MvvmCommonAdapter(
                        publicSeek.getManagers(),BR.funmanger,getActivity(),R.layout.fund_manger_item,KEY);
                binding.fundFundmangerRecyclerView.setAdapter(fundMangersMvvmCommonAdapter);
                fundMangersMvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //点击搜索按钮将搜索内容加入数据库
                        EventBus.getDefault().post(new MyEvenbus("addhistory",KEY));
                    }
                });
            }else{
                fundMangersMvvmCommonAdapter.setKET(KEY);
            }
            binding.ldlmanger.showSuccess();
        }else{
            binding.ldlmanger.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金经理。",KEY,null);
            binding.fundmanger.setVisibility(View.INVISIBLE);
        }

    }
    private MvvmCommonAdapter publicMvvmCommonAdapter;
    private MvvmCommonAdapter fundcompanyMvvmCommonAdapter;
    private MvvmCommonAdapter fundMangersMvvmCommonAdapter;

    private String KEY="";
    public void setKey(String key){
        KEY=key;
        load();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.porduct) {
            EventBus.getDefault().post(new MyEvenbus("Uppubliclist","1"));
        } else if (i == R.id.company) {
            EventBus.getDefault().post(new MyEvenbus("Uppubliclist","2"));
        } else if (i == R.id.fundmanger) {
            EventBus.getDefault().post(new MyEvenbus("Uppubliclist","3"));
        }
    }

    private void load(){
        binding.ldl.showLoading("努力加载中...");
        String timestamp= BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("keyword",KEY);
        map.put("timestamp",timestamp);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        map.put("sign",sign);
        Observable observable1= RetrofitFactory.getInstence(getActivity()).API()
                .publicFunds_search(map)
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
                                binding.ldl.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金信息。"
                                        ,KEY, new LoadDataLayout.SetImgCallBack() {
                                            @Override
                                            public void setImg(ImageView img) {
                                                Glide.with(getActivity())
                                                        .load(R.mipmap.oknull)
                                                        .into(img);
                                            }
                                        });
                            }else{
                                if(publicSeek==null){
                                    publicSeek= (PublicSeek) t.getData();
                                }else{
                                    if(((PublicSeek) t.getData()).getFunds()==null&&
                                            ((PublicSeek) t.getData()).getManagers()==null&&
                                            ((PublicSeek) t.getData()).getCompanys()==null){
                                        binding.ldl.showEmpty("抱歉，未找到与“" + KEY + "”相关的基金产品",
                                                KEY,
                                                new LoadDataLayout.SetImgCallBack() {
                                                    @Override
                                                    public void setImg(ImageView img) {
                                                        Glide.with(getActivity())
                                                                .load(R.mipmap.oknull)
                                                                .into(img);
                                                    }
                                                });
                                        return;
                                    }else{
                                        publicSeek.getCompanys().clear();
                                        publicSeek.getFunds().clear();
                                        publicSeek.getManagers().clear();
                                        if(((PublicSeek) t.getData()).getCompanys()!=null){
                                            publicSeek.getCompanys().addAll(((PublicSeek) t.getData()).getCompanys());
                                        }
                                        if(((PublicSeek) t.getData()).getFunds()!=null){
                                            publicSeek.getFunds().addAll(((PublicSeek) t.getData()).getFunds());
                                        }
                                        if(((PublicSeek) t.getData()).getManagers()!=null){
                                            publicSeek.getManagers().addAll(((PublicSeek) t.getData()).getManagers());
                                        }
                                    }
                                }
                                initdata();
                                binding.ldl.showSuccess();
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
    private PublicSeek publicSeek;
}
