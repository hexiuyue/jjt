package com.guoshi.module_home.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.guoshi.baselib.api.http.RetrofitFactory;
import com.guoshi.baselib.api.http.base.BaseObserver;
import com.guoshi.baselib.api.http.bean.BaseEntity;
import com.guoshi.baselib.api.http.config.HttpConfig;
import com.guoshi.baselib.base.BaseActivity;
import com.guoshi.baselib.entity.Seek;
import com.guoshi.baselib.entity.back.BackProducts;
import com.guoshi.baselib.entity.fund.FundManger;
import com.guoshi.baselib.entity.fund.Company;
import com.guoshi.baselib.entity.fund.Placement;
import com.guoshi.baselib.entity.module_home.Products;
import com.guoshi.baselib.utils.SignUtil;
import com.guoshi.baselib.view.CustomToast;
import com.guoshi.module_home.R;
import com.guoshi.baselib.entity.History;
import com.guoshi.module_home.seek.SeekActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：RecyclerView通用Adapter
 */
public class MvvmCommonAdapter extends RecyclerView.Adapter<MvvmCommonAdapter.CommonHolder> implements View.OnClickListener,View.OnLongClickListener  {
    public static final String TAG = "MvvmCommonAdapter";
    protected Context myContext;
    //所有 item 的数据集合
    protected List mDatas;
    //item 布局文件 id
    protected int mLayoutId;
    protected LayoutInflater mInflater;
    // mvvm绑定的viewModel引用
    private int mVariableId;
    public View getvview(){
        return holder.binding.getRoot();
    }
    //构造方法ordarrview
    public MvvmCommonAdapter(List datas, int variableId, Context context, int layoutId) {
        myContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(myContext);
        mVariableId = variableId;
    }


    public List getmDatas() {
        return mDatas;
    }

    public void setmDatas(List mDatas) {
        this.mDatas = mDatas;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mLayoutId, parent, false);
        CommonHolder myHolder = new CommonHolder(binding.getRoot());
        myHolder.setBinding(binding);
        //将创建的View注册点击事件
        binding.getRoot().setOnClickListener(this);
        binding.getRoot().setOnLongClickListener(this);

//        binding.executePendingBindings(); //防止闪烁

//        myHolder.setIsRecyclable(false);//禁止复用
        return myHolder;
    }

    private CommonHolder holder;

    @Override
    public void onBindViewHolder(final CommonHolder holder, final int position) {
        if(position==0){
            this.holder=holder;
        }
        //item内容点击事件
        //热搜词图片
        final RadioButton hotradioButton=holder.binding.getRoot().findViewById(R.id.hotRadioButton);
        if(hotradioButton!=null){
            List<Seek> seeks=mDatas;
            Seek seek= seeks.get(position);
            if(seek.getIsHot()==1){
                Resources res = myContext.getResources();
                Drawable myImage = res.getDrawable(R.mipmap.huo);
                hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null,null , myImage, null);
            }else{
                hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null,null , null, null);
            }
