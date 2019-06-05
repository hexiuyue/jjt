package com.guoshi.baselib.api.http.bean;

import android.util.Log;

import java.util.List;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：解析实体基类
 */
public class BaseEntity<T> {
    private static int SUCCESS_CODE=1;//成功的code
    private int status;
    private String message;
    private T data;
    private int count;
    private int totalPage;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isSuccess(){
        Log.e("getStatus()",getStatus()+"");
        Log.e("message()",getMessage()+"");
        return getStatus()==SUCCESS_CODE;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
