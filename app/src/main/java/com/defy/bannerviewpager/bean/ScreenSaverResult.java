package com.defy.bannerviewpager.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenglei on 2017/10/13.
 */

public class ScreenSaverResult implements Serializable {

    private List<Notice> notices;
    private List<Picture> pictures;
    private List<Video> videos;
    private List<Ad> ads;

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "ScreenSaverResult{" +
                "notices=" + notices +
                ", pictures=" + pictures +
                ", videos=" + videos +
                ", ads=" + ads +
                '}';
    }
}
