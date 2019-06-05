package com.guoshi.module_home.public_placement;

import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fadai.particlesmasher.ParticleSmasher;
import com.fadai.particlesmasher.SmashAnimator;
import com.guoshi.baselib.Myaplication;
import com.guoshi.baselib.api.http.RetrofitFactory;
import com.guoshi.baselib.api.http.base.BaseObserver;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.db.HistoryDao;
import com.guoshi.baselib.entity.History;
import com.guoshi.baselib.entity.Seek;
import com.guoshi.baselib.evenbus.MyEvenbus;
import com.guoshi.baselib.route.ModuleHomeUtlis;
import com.guoshi.baselib.utils.SignUtil;
import com.guoshi.baselib.utils.StatusBarUtil;
import com.guoshi.baselib.view.CustomToast;
import com.guoshi.module_home.BR;
import com.guoshi.module_home.R;
import com.guoshi.module_home.adapter.MvvmCommonAdapter;
import com.guoshi.module_home.databinding.ActivityPublicMainBinding;
import com.guoshi.module_home.fragment.AllFragment;
import com.guoshi.module_home.fragment.FundCompanyFragment;
import com.guoshi.module_home.fragment.FundManagerFragment;
import com.guoshi.module_home.fragment.FundProductFragment;
import com.guoshi.module_home.seek.SeekActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
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
 * 文件描述：公募主界面
 */
