package com.yunifang.ynf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by MSH on 2016/11/7.
 */

public class SplashActivity extends BaseActivity {


    @Bind(R.id._iv_ad)
    ImageView ivAd;
    @Bind(R.id._bt_skip)
    Button btSkip;

    final MyCountTimer timer = new MyCountTimer(4000,1000);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer.start();
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


    @OnClick({R.id._iv_ad, R.id._bt_skip})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id._iv_ad:
                Intent intent = new Intent(SplashActivity.this,ADActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id._bt_skip:
                Intent intent1 = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }


    class MyCountTimer extends CountDownTimer{
        public MyCountTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            btSkip.setText("跳过"+l/1000+"s");
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(timer!=null){
            timer.cancel();
        }
    }
}
