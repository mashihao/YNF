package com.yunifang.test;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by MSH on 2016/11/7.
 */

public abstract class Base extends AppCompatActivity {


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        Log.d("MSH", "setContentView()");
        initData();
        Log.d("MSH", "initData()");
        initView();
        Log.d("MSH", "initView()");
        initListener();
        Log.d("MSH", "initListener()");
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
        Log.d("MSH", "setContentView()");
        initData();
        Log.d("MSH", "initData()");
        initView();
        Log.d("MSH", "initView()");
        initListener();
        Log.d("MSH", "initListener()");
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
        Log.d("MSH", "setContentView()");
        initData();
        Log.d("MSH", "initData()");
        initView();
        Log.d("MSH", "initView()");
        initListener();
        Log.d("MSH", "initListener()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public abstract void initData();

    public abstract void initView();

    public abstract void initListener();
}
