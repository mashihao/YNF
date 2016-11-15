package com.yunifang.test;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.SearchView;

public class MainActivity extends Base implements View.OnClickListener,SearchView.OnQueryTextListener{

    View show,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void initData() {
        Log.d("MSH","MainActivity   setContentView()");

        show =  findViewById(R.id.show);
        login =  findViewById(R.id.login);
    }

    @Override
    public void initView() {
        Log.d("MSH"," MainActivity   setContentView()");
    }

    @Override
    public void initListener() {
        show.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.show:
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        show,
                        show.getWidth()/2,
                        show.getHeight()/2,
                        show.getWidth(),
                        0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(2000);
                animator.start();

                break;

            case R.id.login:
                Animator animator2 = ViewAnimationUtils.createCircularReveal(
                        login,
                        0,
                        0,
                        0,
                        (float) Math.hypot(login.getWidth(), login.getHeight()));
                animator2.setInterpolator(new AccelerateInterpolator());
                animator2.setDuration(2000);
                animator2.start();

                break;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
