package com.yunifang.ynf.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baoyz.widget.PullRefreshLayout;
import com.yunifang.uilibrary.views.MyWebView;
import com.yunifang.ynf.activity.MainActivity;
import com.yunifang.ynf.activity.R;
import com.yunifang.ynf.utils.IToast;
import com.yunifang.ynf.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;

/**
 * Created by MSH on 2016/11/7.
 */

public class HomeFragment extends BaseFragment implements MainActivity.RefreshCallback {


    @Bind(R.id.lineLayTitle)
    LinearLayout lineLayTitle;
    @Bind(R.id.list)
    ListView list;
    @Bind(R.id.pullRefreshLayout)
    PullRefreshLayout pullRefreshLayout;
    private View rootView;
    private float lastY;
    private MainActivity mainActivity;

    @Bind(R.id.webView)
    MyWebView webView;


    private String[] datas;

    private static int NUM = 50;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initDatas() {
        datas = new String[60];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = "item---->" + i;
        }
    }

    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        ButterKnife.bind(this, rootView);
        pullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_Bitmap);
        initDatas();

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas);
        list.setAdapter(adapter);
        isLogin();
        return rootView;
    }


    private void isLogin() {
        BmobUser user = BmobUser.getCurrentUser();
        if (user != null) {
            IToast.showToast(getActivity(), user.getUsername());
        } else {
            IToast.showToast(getActivity(), "Please Login");
        }
    }


    private void refreshDatas() {
        for (int i = 0; i < datas.length; i++) {
            datas[i] = "item---->" + i + NUM;
        }
        NUM += 50;
    }

    @Override
    protected void initTitle() {
        lineLayTitle = (LinearLayout) getView().findViewById(R.id.lineLayTitle);
        getView().findViewById(R.id.txtScanning).setOnClickListener(this);
        getView().findViewById(R.id.lineLaySearch).setOnClickListener(this);
        getView().findViewById(R.id.txtMessage).setOnClickListener(this);
    }

    @Override
    protected void initView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT,无网络时，使用LOAD_CACHE_ELSE_NETWORK
        if (Utils.NO_NETWORK_STATE == Utils.isNetworkAvailable(getActivity())) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        } else
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); // 设置缓存模式
        // 开启DOM storage API 功能
        webView.getSettings().setDomStorageEnabled(true);
        // 开启database storage API功能
        webView.getSettings().setDatabaseEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");
        webViewScroolChangeListener();


        pullRefreshLayout = (PullRefreshLayout) getView().findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_Bitmap);

        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshDatas();
                        adapter.notifyDataSetChanged();
                        pullRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }

            @Override
            public void onMove(boolean ismove) {
                if (!ismove) {
                    lineLayTitle.setVisibility(View.VISIBLE);
                }
            }
        });

        pullRefreshLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        lastY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if ((motionEvent.getY() - lastY) > 0)
                            lineLayTitle.setVisibility(View.INVISIBLE);
                        else
                            lineLayTitle.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });

    }


    //滑动监听
    private void webViewScroolChangeListener() {
        webView.setOnCustomScroolChangeListener(new MyWebView.ScrollInterface() {
            @Override
            public void onSChanged(int l, int t, int oldl, int oldt) {

                if (webView.getScrollY() > 30) {
                    lineLayTitle.getBackground().setAlpha(200);//0~255透明度值
                    if (lineLayTitle.getVisibility() == View.GONE)
                        lineLayTitle.setVisibility(View.VISIBLE);
                } else if (webView.getScrollY() == 0) {
                    if (lineLayTitle.getVisibility() == View.GONE)
                        lineLayTitle.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.txtScanning:
                break;
            case R.id.lineLaySearch:
                break;
            case R.id.txtMessage:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void isRefresh(boolean flag) {
        if (flag) {
            pullRefreshLayout.setDrawable(flag);
        }
    }
}
