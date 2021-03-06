package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.guoshi.module_home.HomeTestActivity;
import com.guoshi.module_home.private_placement.PrivateListActivity;
import com.guoshi.module_home.public_placement.PublicListActivity;
import com.guoshi.module_home.public_placement.PublicMainActivity;
import com.guoshi.module_home.seek.SeekActivity;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER. */
public class ARouter$$Group$$home implements IRouteGroup {
  @Override
  public void loadInto(Map<String, RouteMeta> atlas) {
    atlas.put("/home/PrivateList", RouteMeta.build(RouteType.ACTIVITY, PrivateListActivity.class, "/home/privatelist", "home", new java.util.HashMap<String, Integer>(){{put("key", 8); }}, -1, -2147483648));
    atlas.put("/home/PublicList", RouteMeta.build(RouteType.ACTIVITY, PublicListActivity.class, "/home/publiclist", "home", new java.util.HashMap<String, Integer>(){{put("key", 8); }}, -1, -2147483648));
    atlas.put("/home/hometest", RouteMeta.build(RouteType.ACTIVITY, HomeTestActivity.class, "/home/hometest", "home", null, -1, -2147483648));
    atlas.put("/home/publicmain", RouteMeta.build(RouteType.ACTIVITY, PublicMainActivity.class, "/home/publicmain", "home", null, -1, -2147483648));
    atlas.put("/home/seek", RouteMeta.build(RouteType.ACTIVITY, SeekActivity.class, "/home/seek", "home", null, -1, -2147483648));
  }
}
