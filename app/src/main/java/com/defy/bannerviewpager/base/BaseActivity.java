package com.defy.bannerviewpager.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by defy on 16/01/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActionBar() != null) {
            getActionBar().hide();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

