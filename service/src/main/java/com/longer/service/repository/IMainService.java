package com.longer.service.repository;

import com.longer.service.response.BaseResult;
import com.longer.service.response.CategoryResult;
import com.longer.service.response.CommentResult;
import com.longer.service.response.FollowResult;
import com.longer.service.response.HomeResult;
import com.longer.service.response.NewsDetailResult;
import com.longer.service.response.NewsResult;
import com.longer.service.response.VideoContentResult;

import retrofit2.http.Url;
import rx.Observable;

public interface IMainService {
    Observable<HomeResult> getHomeInfo(int number);

    Observable<HomeResult> getMoreHomeData(String url);

    Observable<FollowResult> getFollowInfo();

    Observable<HomeResult.IssueListBean> getRelatedData(long id);

    Observable<CategoryResult> getCategory(String url);

    Observable<NewsResult> getNewsList(String url);

    Observable<VideoContentResult> getVideoBean(String url);

    Observable<NewsDetailResult> getNewsDetail(String url);

    Observable<CommentResult> getCommentList(String url);
}
