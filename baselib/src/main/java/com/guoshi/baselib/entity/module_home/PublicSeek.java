package com.guoshi.baselib.entity.module_home;

import com.guoshi.baselib.entity.fund.FundManger;
import com.guoshi.baselib.entity.fund.Company;
import com.guoshi.baselib.entity.fund.Placement;

import java.util.List;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/20
 * 文件描述：首页搜索组合体
 */
public class PublicSeek {

    private List<Placement> funds;
    private List<Company> companys;
    private List<FundManger> managers;

    public List<Placement> getFunds() {
        return funds;
    }

    public void setFunds(List<Placement> funds) {
        this.funds = funds;
    }

    public List<Company> getCompanys() {
        return companys;
    }

    public void setCompanys(List<Company> companys) {
        this.companys = companys;
    }

    public List<FundManger> getManagers() {
        return managers;
    }

    public void setManagers(List<FundManger> managers) {
        this.managers = managers;
    }
}
