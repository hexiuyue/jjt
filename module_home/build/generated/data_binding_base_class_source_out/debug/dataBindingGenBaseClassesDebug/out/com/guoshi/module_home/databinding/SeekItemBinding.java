package com.guoshi.module_home.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.guoshi.baselib.entity.Seek;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SeekItemBinding extends ViewDataBinding {
  @NonNull
  public final RadioButton hotRadioButton;

  @Bindable
  protected Seek mSeek;

  protected SeekItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RadioButton hotRadioButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.hotRadioButton = hotRadioButton;
  }

  public abstract void setSeek(@Nullable Seek seek);

  @Nullable
  public Seek getSeek() {
    return mSeek;
  }

  @NonNull
  public static SeekItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.seek_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SeekItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SeekItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.seek_item, root, attachToRoot, component);
  }

  @NonNull
  public static SeekItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.seek_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SeekItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SeekItemBinding>inflateInternal(inflater, com.guoshi.module_home.R.layout.seek_item, null, false, component);
  }

  public static SeekItemBinding bind(@NonNull View view) {
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
  public static SeekItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (SeekItemBinding)bind(component, view, com.guoshi.module_home.R.layout.seek_item);
  }
}
