package com.yunifang.ynf.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.yunifang.ynf.utils.IToast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MSH on 2016/11/14.
 */

public class WelcomeActivity extends AppCompatActivity {

    @Bind(R.id._bt_welcome)
    Button BtWelcome;
    @Bind(R.id._bt_welcome2)
    Button BtWelcome2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);


    }

    @OnClick(R.id._bt_welcome)
    public void onClick() {

        IToast.showToast(WelcomeActivity.this, "Hello");
    }

    @OnClick(R.id._bt_welcome2)
    public void onClick2() {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }
}
