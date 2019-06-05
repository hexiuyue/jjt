package com.guoshi.module_home.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout aaa;

  @NonNull
  public final RadioButton bankFinancing;

  @NonNull
  public final RadioButton cemetery;

  @NonNull
  public final RadioButton fundPortfolio;

  @NonNull
  public final ImageView homelogo;

  @NonNull
  public final ImageView homes;

  @NonNull
  public final RadioButton privatePlacement;

  @NonNull
  public final ConstraintLayout wdln;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout aaa, RadioButton bankFinancing, RadioButton cemetery,
      RadioButton fundPortfolio, ImageView homelogo, ImageView homes, RadioButton privatePlacement,
      ConstraintLayout wdln) {
    super(_bindingComponent, _root, _localFieldCount);
    this.aaa = aaa;
    this.bankFinancing = bankFinancing;
    this.cemetery = cemetery;
    this.fundPortfolio = fundPortfolio;
    this.homelogo = homelogo;
    this.homes = homes;
    this.privatePlacement = privatePlacement;
    this.wdln = wdln;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
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
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, com.guoshi.module_home.R.layout.fragment_home);
  }
}
