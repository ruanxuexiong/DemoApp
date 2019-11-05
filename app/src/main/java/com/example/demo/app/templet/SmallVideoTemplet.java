package com.example.demo.app.templet;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.MainActivity;
import com.example.demo.app.activity.SmallVideoActivity;
import com.example.demo.app.bean.NewsModel;
import com.example.demo.app.event.HotEvent;
import com.xing.widget.RealtimeBlurView;
import com.zftlive.android.library.AppEnvironment;
import com.zftlive.android.library.annotation.Config;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.adapter.IAdapterModel;
import com.zftlive.android.library.base.adapter.RecyclerViewTemplet;
import com.zftlive.android.library.imageloader.ToolImage;
import com.zftlive.android.library.tools.LogUtil;

import org.greenrobot.eventbus.EventBus;

@Config(layout = R.layout.templet_small_video)
public class SmallVideoTemplet extends RecyclerViewTemplet {
    private ImageView mCoverImg, mCoverImgBg;
    private RealtimeBlurView realtimeBlurView;
    private RelativeLayout mRelBg;
    private TextView mTitleTv, mPlayCountTv, mDiggCountTv;

    public SmallVideoTemplet(Context mContext, View itemView) {
        super(mContext, itemView);
    }

    @Override
    public void initView() {
        mCoverImg = (ImageView) findViewById(R.id.img_cover);
        mRelBg = (RelativeLayout) findViewById(R.id.rel_bg);
        mCoverImgBg = (ImageView) findViewById(R.id.img_cover_bg);
        realtimeBlurView = (RealtimeBlurView) findViewById(R.id.blurView);
        mTitleTv = (TextView) findViewById(R.id.tv_title);
        mPlayCountTv = (TextView) findViewById(R.id.tv_play_count);
        mDiggCountTv = (TextView) findViewById(R.id.tv_digg_count);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        EventBus.getDefault().post(new HotEvent(getLayoutPosition()));
//        Log.e("TAG", "tag===" + getLayoutPosition());
    }

    @Override
    public void fillData(IAdapterModel model, int position) {
        NewsModel newsModel = (NewsModel) model;
        if (newsModel.raw_data.animated_image_list != null && newsModel.raw_data.animated_image_list.size() > 0) {
            setLayoutParams(newsModel.raw_data.animated_image_list.get(0).width, newsModel.raw_data.animated_image_list.get(0).height);
            ToolImage.getInstance().displayImage(mContext, mCoverImg, newsModel.raw_data.animated_image_list.get(0).url, R.mipmap.ic_launcher);
            //ToolImage.getInstance().displayImage(newsModel.raw_data.animated_image_list.get(0).url, mCoverImg, ToolImage.getFadeOptions(R.mipmap.ic_launcher));
            ToolImage.getInstance().displayImage(newsModel.raw_data.animated_image_list.get(0).url, mCoverImgBg, ToolImage.getDefaultOptions());
        } else {
            LogUtil.e(newsModel.toString());
        }
        if (TextUtils.isEmpty(newsModel.raw_data.rich_title))
            mTitleTv.setText("");
        else
            mTitleTv.setText(Html.fromHtml(newsModel.raw_data.rich_title));
        mPlayCountTv.setText(getCount(newsModel.raw_data.action.getPlay_count()) + "次播放");
        mDiggCountTv.setText(newsModel.raw_data.action.getDigg_count() + "赞");
    }

    public String getCount(int count) {
        if (count < 10000)
            return count + "";
        else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(count / 10000).append(".").append(count % 10000 / 1000).append("万");
            return stringBuffer.toString();
        }
    }

    public void setLayoutParams(int width, int height) {
        ViewGroup.LayoutParams layoutParams = mRelBg.getLayoutParams();
        layoutParams.width = AppEnvironment.SCREEN_WIDTH / 2;
        layoutParams.height = layoutParams.width / width * height;
        mRelBg.setLayoutParams(layoutParams);
    }
}
