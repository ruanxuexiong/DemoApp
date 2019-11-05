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

package com.example.demo.app.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

import com.example.demo.app.R;
import com.zftlive.android.library.Logger;
import com.zftlive.android.library.base.ui.CommonActivity;

import java.util.Calendar;

/**
 * 程序启动界面
 *
 * @author
 * @version 1.0
 */
public class LauncherActivity extends CommonActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_launcher;
    }

    @Override
    public void initParams(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        TextView mTitleTv = view.findViewById(R.id.tv_name);
        Typeface textTypeface = Typeface.createFromAsset(getAssets(), "fonts/Lobster-1.4.otf");
        mTitleTv.setTypeface(textTypeface);
        mTitleTv.setText("Sharing is a joy !");

        TextView mCopyrightTv = view.findViewById(R.id.tvCopyright);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String str = "Copyright © 2016--" + year ;
        mCopyrightTv.setText(str);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF");
        mCopyrightTv.setTypeface(typeface);

        TextView mCodeTv = view.findViewById(R.id.tv_code);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/FZLanTingHeiS-L-GB-Regular.TTF");
        mCodeTv.setText("V "+packageCode(getContext()));
        mCodeTv.setTypeface(typeface1);
        //隐藏标题栏
        mWindowTitle.hiddeTitleBar();

        //设置tag
//		BuglyReport.setUserSceneTag(getContext(),17473);
        try {
            String strText = null;

            int i = strText.length();

        } catch (Exception e) {
//			BuglyReport.postCatchedException(e);
        }

        //添加动画效果
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);
        animation.setDuration(4000);
        animation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //跳转界面
                getOperation().forward(MainActivity.class);
                finish();
                //右往左推出效果
//				overridePendingTransition(R.anim.anl_push_left_in,R.anim.anl_push_left_out);
                //转动淡出效果1
//				overridePendingTransition(R.anim.anl_scale_rotate_in,R.anim.anl_alpha_out);
                //下往上推出效果
                overridePendingTransition(R.anim.anl_push_bottom_in, R.anim.anl_push_up_out);
            }
        });
        view.setAnimation(animation);
    }
    public static String packageCode(Context context) {
        PackageManager manager = context.getPackageManager();
        String versionName = null;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

}