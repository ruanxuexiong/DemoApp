package com.example.demo.app.templet;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.zftlive.android.library.model.DTO;

/**
 * 右侧小图布局(1.小图新闻；2.视频类型，右下角显示视频时长)
 */
@Config(layout = R.layout.templet_right_pic_vid)
public class RightPictureTemplet extends RecyclerViewTemplet {
    private TextView mTitle, mDuctionTime, tvAuthor, tvCommentNum, tvTime, tvTag;
    private ImageView mImg;
    private LinearLayout mDuctionLl;
    private NewsModel newsModel;

    public RightPictureTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }


    @Override
    public void initView() {
        mTitle = (TextView) findViewById(R.id.tv_title);
        mImg = (ImageView) findViewById(R.id.iv_img);
        mDuctionTime = (TextView) findViewById(R.id.tv_duration);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvCommentNum = (TextView) findViewById(R.id.tv_comment_num);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvTag = (BorderTextView) findViewById(R.id.tv_tag);
        mDuctionLl = (LinearLayout) findViewById(R.id.ll_duration);

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
            mDuctionLl.setVisibility(View.VISIBLE);
            mDuctionTime.setText(TimeUtils.secToTime(newsModel.video_duration));
        } else {
            mDuctionLl.setVisibility(View.GONE);
        }
        tvAuthor.setText(newsModel.source);
        tvCommentNum.setText(newsModel.comment_count + "评论");
        tvTime.setText(TimeUtils.getShortTime(newsModel.behot_time * 1000));
        tvTag.setVisibility(View.GONE);
        mTitle.setText(newsModel.title);
        if (newsModel.middle_image != null)
            ToolImage.init(mContext).displayImage(newsModel.middle_image.url, mImg, ToolImage.gainSampleOption(R.mipmap.ic_launcher));

    }
}
