package com.example.demo.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.demo.app.R;
import com.example.demo.app.activity.VideoDetailActivity;
import com.example.demo.app.util.TimeUtils;
import com.example.demo.app.view.recycleview.MultipleType;
import com.example.demo.app.view.recycleview.ViewHolder;
import com.example.demo.app.view.recycleview.adapter.CommonAdapter;
import com.longer.service.response.HomeResult;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseActivity;
import com.zftlive.android.library.imageloader.ToolImage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeAdapter extends CommonAdapter<HomeResult.IssueListBean.ItemListBean> {
    // banner 作为 RecyclerView 的第一项
    public int bannerItemSize = 0;


    static int ITEM_TYPE_BANNER = 1;   //Banner 类型
    static int ITEM_TYPE_TEXT_HEADER = 2;  //textHeader
    static int ITEM_TYPE_CONTENT = 3;    //item
    private Context mContext;

    public HomeAdapter(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }


    public HomeAdapter(Context mContext, MultipleType<HomeResult.IssueListBean.ItemListBean> typeSupport) {
        super(mContext, typeSupport);
    }


    /**
     * 设置 Banner 大小
     */
    public void setBannerSize(int count) {
        bannerItemSize = count;
    }

    /**
     * 添加更多数据
     */
    public void addItemData(HomeResult homeResult, boolean isRefresh) {
        if (isRefresh)
            this.mData.clear();
        for (HomeResult.IssueListBean.ItemListBean itemListBean : homeResult.getIssueList().get(0).getItemList()) {
            if (itemListBean.getData().getCover() != null)
                mData.add(itemListBean);
        }
        notifyDataSetChanged();
    }

    /**
     * 得到 Item 的类型
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return ITEM_TYPE_BANNER;
        else if (mData.get(position + bannerItemSize - 1).getType().equals("textHeader")) {
            return ITEM_TYPE_TEXT_HEADER;
        } else
            return ITEM_TYPE_CONTENT;
    }

    /**
     * 得到 RecyclerView Item 数量（Banner 作为一个 item）
     */
    @Override
    public int getItemCount() {
        if (mData.isEmpty())
            return 0;
        else if (mData.size() > bannerItemSize)
            return (mData.size() - bannerItemSize + 1);
        else
            return 1;
    }

    @Override
    protected void bindData(final ViewHolder holder, final HomeResult.IssueListBean.ItemListBean data, final int position) {
        if (getItemViewType(position) == ITEM_TYPE_TEXT_HEADER) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("- MMM. dd, 'Brunch' -", Locale.ENGLISH);
            holder.setText(R.id.tvHeader, simpleDateFormat.format(mData.get(position + bannerItemSize - 1).getData().getDate()) + "");
        } else if (getItemViewType(position) == ITEM_TYPE_CONTENT) {
            ToolImage.init(mContext).displayImage(mData.get(position + bannerItemSize - 1).getData().getCover().getFeed(), (ImageView) holder.getView(R.id.iv_cover_feed), ToolImage.gainSampleOption(R.drawable.placeholder_banner));
            ToolImage.init(mContext).displayImage(mData.get(position + bannerItemSize - 1).getData().getAuthor().getIcon(), (ImageView) holder.getView(R.id.iv_avatar), ToolImage.getRoundOptions(7));

            holder.setText(R.id.tv_title, mData.get(position + bannerItemSize - 1).getData().getTitle());
            holder.setText(R.id.tv_tag, "#" + mData.get(position + bannerItemSize - 1).getData().getCategory() + TimeUtils.durationFormat(mData.get(position + bannerItemSize - 1).getData().getDuration()));

//            holder.setText(R.id.tv_tag, mData.get(position + bannerItemSize - 1).getData().getTags().get(0).getDesc());
            holder.setText(R.id.tv_category, "#" + mData.get(position + bannerItemSize - 1).getData().getCategory());
            holder.getView(R.id.iv_cover_feed).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToVideoPlayer((BaseActivity) mContext,  mData.get(position + bannerItemSize - 1));
                }
            });
        } else if (getItemViewType(position) == ITEM_TYPE_BANNER) {

            final List<HomeResult.IssueListBean.ItemListBean> bannerItemData = new ArrayList<>();
            final List<String> bannerFeedList = new ArrayList<>();
            List<String> bannerTitleList = new ArrayList<>();
            for (int i = 0; i < bannerItemSize; i++) {
                if (mData.get(i).getData().getCover() != null) {
                    bannerItemData.add(mData.get(i));
                    bannerFeedList.add(mData.get(i).getData().getCover().getFeed());
                    bannerTitleList.add(mData.get(i).getData().getTitle());
                }
            }
            //设置 banner
            BGABanner bgaBanner = ((BGABanner) holder.getView(R.id.banner));
            bgaBanner.setAutoPlayAble(bannerFeedList.size() > 1);

            bgaBanner.setData(bannerFeedList, bannerTitleList);
            bgaBanner.setAdapter(new BGABanner.Adapter() {
                @Override
                public void fillBannerItem(BGABanner banner, View itemView, @Nullable Object model, int position) {
                    ToolImage.init(mContext).displayImage(bannerFeedList.get(position), (ImageView) itemView, ToolImage.gainSample2ImageOption(R.drawable.placeholder_banner));

                }

            });
            bgaBanner.setDelegate(new BGABanner.Delegate() {
                @Override
                public void onBannerItemClick(BGABanner banner, View itemView, @Nullable Object model, int position) {
                    goToVideoPlayer((BaseActivity) mContext, bannerItemData.get(position));
                }
            });
        }
    }

    /**
     * 创建布局
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_BANNER)
            return new ViewHolder(inflaterView(R.layout.item_home_banner, parent));
        else if (viewType == ITEM_TYPE_TEXT_HEADER) {
            return new ViewHolder(inflaterView(R.layout.item_home_header, parent));

        } else
            return new ViewHolder(inflaterView(R.layout.item_home_content, parent));

    }

    /**
     * 加载布局
     */
    private View inflaterView(int mLayoutId, ViewGroup parent) {
        View view = null;
        if (mInflater != null)
            view = mInflater.inflate(mLayoutId, parent, false);
        return view == null ? new View(parent.getContext()) : view;
    }

    /**
     * 加载 content item
     */
    private void goToVideoPlayer(BaseActivity activity, HomeResult.IssueListBean.ItemListBean data) {
        activity.getOperation().addGloableAttribute(IBaseConstant.STRING, data);
        activity.getOperation().forward(VideoDetailActivity.class, IBaseConstant.TOP_BOTTOM);
    }
}
