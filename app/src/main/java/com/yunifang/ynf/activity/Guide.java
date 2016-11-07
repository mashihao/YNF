package com.yunifang.ynf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.yunifang.uilibrary.adapter.DemoPagerAdapter;
import com.yunifang.uilibrary.views.CircleIndicator;
import com.yunifang.uilibrary.views.ImageFragment;
import com.yunifang.ynf.utils.AppManager;

/**
 * Created by MSH on 2016/11/7.
 */

public class Guide extends FragmentActivity implements ImageFragment.IntentBack {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_guide);
        ViewPager defaultViewpager = (ViewPager) findViewById(R.id.viewpager_default);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager(),this);
        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);
        AppManager.getAppManager().addActivity(Guide.this);
    }
    @Override
    public void getIntentCallBack() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
