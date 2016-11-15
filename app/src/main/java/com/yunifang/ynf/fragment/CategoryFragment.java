package com.yunifang.ynf.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunifang.uilibrary.views.KeywordsFlow;
import com.yunifang.ynf.activity.R;
import com.yunifang.ynf.utils.IToast;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MSH on 2016/11/7.
 */

public class CategoryFragment extends Fragment implements View.OnClickListener {


    View category;
    @Bind(R.id.keywordsflow_Layout)
    KeywordsFlow keywordsflow;

    private boolean IN_OUT = false;
    public static final String[] keywords = {"贴片面膜", "男士护肤", "凑单专区", "水乳霜", "泥浆面膜", "面膜", "洁面乳", "黑面膜"
            , "睡眠面膜", "眼膜", "其他护理", "精华", "自然面膜"};
    public static final String[] keywords2 = {"火锅", "小吃", "咖啡", "电影院", "KTV",
            "茶馆", "足浴", "按摩", "超市", "银行", "酒店", "超市", "豫菜", "川菜", "蛋糕店", "医院",
            "面包店", "商场", "书店", "烧烤", "海鲜", "清真"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (null != category) {
            ViewGroup parent = (ViewGroup) category.getParent();
            if (null != parent) {
                parent.removeView(category);
            }
        } else {
            category = inflater.inflate(R.layout.fragment_category, container, false);
        }

        ButterKnife.bind(this, category);
        keywordsflow.setDuration(800l);
        keywordsflow.setOnClickListener(this);
        return category;
    }

    @Override
    public void onStart() {
        super.onStart();
        go2showIn();

    }

    // 填充关键词
    private void feedKeywordsFlow(KeywordsFlow keywordsFlow, String[] arr) {
        Random random = new Random();
        for (int i = 0; i < KeywordsFlow.MAX; i++) {
            int ran = random.nextInt(arr.length);
            String tmp = arr[ran];
            keywordsFlow.feedKeyword(tmp);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id._fab_category_refresh)
    public void onClick(View view) {
        if (view.getId() == R.id._fab_category_refresh) {
            if (IN_OUT) {
                go2showOut();
                IN_OUT = false;
            } else {
                go2showIn();
                IN_OUT = true;
            }
            return;
        }

        if (view instanceof TextView) {
            String keyword = ((TextView) view).getText().toString();
            IToast.showToast(getActivity(), keyword);
            return;
        }


    }


    //飞入

    private void go2showIn() {
        keywordsflow.rubKeywords();
        feedKeywordsFlow(keywordsflow, keywords);
        keywordsflow.go2Show(KeywordsFlow.ANIMATION_IN);
    }

    //飞出
    private void go2showOut() {
        keywordsflow.rubKeywords();
        feedKeywordsFlow(keywordsflow, keywords2);
        keywordsflow.go2Show(KeywordsFlow.ANIMATION_OUT);
    }

    @Override
    public void onPause() {
        super.onPause();
        go2showOut();
    }
}
