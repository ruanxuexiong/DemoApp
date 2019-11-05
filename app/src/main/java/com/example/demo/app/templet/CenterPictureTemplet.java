package com.example.demo.app.templet;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.NewsDetailsActivity;
import com.example.demo.app.activity.PlayerDetailActivity;
import com.example.demo.app.activity.WebViewActivity;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.util.TimeUtils;
import com.xing.widget.BorderTextView;
import com.zftlive.android.library.annotation.Config;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.adapter.IAdapterModel;
import com.zftlive.android.library.base.adapter.RecyclerViewTemplet;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.ToolImage;

/**
 * 居中大图布局(1.单图文章；2.单图广告；3.视频，中间显示播放图标，右侧显示时长)
 */
@Config(layout = R.layout.templet_center_pic_vid)
public class CenterPictureTemplet extends RecyclerViewTemplet {
    private ImageView mCenterPic;
    private TextView tvTitle, tvAuthor, tvCommentNum, tvTime, tvBottomRight;
    private ImageView imgPlay;
    private BorderTextView tvTag;
    private NewsModel newsModel;

    public CenterPictureTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }


    @Override
    public void initView() {
        mCenterPic = (ImageView) findViewById(R.id.iv_cover_feed);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvCommentNum = (TextView) findViewById(R.id.tv_comment_num);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvTag = (BorderTextView) findViewById(R.id.tv_tag);
        tvBottomRight = (TextView) findViewById(R.id.tv_bottom_right);
        imgPlay = (ImageView) findViewById(R.id.iv_play);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        ((BaseActivity) mContext).getOperation().addParameter(IBaseConstant.PARAM1, newsModel);
        if (newsModel.has_video) {
            ((BaseActivity) mContext).getOperation().forward(PlayerDetailActivity.class, IBaseConstant.TOP_BOTTOM);
        } else {
            if (newsModel.article_type == 1) {
                ((BaseActivity) mContext).getOperation().forward(NewsDetailsActivity.class, IBaseConstant.TOP_BOTTOM);
            } else {
                ((BaseActivity) mContext).getOperation().forward(NewsDetailsActivity.class, IBaseConstant.TOP_BOTTOM);
            }
        }

    }

    @Override
    public void fillData(IAdapterModel model, int position) {
        newsModel = (NewsModel) model;
        if (newsModel.has_video) {
            imgPlay.setVisibility(View.VISIBLE);
            tvBottomRight.setVisibility(View.VISIBLE);
            ToolImage.init(mContext).displayImage(newsModel.video_detail_info.detail_video_large_image.url, mCenterPic, ToolImage.gainSample4ImageOption(R.mipmap.ic_launcher));
        } else {
            imgPlay.setVisibility(View.GONE);
            tvBottomRight.setVisibility(View.GONE);
            String url = newsModel.image_list.get(0).url.replace("list", "large");
            ToolImage.init(mContext).displayImage(url, mCenterPic, ToolImage.gainSample4ImageOption(R.mipmap.ic_launcher));
            if (newsModel.gallary_image_count == 1) {
                tvBottomRight.setVisibility(View.GONE);
            } else {
                tvBottomRight.setVisibility(View.VISIBLE);
                tvBottomRight.setText(newsModel.gallary_image_count + "图");//设置图片数
            }
        }
        tvTitle.setText(newsModel.title);
        tvAuthor.setText(newsModel.source);
        tvCommentNum.setText(newsModel.comment_count + "评论");
        tvTime.setText(TimeUtils.getShortTime(newsModel.behot_time * 1000));
        tvTag.setVisibility(View.GONE);
    }


}
