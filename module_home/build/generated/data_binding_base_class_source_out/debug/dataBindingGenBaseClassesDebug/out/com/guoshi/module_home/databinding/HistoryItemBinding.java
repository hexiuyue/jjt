package com.guoshi.module_home.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.guoshi.baselib.entity.History;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class HistoryItemBinding extends ViewDataBinding {
  @Bindable
  protected History mHistory;

  protected HistoryItemBinding(Object _bindingComponent, View _root, int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setHistory(@Nullable History history);

  @Nullable
  public History getHistory() {
    return mHistory;
  }

  @NonNull
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.history_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HistoryItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.history_item, root, attachToRoot, component);
  }

  @NonNull
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.history_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<HistoryItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.history_item, null, false, component);
  }

  public static HistoryItemBinding bind(@NonNull View view) {
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
  public static HistoryItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (HistoryItemBinding)bind(component, view, com.guoshi.module_home.R.layout.history_item);
  }
}
