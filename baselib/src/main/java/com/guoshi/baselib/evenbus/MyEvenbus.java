package com.guoshi.baselib.evenbus;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/6
 * 文件描述：
 */
public class MyEvenbus {
    private String tag;
    private String message;


    public MyEvenbus(String tag,String message) {
        this.tag = tag;
        this. message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
