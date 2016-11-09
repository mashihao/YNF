package com.yunifang.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Base implements View.OnClickListener{


    Button show,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void initData() {
        Log.d("MSH","MainActivity   setContentView()");

        show = (Button) findViewById(R.id.show);
        login = (Button) findViewById(R.id.login);
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.show:

                boolean flag = Contants.isLogin;
                if (flag)
                {
                    Toast.makeText(this, "Trun", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.login:
                Contants.isLogin=true;
                break;
        }
    }
}
