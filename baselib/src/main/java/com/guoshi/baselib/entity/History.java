package com.guoshi.baselib.entity;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.guoshi.baselib.BR;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/15
 * 文件描述：搜索历史内容类
 */
@Entity
public class History extends BaseObservable {
    @Id(autoincrement = true)
    private Long id;

    private String content;

    private int type;//历史记录类型 0首页搜索，1公募搜索，2私募搜索

    @Generated(hash = 743537489)
    public History(Long id, String content, int type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    @Generated(hash = 869423138)
    public History() {
    }
    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }
}
