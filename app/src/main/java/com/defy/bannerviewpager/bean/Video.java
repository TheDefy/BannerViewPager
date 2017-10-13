package com.defy.bannerviewpager.bean;

import java.io.Serializable;

/**
 * Created by chenglei on 2017/10/13.
 */

public class Video implements Serializable {

    private String title; //视频标题
    private String url; //视频地址

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
