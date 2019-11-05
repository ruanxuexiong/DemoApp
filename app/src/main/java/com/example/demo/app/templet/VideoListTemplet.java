package com.example.demo.app.templet;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.app.R;
import com.example.demo.app.activity.NewsDetailsActivity;
import com.example.demo.app.activity.PlayerDetailActivity;
import com.example.demo.app.activity.WebViewActivity;
import com.example.demo.app.bean.NewsModel;
import com.longer.service.response.VideoContentResult;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.example.demo.app.util.TimeUtils;
import com.longer.service.response.BaseResult;
import com.longer.service.rx.ResponseObserver;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xing.playeractivity.GetVideoUrl;
import com.xing.playeractivity.OrientationUtilsMy;
import com.xing.playeractivity.SampleCoverVideo;
import com.xing.playeractivity.SampleListener;
import com.zftlive.android.library.annotation.Config;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.adapter.IAdapterModel;
import com.zftlive.android.library.base.adapter.RecyclerViewTemplet;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.ToolImage;


/**
 * 视频列表类型
 */
@Config(layout = R.layout.templet_video_list)
public class VideoListTemplet extends RecyclerViewTemplet {
    private ImageView headPic;
    private TextView tvAuthor, tvCommentCount, tvDuration;
    private SampleCoverVideo gsyVideoPlayer;
    private boolean isPlay = false;
    private OrientationUtils orientationUtils;
    private DataPresenter dataPresenter;
    private NewsModel newsModel;

    public VideoListTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }


    @Override
    public void initView() {
        gsyVideoPlayer = (SampleCoverVideo) findViewById(R.id.video_item_player);
        headPic = (ImageView) findViewById(R.id.iv_avatar);
        tvDuration = (TextView) findViewById(R.id.tv_duration);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvCommentCount = (TextView) findViewById(R.id.tv_comment_count);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        ((BaseActivity) mContext).getOperation().addParameter(IBaseConstant.PARAM1, newsModel);
        if (newsModel.has_video) {
            ((BaseActivity) mContext).getOperation().forward(PlayerDetailActivity.class, IBaseConstant.TOP_BOTTOM);
        } else {
            if (newsModel.article_type == 1) {
                ((BaseActivity) mContext).getOperation().forward(WebViewActivity.class, IBaseConstant.TOP_BOTTOM);
            } else {
                ((BaseActivity) mContext).getOperation().forward(NewsDetailsActivity.class, IBaseConstant.TOP_BOTTOM);
            }
        }
    }

    @Override
    public void fillData(IAdapterModel model, int position) {
        newsModel = (NewsModel) model;
        if (newsModel.user_info != null) {
            tvAuthor.setText(newsModel.user_info.name);
            ToolImage.init(mContext).displayImage(newsModel.user_info.avatar_url, headPic, ToolImage.gainSample4ImageOption(R.mipmap.ic_launcher));
        }
        tvCommentCount.setText(newsModel.comment_count + "");
        tvDuration.setText(TimeUtils.secToTime(newsModel.video_duration));
        dealVideo(newsModel, position);
    }


    private void dealVideo(final NewsModel news, int position) {
        //增加封面
        if (news.video_detail_info == null || news.video_detail_info.video_id == null) {
            return;
        }

        String picUrl = "";
        if (news.video_detail_info != null && news.video_detail_info.detail_video_large_image != null) {
            picUrl = news.video_detail_info.detail_video_large_image.url;
        }
        gsyVideoPlayer.loadCoverImage(picUrl, 0);

        //增加title
//        gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);
        gsyVideoPlayer.getTitleTextView().setTextSize(16);
        //增加 视频播放地址   先设置标题，防止出现黑色背景
        if (TextUtils.isEmpty(news.videoUrl)) {
            gsyVideoPlayer.setUp("", false, null, "" + news.title);
        } else {
            gsyVideoPlayer.setUp(news.videoUrl, false, null, "" + news.title);
        }
        dataPresenter = new DataPresenter(((Activity) mContext).getApplication(), null);
        gsyVideoPlayer.setLoadVideoUrlListener(new SampleCoverVideo.LoadVideoUrlListener() {
            @Override
            public void onLoadUrl() {
                dataPresenter.getVideoUrl(GetVideoUrl.url(news.video_detail_info.video_id), new ResponseObserver<BaseResult>() {
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
                                } else if (videoList.getVideo_2() != null) {
                                    String base64 = videoList.getVideo_2().getMain_url();
                                    url = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                                } else if (videoList.getVideo_1() != null) {
                                    String base64 = videoList.getVideo_1().getMain_url();
                                    url = (new String(Base64.decode(base64.getBytes(), Base64.DEFAULT)));
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(url)) {
                            news.videoUrl = url;
                            gsyVideoPlayer.setUp(url, false, null, "" + news.title);
                            gsyVideoPlayer.clickStartIcon();
                        } else {
                            Toast.makeText(mContext, "播放地址获取失败", Toast.LENGTH_SHORT).show();
                            gsyVideoPlayer.setUp("", false, null, "" + news.title);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "播放地址获取失败", Toast.LENGTH_SHORT).show();
                        gsyVideoPlayer.setUp("", false, null, "" + news.title);
                    }
                });
            }
        });
        //是否点击封面可以播放
        gsyVideoPlayer.setThumbPlay(true);
        //设置返回键
        gsyVideoPlayer.getBackButton().setVisibility(View.GONE);
        //设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolveFullBtn(gsyVideoPlayer);
            }
        });
//        gsyVideoPlayer.setRotateViewAuto(true);
//        gsyVideoPlayer.setLockLand(true);
        gsyVideoPlayer.setPlayTag("TAG");
        gsyVideoPlayer.setShowFullAnimation(false);
        //循环
        //gsyVideoPlayer.setLooping(true);
        gsyVideoPlayer.setNeedLockFull(true);

        //gsyVideoPlayer.setSpeed(2);

        gsyVideoPlayer.setPlayPosition(position);
        gsyVideoPlayer.setStandardVideoAllCallBack(new SampleListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.setEnable(false);
                    orientationUtils.releaseListener();
                    orientationUtils = null;
                }
                orientationUtils = new OrientationUtilsMy((Activity) mContext, gsyVideoPlayer);
                orientationUtils.setEnable(true);
                orientationUtils.setRotateWithSystem(false);
            }

            @Override
            public void onClickStartIcon(String url, Object... objects) {
                super.onClickStartIcon(url, objects);
                //点击播放
                tvDuration.setVisibility(View.GONE);//隐藏时长
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                }
            }

            @Override
            public void onEnterFullscreen(String url, Object... objects) {
                super.onEnterFullscreen(url, objects);
                GSYVideoManager.instance().setNeedMute(false);
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

        });
    }

    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        if (orientationUtils != null) {
            orientationUtils.resolveByClick();
        }
        standardGSYVideoPlayer.startWindowFullscreen(mContext, true, true);
    }
}
