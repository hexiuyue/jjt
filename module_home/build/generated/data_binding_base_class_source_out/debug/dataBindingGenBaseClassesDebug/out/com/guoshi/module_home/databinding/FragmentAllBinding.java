package com.guoshi.module_home.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.guoshi.baselib.layout.LoadDataLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentAllBinding extends ViewDataBinding {
  @NonNull
  public final TextView company;

  @NonNull
  public final RecyclerView fundCompanyRecyclerView;

  @NonNull
  public final RecyclerView fundFundmangerRecyclerView;

  @NonNull
  public final RecyclerView fundPorductRecyclerView;

  @NonNull
  public final TextView fundmanger;

  @NonNull
  public final LoadDataLayout ldl;

  @NonNull
  public final LoadDataLayout ldlcompany;

  @NonNull
  public final LoadDataLayout ldlmanger;

  @NonNull
  public final LoadDataLayout ldlporduct;

  @NonNull
  public final TextView porduct;

  @NonNull
  public final ScrollView seekokview;

  protected FragmentAllBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView company, RecyclerView fundCompanyRecyclerView,
      RecyclerView fundFundmangerRecyclerView, RecyclerView fundPorductRecyclerView,
      TextView fundmanger, LoadDataLayout ldl, LoadDataLayout ldlcompany, LoadDataLayout ldlmanger,
      LoadDataLayout ldlporduct, TextView porduct, ScrollView seekokview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.company = company;
    this.fundCompanyRecyclerView = fundCompanyRecyclerView;
    this.fundFundmangerRecyclerView = fundFundmangerRecyclerView;
    this.fundPorductRecyclerView = fundPorductRecyclerView;
    this.fundmanger = fundmanger;
    this.ldl = ldl;
    this.ldlcompany = ldlcompany;
    this.ldlmanger = ldlmanger;
    this.ldlporduct = ldlporduct;
    this.porduct = porduct;
    this.seekokview = seekokview;
  }

  @NonNull
  public static FragmentAllBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_all, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAllBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentAllBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.fragment_all, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAllBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_all, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAllBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentAllBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.fragment_all, null, false, component);
  }

  public static FragmentAllBinding bind(@NonNull View view) {
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
  public static FragmentAllBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentAllBinding)bind(component, view, com.guoshi.module_home.R.layout.fragment_all);
  }
}
