/*
 *     Android基础开发个人积累、沉淀、封装、整理共通
 *     Copyright (c) 2016. 曾繁添 <zftlive@163.com>
 *     Github：https://github.com/zengfantian || http://git.oschina.net/zftlive
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.zftlive.android.library.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;

import com.zftlive.android.library.base.BaseService;

/**
 * 网络状态监听Service<br>
 * 使用说明：
 * 1、添加权限 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> 
 * 2、注册Service <service android:enabled="true" android:name="NetworkStateService的实现类" />
 * 3、在合适的地方启动Service，可以在Application启动的时候启动，startService(Intent(mContext,NetworkStateService.class));
 * 
 * @author
 * @version 1.0
 * 
 */
public abstract class NetworkStateService extends BaseService {

	@Override
	public void onCreate() {
		super.onCreate();
		// 订阅网络状态变化广播
		IntentFilter mFilter = new IntentFilter();
		mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(mReceiver, mFilter);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//保证Service不杀死 http://blog.csdn.net/primer_programer/article/details/25987439
		flags = START_STICKY;
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// 取消广播订阅
		unregisterReceiver(mReceiver);
	}

	/**
	 * 网络状态变化广播接收器
	 */
	private BroadcastReceiver mReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent
					.getAction())) {
				ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo info = connectivityManager.getActiveNetworkInfo();
				if (info != null && info.isAvailable()) {
					onNetworkChange(info.getTypeName());
				} else {
					onNoNetwork();
				}
			}
		}
	};
	
	/**
	 * 没有网络回调
	 */
	public abstract void onNoNetwork();

	/**
	 * 网络发生变化回调函数
	 * 
	 * @param networkType 当前网络类型
	 */
	public abstract void onNetworkChange(String networkType);
}
