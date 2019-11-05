package com.example.demo.app.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.MainActivity;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.ItemAdapter;
import com.example.demo.app.event.MainEvent;
import com.example.demo.app.util.PreferenceUtil;
import com.longer.service.response.BaseResult;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.widget.MultipleStatusView;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseFragmentV4;
import com.zftlive.android.library.network.ToolNetwork;
import com.zftlive.android.library.tools.LogUtil;
import com.zftlive.android.library.widget.dialog.bean.ItemBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragmentV4 implements CallBackView {
    private static MineFragment mineFragment;
    private RecyclerView recyclerView;
    private String[] titles;
    private int[] titles_icon;
    private Toolbar toolbar;
    private ItemAdapter itemAdapter;
    private AppBarLayout appBarLayout;
    private TextView mCenterTitleTv;
    private TextView mCollectionTv, mHistoryTv, mShoppingTv, mMoneyTv;

    public static MineFragment getInstance(String arg) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(IBaseConstant.STRING, arg);
        if (mineFragment == null)
            mineFragment = new MineFragment();
        mineFragment.setArguments(bundle);
        return mineFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_mine;
    }


    @Override
    public void initParams(Bundle params) {
        titles = getResources().getStringArray(R.array.titles);
        titles_icon = new int[]{R.mipmap.bap, R.mipmap.ban, R.mipmap.bag, R.mipmap.bao, R.mipmap.baq, R.mipmap.baj, R.mipmap.bar};
    }

    @Override
    public void initView(View view) {
        appBarLayout = view.findViewById(R.id.app_bar);
        toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setVisibility(View.GONE);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter = new ItemAdapter(getActivity());
        recyclerView.setAdapter(itemAdapter);
        mCenterTitleTv = view.findViewById(R.id.center_title);
        mCollectionTv = view.findViewById(R.id.tv_collection);
        mHistoryTv = view.findViewById(R.id.tv_history);
        mShoppingTv = view.findViewById(R.id.tv_shopping);
        mMoneyTv = view.findViewById(R.id.tv_money);
        doBusinese();
    }

    public void doBusinese() {
        List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            ItemBean itemBean = new ItemBean(titles[i], null, titles_icon[i], null, false);
            itemBeanList.add(itemBean);
        }
        itemAdapter.setItemBeanList(itemBeanList);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //verticalOffset始终为0以下的负数
                float percent = (Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange());
                toolbar.setBackgroundColor(changeAlpha(getResources().getColor(R.color.anl_gray), percent));
                mCenterTitleTv.setTextColor(changeAlpha(getResources().getColor(R.color.anl_white), percent));
            }
        });
        mCollectionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mHistoryTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mShoppingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mMoneyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * 根据百分比改变颜色透明度
     */
    public int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }

    @Override
    public void loadDataOnce() {
        super.loadDataOnce();
//        multipleStatusView.showContent();
//        if (ToolNetwork.isNetworkConnected(getContext())) {
//            multipleStatusView.showEmpty();
//        } else {
//            multipleStatusView.showNoNetwork();
//        }
    }


    @Override
    public void loginSuccess(BaseResult result, boolean isFirst) {

    }

    @Override
    public void loginFail() {

    }

    @Override
    public void loginException() {

    }
}
