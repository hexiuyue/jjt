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
import com.guoshi.baselib.entity.fund.Company;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PublicCompanyItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView publiccompanyname;

  @NonNull
  public final ImageView publicompanycicon;

  @Bindable
  protected Company mPubliccompany;

  protected PublicCompanyItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView publiccompanyname, ImageView publicompanycicon) {
    super(_bindingComponent, _root, _localFieldCount);
    this.publiccompanyname = publiccompanyname;
    this.publicompanycicon = publicompanycicon;
  }

  public abstract void setPubliccompany(@Nullable Company publiccompany);

  @Nullable
  public Company getPubliccompany() {
    return mPubliccompany;
  }

  @NonNull
  public static PublicCompanyItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.public_company_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PublicCompanyItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PublicCompanyItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.public_company_item, root, attachToRoot, component);
  }

  @NonNull
  public static PublicCompanyItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.public_company_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PublicCompanyItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PublicCompanyItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.public_company_item, null, false, component);
  }

  public static PublicCompanyItemBinding bind(@NonNull View view) {
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
  public static PublicCompanyItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (PublicCompanyItemBinding)bind(component, view, com.guoshi.module_home.R.layout.public_company_item);
  }
}
