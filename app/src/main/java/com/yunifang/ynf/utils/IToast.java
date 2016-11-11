package com.yunifang.ynf.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yunifang.ynf.activity.R;

/**
 * Created by MSH on 2016/11/11.
 */

public class IToast {


    public static void showToast(Context context, String msg) {
        View layoutView = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);

        TextView tv = (TextView) layoutView.findViewById(R.id._tv_toast);
        tv.setText(msg);
        //创建toast对象，
        Toast toast = new Toast(context);
        //把要Toast的布局文件放到toast的对象中
        toast.setView(layoutView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 70);
        toast.show();
    }
}
