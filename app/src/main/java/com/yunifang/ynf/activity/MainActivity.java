package com.yunifang.ynf.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yunifang.uilibrary.views.ImageFragment;
import com.yunifang.ynf.fragment.CartFragment;
import com.yunifang.ynf.fragment.CategoryFragment;
import com.yunifang.ynf.fragment.HomeFragment;
import com.yunifang.ynf.fragment.MeFragment;

public class MainActivity extends BaseActivity implements ImageFragment.IntentBack, View.OnClickListener {

    private int mFinishCount = 0;
    /**
     * TODO 用于展示   首页   的Fragment
     */
    private HomeFragment homeFragment;

    /**
     * TODO 用于展示   购物车   的Fragment
     */
    private CartFragment cartFragment;

    /**
     * TODO 用于展示   分类  的Fragment
     */
    private CategoryFragment categoryFragment;

    /**
     * TODO 用于展示    个人设置   的Fragment
     */
    private MeFragment meFragment;


    /**
     * TODO    首页   布局
     */
    private View homeLayout;

    /**
     * TODO    分类  布局
     */
    private View categoryLayout;

    /**
     * TODO    分类  布局
     */
    private View cartLayout;

    /**
     * TODO   个人设置   布局
     */
    private View meLayout;


    /**
     * TODO 在Tab布局上显示  首页   图标的控件
     */
    private ImageView homeImage;

    /**
     * TODO 在Tab布局上显示   分类   图标的控件
     */
    private ImageView categoryImage;

    /**
     * TODO 在Tab布局上显示    购物车    图标的控件
     */
    private ImageView cartImage;

    /**
     * TODO 在Tab布局上显示    个人设置   图标的控件
     */
    private ImageView meImage;

    /**
     * TODO 从Login登陆进去后进去Setting界面
     */
    private Intent intent = null;

    /**
     * TODO 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    private RefreshCallback rc;//定义一个接口

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();

        setTabSelection(0);

    }



    @Override
    public void initData() {

    }

    /**
     * TODO 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    @Override
    public void initView() {
        homeLayout = findViewById(R.id.home_layout);
        categoryLayout = findViewById(R.id.category_layout);
        cartLayout = findViewById(R.id.cart_layout);
        meLayout = findViewById(R.id.me_layout);

        meImage = (ImageView) findViewById(R.id.me_image);
        categoryImage = (ImageView) findViewById(R.id.category_image);
        cartImage = (ImageView) findViewById(R.id.cart_image);
        homeImage = (ImageView) findViewById(R.id.home_image);

    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示Home，1表示category，2表示cart，3表示Me。
     */
    private void setTabSelection(int index) {

        //TODO 每次选中之后先清除掉上次的选中状态
        clearSelection();
        //TODO 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //TODO 先隐藏掉多有的Fragment 以防止多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                homeImage.setImageResource(R.mipmap.home_);
                if (homeFragment == null) {
                    // 如果HomeFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // HomeFragment，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                categoryImage.setImageResource(R.mipmap.category_);

                if (categoryFragment == null) {
                    // 如果CategoryFragment为空，则创建一个并添加到界面上
                    categoryFragment = new CategoryFragment();
                    transaction.add(R.id.content, categoryFragment);
                } else {
                    // 如果CategoryFragment不为空，则直接将它显示出来
                    transaction.show(categoryFragment);
                }
                break;
            case 2:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                cartImage.setImageResource(R.mipmap.cart_);

                if (cartFragment == null) {
                    // 如果CategoryFragment为空，则创建一个并添加到界面上
                    cartFragment = new CartFragment();
                    transaction.add(R.id.content, cartFragment);
                } else {
                    // 如果CategoryFragment不为空，则直接将它显示出来
                    transaction.show(cartFragment);
                }

                break;
            case 3:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                meImage.setImageResource(R.mipmap.me_);

                if (meFragment == null) {
                    // 如果CategoryFragment为空，则创建一个并添加到界面上
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    // 如果CategoryFragment不为空，则直接将它显示出来
                    transaction.show(meFragment);
                }
                break;
        }
        transaction.commit();
    }

    //返回键的重写
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mFinishCount = 0;
        return super.dispatchTouchEvent(ev);
    }

    //定义一个是否刷新界面
    public interface RefreshCallback {
        void isRefresh(boolean flag);
    }

    public void setRefresh(RefreshCallback rc) {
        this.rc = rc;
    }


    @Override
    public void finish() {
        mFinishCount++;
        if (mFinishCount == 1) {
            Toast.makeText(this, "再按一次退出！", Toast.LENGTH_LONG).show();
        } else if (mFinishCount == 2) {
            super.finish();
        }
    }


    /**
     * TODO 清除掉所有的选中状态。
     */
    private void clearSelection() {

        homeImage.setImageResource(R.mipmap.home);
        cartImage.setImageResource(R.mipmap.cart);
        categoryImage.setImageResource(R.mipmap.category);
        meImage.setImageResource(R.mipmap.me);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {

        if (meFragment != null) {
            transaction.hide(meFragment);
        }
        if (categoryFragment != null) {
            transaction.hide(categoryFragment);
        }
        if (cartFragment != null) {
            transaction.hide(cartFragment);
        }
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
    }

    @Override
    public void initListener() {
        /**
         * TODO 点击事件,布局下四个tab添加点击事件,如果点击后(将ImageView组件变亮,将TextView字体变亮)
         *
         * */
        homeLayout.setOnClickListener(MainActivity.this);
        meLayout.setOnClickListener(MainActivity.this);
        categoryLayout.setOnClickListener(MainActivity.this);
        cartLayout.setOnClickListener(MainActivity.this);

    }


    @Override
    public void getIntentCallBack() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_layout:
                setTabSelection(0);
                break;
            case R.id.category_layout:
                setTabSelection(1);
                break;
            case R.id.cart_layout:
                setTabSelection(2);
                break;
            case R.id.me_layout:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }
}