package com.strong.yujiaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        getSupportActionBar().hide();

        initView();
    }
    public void initView(){

    }
}
