package com.guoshi.baselib.entity.module_home;

import com.guoshi.baselib.entity.back.BackProducts;
import com.guoshi.baselib.entity.fund.Placement;

import java.util.List;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/20
 * 文件描述：首页搜索组合体
 */
public class Products {
    private List<BackProducts> bankProducts;
    private List<Placement> privateFunds;
    private List<Placement> publicFunds;

    public List<BackProducts> getBankProducts() {
        return bankProducts;
    }

    public void setBankProducts(List<BackProducts> bankProducts) {
        this.bankProducts = bankProducts;
    }

    public List<Placement> getPrivateFunds() {
        return privateFunds;
    }

    public void setPrivateFunds(List<Placement> privateFunds) {
        this.privateFunds = privateFunds;
    }

    public List<Placement> getPublicFunds() {
        return publicFunds;
    }

    public void setPublicFunds(List<Placement> publicFunds) {
        this.publicFunds = publicFunds;
    }
}
