package com.guoshi.module_home.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.guoshi.baselib.entity.fund.Placement;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PrivateItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView privateicon;

  @NonNull
  public final TextView privatename;

  @Bindable
  protected Placement mPrivateobj;

  protected PrivateItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView privateicon, TextView privatename) {
    super(_bindingComponent, _root, _localFieldCount);
    this.privateicon = privateicon;
    this.privatename = privatename;
  }

  public abstract void setPrivateobj(@Nullable Placement privateobj);

  @Nullable
  public Placement getPrivateobj() {
    return mPrivateobj;
  }

  @NonNull
  public static PrivateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.private_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PrivateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PrivateItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.private_item, root, attachToRoot, component);
  }

  @NonNull
  public static PrivateItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.private_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PrivateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PrivateItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.private_item, null, false, component);
  }

  public static PrivateItemBinding bind(@NonNull View view) {
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
  public static PrivateItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (PrivateItemBinding)bind(component, view, com.guoshi.module_home.R.layout.private_item);
  }
}
