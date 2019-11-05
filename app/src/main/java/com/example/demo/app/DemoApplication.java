package com.example.demo.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.bumptech.glide.Glide;
import com.example.demo.app.util.PreferenceUtil;
import com.longer.service.api.MainApi;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.smtt.sdk.QbSdk;
import com.zftlive.android.library.MApplication;
import com.zftlive.android.library.imageloader.ToolImage;
import com.zftlive.android.library.tools.LogUtil;

import org.litepal.LitePal;


/**
 * Created by longer on 2017/8/6.
 */

public class DemoApplication extends MApplication {

    private static MainApi mainApi;
    private static DemoApplication demoApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        // init logger.
        PreferenceUtil.getInstance(this);
        //初始化litePal
        LitePal.initialize(getApplicationContext());
        LogUtil.init(isApkInDebug(getApplicationContext()));
//        InitializeService.start(this);
        initX5QbSdk();
        ToolImage.init(getApplicationContext());
        Glide.get(getApplicationContext());
    }

    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
    private void initX5QbSdk() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
            }

            @Override
            public void onCoreInitFinished() {
            }
        });
        if (!QbSdk.isTbsCoreInited()) {
            // preinit只需要调用一次，如果已经完成了初始化，那么就直接构造view
            QbSdk.preInit(getApplicationContext(), null);
        }
    }

}
