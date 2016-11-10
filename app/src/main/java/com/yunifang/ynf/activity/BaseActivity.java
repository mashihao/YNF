package com.yunifang.ynf.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.Stack;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

/**
 * Created by MSH on 2016/11/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private static Stack<Activity> activities = new Stack<>();

    /**
     *  使用频率高 一般用于Activity初始化界面
     *  例如 onCreate()里。初始化布局就用到setContentView(R.layout.xxxx) 就是初始化页面布局
     */
    private static final String APPLICATION_ID = "5da2c4810eb4d9ce575fbfe900482f9a";
    @Override
    public void setContentView(int layoutResId){
        super.setContentView(layoutResId);

//        Bmob
        Bmob.initialize(this, APPLICATION_ID);

        //Butter Knife初始化
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    /**
     * 这个一般用于加载自定义控件，或者系统空间的布局
     */
    @Override
    public void setContentView(View view){
        super.setContentView(view);
        //Butter Knife初始化
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }


    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params){
        super.setContentView(view,params);
        //Butter Knife初始化
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
        mContext=this;
    }
    public abstract void initData();
    public abstract void initView();
    public abstract void initListener();

    /**
     * TODO:退出当前应用程序
     */
    public static void exitApplication(){
        for(Activity activity : activities){
            if(activity != null){
                activity.finish();
            }
        }
        System.exit(0);
    }

}
