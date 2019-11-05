package com.example.demo.app.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.bean.GridPictureModel;
import com.example.demo.app.fragment.ImageDetailFragment;
import com.xing.utils.PixelUtil;
import com.xing.widget.UpDownHideLayout;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.picture.HackyViewPager;


import java.util.List;

import static android.animation.ObjectAnimator.ofFloat;

/**
 * 图片详情界面
 */
public class ImageDetailActivity extends BaseActivity implements UpDownHideLayout.OnLayoutCloseListener {
    private HackyViewPager mViewPager;
    private List<GridPictureModel> mPictureModelList;
    private int position;
    public UpDownHideLayout upDownHideLayout;
    private View mRoot;
    private ScrollView scrollView;
    private TextView mIntroduction;


//	@Override
//	public boolean isSupportFinishAnim() {
//		return false;
//	}
//
//	@Override
//	public boolean isSupportSwipeBack() {
//		return false;
//	}

    @Override
    public void OnLayoutClosed() {
        onBackPressed();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_image_detail;
    }

    @Override
    public void initParams(Bundle params) {

        position = params.getInt("position", 0);
    }

    @Override
    public void initView(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            view.findViewById(R.id.rl_base_layout).setPadding(0, 0, 0, 0);
        }
        getWindowTitle().setVisibility(View.GONE);
        setStatusBarBackground(getResources().getColor(R.color.black_80_alpha));
        upDownHideLayout = view.findViewById(R.id.swipableLayout);
        upDownHideLayout.setOnLayoutCloseListener(this);
        upDownHideLayout.setScrollListener(new UpDownHideLayout.ScrollListener() {
            @Override
            public void onScrolling(float percent, float px) {
                float diffY = PixelUtil.px2dp(px, ImageDetailActivity.this);
                float textHidePercent = (diffY / 50) > 0.99 ? 1 : (diffY / 50);
                //大于50dp则不显示
                scrollView.setAlpha(1 - textHidePercent);

                mRoot.setAlpha(1 - percent);
                if (percent == 1) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                    finish();
                }
            }
        });
        mRoot = view.findViewById(R.id.blackView);
        mViewPager = view.findViewById(R.id.viewPager);
//        mViewPager.setPageTransformer(true, new CardTransformer(0.8f));  //
		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        scrollView = view.findViewById(R.id.scrollView);
        mIntroduction = view.findViewById(R.id.introduction);
    }

    @Override
    public void initListener() {
        mPictureModelList = (List<GridPictureModel>) this.getIntent()
                .getSerializableExtra("mPictureModelList");
        mViewPager.setAdapter(new PagerAdapter());
        mViewPager.addOnPageChangeListener(OnPageChangeListener);
        mViewPager.setCurrentItem(position);
        setIntroductionText(position);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private class PagerAdapter extends
            FragmentPagerAdapter {

        public PagerAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return ImageDetailFragment.getInstance(mPictureModelList, position);
        }

        @Override
        public int getCount() {
            return mPictureModelList.size();
        }

    }

    //	DepthPageTransformer
    private static class CardTransformer implements ViewPager.PageTransformer {
        private final float scaleAmount;

        public CardTransformer(float scalingStart) {   //下一张图片有小到大缩放显示
            scaleAmount = 1 - scalingStart;
        }

        @Override
        public void transformPage(View page, float position) {
            if (position >= 0f) {
                final int w = page.getWidth();
                float scaleFactor = 1 - scaleAmount * position;
                page.setAlpha(1f - position);
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setTranslationX(w * (1 - position) - w);
            }
        }
    }

    private static class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static float MIN_SCALE = 0.99f;

        private static float MIN_ALPHA = 0.8f;

        @Override
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);
            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to
                // shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }
                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                        / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    //控制当前界面是否可以滑动返回到上一界面
    ViewPager.OnPageChangeListener OnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            if (position == 0) {
//				mSwipeBackHelper.setSwipeBackEnable(true);// 允许本页面的滑动销毁
            } else {
//				mSwipeBackHelper.setSwipeBackEnable(false);// 关闭本页面的滑动销毁
            }
            setIntroductionText(position);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };


    private void setIntroductionText(int position) {
        // 6/8 6字体大小为默认的1.3倍
        String text = position + 1 + "/" + mPictureModelList.size();
        if (!TextUtils.isEmpty(mPictureModelList.get(position).getPictureTitle())) {
            text += " " + mPictureModelList.get(position).getPictureTitle();
        }
        int start = text.indexOf("/");
        int end = text.length();
        SpannableString textSpan = new SpannableString(text);
        textSpan.setSpan(new RelativeSizeSpan(1.3f), 0, start, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new RelativeSizeSpan(1f), start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mIntroduction.setText(textSpan);
    }

    @Override
    public void finish() {

        super.finish();
        //关闭activity动画显示
        overridePendingTransition(0, 0);
    }

    private boolean isScrollToHide = false;//防止重复点击造成退出动画重叠

    @Override
    public void onBackPressed() {
        if (!isScrollToHide) {
            scrollToHide();
        }
//		super.onBackPressed();
    }

    //仿今日头条，点击返回键界面由上向下退出（需要设置打开和关闭时都没有动画，并且theme背景透明）
    private void scrollToHide() {
        isScrollToHide = true;
//		View view = getWindow().getDecorView();//.findViewById(android.R.id.content)
        View view = mContentView;
        final int RootViewHeight = view.getMeasuredHeight(); //防止虚拟导航栏
        ObjectAnimator positionAnimator = null;
        positionAnimator = ofFloat(view, "y", view.getY(), RootViewHeight);
        positionAnimator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float diffY = Math.abs((float) animation.getAnimatedValue());
                float percent = (diffY / (float) RootViewHeight) > 0.99 ? 1 : (diffY / (float) RootViewHeight);
                if (percent == 1) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                    finish();
                }
            }
        });
        positionAnimator.setDuration(300);
        positionAnimator.start();
    }
}
