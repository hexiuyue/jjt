package com.guoshi.baselib.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityWebViewBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout root;

  @NonNull
  public final WebView webview;

  @NonNull
  public final View webviewtop;

  protected ActivityWebViewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout root, WebView webview, View webviewtop) {
    super(_bindingComponent, _root, _localFieldCount);
    this.root = root;
    this.webview = webview;
    this.webviewtop = webviewtop;
  }

  @NonNull
  public static ActivityWebViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_web_view, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWebViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityWebViewBinding>inflateInternal(inflater, com.guoshi.baselib.R.layout.activity_web_view, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWebViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_web_view, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWebViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityWebViewBinding>inflateInternal(inflater, com.guoshi.baselib.R.layout.activity_web_view, null, false, component);
  }

  public static ActivityWebViewBinding bind(@NonNull View view) {
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
  public static ActivityWebViewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityWebViewBinding)bind(component, view, com.guoshi.baselib.R.layout.activity_web_view);
  }
}
