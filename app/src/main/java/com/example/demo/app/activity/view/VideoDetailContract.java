package com.example.demo.app.activity.view;

import com.longer.service.response.HomeResult;

public interface VideoDetailContract {

    /**
     * 设置视频播放源
     */
    void setVideo(String url);

    /**
     * 设置视频信息
     */
    void setVideoInfo(HomeResult.IssueListBean.ItemListBean itemInfo);

    /**
     * 设置背景
     */
    void setBackground(String url);

    /**
     * 设置最新相关视频
     */
    void setRecentRelatedVideo(HomeResult.IssueListBean.ItemListBean data);

    /**
     * 设置错误信息
     */
    void setErrorMsg(String errorMs);

}
