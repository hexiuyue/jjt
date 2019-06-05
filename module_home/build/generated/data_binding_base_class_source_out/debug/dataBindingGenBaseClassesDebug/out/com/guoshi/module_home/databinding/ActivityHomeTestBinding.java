package com.guoshi.module_home.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityHomeTestBinding extends ViewDataBinding {
  @NonNull
  public final BarChart BarChart;

  @NonNull
  public final PieChart PieChart;

  @NonNull
  public final RadarChart RadarChart;

  @NonNull
  public final LineChart lineChart;

  protected ActivityHomeTestBinding(Object _bindingComponent, View _root, int _localFieldCount,
      BarChart BarChart, PieChart PieChart, RadarChart RadarChart, LineChart lineChart) {
    super(_bindingComponent, _root, _localFieldCount);
    this.BarChart = BarChart;
    this.PieChart = PieChart;
    this.RadarChart = RadarChart;
    this.lineChart = lineChart;
  }

  @NonNull
  public static ActivityHomeTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_home_test, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityHomeTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityHomeTestBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_home_test, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityHomeTestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_home_test, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityHomeTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityHomeTestBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.activity_home_test, null, false, component);
  }

  public static ActivityHomeTestBinding bind(@NonNull View view) {
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
  public static ActivityHomeTestBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityHomeTestBinding)bind(component, view, com.guoshi.module_home.R.layout.activity_home_test);
  }
}
