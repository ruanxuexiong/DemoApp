package com.example.demo.app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.demo.app.R;
import com.example.demo.app.activity.SmallVideoActivity;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.NewsAdapter;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.event.HotEvent;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.example.demo.app.util.GridItemDecoration;
import com.example.demo.app.util.PreferenceUtil;
import com.google.gson.Gson;
import com.longer.service.response.BaseResult;
import com.longer.service.response.NewsResult;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.widget.MultipleStatusView;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseFragmentV4;
import com.zftlive.android.library.network.ToolNetwork;
import com.zftlive.android.library.tools.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends BaseFragmentV4 implements CallBackView {
    public static String CATEGORY = "hotsoon_video";
    private static HotFragment hotFragment;
    private MultipleStatusView multipleStatusView;
    private DataPresenter dataPresenter;
    private long lastTime;
    private int list_count = 0;
    private long loc_time;
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView mRecycleView;
    private MaterialHeader materialHeader;
    private NewsAdapter newsAdapter;
    private boolean isRefresh = false;
    private boolean loadingMore = false;

    private ArrayList<NewsModel> newsModelList = new ArrayList<>();

    public static HotFragment getInstance(String arg) {
        Bundle bundle = new Bundle();
        bundle.getString(IBaseConstant.PARAM1, arg);
        if (hotFragment == null)
            hotFragment = new HotFragment();
        hotFragment.setArguments(bundle);
        return hotFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_hot;
    }


    @Override
    public void initParams(Bundle params) {
        dataPresenter = new DataPresenter(getActivity().getApplication(), this);
        loc_time = System.currentTimeMillis() / 1000;
        EventBus.getDefault().register(HotFragment.this);
    }

    @Override
    public void initView(View view) {
        multipleStatusView = view.findViewById(R.id.multipleStatusView);
        smartRefreshLayout = view.findViewById(R.id.mRefreshLayout);
        materialHeader = (MaterialHeader) smartRefreshLayout.getRefreshHeader();
        mRecycleView = view.findViewById(R.id.mRecyclerView);

        smartRefreshLayout.setEnableHeaderTranslationContent(true);
        materialHeader.setShowBezierWave(true);
        smartRefreshLayout.setPrimaryColorsId(R.color.color_darker_gray);

        newsAdapter = new NewsAdapter(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        GridItemDecoration divider = new GridItemDecoration.Builder(getContext())
                .setHorizontalSpan(R.dimen.item_line)
                .setVerticalSpan(R.dimen.item_line)
                .setColorResource(R.color.anl_white)
                .setShowLastLine(true)
                .build();
        mRecycleView.addItemDecoration(divider);
        mRecycleView.setLayoutManager(gridLayoutManager);
        mRecycleView.setAdapter(newsAdapter);

        initListener();
    }

    public void initListener() {
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                smartRefreshLayout.finishRefresh();
                isRefresh = true;
                if (ToolNetwork.isNetworkConnected(getContext())) {
                    dataPresenter.getNewsList(getUrl());
                } else {
//                    mTipView.show();
//                    multipleStatusView.showNoNetwork();
                }
            }
        });

        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int childCount = mRecycleView.getChildCount();
                    int itemCount = mRecycleView.getLayoutManager().getItemCount();
                    int firstVisibleItem = ((LinearLayoutManager) mRecycleView.getLayoutManager()).
                            findFirstVisibleItemPosition();
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadingMore) {
                            loadingMore = true;
                            list_count++;
                            dataPresenter.getNewsList(getUrl());
                        }
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    public String getUrl() {
        lastTime = PreferenceUtil.getCategory(CATEGORY);
        if (lastTime == 0) {
            //如果为空，则是从来没有刷新过，使用当前时间戳
            lastTime = System.currentTimeMillis() / 1000;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://it-hl.snssdk.com/api/news/feed/v88/?list_count=")
                .append(list_count).append("&support_rn=4&category=")
                .append(CATEGORY).append("&refer=1&count=20&min_behot_time=")
                .append(lastTime).append("&list_entrance=main_tab&last_refresh_sub_entrance_interval=")
                .append(System.currentTimeMillis() / 1000).append("gps_mode=7&loc_mode=1&loc_time=")
                .append(loc_time).append("1566044999&latitude=22.511271&longitude=113.920823&city=%E6%B7%B1%E5%9C%B3%E5%B8%82&tt_from=pull&lac=2&cid=9827&plugin_enable=3&iid=82570047331&device_id=57583906166&ac=wifi&channel=huawei&aid=13&app_name=news_article&version_code=737&version_name=7.3.7&device_platform=android&ab_group=94569%2C102754&ab_feature=94569%2C102754&ssmix=a&device_type=CLT-AL01&device_brand=HUAWEI&language=zh&os_api=28&os_version=9&uuid=864831043580540&openudid=da51f7eeea556f66&manifest_version_code=737&resolution=720*1439&dpi=320&update_version_code=73709&_rticket=1566046692698&plugin=18766&tma_jssdk_version=1.29.0.1&rom_version=28");
        return stringBuffer.toString();
    }

    @Override
    public void loadDataOnce() {
        super.loadDataOnce();
        multipleStatusView.showLoading();
        if (ToolNetwork.isNetworkConnected(getContext())) {
            dataPresenter.getNewsList(getUrl());
        } else {
            multipleStatusView.showNoNetwork();
        }
    }

    public ArrayList<NewsModel> getNewsModelList(int position) {
        ArrayList<NewsModel> newsModels = new ArrayList<>();
        for (int i = position; i < newsModelList.size(); i++) {
            newsModels.add(newsModelList.get(i));
        }
        return newsModels;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setFragment(HotEvent hotEvent) {
        getOperation().addParameter(IBaseConstant.PARAM1, getNewsModelList(hotEvent.position));
        getOperation().forward(SmallVideoActivity.class, IBaseConstant.TOP_BOTTOM);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataPresenter.detachView();
        EventBus.getDefault().unregister(HotFragment.this);
    }

    @Override
    public void loginSuccess(BaseResult result, boolean isFirst) {

        if (isRefresh) {
            newsAdapter.clear();
//            mTipView.show(newsResult.getTips().getDisplay_info());
            isRefresh = false;
            lastTime = System.currentTimeMillis() / 1000;
            newsModelList.clear();
        }
        loadingMore = false;
        multipleStatusView.showContent();
        NewsResult newsResult = (NewsResult) result;

        List<NewsModel> newsModels = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < newsResult.getData().size(); i++) {
            NewsModel newsModel = gson.fromJson(newsResult.getData().get(i).getContent(), NewsModel.class);
            newsModel.category = CATEGORY;
            if (newsModel.raw_data.animated_image_list != null) {
                newsModels.add(newsModel);
                newsModelList.add(newsModel);
            }
        }
        newsAdapter.addItem(newsModels);
        newsAdapter.notifyDataSetChanged();

    }


    @Override
    public void loginFail() {
        multipleStatusView.showContent();
    }

    @Override
    public void loginException() {
        multipleStatusView.showContent();
    }
}
