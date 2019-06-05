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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.guoshi.baselib.entity.back.BackProducts;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BackProductItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView backname;

  @NonNull
  public final TextView backproductname;

  @NonNull
  public final ImageView bankisHot;

  @NonNull
  public final View bankview;

  @NonNull
  public final LinearLayout itemlin1;

  @Bindable
  protected BackProducts mBackproduct;

  protected BackProductItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView backname, TextView backproductname, ImageView bankisHot, View bankview,
      LinearLayout itemlin1) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backname = backname;
    this.backproductname = backproductname;
    this.bankisHot = bankisHot;
    this.bankview = bankview;
    this.itemlin1 = itemlin1;
  }

  public abstract void setBackproduct(@Nullable BackProducts backproduct);

  @Nullable
  public BackProducts getBackproduct() {
    return mBackproduct;
  }

  @NonNull
  public static BackProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.back_product_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BackProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BackProductItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.back_product_item, root, attachToRoot, component);
  }

  @NonNull
  public static BackProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.back_product_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BackProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BackProductItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.back_product_item, null, false, component);
  }

  public static BackProductItemBinding bind(@NonNull View view) {
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
  public static BackProductItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (BackProductItemBinding)bind(component, view, com.guoshi.module_home.R.layout.back_product_item);
  }
}
