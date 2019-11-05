package com.example.demo.app.templet;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
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

/**
 * 纯文字布局(文章、广告)
 */
@Config(layout = R.layout.templet_text)
public class TextTemplet extends RecyclerViewTemplet {
    private TextView mTitle, tvAuthor, tvCommentNum, tvTime, tvTag;
    private NewsModel newsModel;

    public TextTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }


    @Override
    public void initView() {
        mTitle = (TextView) findViewById(R.id.tv_title);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvCommentNum = (TextView) findViewById(R.id.tv_comment_num);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvTag = (BorderTextView) findViewById(R.id.tv_tag);

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
        mTitle.setText(newsModel.title);
        boolean isTop = (position == 0 || position == 1) && "".equals(newsModel.category); //属于置顶
        boolean isHot = newsModel.hot == 1;//属于热点新闻
        if (isTop) {
            tvTag.setText("置顶");
            tvTag.setVisibility(View.VISIBLE);
        } else if (isHot) {
            tvTag.setText("热");
            tvTag.setVisibility(View.VISIBLE);
        } else {
            tvTag.setVisibility(View.GONE);
        }
    }
}
