package com.longer.service.api;


import com.longer.service.response.BaseResult;
import com.longer.service.response.CategoryResult;
import com.longer.service.response.CommentResult;
import com.longer.service.response.FollowResult;
import com.longer.service.response.HomeResult;
import com.longer.service.response.NewsDetailResult;
import com.longer.service.response.NewsResult;
import com.longer.service.response.VideoContentResult;


import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by longer on 2017/7/30.
 */

public interface MainApi<T> {
    /**
     * 首页精选
     */
    @GET("v2/feed?")
    Observable<HomeResult> getHomeInfo(@Query("num") int number);

    /**
     * 根据 nextPageUrl 请求数据下一页数据
     */
    @GET
    Observable<HomeResult> getMoreHomeData(@Url String url);

    /**
     * 关注
     */
    @GET("v4/tabs/follow")
    Observable<FollowResult> getFollowInfo();

    /**
     * 根据item id获取相关视频
     */
    @GET("v4/video/related?")
    Observable<HomeResult.IssueListBean> getRelatedData(@Query("id") long id);

    /**
     * 头条新闻分类
     */
    @GET
    Observable<CategoryResult> getCategory(@Url String url);

    /**
     * 头条新闻内容
     */
    @GET
    Observable<NewsResult> getNewsList(@Url String url);
    /**
     * 获取头条视频链接
     */
    @GET
    Observable<VideoContentResult> getVideoBean(@Url String url);
    /**
     * 获取头条新闻详情
     */
    @GET
    Observable<NewsDetailResult> getNewsDetail(@Url String url);
    /**
     * 获取评论列表
     */
    @GET
    Observable<CommentResult> getCommentList(@Url String url);
}
