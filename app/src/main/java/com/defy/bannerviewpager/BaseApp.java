package com.defy.bannerviewpager;

import android.app.Application;

import com.squareup.picasso.Picasso;

/**
 * Created by defy on 16/01/2017.
 */

public class BaseApp extends Application {

    private static BaseApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initPicasso();
    }

    public static BaseApp getApp() {
        return app;
    }

    /**
     * Picasso图片加载
     */
    private void initPicasso() {
        Picasso.Builder picassoBuilder = new Picasso.Builder(this);
        Picasso picasso = picassoBuilder.build();
        picasso.setLoggingEnabled(true);
        try {
            Picasso.setSingletonInstance(picasso);
        } catch (IllegalStateException e) {
            // Picasso instance was already set
            // cannot set it after Picasso.with(Context) was already in use
        }
    }
}
