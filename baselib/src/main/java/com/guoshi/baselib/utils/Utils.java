package com.guoshi.baselib.utils;

import android.content.Context;

import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/31
 * 文件描述：
 */
public class Utils {
    public static void share(Context context, String title, String text, final String link_url,
                                String img_url, String type) {// type 'wx' 就是发送到微信'wxp' 微信朋友圈
        OnekeyShare oks = new OnekeyShare();
        oks.setTitle(title);
        oks.setText(text);
        oks.setUrl(link_url);/** url在微信（包括好友、朋友圈收藏）和易信（包括好友和朋友圈）中使用，否则可以不提供 */
        oks.setTitleUrl(link_url);/** titleUrl是标题的网络链接，仅在人人网和QQ空间使用，否则可以不提供 */
        if (!"".equals(img_url)) {
            oks.setImageUrl(img_url);
        }else {
            oks.setImageUrl("http://img.i-banmei.com/inviteShareShowPic.png");
        }
        if (type.equals("wx")) {
            oks.setPlatform(Wechat.NAME);
        } else if (type.equals("wxp")) {
            oks.setPlatform(WechatMoments.NAME);
        } else if (type.equals("qq")) {
            oks.setPlatform(QQ.NAME);
        } else if (type.equals("qqk")) {
            oks.setPlatform(QZone.NAME);
        }
        oks.show(context);
    }
}
