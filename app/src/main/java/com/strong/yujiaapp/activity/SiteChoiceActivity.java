package com.strong.yujiaapp.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.strong.yujiaapp.R;
import com.strong.yujiaapp.base.BaseActivity;
import com.strong.yujiaapp.controls.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/22.
 */

public class SiteChoiceActivity extends BaseActivity {
    private LinearLayout ll_return;
    private TextView tv_title,tv_hot,tv_city,tv_site;
    private RecyclerView choice_recycler,choice_hot_recycler;
    private List<String> hot_mData,mData;
    private List<Map<String, String>> hot_mData2;
    private MyRecyclerAdapter hotmyrecycleradapter,mmyrecycleradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_choice);
        getSupportActionBar().hide();
        initData();
        initView();
        tv_title.setText("选择省市区");
        initEvent();


    }

    public void initView(){

        ll_return = (LinearLayout) findViewById(R.id.ll_return);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_hot = (TextView) findViewById(R.id.tv_hot);
        tv_site = (TextView) findViewById(R.id.tv_site);
        tv_city = (TextView) findViewById(R.id.tv_city);

        choice_hot_recycler = (RecyclerView) findViewById(R.id.choice_hot_recycler);
        choice_recycler = (RecyclerView) findViewById(R.id.choice_recycler);

        hotmyrecycleradapter = new MyRecyclerAdapter(this, hot_mData);
        mmyrecycleradapter = new MyRecyclerAdapter(this, mData);

        choice_hot_recycler.setAdapter(hotmyrecycleradapter);//设置适配器
        choice_recycler.setAdapter(mmyrecycleradapter);//设置适配器


        //设置布局管理器 , 将布局设置成纵向
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        /*mRecycleView.setLayoutManager(new LinearLayoutManager(this));*/
        choice_hot_recycler.setLayoutManager(new GridLayoutManager(this, 3));
        choice_recycler.setLayoutManager(new GridLayoutManager(this, 3));

        //设置分隔线
        //mRecycleView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL_LIST));

        //设置增加或删除条目动画
        choice_hot_recycler.setItemAnimator(new DefaultItemAnimator());


    }
    public void initData(){

        hot_mData = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            hot_mData.add("热门" + i);

        }

     /*   hot_mData2 = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("青岛", "山东");
        map.put("青岛", "山东");
        map.put("青岛", "山东");
        map.put("青岛", "山东");
        map.put("青岛", "山东");
        hot_mData2.add(map);*/



        mData = new ArrayList<String>();
        for (int i = 0; i < 35; i++) {
            mData.add("name" + i);

        }


    }
    public void initEvent(){

        ll_return.setOnClickListener(returnClickListener);

        hotmyrecycleradapter.setOnItemClieckLinster(new MyRecyclerAdapter.OnItemClieckLinster() {
            @Override
            public void onItemClickListener(View view, int pos) {

                tv_hot.setText(hot_mData.get(pos));
                tv_city.setVisibility(View.VISIBLE);
                tv_city.setText(hot_mData.get(pos));
                tv_site.setText("选择区县");


                choice_hot_recycler.setVisibility(View.GONE);

                Toast.makeText(SiteChoiceActivity.this, "热门 click" + pos , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(View view, int pos) {
                Toast.makeText(SiteChoiceActivity.this, "热门 long click" + pos , Toast.LENGTH_SHORT).show();
            }
        });

        mmyrecycleradapter.setOnItemClieckLinster(new MyRecyclerAdapter.OnItemClieckLinster() {
            @Override
            public void onItemClickListener(View view, int pos) {
                Toast.makeText(SiteChoiceActivity.this, "click" + pos , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(View view, int pos) {
                Toast.makeText(SiteChoiceActivity.this, "long click" + pos , Toast.LENGTH_SHORT).show();
            }
        });

    }



}
