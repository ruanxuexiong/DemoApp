package com.example.demo.app.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ProgressBar;

import com.example.demo.app.R;
import com.example.demo.app.bean.GridPictureModel;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseFragmentV4;
import com.zftlive.android.library.imageloader.ToolImage;
import com.zftlive.android.library.imageloader.photoview.PhotoView;


import java.io.Serializable;
import java.util.List;

public class ImageDetailFragment extends BaseFragmentV4 {
    private List<GridPictureModel> mPictureModelList;
    private int mPosition;

    public static ImageDetailFragment getInstance(List<GridPictureModel> mPictureModelList, int position) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(IBaseConstant.PARAM1, (Serializable) mPictureModelList);
        bundle.putInt(IBaseConstant.PARAM2, position);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_image_detail;
    }

    @Override
    public void initParams(Bundle params) {
        mPictureModelList = (List<GridPictureModel>) params.getSerializable(IBaseConstant.PARAM1);
        mPosition = params.getInt(IBaseConstant.PARAM2);
    }

    @Override
    public void initView(View view) {
        final ProgressBar progressBar = view.findViewById(R.id.pb_progressBar);
        PhotoView mPhotoView = view.findViewById(R.id.photoView);
        ToolImage.init(getContext()).displayImage(mPictureModelList.get(mPosition).getPictureUrl(), mPhotoView, ToolImage.gainSample4ImageOption(R.mipmap.ic_error), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
            }
        });

        ViewCompat.setTransitionName(mPhotoView, mPictureModelList.get(mPosition).getPictureUrl());
//        PhotoView !!.setOnTouchListener {
//            v, event ->
//            //				LogUtil.e("zh"," mPhotoView.getScale() " + mPhotoView.getScale());
//            if (PhotoView !!.scale != 1.0f){
//                (activity as ImageDetailActivity).upDownHideLayout.lock()
//            } else{
//                (activity as ImageDetailActivity).upDownHideLayout.unLock()
//            }
//            PhotoView !!.attacher.onTouch(v, event)
//        }
    }
}