@Route(path = ModuleHomeUtlis.PUBLIC_MAIN)
public class PublicMainActivity extends BaseActivity implements View.OnClickListener {
    private ActivityPublicMainBinding binding;
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarLightMode(this);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_public_main);
        initview();
        load();
    }
    private void initview(){
        EventBus.getDefault().register(this);
        binding.publichistorydelete.setOnClickListener(this);
        binding.publictop.findViewById(R.id.baseback).setOnClickListener(this);
        ((TextView)binding.publictop.findViewById(R.id.alltext)).setText("公募");

        //搜索框文字设置
        EditText editText = binding.publicsearchview.findViewById(R.id.search_src_text);
        editText.setTextSize(14);

        //搜索框右边图标设置
        ImageView closeViewIcon = binding.publicsearchview.findViewById(R.id.search_close_btn);
        closeViewIcon.setImageDrawable(ContextCompat
                .getDrawable(this,R.mipmap.souclear));
        //去除下划线
        binding.publicsearchview.findViewById(R.id.search_plate).setBackground(null);
        binding.publicsearchview.findViewById(R.id.submit_area).setBackground(null);

        //搜索历史
        binding.publichistoryHotRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.publichistoryHotRecyclerView.setNestedScrollingEnabled(false);
        historyDao= Myaplication.getInstances().getDaoSession().getHistoryDao();
        mainhistory();

        //发现RecyclerView
        binding.HotRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.HotRecyclerView.setNestedScrollingEnabled(false);

        //搜索框内容变化监听
        binding.publicsearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                binding.publicoka.setVisibility(View.GONE);
                binding.publicokb.setVisibility(View.VISIBLE);
                //点击搜索按钮将搜索内容加入数据库
                for (History history : historyList) {
                    if(history.getContent().equals(s)){
                        historyDao.delete(history);
                        break;
                    }
                }
                History history=new History();
                history.setContent(s);
                history.setType(1);
                historyDao.insert(history);
                mainhistory();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {//搜索框内容变化时
                if(!"".equals(s)&&s!=null){
                    KEY=s;
                    binding.publicoka.setVisibility(View.GONE);
                    binding.publicokb.setVisibility(View.VISIBLE);
                    binding.publicmainviewpager.setCurrentItem(0,false);
                    setkey();
                }else{
                    binding.publicoka.setVisibility(View.VISIBLE);
                    binding.publicokb.setVisibility(View.GONE);
                }
                return false;
            }
        });
        fragmentList=new ArrayList<>();
        allFragment=new AllFragment();
        fundProductFragment=new FundProductFragment();
        fundCompanyFragment=new FundCompanyFragment();
        fundManagerFragment=new FundManagerFragment();
        fragmentList.add(allFragment);
        fragmentList.add(fundProductFragment);
        fragmentList.add(fundCompanyFragment);
        fragmentList.add(fundManagerFragment);
        navigationTag.add("全部");
        navigationTag.add("基金产品");
        navigationTag.add("基金公司");
        navigationTag.add("基金经理");
        binding.publicmainviewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                super.destroyItem(container, position, object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return navigationTag.get(position);
            }
        });
        binding.publicmaintablayout.setupWithViewPager(binding.publicmainviewpager);
        reflex(binding.publicmaintablayout);
        binding.publicmainviewpager.setOffscreenPageLimit(3);

        //去除点击黑色背景
        binding.publicmaintablayout.setTabRippleColor(ColorStateList.valueOf(
                PublicMainActivity.this.getResources().getColor(R.color.white)));
        //取消点击tab，feagment切换动画
        binding.publicmaintablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                BaseActivity.hidenInputMethod(PublicMainActivity.this);
                int position = tab.getPosition();
                binding.publicmainviewpager.setCurrentItem(position,false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MyEvenbus event){
        if("Uppubliclist".equals(event.getTag())){
            int index=Integer.parseInt(event.getMessage());
            binding.publicmainviewpager.setCurrentItem(index,false);
        }else if("addhistory".equals(event.getTag())){
            //点击搜索按钮将搜索内容加入数据库
            for (History history : historyList) {
                if(history.getContent().equals(event.getMessage())){
                    historyDao.delete(history);
                    break;
                }
            }
            History history=new History();
            history.setContent(event.getMessage());
            history.setType(1);
            historyDao.insert(history);
            mainhistory();
        }
    }
    private String KEY="";
    private void setkey(){
        allFragment.setKey(KEY);
        fundProductFragment.setKey(KEY);
        fundCompanyFragment.setKey(KEY);
        fundManagerFragment.setKey(KEY);
    }

    private AllFragment allFragment;
    private FundProductFragment fundProductFragment;
    private FundCompanyFragment fundCompanyFragment;
    private FundManagerFragment fundManagerFragment;

    private List<Seek> seekList;
    private MvvmCommonAdapter hotmvvmCommonAdapter;
    private HistoryDao historyDao;
    private List<History> historyList=new ArrayList<>();
    private MvvmCommonAdapter historymvvmCommonAdapter;
    private void mainhistory(){
        historyList.clear();
        List<History> historys=historyDao.queryBuilder()
                .where(HistoryDao.Properties.Type.eq(1))
                .orderDesc(HistoryDao.Properties.Id)
                .limit(9)
                .list();
        historyList.addAll(historys);
        if(historyList.size()==0){
            binding.historylin.setVisibility(View.GONE);
        }else{
            binding.historylin.setVisibility(View.VISIBLE);
            binding.publichistoryHotRecyclerView.setVisibility(View.VISIBLE);
            if(historymvvmCommonAdapter==null){
                historymvvmCommonAdapter=new MvvmCommonAdapter(historyList, BR.history,this,R.layout.history_item);
                binding.publichistoryHotRecyclerView.setAdapter(historymvvmCommonAdapter);
                historymvvmCommonAdapter.setOnItemClickListener(new MvvmCommonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        binding.publicsearchview.setQuery(historyList.get(position).getContent(),true);
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

    private List<String> navigationTag=new ArrayList<>();
    public static void reflex(final TabLayout tabLayout){
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
                    int dp10 = dip2px(tabLayout.getContext(), 10);
                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);
                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);
                        TextView mTextView = (TextView) mTextViewField.get(tabView);
                        tabView.setPadding(0, 0, 0, 0);
                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }
                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);
                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    /**
     * 自定义Tab的View
     * @param currentPosition
     * @return
     */
    private View getTabView(int currentPosition) {
        View view = LayoutInflater.from(PublicMainActivity.this).inflate(R.layout.layout_tab, null);
        TextView textView = (TextView) view.findViewById(R.id.tab_item_textview);
        textView.setText(navigationTag.get(currentPosition));
        return view;
    }
    ParticleSmasher smasher;
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.baseback){
            if(binding.publicokb.getVisibility()==View.VISIBLE&&!"".equals(KEY)){
                BaseActivity.hidenInputMethod(PublicMainActivity.this);
                binding.publicoka.setVisibility(View.VISIBLE);
                binding.publicokb.setVisibility(View.GONE);
                binding.publicsearchview.setQuery("",false);
            }else{
                finish();
                outacvivity(PublicMainActivity.this);
            }
        }else if(id==R.id.publichistorydelete){
            smasher = new ParticleSmasher(this);
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
        if(binding.publicokb.getVisibility()==View.VISIBLE&&!"".equals(KEY)){
            binding.publicoka.setVisibility(View.VISIBLE);
            binding.publicokb.setVisibility(View.GONE);
            binding.publicsearchview.setQuery("",false);
        }else{
            finish();
            outacvivity(this);
        }
    }

    private void load(){
        String timestamp=BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("timestamp",timestamp);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        map.put("sign",sign);
        Observable observable1= RetrofitFactory.getInstence(PublicMainActivity.this).API()
                .publicFunds_find(map)
                .compose(this.<BaseEntity>setThread());
        observable1
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        if(t.getStatus()==1){
                            if(seekList==null){
                                seekList=new ArrayList<>();
                            }
                            seekList.addAll((List<Seek>)t.getData());
                            hotmvvmCommonAdapter=new MvvmCommonAdapter(seekList, BR.seek,
                                    PublicMainActivity.this,R.layout.seek_item);
                            binding.HotRecyclerView.setAdapter(hotmvvmCommonAdapter);
                        }else{
                            CustomToast.showToast(PublicMainActivity.this,t.getMessage());
                        }
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });
    }
}
