package com.yunifang.ynf.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunifang.ynf.activity.R;


public abstract class BaseFragment extends Fragment implements OnClickListener {
	protected Context context;
	protected TextView title_TextView;
	protected TextView title;
	protected ImageView back;
	protected TextView ensure;
	protected FrameLayout right;

	@Override
	public abstract View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState);

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context=getActivity();
		initView();// 加载view
		initTitle();// 加载title
		initData();// 加载数据 data
	}

	protected void initData() {

	}

	protected void initTitle() {
		title=(TextView)getView().findViewById(R.id.title);
		back = (ImageView)getView().findViewById(R.id.back);
		back.setVisibility(View.INVISIBLE);
		ensure = (TextView)getView().findViewById(R.id.ensure);
		right = (FrameLayout) getView().findViewById(R.id.right);
	}

	protected abstract void initView();

	@Override
	public void onClick(View v) {

	}
}
