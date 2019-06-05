package com.guoshi.module_mine.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMineBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout wdln;

  protected FragmentMineBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout wdln) {
    super(_bindingComponent, _root, _localFieldCount);
    this.wdln = wdln;
  }

  @NonNull
  public static FragmentMineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_mine, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMineBinding>inflateInternal(inflater, com.guoshi.module_mine.R.layout.fragment_mine, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_mine, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMineBinding>inflateInternal(inflater, com.guoshi.module_mine.R.layout.fragment_mine, null, false, component);
  }

  public static FragmentMineBinding bind(@NonNull View view) {
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
  public static FragmentMineBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMineBinding)bind(component, view, com.guoshi.module_mine.R.layout.fragment_mine);
  }
}
