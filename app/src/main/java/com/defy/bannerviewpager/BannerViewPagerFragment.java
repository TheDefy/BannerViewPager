package com.defy.bannerviewpager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.defy.bannerviewpager.adapter.BannerAdapter;
import com.defy.bannerviewpager.base.BaseFragment;
import com.defy.bannerviewpager.bean.Ad;
import com.defy.bannerviewpager.bean.Notice;
import com.defy.bannerviewpager.bean.Picture;
import com.defy.bannerviewpager.bean.ScreenSaverData;
import com.defy.bannerviewpager.bean.ScreenSaverResult;
import com.defy.bannerviewpager.bean.Video;
import com.defy.bannerviewpager.common.Constant;
import com.defy.bannerviewpager.utils.DataUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by chenglei on 2017/9/21.
 */

public class BannerViewPagerFragment extends BaseFragment {

    @BindView(R.id.vp_pager)
    ViewPager mViewPager;
    @BindView(R.id.ll_dots)
    LinearLayout mDotList;

    private ImageView lastCircleIcon; //上一个小圆点对象

    @Override
    public int contentView() {
        return R.layout.banner_viewpager_fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initView(Bundle savedInstanceState) {
        initViewListener();
        initData();
    }

    private void initViewListener() {
//        mViewPager.set
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initData() {
        ArrayList<ScreenSaverData> screenSavers = new ArrayList<>();
        screenSavers.clear();

        String listAssets = DataUtils.getFromAssets("lists.json", mContext);
        ScreenSaverResult screenSaverResult = new Gson().fromJson(listAssets, ScreenSaverResult.class);
        Log.e("666", "screenSaverResult: \t" + screenSaverResult.toString());

        List<Ad> ads;
        List<Notice> notices;
        List<Picture> pictures;
        List<Video> videos;
        ads = screenSaverResult.getAds();
        notices = screenSaverResult.getNotices();
        pictures = screenSaverResult.getPictures();
        videos = screenSaverResult.getVideos();

        if (notices != null && !notices.isEmpty()) {
            for (int i = 0; i < notices.size(); i++) {
                ScreenSaverData bean = new ScreenSaverData();
                bean.setType(Constant.TYPE_TEXT);
                bean.setNotice(notices.get(i));
                screenSavers.add(bean);
            }
        }

        if (videos != null && !videos.isEmpty()) {
            for (int i = 0; i < videos.size(); i++) {
                ScreenSaverData bean = new ScreenSaverData();
                bean.setType(Constant.TYPE_VIDEO);
                bean.setVideo(videos.get(i));
                screenSavers.add(bean);
            }
        }

        if (ads != null && !ads.isEmpty()) {
            for (int i = 0; i < ads.size(); i++) {
                ScreenSaverData bean = new ScreenSaverData();
                bean.setType(Constant.TYPE_ADS);
                bean.setAd(ads.get(i));
                screenSavers.add(bean);
            }
        }

        if (pictures != null && !pictures.isEmpty()) {
            for (int i = 0; i < pictures.size(); i++) {
                ScreenSaverData bean = new ScreenSaverData();
                bean.setType(Constant.TYPE_PIC);
                bean.setPicture(pictures.get(i));
                screenSavers.add(bean);
            }
        }

        initDots(screenSavers);
        BannerAdapter adapter = new BannerAdapter(mViewPager, screenSavers, mContext);
        mViewPager.setAdapter(adapter);
    }

    /**
     * 计算小圆点
     *
     * @param list
     */
    private void initDots(ArrayList<ScreenSaverData> list) {
        if (mDotList == null || !isAdded()) {
            return;
        }
        mDotList.removeAllViews();
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_focus_select);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(bitmap.getWidth() / 2, bitmap.getWidth() / 2);
        layoutParams.setMargins(bitmap.getWidth() / 3, 0, bitmap.getWidth() / 3, 0);
        // 循环取得小点图片
        for (int i = 0; i < list.size(); i++) {
            ImageView img = new ImageView(mContext);
            img.setLayoutParams(new ViewGroup.LayoutParams(bitmap.getWidth() / 2, bitmap.getHeight() / 2));
            img.setBackgroundResource(R.mipmap.ic_focus_select);
            img.setPadding(bitmap.getWidth() / 2, 0, bitmap.getWidth() / 2, 0);
            img.setLayoutParams(layoutParams);
            mDotList.addView(img);
        }
        if (list.size() > 0) {
            lastCircleIcon = (ImageView) mDotList.getChildAt(0);
            lastCircleIcon.setBackgroundResource(R.mipmap.ic_focus);
        }
        bitmap.recycle();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
