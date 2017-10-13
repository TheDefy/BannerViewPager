package com.defy.bannerviewpager.bean;

import java.io.Serializable;

/**
 * Created by chenglei on 2017/10/13.
 */

public class Ad implements Serializable {

    /**
     * adType : 1
     * pic1 : http://bbtree-kaoqin-ads.bbtree.com/kqad/1501837096174.jpg
     * id : 46
     * pic2 : http://bbtree-kaoqin-ads.bbtree.com/kqad/1501837099646.jpg
     */

    private int adType;
    private String pic1;
    private int id;
    private String pic2;

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }
}
