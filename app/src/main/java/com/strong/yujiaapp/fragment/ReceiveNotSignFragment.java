package com.strong.yujiaapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strong.yujiaapp.R;

/**
 * Created by Administrator on 2017/8/23.
 */

public class ReceiveNotSignFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_send_notsign, container, false);
    }
}
