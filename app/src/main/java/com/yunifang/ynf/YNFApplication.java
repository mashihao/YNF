package com.yunifang.ynf;

import android.app.Application;

/**
 * Created by MSH on 2016/11/7.
 */

public class YNFApplication extends Application implements Thread.UncaughtExceptionHandler {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
