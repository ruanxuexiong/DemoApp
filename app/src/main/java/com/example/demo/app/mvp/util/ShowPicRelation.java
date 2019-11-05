package com.example.demo.app.mvp.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.example.demo.app.activity.ImageDetailActivity;
import com.example.demo.app.bean.GridPictureModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowPicRelation {

    private static final String TAG = ShowPicRelation.class.getSimpleName();

    private Context mContext;
    private List<String> mUrls = new ArrayList();

    public ShowPicRelation(Context context) {
        this.mContext = context;
    }

    /**
     * JS中点击图片执行的Java代码
     */
    @JavascriptInterface
    public void openImg(String url) {

        //传到展示图片的viewPager
        List<GridPictureModel> mPictureModelList = new ArrayList();
        for (int i = 0; i < mUrls.size(); i++) {
            GridPictureModel gr = new GridPictureModel();
            gr.setPictureUrl(mUrls.get(i));
            mPictureModelList.add(gr);
        }
        Intent intent = new Intent(mContext, ImageDetailActivity.class);
        intent.putExtra("mPictureModelList", (Serializable) mPictureModelList);
        intent.putExtra("position", mUrls.indexOf(url));
        mContext.startActivity(intent);
    }

    /**
     * 页面加载时JS调用的Java代码
     */
    @JavascriptInterface
    public void getImgArray(String urlArray) {
        String[] urls = urlArray.split(";");//url拼接成的字符串，有分号隔开
        for (String url : urls) {
            mUrls.add(url);
        }
    }
}
