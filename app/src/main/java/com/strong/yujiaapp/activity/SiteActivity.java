package com.strong.yujiaapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.strong.yujiaapp.R;
import com.strong.yujiaapp.base.BaseActivity;

/**
 * Created by Administrator on 2017/8/22.
 */

public class SiteActivity extends BaseActivity {
    private LinearLayout ll_return;
    private TextView tv_title;
    private EditText et_choice_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        getSupportActionBar().hide();
        initView();
        initData();
        initEvent();
    }

    public void initView(){

        ll_return = (LinearLayout) findViewById(R.id.ll_return);
        tv_title = (TextView) findViewById(R.id.tv_title);
        et_choice_city = (EditText) findViewById(R.id.et_choice_city);

    }
    public void initData(){

        tv_title.setText("网点查询");
    }
    public void initEvent(){

        ll_return.setOnClickListener(returnClickListener);
        et_choice_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SiteActivity.this, CityChoiceActivity.class);
                startActivity(intent);
            }
        });
    }

}
