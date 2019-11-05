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
 * 三张图片布局(文章、广告)
 */
@Config(layout = R.layout.templet_three_pic)
public class ThreePictureTemplet extends RecyclerViewTemplet {
    private TextView mTitle, tvAuthor, tvCommentNum, tvTime, tvTag;
    private ImageView imageView1, imageView2, imageView3;
    private NewsModel newsModel;

    public ThreePictureTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }


    @Override
    public void initView() {
        mTitle = (TextView) findViewById(R.id.tv_title);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvCommentNum = (TextView) findViewById(R.id.tv_comment_num);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvTag = (BorderTextView) findViewById(R.id.tv_tag);

        imageView1 = (ImageView) findViewById(R.id.iv_img1);
        imageView2 = (ImageView) findViewById(R.id.iv_img2);
        imageView3 = (ImageView) findViewById(R.id.iv_img3);
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
        tvAuthor.setText(newsModel.source);
        tvCommentNum.setText(newsModel.comment_count + "评论");
        tvTime.setText(TimeUtils.getShortTime(newsModel.behot_time * 1000));
        tvTag.setVisibility(View.GONE);
        mTitle.setText(newsModel.title);

        ToolImage.init(mContext).displayImage(newsModel.image_list.get(0).url, imageView1, ToolImage.gainSampleOption(R.mipmap.ic_launcher));

        ToolImage.init(mContext).displayImage(newsModel.image_list.get(1).url, imageView2, ToolImage.gainSampleOption(R.mipmap.ic_launcher));

        ToolImage.init(mContext).displayImage(newsModel.image_list.get(2).url, imageView3, ToolImage.gainSampleOption(R.mipmap.ic_launcher));

    }
}
