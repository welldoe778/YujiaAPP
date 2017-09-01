package com.strong.yujiaapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.strong.yujiaapp.R;

/**
 * Created by Administrator on 2017/8/23.
 */

public class MyFragment extends Fragment {

    public Activity mActivity;
    private LinearLayout ll_return;
    private TextView tv_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();//获取当前fragment依赖的activity
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        ll_return = view.findViewById(R.id.ll_return);
        tv_title = view.findViewById(R.id.tv_title);

        initData();

        return view;
    }


    public void initData(){

        tv_title.setText("我");
    }

}
