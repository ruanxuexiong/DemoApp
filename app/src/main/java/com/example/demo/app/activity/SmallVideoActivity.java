package com.example.demo.app.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.example.demo.app.R;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.SmallVideoAdapter;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.example.demo.app.util.PreferenceUtil;
import com.google.gson.Gson;
import com.longer.service.response.BaseResult;
import com.longer.service.response.NewsResult;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.xing.playeractivity.ScrollCalculatorHelper;
import com.xing.utils.PixelUtil;
import com.xing.widget.UpDownHideLayout;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.CommonActivity;
import com.zftlive.android.library.network.ToolNetwork;
import com.zftlive.android.library.tools.ToolToast;
import java.util.ArrayList;
import java.util.List;
import static android.animation.ObjectAnimator.ofFloat;

public class SmallVideoActivity extends CommonActivity implements CallBackView, UpDownHideLayout.OnLayoutCloseListener {
    public static String CATEGORY = "hotsoon_video";
    private RecyclerView mRecycleView;
    private List<NewsModel> newsModels = new ArrayList<>();
    private boolean isLoadMore = false;
    private DataPresenter dataPresenter;
    private long lastTime;
    private int list_count = 0;
    private long loc_time;
    private SmallVideoAdapter smallVideoAdapter;
    private ScrollCalculatorHelper scrollCalculatorHelper;
    private UpDownHideLayout upDownHideLayout;
    private View mRoot;

    @Override
    public int bindLayout() {
        return R.layout.activity_small_video;
    }

    @Override
    public void initParams(Bundle parms) {
        super.initParams(parms);
        newsModels = (ArrayList<NewsModel>) getOperation().getParameter(IBaseConstant.PARAM1);
    }

    @Override
    public void doBusiness(Context mContext) {
        super.doBusiness(mContext);
        getWindowTitle().hiddeTitleBar();
        loc_time = System.currentTimeMillis() / 1000;
        dataPresenter = new DataPresenter(getApplication(), this);
        if (ToolNetwork.isNetworkConnected(getContext())) {
            dataPresenter.getNewsList(getUrl());
        } else {
            ToolToast.showLong("网络异常");
        }
    }

    @Override
    public void initView(View view) {
        mRoot = view.findViewById(R.id.blackView);
        upDownHideLayout = view.findViewById(R.id.swipableLayout);
        mRecycleView = view.findViewById(R.id.recyclerView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        ((LinearLayoutManager) mRecycleView.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        smallVideoAdapter = new SmallVideoAdapter(this);
        smallVideoAdapter.addItem(newsModels);
        mRecycleView.setAdapter(smallVideoAdapter);

        //获取屏幕宽高
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //自定播放帮助类 限定范围为屏幕一半的上下偏移180   括号里不用在意 因为是一个item一个屏幕
        scrollCalculatorHelper = new ScrollCalculatorHelper(R.id.video_item_player, dm.heightPixels / 2 - PixelUtil.dp2px(180, this), dm.heightPixels / 2 + PixelUtil.dp2px(180, this));

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper() {
            @Nullable
            @Override
            public View findSnapView(RecyclerView.LayoutManager layoutManager) {
                scrollCalculatorHelper.onScrollStateChanged(mRecycleView, mRecycleView.getScrollState());
                return super.findSnapView(layoutManager);
            }

            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                return super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
            }
        };
        pagerSnapHelper.attachToRecyclerView(mRecycleView);


    }

    @Override
    public void initListener() {
        super.initListener();
        upDownHideLayout.setOnLayoutCloseListener(this);
        upDownHideLayout.setScrollListener(new UpDownHideLayout.ScrollListener() {
            @Override
            public void onScrolling(float percent, float px) {
                float diffY = PixelUtil.px2dp(px, SmallVideoActivity.this);
                float textHidePercent = (diffY / 50) > 0.99 ? 1 : (diffY / 50);
                //大于50dp则不显示

                mRoot.setAlpha(1 - percent);
                if (percent == 1) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                    finish();
                }
            }
        });
        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                scrollCalculatorHelper.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int childCount = recyclerView.getChildCount();
                    int itemCount = recyclerView.getLayoutManager().getItemCount();
                    int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    if (firstVisibleItemPosition + childCount == itemCount) {
                        if (!isLoadMore) {
                            isLoadMore = true;
                            list_count++;
                            dataPresenter.getNewsList(getUrl());
                        }
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                int lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                //一屏幕显示一个item 所以固定1
                // 实时获取设置 当前显示的GSYBaseVideoPlayer的下标
                scrollCalculatorHelper.onScroll(recyclerView, firstVisibleItem, lastVisibleItem, 1);

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
    public void loginSuccess(BaseResult result, boolean isFirst) {
        isLoadMore = false;
        NewsResult newsResult = (NewsResult) result;
        List<NewsModel> newsModels = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < newsResult.getData().size(); i++) {
            NewsModel newsModel = gson.fromJson(newsResult.getData().get(i).getContent(), NewsModel.class);
            newsModel.category = CATEGORY;
            if (newsModel.raw_data.animated_image_list != null) {
                newsModels.add(newsModel);
            }
        }
        if (smallVideoAdapter.addItem(newsModels))
            smallVideoAdapter.notifyDataSetChanged();
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void loginException() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoPlayer.releaseAllVideos();
    }

    private boolean isScrollToHide = false;//防止重复点击造成退出动画重叠

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        dataPresenter.detachView();
    }

    @Override
    public void OnLayoutClosed() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (!isScrollToHide) {
            scrollToHide();
        }
//		super.onBackPressed();
    }

    //仿今日头条，点击返回键界面由上向下退出（需要设置打开和关闭时都没有动画，并且theme背景透明）
    private void scrollToHide() {
        isScrollToHide = true;
//		View view = getWindow().getDecorView();//.findViewById(android.R.id.content)
        View view = mContentView;
        final int RootViewHeight = view.getMeasuredHeight(); //防止虚拟导航栏
        ObjectAnimator positionAnimator = null;
        positionAnimator = ofFloat(view, "y", view.getY(), RootViewHeight);
        positionAnimator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float diffY = Math.abs((float) animation.getAnimatedValue());
                float percent = (diffY / (float) RootViewHeight) > 0.99 ? 1 : (diffY / (float) RootViewHeight);
                if (percent == 1) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                    finish();
                }
            }
        });
        positionAnimator.setDuration(300);
        positionAnimator.start();
    }
}
