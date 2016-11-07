package com.yunifang.uilibrary.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunifang.uilibrary.R;

/**
 * Created by MSH on 2016/11/7.
 */

public class ImageFragment extends Fragment {

    private static String ARG_IMAGE = "image";
    private int flag = 0;
    private static Context mContext;
    private static IntentBack intentBack;
    public static int[] image = {R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3, R.mipmap.guide4, R.mipmap.guide5};

    public static ImageFragment newInstance(int param, Context context) {
        mContext = context;
        intentBack = (IntentBack) mContext;
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, param);
        fragment.setArguments(args);
        return fragment;
    }


    //TODO  onCreate执行在onCreateView()之前提前uhoqu出来flag并赋值
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null)
        {
            flag = getArguments().getInt(ARG_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //TODO 获取到布局文件中的一个View
        View view = inflater.inflate(R.layout.color_fragment,container,false);
        view.setBackgroundResource(image[flag]);
        TextView tv = (TextView) view.findViewById(R.id.start_inport);
        //TODO 判断是否是最后一页,如果是最后一页的话,就显示出来 立即体验 并跳转到主页面上去
        if (flag == 4)
        {
            tv.setVisibility(View.VISIBLE);
        }
        else
        {
            tv.setVisibility(View.GONE);
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 根据主页面的  回调函数,来看 需要跳转到哪个界面
                intentBack.getIntentCallBack();
            }
        });

        return view;
    }

    //TODO intent回调函数
    public interface IntentBack {
        void getIntentCallBack();
    }
}
