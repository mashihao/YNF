package com.yunifang.ynf.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.Bind;

/**
 * Created by MSH on 2016/11/11.
 */

public class WebViewActivity extends BaseActivity {


    @Bind(R.id.wv_show)
    WebView wvShow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }
    @Override
    public void initData() {
        WebSettings wSet = wvShow.getSettings();
        wSet.setJavaScriptEnabled(true);
        wvShow.loadUrl("file:///android_asset/web/index.html");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }
}
