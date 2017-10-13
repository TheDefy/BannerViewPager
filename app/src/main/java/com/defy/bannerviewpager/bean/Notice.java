package com.defy.bannerviewpager.bean;

import java.io.Serializable;

/**
 * Created by chenglei on 2017/10/13.
 */

public class Notice implements Serializable {
    private String title; //通知标题
    private String content; //通知内容
    private String signature;
    private String noticeTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }
}
