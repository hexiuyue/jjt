package com.guoshi.baselib.entity.fund;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/6
 * 文件描述：基金公司
 */
public class Company {
    private String companyId;//": "C000005",
    private int addAttention;//": "0",
    private String companyName;//": "华安基金"

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

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
}
