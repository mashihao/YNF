package com.yunifang.ynf.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yunifang.ynf.model.User;
import com.yunifang.ynf.utils.CountTimerUtil;
import com.yunifang.ynf.utils.IToast;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * TODO 注册界面  通过手机号+验证码+密码来注册
 * Created by MSH on 2016/11/10.
 */

public class RegisterActivity extends BaseActivity {

    @Bind(R.id._et_register_phone)
    EditText etRegisterPhone;
    @Bind(R.id._et_register_phone_code)
    EditText etRegisterPhoneCode;
    @Bind(R.id._bt_register_phone_code)
    Button btRegisterPhoneCode;
    @Bind(R.id._et_register_password)
    EditText etRegisterPassword;
    @Bind(R.id._bt_registe)
    Button btRegiste;

    CountTimerUtil timer;

    public static final String REGISTER_TO_LOGIN_PHONE_NUM = "register_phone_num_done";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initData() {
        timer = new CountTimerUtil(this, btRegisterPhoneCode);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {


    }

    @OnClick({R.id._bt_register_phone_code, R.id._bt_registe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id._bt_register_phone_code:
                requestSMSCode(etRegisterPhone.getText().toString().trim());
                timerStart();
                break;
            case R.id._bt_registe:
                registerWithPassword(etRegisterPhone.getText().toString(), etRegisterPassword.getText().toString(), etRegisterPhoneCode.getText().toString());
                break;
        }
    }


    /**
     * TODO 通过手机号, 验证码,密码 注册账号
     * @param phoneNum
     * @param password
     * @param code
     */
    public void registerWithPassword(final String phoneNum, String password, String code) {
        User user = new User();
        user.setMobilePhoneNumber(phoneNum);
        user.setPassword(password);
        user.signOrLogin(code, new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    IToast.showToast(RegisterActivity.this, "success");
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    intent.putExtra("REGISTER_TO_LOGIN_PHONE_NUM",phoneNum);
                    startActivity(intent);
                } else {
                    IToast.showToast(RegisterActivity.this, e.toString());
                }
            }
        });

    }
    private void requestSMSCode(String phoneNum) {

        // 验证手机号码
        if (!TextUtils.isEmpty(phoneNum)) {
            BmobSMS.requestSMSCode(phoneNum, "淤泥仿", new QueryListener<Integer>() {

                @Override
                public void done(Integer smsId, BmobException ex) {
                    if (ex == null) {//验证码发送成功
                        Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();//用于查询本次短信发送详情
                    } else {
                        IToast.showToast(RegisterActivity.this,"验证码发送失败,请检查手机号!");
                        timerFinish();
                    }
                }
            });
        }
    }


    /**
     * TODO 当验证码发送成功的之后,修改按钮的状态, 开始60s计时
     */
    private void codeSendSucc() {
        btRegisterPhoneCode.setClickable(false);
        btRegisterPhoneCode.setBackgroundColor(Color.GRAY);
        timerStart();
    }


    /**
     * TODO  启动计时器
     */
    public void timerStart() {
        btRegisterPhoneCode.setClickable(false);
        btRegisterPhoneCode.setBackgroundResource(R.drawable.rect_gray_button);
        btRegisterPhoneCode.setTextColor(ContextCompat.getColor(this, R.color.white));
        timer.start();
    }

    /**
     * TODO  关闭计时器
     */
    public void timerFinish() {
        btRegisterPhoneCode.setClickable(true);
        btRegisterPhoneCode.setBackgroundResource(R.drawable.rect_red_button);
        btRegisterPhoneCode.setTextColor(ContextCompat.getColor(this, R.color.lightRed));
        btRegisterPhoneCode.setText("获取验证码");
        if (timer != null) {
            timer.cancel();
        }
    }


    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        timerFinish();
    }

    @Override
    public void finish() {
        super.finish();
        timerFinish();
    }
}
