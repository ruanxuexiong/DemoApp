package com.example.demo.app.mvp.presenter;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.activity.view.VideoDetailContract;
import com.example.demo.app.mvp.MainRetrofit;
import com.example.demo.app.mvp.presenter.base.RxMvpPresenter;
import com.example.demo.app.mvp.util.AndroidScheduler;
import com.longer.service.repository.MainDataSource;
import com.longer.service.response.BaseResult;
import com.longer.service.response.CategoryResult;
import com.longer.service.response.CommentResult;
import com.longer.service.response.FollowResult;
import com.longer.service.response.HomeResult;
import com.longer.service.response.NewsDetailResult;
import com.longer.service.response.NewsResult;
import com.longer.service.rx.ResponseObserver;
import com.zftlive.android.library.network.ToolNetwork;
import com.zftlive.android.library.tools.ToolToast;

import java.util.List;

import rx.functions.Action0;
import rx.schedulers.Schedulers;


public class DataPresenter extends RxMvpPresenter<CallBackView> {

    private MainDataSource mainDataSource;
    private String nextPagerUrl;
    private VideoDetailContract mVideoContract;
    private Context mContext;

    public DataPresenter(Application application, CallBackView callBackView) {
        mContext = application;
        attachView(callBackView);
        mainDataSource = new MainDataSource(MainRetrofit.getInstance(application));
    }

    /**
     * @param application
     * @param callBackView
     * @param videoDetailContract
     */
    public DataPresenter(Application application, CallBackView callBackView, VideoDetailContract videoDetailContract) {
        this(application, callBackView);
        mVideoContract = videoDetailContract;
    }

    /**
     * 首頁數據
     *
     * @param number
     */
    public void getHomeInfo(int number) {

        mCompositeSubscription.add(mainDataSource.getHomeInfo(number).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<HomeResult>() {
            @Override
            public void onError(Throwable e) {
                Log.e("tag","E=="+e.getMessage());
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(HomeResult result) {
                nextPagerUrl = result.getNextPageUrl();
                getMoreHomeData();
                getMvpView().loginSuccess(result, true);
            }
        }));
    }

    /**
     * 首頁更多數據
     */
    public void getMoreHomeData() {
        mCompositeSubscription.add(mainDataSource.getMoreHomeData(nextPagerUrl).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<HomeResult>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();

            }

            @Override
            public void onSuccess(HomeResult result) {
                nextPagerUrl = result.getNextPageUrl();
                getMvpView().loginSuccess(result, false);
            }
        }));
    }

    public void getFollowInfo() {
        mCompositeSubscription.add(mainDataSource.getFollowInfo().subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<FollowResult>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(FollowResult result) {
                getMvpView().loginSuccess(result, false);
            }
        }));
    }

    /**
     * 加载视频相关的数据
     */
    public void loadVideoInfo(HomeResult.IssueListBean.ItemListBean data) {
        List<HomeResult.IssueListBean.ItemListBean.DataBean.PlayInfoBean> playInfoBeanList = data.getData().getPlayInfo();
        checkMvpViewAttached();
        if (playInfoBeanList != null && playInfoBeanList.size() > 1) {
            if (ToolNetwork.isWIFIConnected(mContext)) {
                for (HomeResult.IssueListBean.ItemListBean.DataBean.PlayInfoBean playInfoBean : playInfoBeanList) {
                    if ("high".equals(playInfoBean.getType())) {
                        if (mVideoContract != null) {
                            mVideoContract.setVideo(playInfoBean.getUrl());
                            ToolToast.showLong("播放高清視頻");
                            break;
                        }
                    }
                }
            } else {
                for (HomeResult.IssueListBean.ItemListBean.DataBean.PlayInfoBean playInfoBean : playInfoBeanList) {
                    if (playInfoBean.getType() == "normal") {
                        if (mVideoContract != null) {
                            mVideoContract.setVideo(playInfoBean.getUrl());
                            break;
                        }
                    }
                }
            }
        } else {
            if (mVideoContract != null) {
                mVideoContract.setVideo(data.getData().getPlayUrl());
            }
        }
        if (mVideoContract != null) {
//            val backgroundUrl = data.getData().getCover().getBlurred() + "/thumbnail/${DisplayManager.getScreenHeight()!! - DisplayManager.dip2px(250f)!!}x${DisplayManager.getScreenWidth()}"

            mVideoContract.setBackground(data.getData().getCover().getBlurred());
            mVideoContract.setVideoInfo(data);
        }

    }

    /**
     * 請求相關數據
     */
    public void requestRelatedVideo(long videoId) {
        mCompositeSubscription.add(mainDataSource.getRelatedData(videoId).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<HomeResult.IssueListBean>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(HomeResult.IssueListBean result) {
                Log.e("TAG", "result==" + result.toString());
                getMvpView().loginSuccess(result, false);
            }
        }));
    }


    /**
     * 請求头条分类
     */
    public void getCategory(String url) {
        mCompositeSubscription.add(mainDataSource.getCategory(url).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<CategoryResult>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(CategoryResult result) {
                getMvpView().loginSuccess(result, false);
            }
        }));
    }

    /**
     * 請求头条新闻列表
     */
    public void getNewsList(String url) {
        mCompositeSubscription.add(mainDataSource.getNewsList(url).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<NewsResult>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(NewsResult result) {
                getMvpView().loginSuccess(result, false);
            }
        }));
    }

    /**
     * 获取视频url
     */
    public void getVideoUrl(String url, ResponseObserver<BaseResult> responseObserver) {
        mCompositeSubscription.add(mainDataSource.getVideoBean(url).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(responseObserver));
    }

    /**
     * 請求头条新闻内容
     */
    public void getNewsDetail(String url) {
        mCompositeSubscription.add(mainDataSource.getNewsDetail(url).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<NewsDetailResult>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(NewsDetailResult result) {
                getMvpView().loginSuccess(result, true);
            }
        }));
    }

    /**
     * 获取评论列表
     */
    public void getCommentList(String url) {
        mCompositeSubscription.add(mainDataSource.getCommentList(url).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //加载中处理
            }
        }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                //加载完成处理
            }
        }).subscribe(new ResponseObserver<CommentResult>() {
            @Override
            public void onError(Throwable e) {
                getMvpView().loginException();
            }

            @Override
            public void onSuccess(CommentResult result) {
                getMvpView().loginSuccess(result, false);
            }
        }));
    }
}
