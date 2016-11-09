package com.yunifang.ynf.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunifang.ynf.activity.R;

/**
 * Created by MSH on 2016/11/7.
 */

public class CategoryFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View category = inflater.inflate(R.layout.fragment_category,container,false);

        return category;
    }
}
