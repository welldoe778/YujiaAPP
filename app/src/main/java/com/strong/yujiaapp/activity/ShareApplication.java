package com.strong.yujiaapp.activity;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.strong.yujiaapp.baidugps.LocationService;

/**
 * ȫ�ֱ���
 * 
 * @author Administrator
 * 
 */
public class ShareApplication extends Application {
	public LocationClient mLocationClient = null;

	public LocationService locationService;
	public Vibrator mVibrator;
	@Override
	public void onCreate() {
		super.onCreate();
	/*	mLocationClient = new LocationClient(getApplicationContext());
		BDAbstractLocationListener myListener = new MyLocationListener();
		//声明LocationClient类
		mLocationClient.registerLocationListener(myListener);*/
		//注册监听函数
		locationService = new LocationService(getApplicationContext());
		mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
		SDKInitializer.initialize(getApplicationContext());

	}

}
