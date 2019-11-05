package com.example.demo.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.demo.app.R;
import com.xing.view.tablayout.SlidingTabLayout;

import com.zftlive.android.library.base.ui.BaseFragmentV4;

import java.util.ArrayList;

public class VideoFragment extends BaseFragmentV4 {
    private static VideoFragment videoFragment;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager mViewPage;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private String[] titles = new String[]{"热门", "附近"};

    public static VideoFragment getInstance(String str) {
        if (videoFragment == null)
            videoFragment = new VideoFragment();
        return videoFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        fragmentList.add(HotFragment.getInstance("热门"));
        fragmentList.add(NearlyFragment.getInstance());

        slidingTabLayout = view.findViewById(R.id.tab_layout);
        mViewPage = view.findViewById(R.id.pager);
        slidingTabLayout.setViewPager(mViewPage, titles, getActivity(), fragmentList);
    }
}
