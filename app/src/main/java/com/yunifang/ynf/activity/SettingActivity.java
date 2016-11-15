package com.yunifang.ynf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MSH on 2016/11/11.
 */

public class SettingActivity extends BaseActivity {

    @Bind(R.id._tv_set_title_back)
    TextView tvSetTitleBack;
    @Bind(R.id._tv_set_Buyer_Reading)
    TextView tvSetBuyerReading;
    @Bind(R.id._tv_set_Suggestion_Feedback)
    TextView tvSetSuggestionFeedback;
    @Bind(R.id._tv_set_Clear_Cache)
    TextView tvSetClearCache;
    @Bind(R.id._tv_set_About_Us)
    TextView tvSetAboutUs;
    @Bind(R.id._tv_set_Call)
    TextView tvSetCall;
    @Bind(R.id._tv_set_Update)
    TextView tvSetUpdate;
    @Bind(R.id._bt_set_logout)
    Button btSetLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

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

    @OnClick({R.id._tv_set_title_back, R.id._tv_set_Buyer_Reading, R.id._tv_set_Suggestion_Feedback, R.id._tv_set_Clear_Cache, R.id._tv_set_About_Us, R.id._tv_set_Call, R.id._tv_set_Update, R.id._bt_set_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id._tv_set_title_back:
                break;
            case R.id._tv_set_Buyer_Reading:
                startActivity(new Intent(SettingActivity.this, AboutMeActivity.class));
                break;
            case R.id._tv_set_Suggestion_Feedback:
                break;
            case R.id._tv_set_Clear_Cache:
                break;
            case R.id._tv_set_About_Us:

                break;
            case R.id._tv_set_Call:
                break;
            case R.id._tv_set_Update:
                break;
            case R.id._bt_set_logout:
                break;
        }
    }
}
