package com.guoshi.module_home.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.guoshi.baselib.layout.LoadDataLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySeekBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView HotRecyclerView;

  @NonNull
  public final SmartRefreshLayout SmartRefresh;

  @NonNull
  public final RecyclerView bankRecyclerView;

  @NonNull
  public final TextView bankgengduo;

  @NonNull
  public final RadioButton history;

  @NonNull
  public final RecyclerView historyHotRecyclerView;

  @NonNull
  public final ImageView historydelete;

  @NonNull
  public final LinearLayout historylin;

  @NonNull
  public final RadioButton hottext;

  @NonNull
  public final TextView intoprivatelist;

  @NonNull
  public final TextView intopubliclist;

  @NonNull
  public final LoadDataLayout ldl;

  @NonNull
  public final LoadDataLayout ldlbank;

  @NonNull
  public final LoadDataLayout ldlprivate;

  @NonNull
  public final LoadDataLayout ldlpublic;

  @NonNull
  public final RecyclerView privateRecyclerView;

  @NonNull
  public final RecyclerView publicRecyclerView;

  @NonNull
  public final LinearLayout resouview;

  @NonNull
  public final TextView rv;

  @NonNull
  public final ScrollView seekokview;

  @NonNull
  public final View seektop;

  @NonNull
  public final TextView yinview;

  @Bindable
  protected String mSa;

  protected ActivitySeekBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView HotRecyclerView, SmartRefreshLayout SmartRefresh, RecyclerView bankRecyclerView,
      TextView bankgengduo, RadioButton history, RecyclerView historyHotRecyclerView,
      ImageView historydelete, LinearLayout historylin, RadioButton hottext,
      TextView intoprivatelist, TextView intopubliclist, LoadDataLayout ldl, LoadDataLayout ldlbank,
      LoadDataLayout ldlprivate, LoadDataLayout ldlpublic, RecyclerView privateRecyclerView,
      RecyclerView publicRecyclerView, LinearLayout resouview, TextView rv, ScrollView seekokview,
      View seektop, TextView yinview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.HotRecyclerView = HotRecyclerView;
    this.SmartRefresh = SmartRefresh;
    this.bankRecyclerView = bankRecyclerView;
    this.bankgengduo = bankgengduo;
    this.history = history;
    this.historyHotRecyclerView = historyHotRecyclerView;
    this.historydelete = historydelete;
    this.historylin = historylin;
    this.hottext = hottext;
    this.intoprivatelist = intoprivatelist;
    this.intopubliclist = intopubliclist;
    this.ldl = ldl;
    this.ldlbank = ldlbank;
    this.ldlprivate = ldlprivate;
    this.ldlpublic = ldlpublic;
    this.privateRecyclerView = privateRecyclerView;
    this.publicRecyclerView = publicRecyclerView;
    this.resouview = resouview;
    this.rv = rv;
    this.seekokview = seekokview;
    this.seektop = seektop;
    this.yinview = yinview;
  }

  public abstract void setSa(@Nullable String sa);

  @Nullable
  public String getSa() {
    return mSa;
  }

  @NonNull
  public static ActivitySeekBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_seek, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySeekBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySeekBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_seek, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySeekBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_seek, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySeekBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySeekBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_seek, null, false, component);
  }

  public static ActivitySeekBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivitySeekBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySeekBinding)bind(component, view, com.guoshi.module_home.R.layout.activity_seek);
  }
}
