package com.example.demo.app.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.fragment.HotFragment;
import com.example.demo.app.templet.BigVideoTemplet;
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

public class SmallVideoAdapter extends RecyclerViewMutilTypeAdapter {


    /**
     * 视频列表类型
     */
    private static final int VIDEO_LIST_NEWS = 500;
    /**
     * 小视频
     */
    private static final int VIDEO_SMALL_NEWS = 600;

    public SmallVideoAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void registeViewTemplet(Map<Integer, Class<? extends RecyclerViewTemplet>> mViewTemplet) {
        mViewTemplet.put(VIDEO_LIST_NEWS, BigVideoTemplet.class);
    }

    @Override
    protected int adjustItemViewType(IAdapterModel model, int position) {
        return VIDEO_LIST_NEWS;
    }
}
