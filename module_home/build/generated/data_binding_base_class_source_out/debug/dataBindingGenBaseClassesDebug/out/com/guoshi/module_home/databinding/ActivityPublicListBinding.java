package com.guoshi.module_home.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPublicListBinding extends ViewDataBinding {
  @NonNull
  public final SmartRefreshLayout SmartRefresh;

  @NonNull
  public final RecyclerView publicListRecyclerView;

  @NonNull
  public final View publiclisttop;

  protected ActivityPublicListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      SmartRefreshLayout SmartRefresh, RecyclerView publicListRecyclerView, View publiclisttop) {
    super(_bindingComponent, _root, _localFieldCount);
    this.SmartRefresh = SmartRefresh;
    this.publicListRecyclerView = publicListRecyclerView;
    this.publiclisttop = publiclisttop;
  }

  @NonNull
  public static ActivityPublicListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_public_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPublicListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPublicListBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_public_list, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPublicListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_public_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPublicListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPublicListBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_public_list, null, false, component);
  }

  public static ActivityPublicListBinding bind(@NonNull View view) {
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
  public static ActivityPublicListBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPublicListBinding)bind(component, view, com.guoshi.module_home.R.layout.activity_public_list);
  }
}
