package com.defy.bannerviewpager;

import android.os.Bundle;

import com.defy.bannerviewpager.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (null == savedInstanceState) {
            BannerViewPagerFragment fragment = new BannerViewPagerFragment();
            getFragmentManager().beginTransaction().replace(R.id.fl_content,fragment).commit();

        }
    }
}
