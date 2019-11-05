package com.example.demo.app.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.view.VideoDetailContract;
import com.example.demo.app.util.TimeUtils;
import com.example.demo.app.view.recycleview.MultipleType;
import com.example.demo.app.view.recycleview.ViewHolder;
import com.example.demo.app.view.recycleview.adapter.CommonAdapter;
import com.longer.service.response.HomeResult;
import com.zftlive.android.library.imageloader.ToolImage;

import java.util.List;


public class VideoDetailAdapter extends CommonAdapter<HomeResult.IssueListBean.ItemListBean> implements MultipleType<HomeResult.IssueListBean.ItemListBean> {

    private Context mContext;
    private Typeface textTypeface;
    private VideoDetailContract videoDetailContract;

    public VideoDetailAdapter(Context mContext) {
        super(mContext);
        this.mContext = mContext;

    }

    public VideoDetailAdapter(Context mContext, MultipleType<HomeResult.IssueListBean.ItemListBean> typeSupport, VideoDetailContract videoDetailContract) {
        super(mContext, typeSupport);
        this.mContext = mContext;
        textTypeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/FZLanTingHeiS-L-GB-Regular.TTF");
        this.videoDetailContract = videoDetailContract;
    }


    @Override
    public int getLayout(HomeResult.IssueListBean.ItemListBean item, int position) {
        if (position == 0) {
            return R.layout.item_video_detail_info;
        } else if ("textCard".equals(item.getType())) {
            return R.layout.item_video_text_card;
        } else if ("videoSmallCard".equals(item.getType())) {
            return R.layout.item_video_small_card;
        } else
            try {
                throw new IllegalAccessException("Api 解析出错了，出现其他类型");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return 0;
    }

    /**
     * 添加视频的详细信息
     */
    public void addData(HomeResult.IssueListBean.ItemListBean item) {
        mData.clear();
        notifyDataSetChanged();
        mData.add(item);
        notifyItemInserted(0);
    }

    /**
     * 添加所有數據
     */
    public void addAllData(List<HomeResult.IssueListBean.ItemListBean> listBeans) {
        for (int i = 0; i < mData.size(); i++) {
            if (i != 0) {
                mData.remove(i);
            }
        }
        mData.addAll(listBeans);
        notifyDataSetChanged();
    }

    @Override
    protected void bindData(ViewHolder holder, final HomeResult.IssueListBean.ItemListBean data, int position) {
        if (position == 0) {
            setVideoDetailInfo(data, holder);
        } else if ("textCard".equals(data.getType())) {
            holder.setText(R.id.tv_text_card, data.getData().getText());
            ((TextView) holder.getView(R.id.tv_text_card)).setTypeface(textTypeface);
        } else if ("videoSmallCard".equals(data.getType())) {
            holder.setText(R.id.tv_title, data.getData().getTitle());
            holder.setText(R.id.tv_tag, "#" + data.getData().getCategory() + TimeUtils.durationFormat(data.getData().getDuration()));
            ToolImage.init(mContext).displayImage(data.getData().getCover().getDetail(), (ImageView) holder.getView(R.id.iv_video_small_card), ToolImage.gainSampleOption(R.drawable.placeholder_banner));
//          默認圖片
            // 判断onItemClickRelatedVideo 并使用
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoDetailContract != null) {
                        videoDetailContract.setRecentRelatedVideo(data);
                    }
                }
            });
        }
    }

    /**
     * 設置視頻詳情數據
     */
    private void setVideoDetailInfo(HomeResult.IssueListBean.ItemListBean data, ViewHolder viewHolder) {
        //標題
        viewHolder.setText(R.id.tv_title, data.getData().getTitle());
        //視頻簡介
        viewHolder.setText(R.id.expandable_text, data.getData().getDescription());
        //標簽
        viewHolder.setText(R.id.tv_tag, "#" + data.getData().getCategory() + TimeUtils.durationFormat(data.getData().getDuration()));
        //喜歡
        viewHolder.setText(R.id.tv_action_favorites, data.getData().getConsumption().getCollectionCount() + "");
        //分享
        viewHolder.setText(R.id.tv_action_share, data.getData().getConsumption().getShareCount() + "");
        //評論
        viewHolder.setText(R.id.tv_action_reply, data.getData().getConsumption().getReplyCount() + "");
        if (data.getData().getAuthor() != null) {
            viewHolder.setText(R.id.tv_author_name, data.getData().getAuthor().getName());
            viewHolder.setText(R.id.tv_author_desc, data.getData().getAuthor().getDescription());
            ToolImage.init(mContext).displayImage(data.getData().getAuthor().getIcon(), (ImageView) viewHolder.getView(R.id.iv_avatar), ToolImage.gainRoundOption(10));
        } else {
            viewHolder.setViewVisibility(R.id.layout_author_view, View.GONE);
        }

    }

}
