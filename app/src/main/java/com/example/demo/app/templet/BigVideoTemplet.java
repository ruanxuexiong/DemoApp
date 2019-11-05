package com.example.demo.app.templet;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.app.R;
import com.example.demo.app.activity.SmallVideoActivity;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.jaren.lib.view.FlowLikeView;
import com.jaren.lib.view.GoodView;
import com.longer.service.response.BaseResult;
import com.longer.service.response.VideoContentResult;
import com.longer.service.rx.ResponseObserver;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.xing.playeractivity.GetVideoUrl;
import com.xing.playeractivity.OrientationUtilsMy;
import com.xing.playeractivity.SampleListener;
import com.xing.playeractivity.SampleNoBottomVideo;
import com.zftlive.android.library.annotation.Config;
import com.zftlive.android.library.base.adapter.IAdapterModel;
import com.zftlive.android.library.base.adapter.RecyclerViewTemplet;
import com.zftlive.android.library.imageloader.ToolImage;

@Config(layout = R.layout.templet_big_video)
public class BigVideoTemplet extends RecyclerViewTemplet {
    private ImageView mAvatarImg;

    private TextView mTitleTv, mNameTv, mDigCountTv, mCommentTv;
    private SampleNoBottomVideo sampleCoverVideo;
    private DataPresenter dataPresenter;
    private OrientationUtils orientationUtils;
    private GSYVideoOptionBuilder gsyVideoOptionBuilder;
    private ImageView mCloseImg;
    private boolean isStart = true;
    private int oldPosition;
    private GoodView mGoodView;
    private boolean isCollection = false;
    private NewsModel newsModel;
    private FlowLikeView likeViewLayout;

    public BigVideoTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }

    @Override
    public void initView() {
        isStart = true;
        mGoodView = new GoodView(mContext);
        mDigCountTv = (TextView) findViewById(R.id.tv_dig_count);
        mCommentTv = (TextView) findViewById(R.id.tv_comment_count);
        mAvatarImg = (ImageView) findViewById(R.id.img_avatar);
        mTitleTv = (TextView) findViewById(R.id.tv_title);
        mNameTv = (TextView) findViewById(R.id.tv_name);
        sampleCoverVideo = (SampleNoBottomVideo) findViewById(R.id.video_item_player);
        dataPresenter = new DataPresenter(((Activity) mContext).getApplication(), null);
        mCloseImg = (ImageView) findViewById(R.id.img_close);
        likeViewLayout = (FlowLikeView) findViewById(R.id.ll_right);
        mCloseImg.setOnClickListener(this);
        mDigCountTv.setOnClickListener(this);
        gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        gsyVideoOptionBuilder.setIsTouchWigetFull(false)
                .setIsTouchWiget(false)
                .setCacheWithPlay(false)
                .setRotateViewAuto(false)
                .setPlayTag("TAG")
                .setPlayPosition(getLayoutPosition())
                .setVideoAllCallBack(new SampleListener() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (orientationUtils != null) {
                            orientationUtils.setEnable(false);
                            orientationUtils.releaseListener();
                            orientationUtils = null;
                        }
                        orientationUtils = new OrientationUtilsMy((Activity) mContext, sampleCoverVideo);
                        orientationUtils.setEnable(true);
                        orientationUtils.setRotateWithSystem(false);
                    }

                    @Override
                    public void onClickStartIcon(String url, Object... objects) {
                        super.onClickStartIcon(url, objects);
                        //点击播放
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

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.img_close:
                ((SmallVideoActivity) mContext).finish();
                break;
            case R.id.tv_dig_count:
                if (!isCollection) {
                    likeViewLayout.addLikeView(R.drawable.arw);
                    isCollection = true;
                    Drawable drawable = mContext.getDrawable(R.mipmap.arw);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    mDigCountTv.setCompoundDrawables(null, drawable, null, null);
                    mDigCountTv.setTextColor(mContext.getColor(R.color.anl_crimson));
                    mGoodView.setTextInfo("收藏成功", mContext.getColor(R.color.anl_crimson), 14);
                    if (newsModel != null) {
                        newsModel.raw_data.action.setDigg_count(newsModel.raw_data.action.getDigg_count() + 1);
                        mDigCountTv.setText(String.valueOf(newsModel.raw_data.action.getDigg_count()));
                    }

                } else {
                    likeViewLayout.addLikeView(R.drawable.arv);
                    isCollection = false;
                    mDigCountTv.setTextColor(mContext.getColor(R.color.anl_white));
                    Drawable drawable = mContext.getDrawable(R.mipmap.arv);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    mDigCountTv.setCompoundDrawables(null, drawable, null, null);
                    mGoodView.setTextInfo("取消收藏", mContext.getColor(R.color.anl_white), 14);
                    if (newsModel != null) {
                        newsModel.raw_data.action.setDigg_count(newsModel.raw_data.action.getDigg_count() - 1);
                        mDigCountTv.setText(String.valueOf(newsModel.raw_data.action.getDigg_count()));
                    }

                }
                mGoodView.show(v);
                break;
        }

    }

    @Override
    public void fillData(IAdapterModel model, final int position) {
        if (!isStart && (oldPosition == position))
            return;

        isStart = false;
        oldPosition = position;
        newsModel = (NewsModel) model;
        mDigCountTv.setText(String.valueOf(newsModel.raw_data.action.getDigg_count()));
        mCommentTv.setText(String.valueOf(newsModel.raw_data.action.getComment_count()));
        if (TextUtils.isEmpty(newsModel.raw_data.rich_title))
            mTitleTv.setText("");
        else
            mTitleTv.setText(Html.fromHtml(newsModel.raw_data.rich_title));
        ToolImage.getInstance().displayImage(newsModel.raw_data.user.getInfo().getAvatar_url(), mAvatarImg, ToolImage.getRoundOptions(R.mipmap.ic_launcher));
        mNameTv.setText(newsModel.raw_data.user.getInfo().getName());

        dataPresenter.getVideoUrl(GetVideoUrl.url(newsModel.raw_data.video.video_id), new ResponseObserver<BaseResult>() {
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
                    newsModel.videoUrl = url;
                    gsyVideoOptionBuilder.setUrl(url).build(sampleCoverVideo);
                    if (position == 0) {
                        sampleCoverVideo.startPlayLogic();
                    }
                } else {
                    Toast.makeText(mContext, "播放地址获取失败", Toast.LENGTH_SHORT).show();
                    sampleCoverVideo.setUp("", false, null, "");
                }
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(mContext, "播放地址获取失败", Toast.LENGTH_SHORT).show();
            }
        });

        sampleCoverVideo.loadCoverImage(newsModel.raw_data.animated_image_list.get(0).url, 0);
        //设置返回键
        sampleCoverVideo.getBackButton().setVisibility(View.GONE);
    }

}
