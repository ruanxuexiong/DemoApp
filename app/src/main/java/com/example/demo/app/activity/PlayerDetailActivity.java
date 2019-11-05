package com.example.demo.app.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.CommentAdapter;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.google.gson.Gson;
import com.longer.service.response.BaseResult;
import com.longer.service.response.CommentResult;
import com.longer.service.response.NewsResult;
import com.longer.service.response.VideoContentResult;
import com.longer.service.rx.ResponseObserver;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.xing.playeractivity.GetVideoUrl;
import com.xing.playeractivity.OrientationUtilsMy;
import com.xing.playeractivity.SampleCoverVideo;
import com.xing.playeractivity.SampleListener;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.ToolImage;
import com.zftlive.android.library.model.DTO;

import io.reactivex.observers.DisposableObserver;

public class PlayerDetailActivity extends BaseActivity implements CallBackView {
    NestedScrollView postDetailNestedScroll;
    //推荐使用StandardGSYVideoPlayer，功能一致
    SampleCoverVideo detailPlayer;
    LinearLayout activityDetailPlayer;
    private TextView mVideoName;// 视频名称
    private TextView mVideoDec;// 视频描述


    private boolean isPlay;
    private boolean isPause;
    private OrientationUtilsMy orientationUtils;
    public String playUrl;
    public String playTitle;
    public String playPic;
    public String playId;
    private DataPresenter dataPresenter;
    private ImageView mAvatarImg;
    private TextView mAvatarTv;
    private NewsModel newsModel;
    private TextView mDescription;
    private RecyclerView mRecycleView;
    private CommentAdapter commentAdapter;
    private String url = "";

    @Override
    public int bindLayout() {
        return R.layout.activity_player_detaill;
    }

    @Override
    public void initParams(Bundle params) {

        newsModel = (NewsModel) getOperation().getParameter(IBaseConstant.PARAM1);
        playId = newsModel.video_detail_info.video_id;
        playTitle = newsModel.title;
        playPic = newsModel.video_detail_info.detail_video_large_image.url;
    }

    @Override
    public void initView(View view) {
        getWindowTitle().setVisibility(View.GONE);
        setStatusBarBackground(getResources().getColor(R.color.anl_white));
        dataPresenter = new DataPresenter(getApplication(), this);
        detailPlayer = view.findViewById(R.id.detail_player);
        activityDetailPlayer = view.findViewById(R.id.activity_detail_player);
        mVideoName = view.findViewById(R.id.video_name);
        mVideoDec = view.findViewById(R.id.video_dec);
        mAvatarImg = view.findViewById(R.id.iv_avatar);
        mAvatarTv = view.findViewById(R.id.tv_author);
        mDescription = view.findViewById(R.id.tv_description);
        mRecycleView = view.findViewById(R.id.recyclerView);
        commentAdapter = new CommentAdapter(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(commentAdapter);
        initData();
    }

    @Override
    public void initListener() {

    }

    private void initData() {
        url = "https://is.snssdk.com/article/v4/tab_comments/?fold=1&offset=0&group_id=" + newsModel.group_id + "&count=20&comment_request_from=2&app_name=news_article_lite&device_platform=android&language=zh";
        dataPresenter.getCommentList(url);
        ToolImage.init(PlayerDetailActivity.this).displayImage(newsModel.user_info.avatar_url, mAvatarImg, ToolImage.getRoundOptions(R.mipmap.ic_launcher));
        mAvatarTv.setText(newsModel.user_info.name);
        mDescription.setText(newsModel.user_info.description);
        //增加封面
        detailPlayer.getTitleTextView().setTextSize(16);
        detailPlayer.loadCoverImage(playPic + "", 0);
        if (!TextUtils.isEmpty(playId)) {
            dataPresenter.getVideoUrl(GetVideoUrl.url(playId), new ResponseObserver<BaseResult>() {
                @Override
                public void onSuccess(BaseResult baseResult) {

                    VideoContentResult videoContentBean = (VideoContentResult) baseResult;
                    String url = null;
                    if (videoContentBean != null && videoContentBean.getData() != null) {
                        VideoContentResult.DataBean.VideoListBean videoList = videoContentBean.getData().getVideo_list();
                        if (videoList != null) {
                            if (videoList.getVideo_3() != null) {
                                String base64 = videoList.getVideo_3().getMain_url();
                                url = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                                Log.e("zh", "getVideoUrls getVideo_3: " + url);
                            } else if (videoList.getVideo_2() != null) {
                                String base64 = videoList.getVideo_2().getMain_url();
                                url = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                                Log.e("zh", "getVideoUrls getVideo_2: " + url);
                            } else if (videoList.getVideo_1() != null) {
                                String base64 = videoList.getVideo_1().getMain_url();
                                url = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                                Log.e("zh", "getVideoUrls getVideo_2: " + url);
                            }
                        }
                    }
                    if (url != null) {
                        playUrl = url;
                        detailPlayer.setUp(url, false, null, "" + playTitle);
                    } else {
                        detailPlayer.setUp("", false, null, "" + playTitle);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    detailPlayer.setUp("", false, null, "" + playTitle);
                }
            });

        } else {
            detailPlayer.setUp(playUrl, false, null, "" + playTitle);
        }
        //detailPlayer.setLooping(true);
        //detailPlayer.setShowPauseCover(false);
        /*VideoOptionModel videoOptionModel =
                new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "framedrop", 5);
        List<VideoOptionModel> list = new ArrayList<>();
        list.add(videoOptionModel);
        GSYVideoManager.instance().setOptionModelList(list);*/
        //GSYVideoManager.instance().setTimeOut(4000, true);

        mVideoName.setText(playTitle);
        mVideoDec.setText(newsModel.user_info.description);


        resolveNormalVideoUI();
        //外部辅助的旋转，帮助全屏
        orientationUtils = new OrientationUtilsMy(this, detailPlayer);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);
        detailPlayer.setIsTouchWiget(true);
        //detailPlayer.setIsTouchWigetFull(false);
        //关闭自动旋转
//        detailPlayer.setRotateViewAuto(true);
        //重力旋转
        orientationUtils.setRotateWithSystem(false);
        //是否点击封面可以播放
        detailPlayer.setThumbPlay(true);
//        detailPlayer.setLockLand(true);
        detailPlayer.setShowFullAnimation(false);
        detailPlayer.setNeedLockFull(true);
        //detailPlayer.setOpenPreView(false);
        detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();
                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                detailPlayer.startWindowFullscreen(PlayerDetailActivity.this, true, true);
            }
        });

        detailPlayer.setStandardVideoAllCallBack(new SampleListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                //开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onClickStartError(String url, Object... objects) {
                super.onClickStartError(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                }
            }
        });

        detailPlayer.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        });

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void resolveNormalVideoUI() {
        //增加title
//        detailPlayer.getTitleTextView().setVisibility(View.GONE);
        detailPlayer.getTitleTextView().setText("" + playTitle);
        detailPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }

        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        //GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }


    @Override
    public void loginSuccess(BaseResult result, boolean isFirst) {
        CommentResult commentResult = (CommentResult) result;
        commentAdapter.setDataBeanList(commentResult.getData());
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void loginException() {

    }
}
