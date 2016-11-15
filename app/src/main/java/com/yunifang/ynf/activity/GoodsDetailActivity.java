package com.yunifang.ynf.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.yunifang.uilibrary.adapter.DemoPagerAdapter;
import com.yunifang.uilibrary.adapter.ViewPagerAdapter;
import com.yunifang.uilibrary.views.CircleIndicator;
import com.yunifang.uilibrary.views.ImageFragment;

/**
 * Created by MSH on 2016/11/14.
 */

public class GoodsDetailActivity extends BaseActivity implements ImageFragment.IntentBack {

    private TabLayout toolbar_tab;
    private ViewPager main_vp_container;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private CoordinatorLayout root_layout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
    }

    @Override
    public void initData() {

        ViewPager defaultViewpager = (ViewPager) findViewById(R.id._vp_detail);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id._detail_indicator);
        DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager(), this,ImageFragment.GOODS_DETAIL);

        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);
    }

    @Override
    public void initView() {

        AppBarLayout app_bar_layout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        //上部信息布局
        //底部信息布局

        root_layout = (CoordinatorLayout) findViewById(R.id.root_layout);
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        toolbar_tab = (TabLayout) findViewById(R.id.toolbar_tab);
        main_vp_container = (ViewPager) findViewById(R.id.main_vp_container);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        main_vp_container.setAdapter(vpAdapter);

//        tablayout和viewpager建立相互的联系
        main_vp_container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(toolbar_tab));
        toolbar_tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(main_vp_container));


    }

    @Override
    public void initListener() {

    }

    @Override
    public void getIntentCallBack() {

    }
}