//            if(2<position){
//                if(position>4){
//                    hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null,null , null, null);
//                }else{
//                    Resources res = mContext.getResources();
//                    Drawable myImage = res.getDrawable(R.mipmap.huo);
//                    hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null,null , myImage, null);
//                }
//            }
        }
        //联动搜索关键字字体
        //公募基金
        final TextView publicname=holder.binding.getRoot().findViewById(R.id.publicname);
        if(publicname!=null&&KEY!=null){
            List<Placement> publicPlacements=mDatas;
            Placement placement=publicPlacements.get(position);
            String textString=placement.getFundName();
            if(!"".equals(textString)&&textString!=null){
                ForegroundColorSpan span = new ForegroundColorSpan(myContext.getResources().getColor(R.color.red));//要显示的颜色
                SpannableStringBuilder builder = new SpannableStringBuilder(textString);
                int index = textString.indexOf(KEY);//从第几个匹配上
                if(index!=-1){//有这个关键字用builder显示
                    builder.setSpan(span, index, index+KEY.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    publicname.setText(builder);
                }else{//没有则直接显示
                    publicname.setText(textString);
                }
            }
        }
        //联动搜索关键字字体
        //私募基金
        final TextView privatename=holder.binding.getRoot().findViewById(R.id.privatename);
        if(privatename!=null&&KEY!=null){
            List<Placement> privatePlacements=mDatas;
            Placement placement=privatePlacements.get(position);
            String textString=placement.getFundName();
            if(!"".equals(textString)&&textString!=null){
                ForegroundColorSpan span = new ForegroundColorSpan(myContext.getResources().getColor(R.color.red));//要显示的颜色
                SpannableStringBuilder builder = new SpannableStringBuilder(textString);
                int index = textString.indexOf(KEY);//从第几个匹配上
                if(index!=-1){//有这个关键字用builder显示
                    builder.setSpan(span, index, index+KEY.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    privatename.setText(builder);
                }else{//没有则直接显示
                    privatename.setText(textString);
                }
            }

        }

        //联动搜索关键字字体
        //银行理财
        final TextView backproductname=holder.binding.getRoot().findViewById(R.id.backproductname);
        if(backproductname!=null&&KEY!=null){
            List<BackProducts> backProducts=mDatas;
            BackProducts products=backProducts.get(position);
            String textString=products.getName();
            if(!"".equals(textString)&&textString!=null){
                ForegroundColorSpan span = new ForegroundColorSpan(myContext.getResources().getColor(R.color.red));//要显示的颜色
                SpannableStringBuilder builder = new SpannableStringBuilder(textString);
                int index = textString.indexOf(KEY);//从第几个匹配上
                if(index!=-1){//有这个关键字用builder显示
                    builder.setSpan(span, index, index+KEY.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    backproductname.setText(builder);
                }else{//没有则直接显示
                    backproductname.setText(textString);
                }
            }
        }
        //联动搜索关键字字体
        //基金公司
        final TextView publiccompanyname=holder.binding.getRoot().findViewById(R.id.publiccompanyname);
        if(publiccompanyname!=null&&KEY!=null){
            List<Company> publicCompanies=mDatas;
            Company company=publicCompanies.get(position);
            String textString=company.getCompanyName();
            if(!"".equals(textString)&&textString!=null){
                ForegroundColorSpan span = new ForegroundColorSpan(myContext.getResources().getColor(R.color.red));//要显示的颜色
                SpannableStringBuilder builder = new SpannableStringBuilder(textString);
                int index = textString.indexOf(KEY);//从第几个匹配上
                if(index!=-1){//有这个关键字用builder显示
                    builder.setSpan(span, index, index+KEY.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    publiccompanyname.setText(builder);
                }else{//没有则直接显示
                    publiccompanyname.setText(textString);
                }
            }
        }
        //联动搜索关键字字体
        //基金经理
        final TextView fundmname=holder.binding.getRoot().findViewById(R.id.fundmname);
        if(fundmname!=null&&KEY!=null){
            List<FundManger> fundMangers=mDatas;
            FundManger fundManger=fundMangers.get(position);
            String textString=fundManger.getManagerName();
            if(!"".equals(textString)&&textString!=null){
                ForegroundColorSpan span = new ForegroundColorSpan(myContext.getResources().getColor(R.color.red));//要显示的颜色
                SpannableStringBuilder builder = new SpannableStringBuilder(textString);
                int index = textString.indexOf(KEY);//从第几个匹配上
                if(index!=-1){//有这个关键字用builder显示
                    builder.setSpan(span, index, index+KEY.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    fundmname.setText(builder);
                }else{//没有则直接显示
                    fundmname.setText(textString);
                }
            }
        }
        //公募基金是否加入自选
        final ImageView publicicon=holder.binding.getRoot().findViewById(R.id.publicicon);
        if(publicicon!=null){
            List<Placement> publicPlacements=mDatas;
            Placement placement=publicPlacements.get(position);
            if(placement.getAddOptional()==1){//已加入自选
                publicicon.setImageResource(R.mipmap.deicon);
            }else{//未加入自选
                publicicon.setImageResource(R.mipmap.addicon);
            }
            publicicon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(placement.getAddOptional()==1){//已加入自选
                        optional(placement.getFundId(),2,1);
                    }else{//未加入自选
                        optional(placement.getFundId(),1,1);
                    }
                }
            });
        }
        //私募基金是否加入自选
        final ImageView privateicon=holder.binding.getRoot().findViewById(R.id.privateicon);
        if(privateicon!=null){
            List<Placement> privatePlacements=mDatas;
            Placement placement=privatePlacements.get(position);
            if(placement.getAddOptional()==1){//已加入自选
                privateicon.setImageResource(R.mipmap.deicon);
            }else{//未加入自选
                privateicon.setImageResource(R.mipmap.addicon);
            }
            privateicon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(placement.getAddOptional()==1){//已加入自选
                        optional(placement.getFundId(),2,2);
                    }else{//未加入自选
                        optional(placement.getFundId(),1,2);
                    }

                }
            });
        }
        //基金公司是否关注
        final ImageView publicompanycicon=holder.binding.getRoot().findViewById(R.id.publicompanycicon);
        if(publicompanycicon!=null){
            List<Company> publicCompanies=mDatas;
            Company company=publicCompanies.get(position);
            if(company.getAddAttention()==1){//已加入关注
                publicompanycicon.setImageResource(R.mipmap.deicon);
            }else{//未加入关注
                publicompanycicon.setImageResource(R.mipmap.addicon);
            }
            publicompanycicon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(company.getAddAttention()==1){//已加入自选
                        attention(company.getCompanyId(),2,2);
                    }else{//未加入自选
                        attention(company.getCompanyId(),1,2);
                    }

                }
            });
        }
        //基金经理是否关注
        final ImageView publicmangericon=holder.binding.getRoot().findViewById(R.id.publicmangericon);
        if(publicmangericon!=null){
            List<FundManger> fundMangers=mDatas;
            FundManger manger=fundMangers.get(position);
            if(manger.getAddAttention()==1){//已加入关注
                publicmangericon.setImageResource(R.mipmap.deicon);
            }else{//未加入关注
                publicmangericon.setImageResource(R.mipmap.addicon);
            }
            publicmangericon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(manger.getAddAttention()==1){//已加入自选
                        attention(manger.getManagerId(),2,3);
                    }else{//未加入自选
                        attention(manger.getManagerId(),1,3);
                    }

                }
            });
        }
        //通用
        holder.binding.setVariable(mVariableId,mDatas.get(position));
        holder.binding.executePendingBindings();
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.binding.getRoot().setTag(position);
    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }


    class CommonHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public CommonHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }
    /*设置点击事件*/
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    private OnItemClickListener mOnItemClickListener = null;
    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    /*设置长按事件*/
    public void setOnItemLongClickListener(RecyclerViewOnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
    private RecyclerViewOnItemLongClickListener onItemLongClickListener;
    public interface RecyclerViewOnItemLongClickListener {
        boolean onItemLongClickListener(View view, int position);
    }
    @Override
    public boolean onLongClick(View v) {
        return onItemLongClickListener != null && onItemLongClickListener.onItemLongClickListener(v, (Integer) v.getTag());
    }

    public void setFilter(List<History> filterHistory){
        mDatas=filterHistory;
        notifyDataSetChanged();
    }
    //构造方法ordarrview
    public MvvmCommonAdapter(List datas, int variableId, Context context, int layoutId,String KEYs) {
        myContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(myContext);
        mVariableId = variableId;
        KEY=KEYs;
    }



    private String KEY;
    public void setKET(String KEYs){
        KEY=KEYs;
        notifyDataSetChanged();
    }
    public <T> ObservableTransformer<T,T> setThread(){
        return new ObservableTransformer<T,T>() {
            @Override
            public ObservableSource<T> apply(Observable<T>  upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    private void attention(String id,int operateType,int type){
        String timestamp= BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("operateType",operateType);
        map.put("type",type);
        map.put("timestamp",timestamp);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        JSONObject object=new JSONObject();
        try {
            object.put("id",id);
            object.put("operateType",operateType);
            object.put("type",type);
            object.put("timestamp",timestamp);
            object.put("sign",sign);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json=object.toString();
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);
        Observable observable1= RetrofitFactory.getInstence(myContext).API()
                .publicFunds_attention(requestBody)
                .compose(this.<BaseEntity>setThread());
        observable1
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        CustomToast.showToast(myContext,t.getMessage());
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });
    }

    private void optional(String id,int operateType,int type){
        String timestamp= BaseActivity.getTime();
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("operateType",operateType);
        map.put("type",type);
        map.put("timestamp",timestamp);
        String sign= SignUtil.getSign(map, HttpConfig.APPKEY);
        JSONObject object=new JSONObject();
        try {
            object.put("id",id);
            object.put("operateType",operateType);
            object.put("type",type);
            object.put("timestamp",timestamp);
            object.put("sign",sign);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json=object.toString();
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);
        Observable observable1= RetrofitFactory.getInstence(myContext).API()
                .mainPage_optional(requestBody)
                .compose(this.<BaseEntity>setThread());
        observable1
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new BaseObserver<Object>(){
                    @Override
                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
                        CustomToast.showToast(myContext,t.getMessage());
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });
    }
}
