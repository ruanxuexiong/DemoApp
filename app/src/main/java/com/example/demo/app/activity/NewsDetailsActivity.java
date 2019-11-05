package com.example.demo.app.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.CommentAdapter;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.example.demo.app.mvp.util.ShowPicRelation;
import com.longer.service.response.BaseResult;
import com.longer.service.response.CommentResult;
import com.longer.service.response.NewsDetailResult;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.ToolImage;

public class NewsDetailsActivity extends BaseActivity implements View.OnClickListener, CallBackView {


    private WebView mWebView;
    private String mTitle = ""; //页面标题
    private RecyclerView mRecyclerView;
    private MyLinearLayoutManager layoutManager;
    private NewsModel newsModel;
    private final static String FUNCTIONNAME = "fuctionname";
    private String mDetalUrl;
    protected String mChannelCode;
    private TextView mTvTitle;//新闻标题
    private TextView mNameTv;
    private View mLoadingView;
    private ImageView mAvatarImg;
    private DataPresenter dataPresenter;
    private TextView mTagTv;
    private CommentAdapter adapter;
    private NestedScrollView nestedScrollView;

    @Override
    public int bindLayout() {
        return R.layout.activity_news_details;
    }

    @Override
    public void initParams(Bundle params) {
        newsModel = (NewsModel) getOperation().getParameter(IBaseConstant.PARAM1);
        StringBuffer urlSb = new StringBuffer("https://m.toutiao.com/i");
        urlSb.append(newsModel.item_id).append("/info/");
        mDetalUrl = urlSb.toString();//http://m.toutiao.com/i6412427713050575361/info/
        mChannelCode = newsModel.category;
        dataPresenter = new DataPresenter(getApplication(), this);
        dataPresenter.getNewsDetail(mDetalUrl);
    }

