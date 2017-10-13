package com.defy.bannerviewpager.utils;

import android.content.Context;

import java.io.InputStream;

/**
 * Created by chenglei on 2017/10/13.
 */

public class DataUtils {

    /**
     * 从assets读取
     *
     * @param fileName
     * @param context
     * @return
     */
    public static String getFromAssets(String fileName, Context context) {
        String result = "";
        try {
            InputStream in = context.getResources().getAssets().open(fileName);
            int lenght = in.available();
            byte[] buffer = new byte[lenght];
            in.read(buffer);
            result = new String(buffer, "utf-8");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
