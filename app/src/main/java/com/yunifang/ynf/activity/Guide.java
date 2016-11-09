package com.yunifang.ynf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.yunifang.uilibrary.adapter.DemoPagerAdapter;
import com.yunifang.uilibrary.views.CircleIndicator;
import com.yunifang.uilibrary.views.ImageFragment;
import com.yunifang.ynf.utils.AppManager;

public class Guide extends BaseActivity implements ImageFragment.IntentBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ViewPager defaultViewpager = (ViewPager) findViewById(R.id.viewpager_default);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager(),this);
        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);
        AppManager.getAppManager().addActivity(Guide.this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }


    @Override
    public void getIntentCallBack() {
        Intent intent = new Intent(Guide.this,SplashActivity.class);
        startActivity(intent);
    }
}