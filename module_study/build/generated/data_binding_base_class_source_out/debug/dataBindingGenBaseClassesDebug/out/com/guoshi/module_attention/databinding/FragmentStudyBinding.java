package com.guoshi.module_attention.databinding;

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

public abstract class FragmentStudyBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout wdln;

  protected FragmentStudyBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout wdln) {
    super(_bindingComponent, _root, _localFieldCount);
    this.wdln = wdln;
  }

  @NonNull
  public static FragmentStudyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_study, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStudyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentStudyBinding>inflateInternal(inflater, com.guoshi.module_attention.R.layout.fragment_study, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentStudyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_study, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStudyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentStudyBinding>inflateInternal(inflater, com.guoshi.module_attention.R.layout.fragment_study, null, false, component);
  }

  public static FragmentStudyBinding bind(@NonNull View view) {
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
  public static FragmentStudyBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentStudyBinding)bind(component, view, com.guoshi.module_attention.R.layout.fragment_study);
  }
}
