package com.guoshi.jjt;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

  static {
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(7);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.guoshi.baselib.DataBinderMapperImpl());
    result.add(new com.guoshi.module_attention.DataBinderMapperImpl());
    result.add(new com.guoshi.module_home.DataBinderMapperImpl());
    result.add(new com.guoshi.module_main.DataBinderMapperImpl());
    result.add(new com.guoshi.module_mine.DataBinderMapperImpl());
    result.add(new com.guoshi.module_news.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(13);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "id");
      sKeys.put(2, "type");
      sKeys.put(3, "content");
      sKeys.put(4, "publicobj");
      sKeys.put(5, "privateobj");
      sKeys.put(6, "backproduct");
      sKeys.put(7, "history");
      sKeys.put(8, "funmanger");
      sKeys.put(9, "publiccompany");
      sKeys.put(10, "seek");
      sKeys.put(11, "sa");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(0);

    static {
    }
  }
}
