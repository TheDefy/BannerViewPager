package com.defy.bannerviewpager.bean;

import java.io.Serializable;

/**
 * Created by chenglei on 2017/10/13.
 */

public class ScreenSaverData implements Serializable {

    private int type;  // 0 图片  1 文字 // 3 video
    private int res;   // 显示默认图
    private Notice notice;//文字
    private Picture picture;//图片
    private Video video;//视频
    private Ad ad;// 广告

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "ScreenSaverData{" +
                "type=" + type +
                ", res=" + res +
                ", notice=" + notice +
                ", picture=" + picture +
                ", video=" + video +
                ", ad=" + ad +
                '}';
    }
}
