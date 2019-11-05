package com.longer.service.repository;

import com.longer.service.api.MainApi;
import com.longer.service.response.BaseResult;
import com.longer.service.response.CategoryResult;
import com.longer.service.response.CommentResult;
import com.longer.service.response.FollowResult;
import com.longer.service.response.HomeResult;
import com.longer.service.response.NewsDetailResult;
import com.longer.service.response.NewsResult;
import com.longer.service.response.VideoContentResult;


import rx.Observable;

public class MainDataSource implements IMainService {


    MainApi maiApi;

    public MainDataSource(MainApi accountApi) {
        this.maiApi = accountApi;
    }

    @Override
    public Observable<HomeResult> getHomeInfo(int number) {
        return maiApi.getHomeInfo(number);
    }

    @Override
    public Observable<HomeResult> getMoreHomeData(String url) {
        return maiApi.getMoreHomeData(url);
    }

    @Override
    public Observable<FollowResult> getFollowInfo() {
        return maiApi.getFollowInfo();
    }

    @Override
    public Observable<HomeResult.IssueListBean> getRelatedData(long id) {
        return maiApi.getRelatedData(id);
    }

    @Override
    public Observable<CategoryResult> getCategory(String url) {
        return maiApi.getCategory(url);
    }

    @Override
    public Observable<NewsResult> getNewsList(String url) {
        return maiApi.getNewsList(url);
    }

    @Override
    public Observable<VideoContentResult> getVideoBean(String url) {
        return maiApi.getVideoBean(url);
    }

    @Override
    public Observable<NewsDetailResult> getNewsDetail(String url) {
        return maiApi.getNewsDetail(url);
    }
    @Override
    public Observable<CommentResult> getCommentList(String url) {
        return maiApi.getCommentList(url);
    }
}