    @Override
    public void initView(View view) {
        getWindowTitle().initBackCenterTitle("头条新闻");
        getWindowTitle().getTitleTextView().setTextColor(getResources().getColor(R.color.black_80_alpha));
        getWindowTitle().getBackImageButton().setImageDrawable(getDrawable(R.drawable.anl_selector_common_back_black_btn));
        getWindowTitle().setBackgroundColor(getResources().getColor(R.color.anl_white));
        setStatusBarBackground(getResources().getColor(R.color.anl_white));
        mTvTitle = findViewById(R.id.tvTitle);
        mLoadingView = findViewById(R.id.loading_view);
        mNameTv = view.findViewById(R.id.tv_name);
        mAvatarImg = view.findViewById(R.id.iv_avatar);
        mTagTv = view.findViewById(R.id.tv_tag);
        nestedScrollView = view.findViewById(R.id.scrollView);

        //防止内存泄露
        LinearLayout webViewLayout = findViewById(R.id.ll_webview_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(params);
        webViewLayout.addView(mWebView);
        initWebView(mWebView);
        mRecyclerView = findViewById(R.id.recyclerView);
        layoutManager = new MyLinearLayoutManager(this);
        layoutManager.setSmoothScrollbarEnabled(true);
        initComment();
    }


    @Override
    public void loginSuccess(BaseResult result, boolean isFirst) {
        if (isFirst) {
            NewsDetailResult newsDetail = (NewsDetailResult) result;
            mTvTitle.setText(newsDetail.getData().title);
            mNameTv.setText(newsDetail.getData().media_user.screen_name);
            mTagTv.setText(newsModel.user_info.description);
            ToolImage.getInstance().displayImage(newsDetail.getData().media_user.avatar_url, mAvatarImg, ToolImage.getRoundOptions(R.mipmap.ic_launcher));
//            if (newsDetail.getData().media_user == null) {
//                //如果没有用户信息
//            } else {
//                if (!TextUtils.isEmpty(newsDetail.getData().media_user.avatar_url)) {
////								GlideUtils.loadRound(mContext, detail.media_user.avatar_url, mIvAvatar);
//                }
//            }
            if (TextUtils.isEmpty(newsDetail.getData().content))
                mWebView.setVisibility(View.GONE);

            mWebView.getSettings().setJavaScriptEnabled(true);//设置JS可用
            mWebView.addJavascriptInterface(new ShowPicRelation(NewsDetailsActivity.this), "chaychan");//绑定JS和Java的联系类，以及使用到的昵称

            String htmlPart1 = "<!DOCTYPE HTML html>\n" +
                    "<head><meta charset=\"utf-8\"/>\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=no\"/>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<style> \n" +
                    "img{width:100%!important;height:auto!important}\n" +
                    " </style>";
            String htmlPart2 = "</body></html>";
            String html = htmlPart1 + newsDetail.getData().content + htmlPart2;
            mWebView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
            mWebView.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    addJs(view);//添加多JS代码，为图片绑定点击函数
                    mLoadingView.setVisibility(View.GONE);
                    String comment_url = "https://is.snssdk.com/article/v4/tab_comments/?fold=1&offset=0&group_id=" + newsModel.group_id + "&count=20&comment_request_from=2&app_name=news_article_lite&device_platform=android&language=zh";
                    dataPresenter.getCommentList(comment_url);
                }
            });
            //webview加载完成之后重新测量webview的高度
            ViewGroup.LayoutParams params = mWebView.getLayoutParams();
            params.width = getResources().getDisplayMetrics().widthPixels;
            params.height = mWebView.getHeight() - nestedScrollView.getHeight();
            mWebView.setLayoutParams(params);

        } else {
            CommentResult commentResult = (CommentResult) result;
            adapter.setDataBeanList(commentResult.getData());
        }
    }


    @Override
    public void loginFail() {

    }

    @Override
    public void loginException() {

    }

    public static class MyLinearLayoutManager extends LinearLayoutManager {

        public MyLinearLayoutManager(Context context) {
            super(context);
        }

        public MyLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public MyLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public boolean isAutoMeasureEnabled() {
            return true;
        }
    }

    private void initWebView(WebView webView) {

        WebSettings webSettings = webView.getSettings();
        //下面方法去掉滚动条
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        IX5WebViewExtension ix5 = webView.getX5WebViewExtension();
        if (null != ix5) {
            ix5.setScrollBarFadingEnabled(false);
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);//设置webview支持插件
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
//        String appCachePath = DemoApplication.getInstance().getCacheDir().getAbsolutePath();
//        webSettings.setAppCachePath(appCachePath);
        webSettings.setAppCacheEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        //密码明文存储漏洞 关闭密码保存提醒
        webSettings.setSavePassword(false);
        //域控制不严格漏洞 禁用 file 协议；
        webSettings.setAllowFileAccess(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.getMediaPlaybackRequiresUserGesture();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    /**
     * 模拟评论数据
     */
    private void initComment() {
        //方法已过时,自定义LinearLayoutManager，重写isAutoMeasureEnabled
        //		layoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new CommentAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * 添加JS代码，获取所有图片的链接以及为图片设置点击事件
     */
    private void addJs(WebView wv) {
        wv.loadUrl("javascript:(function  pic(){" +
                "var imgList = \"\";" +
                "var imgs = document.getElementsByTagName(\"img\");" +
                "for(var i=0;i<imgs.length;i++){" +
                "var img = imgs[i];" +
                "imgList = imgList + img.src +\";\";" +
                "img.onclick = function(){" +
                "window.chaychan.openImg(this.src);" +
                "}" +
                "}" +
                "window.chaychan.getImgArray(imgList);" +
                "})()");
    }

    /**
     * 给图片添加点击事件
     *
     * @param webView
     */
    private void addImageClickListener(WebView webView) {
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "    objs[i].οnclick=function()  " +
                "    {  "
                + "        window." + FUNCTIONNAME + ".openImage(this.src);  " +//通过js代码找到标签为img的代码块，设置点击的监听方法与本地的openImage方法进行连接
                "    }  " +
                "}" +
                "})()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.title_bar_share:
//                String curUrl = mDetalUrl;
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT, mTitle + ":" + curUrl);
//                sendIntent.setType("text/plain");
//                startActivity(sendIntent);
//                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再destory()
            ViewParent parent = mWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(mWebView);
            }
            mWebView.stopLoading();
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            mWebView.getSettings().setJavaScriptEnabled(false);
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
