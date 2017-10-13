package com.defy.bannerviewpager.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.defy.bannerviewpager.R;
import com.defy.bannerviewpager.bean.Ad;
import com.defy.bannerviewpager.bean.Notice;
import com.defy.bannerviewpager.bean.Picture;
import com.defy.bannerviewpager.bean.ScreenSaverData;
import com.defy.bannerviewpager.common.Constant;
import com.defy.bannerviewpager.widget.VerticalMarqueeTextView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

/**
 * Created by chenglei on 2017/10/13.
 */

public class BannerAdapter extends PagerAdapter {
    private List<ScreenSaverData> mDatas;
    private Context mContext;
    private int count;

    public BannerAdapter(final ViewPager pager, List<ScreenSaverData> mDatas, Context mContext) {
        super();
        this.mContext = mContext;
        int actualNoOfIDs = mDatas.size();
        count = actualNoOfIDs + 2;

        ScreenSaverData t = mDatas.get(0);//获取到第一个
        ScreenSaverData t1 = mDatas.get(mDatas.size() - 1);//获取到最后一个

        this.mDatas = mDatas;
        this.mDatas.add(mDatas.size(), t);
        this.mDatas.add(0, t1);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                int pageCount = getCount();
                if (position == 0) {
                    pager.setCurrentItem(pageCount - 2, false);
                } else if (position == pageCount - 1) {
                    //延时切换，避免闪烁
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pager.setCurrentItem(1, false);
                        }
                    }, 600);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public int getCount() {
        return count;
    }

    public Object instantiateItem(View container, int position) {

        View view = null;
        ScreenSaverData screenSaverData = mDatas.get(position);
        int type = screenSaverData.getType();
        switch (type) {
            case Constant.TYPE_TEXT: // 文字
                Notice notice = screenSaverData.getNotice();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.render_type_text, null);
                TextView notice_title = (TextView) view.findViewById(R.id.notice_title);
                notice_title.setText(notice.getTitle());
                VerticalMarqueeTextView notice_content = (VerticalMarqueeTextView) view.findViewById(R.id.notice_content);
                notice_content.setText(notice.getContent());
                TextView notice_sign = (TextView) view.findViewById(R.id.notice_sign);
                notice_sign.setText(notice.getSignature());
                TextView notice_date = (TextView) view.findViewById(R.id.notice_date);
                notice_date.setText(notice.getNoticeTime());

                break;
            case Constant.TYPE_PIC: // 图片
                Picture picture = screenSaverData.getPicture();
                RoundedImageView img = (RoundedImageView) LayoutInflater.from(mContext).inflate(R.layout.screen_saver_item, null);

                Picasso.with(mContext).load(picture.getUrl())
                        .placeholder(R.mipmap.screensaver_default)
                        .error(R.mipmap.screensaver_default)
                        .config(Bitmap.Config.RGB_565).into(img);
                view = img;
                break;
            case Constant.TYPE_ADS: // 广告
                Ad ad = screenSaverData.getAd();
                RoundedImageView imgAd = (RoundedImageView) LayoutInflater.from(mContext).inflate(R.layout.screen_saver_item, null);
                String url;
                if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    url = ad.getPic1();
                } else {
                    url = ad.getPic2();
                }
                RequestCreator loadAd;
                if (TextUtils.isEmpty(url))
                    loadAd = Picasso.with(this.mContext).load(R.mipmap.screensaver_default);
                else
                    loadAd = Picasso.with(this.mContext).load(url);

                loadAd.placeholder(R.mipmap.screensaver_default)
                        .error(R.mipmap.screensaver_default)
                        .config(Bitmap.Config.RGB_565).into(imgAd);
                view = imgAd;

                break;
            case Constant.TYPE_VIDEO: // 视频

                break;
        }

        //TODO 在这里返回你的View
        ((ViewPager) container).addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
