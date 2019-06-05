package com.guoshi.baselib.entity.fund;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.guoshi.baselib.R;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/6
 * 文件描述：基金经理
 */
public class FundManger {
   private int addAttention;//": "1",
   private String companyName;//": "华安基金",
   private String managerName;//": "张三",
   private String icon;//": "1.jpg",
   private String experience;//": "10年经验"
   private String managerId;//": "10年经验"

    public int getAddAttention() {
        return addAttention;
    }

    public void setAddAttention(int addAttention) {
        this.addAttention = addAttention;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @BindingAdapter("fundmangerimgs")
    public static void getInternetImage(ImageView iv, String userface) {
        if(!"".equals(userface)&&userface!=null){
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.mipmap.ic_launcher_round);
            requestOptions.error(R.mipmap.ic_launcher_round);
            requestOptions.circleCrop();
//            requestOptions.bitmapTransform(new CircleCrop());//圆形
            Glide.with(iv.getContext())
                    .load(userface)
                    .apply(requestOptions)
                    .into(iv);
        }else{
            Glide.with(iv.getContext())
                    .load(R.color.honeydew)
                    .into(iv);
        }
    }

}
