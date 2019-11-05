package com.example.demo.app.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.demo.app.R;
import com.example.demo.app.bean.ChannelModel;
import com.example.demo.app.event.DiscoveryEvent;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.xing.widget.ColorTrackTabLayout;
import com.xing.widget.MultipleStatusView;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseFragmentV4;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class DiscoveryFragment extends BaseFragmentV4 {

    private static DiscoveryFragment discoveryFragment;
    private String title;
    private ColorTrackTabLayout trackTabLayout;
    private ViewPager viewPager;
    private NewsPagerAdapter newsPagerAdapter;
    private List<ChannelModel> mSelectedChannels = new ArrayList<>();
    private MultipleStatusView multipleStatusView;

    public static DiscoveryFragment getInstance(String arg) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(IBaseConstant.PARAM1, arg);
        if (discoveryFragment == null)
            discoveryFragment = new DiscoveryFragment();
        discoveryFragment.setArguments(bundle);
        return discoveryFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_discovery;
    }


    @Override
    public void initParams(Bundle params) {
        title = (String) params.get(IBaseConstant.PARAM1);
        if (!EventBus.getDefault().isRegistered(DiscoveryFragment.this))
            EventBus.getDefault().register(DiscoveryFragment.this);
    }

    @Override
    public void initView(View view) {
        initChannelData();
        multipleStatusView = view.findViewById(R.id.multipleStatusView);
        trackTabLayout = view.findViewById(R.id.tab_channel);
        viewPager = view.findViewById(R.id.viewPager);
        newsPagerAdapter = new NewsPagerAdapter(getFragmentManager(), mSelectedChannels);
        viewPager.setAdapter(newsPagerAdapter);
        trackTabLayout.setupWithViewPager(viewPager, true);
        multipleStatusView.showLoading();
    }

    @Override
    public void loadDataOnce() {
        super.loadDataOnce();
//        dataPresenter = new DataPresenter(getActivity().getApplication(), this);
//        dataPresenter.getCategory("https://is.snssdk.com/article/category/get_subscribed/v4/?iid=80131595906&device_id=47041978557&ac=wifi&channel=lite_huawei&aid=35&app_name=news_article_lite&version_code=705&version_name=7.0.5&device_platform=android&ab_version=377588%2C643996%2C661930%2C785656%2C668907%2C808414%2C772541%2C1016024%2C846821%2C861707%2C861726%2C668904%2C1023120%2C668906%2C668903%2C679107%2C944309%2C668905%2C933995%2C996338%2C908123%2C928942%2C1000584&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7&ab_group=z1&ab_feature=z1&abflag=3&ssmix=a&device_type=EVA-AL00&device_brand=HUAWEI&language=zh&os_api=26&os_version=8.0.0&uuid=869158024615698&openudid=e00d96fc02a7b63c&manifest_version_code=705&resolution=1080*1792&dpi=480&update_version_code=70502&_rticket=1564323317075&sa_enable=0&plugin_state=7563839&rom_version=emotionui_8.0.0_eva-al00+8.0.0.540%28c00%29");
    }


    /**
     * 初始化已选频道和未选频道的数据
     */
    private void initChannelData() {
        String[] channels = getResources().getStringArray(R.array.channel);
        String[] channelCodes = getResources().getStringArray(R.array.channel_code);
        //添加全部频道
        for (int i = 0; i < channelCodes.length; i++) {
            String title = channels[i];
            String code = channelCodes[i];
            mSelectedChannels.add(new ChannelModel(title, code));
        }
    }

    public class NewsPagerAdapter extends FragmentStatePagerAdapter {
        private List<ChannelModel> mSelectedChannels;
        private NewsFragment[] newsFragments;

        public NewsPagerAdapter(FragmentManager fm, List<ChannelModel> mSelectedChannels) {
            super(fm);
            newsFragments = new NewsFragment[mSelectedChannels.size()];
            this.mSelectedChannels = mSelectedChannels;
        }


        public NewsFragment getFragment(int position) {
            if (newsFragments[position] == null) {
                NewsFragment fragment = NewsFragment.getInstance(mSelectedChannels.get(position).title, mSelectedChannels.get(position).channelCode);
                newsFragments[position] = fragment;
            }
            return newsFragments[position];
        }

        @Override
        public Fragment getItem(int position) {

            return getFragment(position);
        }

        @Override
        public int getCount() {
            return mSelectedChannels == null ? 0 : mSelectedChannels.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mSelectedChannels.get(position).title;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void disLoadding(DiscoveryEvent discoveryEvent) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                multipleStatusView.showContent();
            }
        }, 2000);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(DiscoveryFragment.this);
    }
}
