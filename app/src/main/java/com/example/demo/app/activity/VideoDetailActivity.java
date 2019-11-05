package com.example.demo.app.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageView;


import com.example.demo.app.R;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.activity.view.VideoDetailContract;

import com.example.demo.app.activity.view.VideoListener;
import com.example.demo.app.adapter.VideoDetailAdapter;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.longer.service.response.BaseResult;
import com.longer.service.response.HomeResult;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.ToolImage;
import com.zftlive.android.library.tools.ToolToast;

/**
 * 视频详情
 */
public class VideoDetailActivity extends BaseActivity implements VideoDetailContract, CallBackView {
    private SmartRefreshLayout smartRefreshLayout;
    private StandardGSYVideoPlayer standardGSYVideoPlayer;
    private HomeResult.IssueListBean.ItemListBean data;
    private OrientationUtils orientationUtils;
    private boolean isPlay = false;
    private boolean isPause = false;
    private boolean isTransition = false;
    private DataPresenter dataPresenter;
    private ImageView mImageView;
    private RecyclerView mRecyclerView;
    private VideoDetailAdapter videoDetailAdapter;


    @Override
    public int bindLayout() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void initParams(Bundle params) {
        data = (HomeResult.IssueListBean.ItemListBean) getOperation().getGloableAttribute(IBaseConstant.STRING);
        getWindowTitle().setVisibility(View.GONE);
        dataPresenter = new DataPresenter(getApplication(), this, this);

    }

    @Override
    public void initView(View view) {
        mImageView = view.findViewById(R.id.mVideoBackground);
        smartRefreshLayout = view.findViewById(R.id.mRefreshLayout);
        standardGSYVideoPlayer = view.findViewById(R.id.mVideoView);
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        videoDetailAdapter = new VideoDetailAdapter(getApplicationContext(), new VideoDetailAdapter(this), this);
        initTransition();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void doBusiness(Context mContext) {
        orientationUtils = new OrientationUtils(this, standardGSYVideoPlayer);
        standardGSYVideoPlayer.setRotateViewAuto(false);
        standardGSYVideoPlayer.setIsTouchWiget(true);
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ToolImage.init(this).displayImage(data.getData().getCover().getFeed(), imageView);
        standardGSYVideoPlayer.setThumbImageView(imageView);
        standardGSYVideoPlayer.setStandardVideoAllCallBack(new VideoListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onPlayError(String url, Object... objects) {
                super.onPlayError(url, objects);
                ToolToast.showLong("播放失敗");
            }

            @Override
            public void onEnterFullscreen(String url, Object... objects) {
                super.onEnterFullscreen(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                orientationUtils.backToProtVideo();
            }
        });
        standardGSYVideoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        smartRefreshLayout.setEnableHeaderTranslationContent(true);
        MaterialHeader materialHeader = (MaterialHeader) smartRefreshLayout.getRefreshHeader();
        materialHeader.setShowBezierWave(true);
        smartRefreshLayout.setPrimaryColorsId(R.color.color_light_black, R.color.color_title_bg);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                dataPresenter.requestRelatedVideo(data.getData().getId());
            }
        });
        standardGSYVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();
                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                standardGSYVideoPlayer.startWindowFullscreen(VideoDetailActivity.this, true, true);
            }
        });
        standardGSYVideoPlayer.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                orientationUtils.setEnable(!lock);
            }
        });
    }

    @Override
    public void setVideo(String url) {
        standardGSYVideoPlayer.setUp(url, false, "");
        //开始自动播放
        standardGSYVideoPlayer.startPlayLogic();
    }

    @Override
    public void setVideoInfo(HomeResult.IssueListBean.ItemListBean itemInfo) {
        videoDetailAdapter.addData(itemInfo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(videoDetailAdapter);
        dataPresenter.requestRelatedVideo(itemInfo.getData().getId());
    }

    @Override
    public void setBackground(String url) {
        ToolImage.init(getApplicationContext()).displayImage(url, mImageView);
    }

    @Override
    public void setRecentRelatedVideo(HomeResult.IssueListBean.ItemListBean data) {
        goToVideoPlayer(data);
    }

    @Override
    public void setErrorMsg(String errorMs) {

    }

    /**
     * 加载 content item
     */
    private void goToVideoPlayer(HomeResult.IssueListBean.ItemListBean data) {
        this.data = data;
        initTransition();
//        videoDetailAdapter.addData(data);
//        dataPresenter.requestRelatedVideo(data.getData().getId());
//        getOperation().addGloableAttribute(IBaseConstant.STRING, data);
//        getOperation().forward(VideoDetailActivity.class, IBaseConstant.TOP_BOTTOM);
    }

    private GSYVideoPlayer getCurPlay() {
        if (standardGSYVideoPlayer.getFullWindowPlayer() != null) {
            return standardGSYVideoPlayer.getFullWindowPlayer();
        } else
            return standardGSYVideoPlayer;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCurPlay().onVideoResume();
        isPause = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        getCurPlay().onVideoPause();
        isPause = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        orientationUtils.releaseListener();
        ToolImage.clearCache();
        dataPresenter.attachView(this);
    }

    /**
     * 监听返回键
     */
    public void onBackPressed() {
        orientationUtils.backToProtVideo();
        if (StandardGSYVideoPlayer.backFromWindowFull(this))
            return;
        //释放所有
        standardGSYVideoPlayer.setStandardVideoAllCallBack(null);
        GSYVideoPlayer.releaseAllVideos();
        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed();
        } else {
            finish();
            overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
        }
    }

    private void initTransition() {
        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition();
            ViewCompat.setTransitionName(standardGSYVideoPlayer, IBaseConstant.IMG_TRANSITION);
            addTransitionListener();
            startPostponedEnterTransition();
        } else {
            dataPresenter.loadVideoInfo(data);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addTransitionListener() {
        Transition transition = getWindow().getSharedElementEnterTransition();
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                dataPresenter.loadVideoInfo(data);
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isPlay && !isPause) {
            standardGSYVideoPlayer.onConfigurationChanged(this, newConfig, orientationUtils);
        }
    }


    @Override
    public void loginSuccess(BaseResult result,boolean isFirst) {
        smartRefreshLayout.finishRefresh();
        videoDetailAdapter.addAllData(((HomeResult.IssueListBean) result).getItemList());
    }

    @Override
    public void loginFail() {
    }

    @Override
    public void loginException() {

    }
}
