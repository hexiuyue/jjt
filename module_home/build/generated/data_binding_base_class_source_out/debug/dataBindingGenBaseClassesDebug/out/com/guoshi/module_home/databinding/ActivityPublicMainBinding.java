package com.guoshi.module_home.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPublicMainBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView HotRecyclerView;

  @NonNull
  public final RadioButton history;

  @NonNull
  public final LinearLayout historylin;

  @NonNull
  public final RadioButton hottext;

  @NonNull
  public final RecyclerView publichistoryHotRecyclerView;

  @NonNull
  public final ImageView publichistorydelete;

  @NonNull
  public final TextView publicmainsou;

  @NonNull
  public final TabLayout publicmaintablayout;

  @NonNull
  public final ViewPager publicmainviewpager;

  @NonNull
  public final LinearLayout publicoka;

  @NonNull
  public final LinearLayout publicokb;

  @NonNull
  public final SearchView publicsearchview;

  @NonNull
  public final View publictop;

  protected ActivityPublicMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView HotRecyclerView, RadioButton history, LinearLayout historylin,
      RadioButton hottext, RecyclerView publichistoryHotRecyclerView, ImageView publichistorydelete,
      TextView publicmainsou, TabLayout publicmaintablayout, ViewPager publicmainviewpager,
      LinearLayout publicoka, LinearLayout publicokb, SearchView publicsearchview, View publictop) {
    super(_bindingComponent, _root, _localFieldCount);
    this.HotRecyclerView = HotRecyclerView;
    this.history = history;
    this.historylin = historylin;
    this.hottext = hottext;
    this.publichistoryHotRecyclerView = publichistoryHotRecyclerView;
    this.publichistorydelete = publichistorydelete;
    this.publicmainsou = publicmainsou;
    this.publicmaintablayout = publicmaintablayout;
    this.publicmainviewpager = publicmainviewpager;
    this.publicoka = publicoka;
    this.publicokb = publicokb;
    this.publicsearchview = publicsearchview;
    this.publictop = publictop;
  }

  @NonNull
  public static ActivityPublicMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_public_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPublicMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPublicMainBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_public_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPublicMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_public_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPublicMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPublicMainBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_public_main, null, false, component);
  }

  public static ActivityPublicMainBinding bind(@NonNull View view) {
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
  public static ActivityPublicMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPublicMainBinding)bind(component, view, com.guoshi.module_home.R.layout.activity_public_main);
  }
}
