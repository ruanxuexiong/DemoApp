package com.example.demo.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.demo.app.R;
import com.example.demo.app.event.DiscoveryEvent;
import com.example.demo.app.event.HotEvent;
import com.example.demo.app.event.MainEvent;
import com.example.demo.app.fragment.DiscoveryFragment;
import com.example.demo.app.fragment.HomeFragment;
import com.example.demo.app.fragment.HotFragment;
import com.example.demo.app.fragment.MineFragment;
import com.example.demo.app.fragment.NotLoggedFragment;
import com.example.demo.app.fragment.VideoFragment;
import com.example.demo.app.util.PreferenceUtil;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.xing.dialog.AdDialog;
import com.xing.utils.FragmentChangeManager;
import com.xing.view.tablayout.CommonTabLayout;
import com.xing.view.tablayout.listener.CustomTabEntity;
import com.xing.view.tablayout.listener.OnTabSelectListener;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.base.ui.IBaseActivity;
import com.zftlive.android.library.tools.ToolToast;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {
    private CommonTabLayout commonTabLayout;
    private ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();
    private String[] titles = new String[]{"每日精选", "新闻", "小视频", "我的"};
    private int[] select_icon = new int[]{R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected};
    private int[] no_select_icon = new int[]{R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal};
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentChangeManager fragmentChangeManager;
    private boolean isQuit = false;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        commonTabLayout = view.findViewById(R.id.tab_layout);
    }

    @Override
    public void doBusiness(Context mContext) {
        setStatusBarBackground(getColor(R.color.anl_gray));
        if (!EventBus.getDefault().isRegistered(MainActivity.this))
            EventBus.getDefault().register(MainActivity.this);
        setCanScreenshot(false);
        fragments.add(HomeFragment.getInstance(titles[0]));
//        fragments.add(NotLoggedFragment.getInstance());
        fragments.add(DiscoveryFragment.getInstance(titles[1]));
        fragments.add(HotFragment.getInstance(titles[2]));
        fragments.add(MineFragment.getInstance(titles[3]));
        for (int i = 0; i < titles.length; i++) {
            final int finalI = i;
            CustomTabEntity customTabEntity = new CustomTabEntity() {
                @Override
                public String getTabTitle() {
                    return titles[finalI];
                }

                @Override
                public int getTabSelectedIcon() {
                    return select_icon[finalI];
                }

                @Override
                public int getTabUnselectedIcon() {
                    return no_select_icon[finalI];
                }
            };
            customTabEntities.add(customTabEntity);
        }
        commonTabLayout.setTabData(customTabEntities);
//        getWindowTitle().initCenterTitle(titles[0]);
        getWindowTitle().setVisibility(View.GONE);
        getWindowTitle().setBackgroundColor(getColor(R.color.anl_gray));
        fragmentChangeManager = new FragmentChangeManager(getSupportFragmentManager(), R.id.fl_container, fragments);
        showDialog();
    }

    public void showDialog() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.ad_dialog_contentview, null);
        AdDialog diaLog = new AdDialog(getContext(), view, AdDialog.ViewType.IMG);
        diaLog //设置外边距
                .setContentView_Margin_Top(0)
                .setContentView_Margin_Bottom(0)
                .setContentView_Margin_Left(0)
                .setContentView_Margin_Right(0)
                .setOverScreen(true) //设置是否全屏,覆盖状态栏
                .setCloseButtonImg(R.drawable.ad_dialog_closebutton) //设置关闭按钮图片
                .setCloseButtonListener(new View.OnClickListener() { //设置关闭按钮监听事件
                    @Override
                    public void onClick(View view) {
                    }
                })
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        EventBus.getDefault().unregister(MainActivity.this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setFragment(MainEvent mainEvent) {
        if (PreferenceUtil.getLoginSuccess()) {
            fragmentChangeManager.setFragments(3);
        } else {
            getOperation().forward(LoginActivity.class, IBaseActivity.LEFT_RIGHT);
//            fragmentChangeManager.setFragments(4);
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void setFragment(HotEvent hotEvent) {
//        if ("SmallVideoTemplet".equals(hotEvent.className)) {
//            mBottomRel.setVisibility(View.GONE);
//        } else {
//            mBottomRel.setVisibility(View.VISIBLE);
//        }
//    }

    @Override
    public void initListener() {
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                fragmentChangeManager.setFragments(position);
                if (position == 1) {
                    getWindowTitle().setVisibility(View.VISIBLE);
                    getWindowTitle().initCenterTitle("头条新闻");
                    EventBus.getDefault().post(new DiscoveryEvent());
                } else {
                    GSYVideoPlayer.releaseAllVideos();
                    getWindowTitle().setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isQuit) {
                isQuit = true;
                ToolToast.showLong("再按一次退出");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isQuit = false;
                    }
                }, 2000);
            } else {
                System.exit(0);
            }
        }
        return true;
    }
}
