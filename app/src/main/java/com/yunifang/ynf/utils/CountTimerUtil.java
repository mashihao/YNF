package com.yunifang.ynf.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.widget.Button;

import com.yunifang.ynf.activity.R;

/**
 * Created by MSH on 2016/11/11.
 */

public class CountTimerUtil extends CountDownTimer {

    private Button view;
    private Context context;

    public CountTimerUtil(Context context, Button view) {
        super(60000, 1000);
        this.view = view;
        this.context = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        view.setText((millisUntilFinished / 1000) + "秒后重发");
    }

    @Override
    public void onFinish() {
        view.setBackgroundResource(R.drawable.rect_red_button);
        view.setTextColor(ContextCompat.getColor(context, R.color.lightRed));
        view.setText("发送验证码");
    }
}
