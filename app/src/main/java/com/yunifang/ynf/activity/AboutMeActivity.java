package com.yunifang.ynf.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by MSH on 2016/11/11.
 */

public class AboutMeActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        WebView wView = (WebView)findViewById(R.id.wv_show);
        WebSettings wSet = wView.getSettings();
        wSet.setJavaScriptEnabled(true);

        wView.loadUrl("file:///android_asset/web/index.html");


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
}
