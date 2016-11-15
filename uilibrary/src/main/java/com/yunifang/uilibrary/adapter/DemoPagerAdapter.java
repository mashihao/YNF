package com.yunifang.uilibrary.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yunifang.uilibrary.views.ImageFragment;


public class DemoPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int style;

    public DemoPagerAdapter(FragmentManager fm, Context context, int style) {
        super(fm);
        this.context = context;
        this.style = style;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return ImageFragment.newInstance(arg0, context, style);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (ImageFragment.GOODS_DETAIL == style) {
            return ImageFragment.image2.length;
        } else
            return ImageFragment.image.length;
    }
}
