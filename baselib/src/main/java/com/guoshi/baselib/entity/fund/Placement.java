package com.guoshi.baselib.entity.fund;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/16
 * 文件描述：基金实体
 */
public class Placement {
    private String fundId;
    private String fundName;
    private int addOptional;

    public int getAddOptional() {
        return addOptional;
    }

    public void setAddOptional(int addOptional) {
        this.addOptional = addOptional;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
