package com.example.demo.app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.example.demo.app.R;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.NewsAdapter;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.bean.NewsRecordModel;
import com.example.demo.app.dbhelper.NewsRecordHelper;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.example.demo.app.util.PreferenceUtil;
import com.google.gson.Gson;
import com.longer.service.response.BaseResult;
import com.longer.service.response.NewsResult;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.xing.widget.MultipleStatusView;
import com.xing.widget.TipView;
import com.zftlive.android.library.Logger;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseFragmentV4;
import com.zftlive.android.library.network.ToolNetwork;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragmentV4 implements CallBackView {

    private long loc_time;
    private DataPresenter dataPresenter;
    private String category;
    private MultipleStatusView multipleStatusView;
    private RecyclerView mRecycleView;
    private NewsAdapter newsAdapter;
    private SmartRefreshLayout smartRefreshLayout;
    private MaterialHeader materialHeader;
    private TipView mTipView;
    private LinearLayout mContentLl;
    private boolean loadingMore = false;
    private boolean isRefresh = false;
    private long lastTime;
    private int list_count;
    private List<NewsModel> newsRecordModels;

    public static NewsFragment getInstance(String name, String category) {
        NewsFragment newsFragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IBaseConstant.PARAM1, name);
        bundle.putString(IBaseConstant.PARAM2, category);
        newsFragment.setArguments(bundle);
        return newsFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void initParams(Bundle params) {
        category = params.getString(IBaseConstant.PARAM2);
    }

    @Override
    public void initView(View view) {
        mContentLl = view.findViewById(R.id.ll_content);
        mTipView = view.findViewById(R.id.tip_view);
        smartRefreshLayout = view.findViewById(R.id.mRefreshLayout);
        materialHeader = (MaterialHeader) smartRefreshLayout.getRefreshHeader();

        multipleStatusView = view.findViewById(R.id.multipleStatusView);
        mRecycleView = view.findViewById(R.id.mRecyclerView);
        newsAdapter = new NewsAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecycleView.setLayoutManager(linearLayoutManager);
        NewsRecordModel newsRecordModel = NewsRecordHelper.getLastNewsRecord(category);
        if (newsRecordModel != null) {
            newsRecordModels = NewsRecordHelper.convertToNewsList(newsRecordModel.getJson());
            newsAdapter.addItem(newsRecordModels);
            isRefresh = true;
        } else {
            multipleStatusView.showLoading();
        }
        mRecycleView.setAdapter(newsAdapter);
        dataPresenter = new DataPresenter(mActivity.getApplication(), this);

        lastTime = System.currentTimeMillis() / 1000;
        if (newsRecordModel == null || Math.abs(newsRecordModel.getTime() - System.currentTimeMillis()) >= 10 * 60 * 1000) {
            if (ToolNetwork.isNetworkConnected(getContext())) {
                list_count = 0;
                isRefresh = true;
                dataPresenter.getNewsList(getUrl());
            } else {
                mTipView.show();
            }
        }
        setListener();
    }

    public String getUrl() {
//        lastTime = PreferenceUtil.getCategory(category);
//        if (lastTime == 0) {
//            //如果为空，则是从来没有刷新过，使用当前时间戳
//            lastTime = System.currentTimeMillis() / 1000;
//        }
        loc_time = System.currentTimeMillis() / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://it-hl.snssdk.com/api/news/feed/v88/?list_count=")
                .append(list_count).append("&support_rn=4&category=")
                .append(category).append("&refer=1&count=20&min_behot_time=")
                .append(lastTime).append("&list_entrance=main_tab&last_refresh_sub_entrance_interval=")
                .append(System.currentTimeMillis() / 1000).append("gps_mode=7&loc_mode=1&loc_time=")
                .append(loc_time)
                .append("&latitude=22.511271&longitude=113.920823&city=%E6%B7%B1%E5%9C%B3%E5%B8%82&tt_from=pull&lac=2&cid=9827")
                .append("&plugin_enable=3&iid=82570047331&device_id=57583906166&ac=wifi&channel=huawei&aid=13&app_name=news_article")
                .append("&version_code=737&version_name=7.3.7&device_platform=android&ab_group=94569%2C102754&ab_feature=94569%2C102754")
//                .append("&ssmix=a&device_type=CLT-AL01&device_brand=HUAWEI&language=zh&os_api=28&os_version=9&uuid=864831043580540");
                .append("&openudid=da51f7eeea556f66&manifest_version_code=737&resolution=720*1439&dpi=320&update_version_code=73709")
                .append("&plugin=18766&tma_jssdk_version=1.29.0.1&rom_version=28");
        return stringBuffer.toString();
    }

    public void setListener() {
        mTipView.setAnimation(new TipView.OnAnimation() {
            @Override
            public void onAnimationStart() {
                hide();
            }
        });
        smartRefreshLayout.setEnableHeaderTranslationContent(true);
        materialHeader.setShowBezierWave(true);
        smartRefreshLayout.setPrimaryColorsId(R.color.color_darker_gray);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                smartRefreshLayout.finishRefresh();
                isRefresh = true;
                if (ToolNetwork.isNetworkConnected(getContext())) {
                    list_count = 0;
                    dataPresenter.getNewsList(getUrl());
                } else {
                    mTipView.show();
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
                            isRefresh = false;
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
        //移除屏幕监听
        mRecycleView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                Logger.d(TAG, "onViewRecycled-->" + holder.getClass().getName());
            }
        });
    }

    /**
     * 隐藏，收起
     */
    private void hide() {
        final TranslateAnimation hideAnim = new TranslateAnimation(0, 0, 0, -mTipView.getHeight());
        hideAnim.setDuration(200);
        hideAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mTipView.reset();
                //防止动画结束后，界面抖动
                TranslateAnimation anim = new TranslateAnimation(0, 0, 0, 0);
                mContentLl.setAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mContentLl.startAnimation(hideAnim);
    }


    @Override
    public void loginSuccess(BaseResult result, boolean isFirst) {
        multipleStatusView.showContent();
        NewsResult newsResult = (NewsResult) result;
        if (isRefresh) {
            newsAdapter.clear();
            mTipView.show(newsResult.getTips().getDisplay_info());
            isRefresh = false;
            lastTime = System.currentTimeMillis() / 1000;
        }
        loadingMore = false;
        List<NewsModel> newsModels = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < newsResult.getData().size(); i++) {
            NewsModel newsModel = gson.fromJson(newsResult.getData().get(i).getContent(), NewsModel.class);
            newsModel.category = category;
            if (!TextUtils.isEmpty(newsModel.title)) {
                if (list_count == 0)
                    newsModels.add(newsModel);
                else {
                    if (!isHaveNews(newsModel.title))
                        newsModels.add(newsModel);
                }
            }
//            Logger.e("TAG","data=="+newsModel.toString());
        }
        newsAdapter.addItem(newsModels);
        newsAdapter.notifyDataSetChanged();
        if (list_count == 0)
            NewsRecordHelper.save(category, gson.toJson(newsModels));
    }

    public boolean isHaveNews(String title) {
        if (newsRecordModels != null && title != null) {
            for (NewsModel newsModel : newsRecordModels) {
                if (title.equals(newsModel.title))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void loginFail() {
        multipleStatusView.showContent();
    }

    @Override
    public void loginException() {
        multipleStatusView.showContent();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }
}
