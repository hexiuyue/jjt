package com.guoshi.baselib.entity.back;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/16
 * 文件描述：银行产品实体类
 */
public class BackProducts {
    private String rate;
    private String name;
    private String limit;
    private String bankName;
    private Integer isHot;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
}
