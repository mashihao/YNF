package com.yunifang.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MSH on 2016/11/14.
 */

public class PullActivity extends Base {

    @BindView(R.id.list)
    ListView list;
    String[] str = {"item", "item", "item", "item", "item", "item", "item", "item", "item",
            "item", "item", "item", "item",
            "item", "item", "item", "item", "item", "item",
            "item", "item", "item", "item", "item", "item",
            "item", "item", "item", "item", "item", "item", "item", "item", "item", "item", "item", "item",
            "item", "item", "item", "item", "item", "item",

            "item", "item", "item", "item",
            "item", "item"
    };
    @BindView(R.id.pull)
    PullRefreshLayout pull;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PullActivity.this, android.R.layout.simple_list_item_1, str);
        list.setAdapter(adapter);

        pull.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(PullActivity.this, "刷新", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMove(boolean ismove) {

            }
        });

        pull.setRefreshStyle(PullRefreshLayout.STYLE_Bitmap);
    }


    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }
}
