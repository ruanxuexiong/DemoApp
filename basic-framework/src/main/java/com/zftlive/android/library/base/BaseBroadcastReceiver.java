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
 */

package com.zftlive.android.library.base;

import android.content.BroadcastReceiver;

/**
 *  android 系统中的四大组件之一BroadcastReceiver基类<生命周期只有十秒左右，耗时操作需开service来做><br>
 * @authorr
 * @version 1.0
 *
 */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver implements IBaseConstant {

	/**日志输出标志**/
	protected final String TAG = this.getClass().getSimpleName();
}
