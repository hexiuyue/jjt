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

public abstract class PublicItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView publicicon;

  @NonNull
  public final TextView publicname;

  @Bindable
  protected Placement mPublicobj;

  protected PublicItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView publicicon, TextView publicname) {
    super(_bindingComponent, _root, _localFieldCount);
    this.publicicon = publicicon;
    this.publicname = publicname;
  }

  public abstract void setPublicobj(@Nullable Placement publicobj);

  @Nullable
  public Placement getPublicobj() {
    return mPublicobj;
  }

  @NonNull
  public static PublicItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.public_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PublicItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PublicItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.public_item, root, attachToRoot, component);
  }

  @NonNull
  public static PublicItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.public_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PublicItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PublicItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.public_item, null, false, component);
  }

  public static PublicItemBinding bind(@NonNull View view) {
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
  public static PublicItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (PublicItemBinding)bind(component, view, com.guoshi.module_home.R.layout.public_item);
  }
}
