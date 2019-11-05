package com.example.demo.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.fragment.HotFragment;
import com.example.demo.app.templet.CenterPictureTemplet;
import com.example.demo.app.templet.RightPictureTemplet;
import com.example.demo.app.templet.SmallVideoTemplet;
import com.example.demo.app.templet.TextTemplet;
import com.example.demo.app.templet.ThreePictureTemplet;
import com.example.demo.app.templet.VideoListTemplet;
import com.zftlive.android.library.base.adapter.IAdapterModel;
import com.zftlive.android.library.base.adapter.RecyclerViewMutilTypeAdapter;
import com.zftlive.android.library.base.adapter.RecyclerViewTemplet;

import java.util.Map;

public class NewsAdapter extends RecyclerViewMutilTypeAdapter {

    /**
     * 纯文字布局(文章、广告)
     */
    private static final int TEXT_NEWS = 100;
    /**
     * 居中大图布局(1.单图文章；2.单图广告；3.视频，中间显示播放图标，右侧显示时长)
     */
    private static final int CENTER_SINGLE_PIC_NEWS = 200;
    /**
     * 右侧小图布局(1.小图新闻；2.视频类型，右下角显示视频时长)
     */
    private static final int RIGHT_PIC_VIDEO_NEWS = 300;
    /**
     * 三张图片布局(文章、广告)
     */
    private static final int THREE_PICS_NEWS = 400;

    /**
     * 视频列表类型
     */
    private static final int VIDEO_LIST_NEWS = 500;
    /**
     * 小视频
     */
    private static final int VIDEO_SMALL_NEWS = 600;

    public NewsAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void registeViewTemplet(Map<Integer, Class<? extends RecyclerViewTemplet>> mViewTemplet) {
        mViewTemplet.put(TEXT_NEWS, TextTemplet.class);
        mViewTemplet.put(CENTER_SINGLE_PIC_NEWS, CenterPictureTemplet.class);
        mViewTemplet.put(RIGHT_PIC_VIDEO_NEWS, RightPictureTemplet.class);
        mViewTemplet.put(THREE_PICS_NEWS, ThreePictureTemplet.class);
        mViewTemplet.put(VIDEO_LIST_NEWS, VideoListTemplet.class);
        mViewTemplet.put(VIDEO_SMALL_NEWS, SmallVideoTemplet.class);
    }

    @Override
    protected int adjustItemViewType(IAdapterModel model, int position) {
        NewsModel news = (NewsModel) model;
        if ("video".equals(news.category)) {
            return VIDEO_LIST_NEWS;
        }
        if (HotFragment.CATEGORY.equals(news.category)) {
            return VIDEO_SMALL_NEWS;
        }
        if (news.has_video) {
            //如果有视频
            if (news.video_style == 0) {
                //右侧视频
                if (news.middle_image == null || TextUtils.isEmpty(news.middle_image.url)) {
                    return TEXT_NEWS;
                }
                return RIGHT_PIC_VIDEO_NEWS;
            } else if (news.video_style == 2) {
                //居中视频
                return CENTER_SINGLE_PIC_NEWS;
            }
        } else {
            //非视频新闻
            if (!news.has_image) {
                //纯文字新闻
                return TEXT_NEWS;
            } else {
                if (news.image_list == null || news.image_list.size() == 0) {
                    //图片列表为空，则是右侧图片
                    return RIGHT_PIC_VIDEO_NEWS;
                }

                if (news.gallary_image_count == 3) {
                    //图片数为3，则为三图
                    return THREE_PICS_NEWS;
                }

                //中间大图，右下角显示图数
                return CENTER_SINGLE_PIC_NEWS;
            }
        }
        return TEXT_NEWS;
    }
}
