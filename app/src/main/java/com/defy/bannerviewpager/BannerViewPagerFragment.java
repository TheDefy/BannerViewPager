package com.defy.bannerviewpager;

import android.os.Bundle;

import com.defy.bannerviewpager.base.BaseFragment;

/**
 * Created by chenglei on 2017/9/21.
 */

public class BannerViewPagerFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int contentView() {
        return R.layout.banner_viewpager_fragment;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
