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
import com.guoshi.baselib.entity.fund.FundManger;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FundMangerItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView fundmimg;

  @NonNull
  public final TextView fundmname;

  @NonNull
  public final ImageView publicmangericon;

  @NonNull
  public final TextView viewgui;

  @Bindable
  protected FundManger mFunmanger;

  protected FundMangerItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView fundmimg, TextView fundmname, ImageView publicmangericon, TextView viewgui) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fundmimg = fundmimg;
    this.fundmname = fundmname;
    this.publicmangericon = publicmangericon;
    this.viewgui = viewgui;
  }

  public abstract void setFunmanger(@Nullable FundManger funmanger);

  @Nullable
  public FundManger getFunmanger() {
    return mFunmanger;
  }

  @NonNull
  public static FundMangerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fund_manger_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FundMangerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FundMangerItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.fund_manger_item, root, attachToRoot, component);
  }

  @NonNull
  public static FundMangerItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fund_manger_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FundMangerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FundMangerItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.fund_manger_item, null, false, component);
  }

  public static FundMangerItemBinding bind(@NonNull View view) {
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
  public static FundMangerItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (FundMangerItemBinding)bind(component, view, com.guoshi.module_home.R.layout.fund_manger_item);
  }
}
