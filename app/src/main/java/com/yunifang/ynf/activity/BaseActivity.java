package com.yunifang.ynf.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.Stack;

import butterknife.ButterKnife;

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
    @Override
    public void setContentView(int layoutResId){
        super.setContentView(layoutResId);
        //Butter Knife初始化
        ButterKnife.bind(this);
    }

    /**
     * 这个一般用于加载自定义控件，或者系统空间的布局
     */
    @Override
    public void setContentView(View view){
        super.setContentView(view);
        //Butter Knife初始化
        ButterKnife.bind(this);
    }


    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params){
        super.setContentView(view,params);
        //Butter Knife初始化
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activities.add(this);
        mContext=this;
        initData();
        initView();
        initListener();



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

//    public void itLogin(Context context){
//        Intent itLogin = new Intent(context, LoginActivity.class);
//        startActivity(itLogin);
//    }
}
