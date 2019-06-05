package com.guoshi.baselib.entity;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/15
 * 文件描述：热搜实体类
 */
public class Seek {
    private int id;
    private String name;
    private int isHot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
