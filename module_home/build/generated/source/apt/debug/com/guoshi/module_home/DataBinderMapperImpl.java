package com.guoshi.module_home;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.guoshi.module_home.databinding.ActivityHomeTestBindingImpl;
import com.guoshi.module_home.databinding.ActivityPrivateBindingImpl;
import com.guoshi.module_home.databinding.ActivityPublicListBindingImpl;
import com.guoshi.module_home.databinding.ActivityPublicMainBindingImpl;
import com.guoshi.module_home.databinding.ActivitySeekBindingImpl;
import com.guoshi.module_home.databinding.BackProductItemBindingImpl;
import com.guoshi.module_home.databinding.FragmentAllBindingImpl;
import com.guoshi.module_home.databinding.FragmentFundCompanyBindingImpl;
import com.guoshi.module_home.databinding.FragmentFundManagerBindingImpl;
import com.guoshi.module_home.databinding.FragmentFundProductBindingImpl;
import com.guoshi.module_home.databinding.FragmentHomeBindingImpl;
import com.guoshi.module_home.databinding.FundMangerItemBindingImpl;
import com.guoshi.module_home.databinding.HistoryItemBindingImpl;
import com.guoshi.module_home.databinding.PrivateItemBindingImpl;
import com.guoshi.module_home.databinding.PublicCompanyItemBindingImpl;
import com.guoshi.module_home.databinding.PublicItemBindingImpl;
import com.guoshi.module_home.databinding.SeekItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYHOMETEST = 1;

  private static final int LAYOUT_ACTIVITYPRIVATE = 2;

  private static final int LAYOUT_ACTIVITYPUBLICLIST = 3;

  private static final int LAYOUT_ACTIVITYPUBLICMAIN = 4;

  private static final int LAYOUT_ACTIVITYSEEK = 5;

  private static final int LAYOUT_BACKPRODUCTITEM = 6;

  private static final int LAYOUT_FRAGMENTALL = 7;

  private static final int LAYOUT_FRAGMENTFUNDCOMPANY = 8;

  private static final int LAYOUT_FRAGMENTFUNDMANAGER = 9;

  private static final int LAYOUT_FRAGMENTFUNDPRODUCT = 10;

  private static final int LAYOUT_FRAGMENTHOME = 11;

  private static final int LAYOUT_FUNDMANGERITEM = 12;

  private static final int LAYOUT_HISTORYITEM = 13;

  private static final int LAYOUT_PRIVATEITEM = 14;

  private static final int LAYOUT_PUBLICCOMPANYITEM = 15;

  private static final int LAYOUT_PUBLICITEM = 16;

  private static final int LAYOUT_SEEKITEM = 17;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(17);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.activity_home_test, LAYOUT_ACTIVITYHOMETEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.activity_private, LAYOUT_ACTIVITYPRIVATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.activity_public_list, LAYOUT_ACTIVITYPUBLICLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.activity_public_main, LAYOUT_ACTIVITYPUBLICMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.activity_seek, LAYOUT_ACTIVITYSEEK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.back_product_item, LAYOUT_BACKPRODUCTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.fragment_all, LAYOUT_FRAGMENTALL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.fragment_fund_company, LAYOUT_FRAGMENTFUNDCOMPANY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.fragment_fund_manager, LAYOUT_FRAGMENTFUNDMANAGER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.fragment_fund_product, LAYOUT_FRAGMENTFUNDPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.fund_manger_item, LAYOUT_FUNDMANGERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.history_item, LAYOUT_HISTORYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.private_item, LAYOUT_PRIVATEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.public_company_item, LAYOUT_PUBLICCOMPANYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.public_item, LAYOUT_PUBLICITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.guoshi.module_home.R.layout.seek_item, LAYOUT_SEEKITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYHOMETEST: {
          if ("layout/activity_home_test_0".equals(tag)) {
            return new ActivityHomeTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home_test is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRIVATE: {
          if ("layout/activity_private_0".equals(tag)) {
            return new ActivityPrivateBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_private is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPUBLICLIST: {
          if ("layout/activity_public_list_0".equals(tag)) {
            return new ActivityPublicListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_public_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPUBLICMAIN: {
          if ("layout/activity_public_main_0".equals(tag)) {
            return new ActivityPublicMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_public_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEEK: {
          if ("layout/activity_seek_0".equals(tag)) {
            return new ActivitySeekBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_seek is invalid. Received: " + tag);
        }
        case  LAYOUT_BACKPRODUCTITEM: {
          if ("layout/back_product_item_0".equals(tag)) {
            return new BackProductItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for back_product_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTALL: {
          if ("layout/fragment_all_0".equals(tag)) {
            return new FragmentAllBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_all is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFUNDCOMPANY: {
          if ("layout/fragment_fund_company_0".equals(tag)) {
            return new FragmentFundCompanyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_fund_company is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFUNDMANAGER: {
          if ("layout/fragment_fund_manager_0".equals(tag)) {
            return new FragmentFundManagerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_fund_manager is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFUNDPRODUCT: {
          if ("layout/fragment_fund_product_0".equals(tag)) {
            return new FragmentFundProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_fund_product is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FUNDMANGERITEM: {
          if ("layout/fund_manger_item_0".equals(tag)) {
            return new FundMangerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fund_manger_item is invalid. Received: " + tag);
        }
        case  LAYOUT_HISTORYITEM: {
          if ("layout/history_item_0".equals(tag)) {
            return new HistoryItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for history_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PRIVATEITEM: {
          if ("layout/private_item_0".equals(tag)) {
            return new PrivateItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for private_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PUBLICCOMPANYITEM: {
          if ("layout/public_company_item_0".equals(tag)) {
            return new PublicCompanyItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for public_company_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PUBLICITEM: {
          if ("layout/public_item_0".equals(tag)) {
            return new PublicItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for public_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SEEKITEM: {
          if ("layout/seek_item_0".equals(tag)) {
            return new SeekItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for seek_item is invalid. Received: " + tag);
        }
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
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.guoshi.baselib.DataBinderMapperImpl());
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(17);

    static {
      sKeys.put("layout/activity_home_test_0", com.guoshi.module_home.R.layout.activity_home_test);
      sKeys.put("layout/activity_private_0", com.guoshi.module_home.R.layout.activity_private);
      sKeys.put("layout/activity_public_list_0", com.guoshi.module_home.R.layout.activity_public_list);
      sKeys.put("layout/activity_public_main_0", com.guoshi.module_home.R.layout.activity_public_main);
      sKeys.put("layout/activity_seek_0", com.guoshi.module_home.R.layout.activity_seek);
      sKeys.put("layout/back_product_item_0", com.guoshi.module_home.R.layout.back_product_item);
      sKeys.put("layout/fragment_all_0", com.guoshi.module_home.R.layout.fragment_all);
      sKeys.put("layout/fragment_fund_company_0", com.guoshi.module_home.R.layout.fragment_fund_company);
      sKeys.put("layout/fragment_fund_manager_0", com.guoshi.module_home.R.layout.fragment_fund_manager);
      sKeys.put("layout/fragment_fund_product_0", com.guoshi.module_home.R.layout.fragment_fund_product);
      sKeys.put("layout/fragment_home_0", com.guoshi.module_home.R.layout.fragment_home);
      sKeys.put("layout/fund_manger_item_0", com.guoshi.module_home.R.layout.fund_manger_item);
      sKeys.put("layout/history_item_0", com.guoshi.module_home.R.layout.history_item);
      sKeys.put("layout/private_item_0", com.guoshi.module_home.R.layout.private_item);
      sKeys.put("layout/public_company_item_0", com.guoshi.module_home.R.layout.public_company_item);
      sKeys.put("layout/public_item_0", com.guoshi.module_home.R.layout.public_item);
      sKeys.put("layout/seek_item_0", com.guoshi.module_home.R.layout.seek_item);
    }
  }
}
