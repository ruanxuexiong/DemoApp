package com.example.demo.app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.activity.MainActivity;
import com.example.demo.app.activity.SearchActivity;
import com.example.demo.app.activity.view.CallBackView;
import com.example.demo.app.adapter.HomeAdapter;
import com.example.demo.app.mvp.presenter.DataPresenter;
import com.longer.service.response.BaseResult;
import com.longer.service.response.HomeResult;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.widget.MultipleStatusView;
import com.zftlive.android.library.base.IBaseConstant;
import com.zftlive.android.library.base.ui.BaseFragmentV4;
import com.zftlive.android.library.network.ToolNetwork;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class HomeFragment extends BaseFragmentV4 implements CallBackView {
    private static String KEY = "0";
    private static HomeFragment homeFragment;
    private String title;
    private MultipleStatusView multipleStatusView;
    private DataPresenter dataPresenter;
    private RecyclerView mRecyclerView;
    private HomeAdapter homeAdapter;
    private SmartRefreshLayout smartRefreshLayout;
    private MaterialHeader materialHeader;
    private Toolbar toolbar;
    private boolean loadingMore = false;
    private TextView mHeadTitle;
    private ImageView mSearchImage;

    public static HomeFragment getInstance(String arg) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, arg);
        if (homeFragment == null)
            homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }


    @Override
    public void initParams(Bundle params) {
        title = params.getString(KEY);
    }

    @Override
    public void initView(View view) {
        mSearchImage = view.findViewById(R.id.iv_search);
        mHeadTitle = view.findViewById(R.id.tv_header_title);
        toolbar = view.findViewById(R.id.toolbar);
        multipleStatusView = view.findViewById(R.id.multipleStatusView);
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        smartRefreshLayout = view.findViewById(R.id.mRefreshLayout);
        smartRefreshLayout.setEnableHeaderTranslationContent(true);
        materialHeader = (MaterialHeader) smartRefreshLayout.getRefreshHeader();
        materialHeader.setShowBezierWave(true);
        smartRefreshLayout.setPrimaryColorsId(R.color.color_light_black, R.color.color_title_bg);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        homeAdapter = new HomeAdapter(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(homeAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int childCount = mRecyclerView.getChildCount();
                    int itemCount = mRecyclerView.getLayoutManager().getItemCount();

                    int firstVisibleItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).
                            findFirstVisibleItemPosition();
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadingMore) {
                            loadingMore = true;
                            dataPresenter.getMoreHomeData();
                        }
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int currentVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (currentVisibleItemPosition == 0) {
                    //背景设置为透明
                    toolbar.setBackgroundColor(getResources().getColor(R.color.color_translucent));
                    mHeadTitle.setText("");
                    mSearchImage.setBackground(getResources().getDrawable(R.mipmap.ic_action_search_white));
                } else {
                    if (homeAdapter.mData.size() > 1) {
                        toolbar.setBackgroundColor(getResources().getColor(R.color.color_title_bg));
                        mSearchImage.setBackground(getResources().getDrawable(R.mipmap.ic_action_search_black));
                        HomeResult.IssueListBean.ItemListBean item = homeAdapter.mData.get(currentVisibleItemPosition + homeAdapter.bannerItemSize - 1);
                        if (item.getType() == "textHeader") {
                            mHeadTitle.setText(item.getData().getTitle());
                        } else {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("- MMM. dd, 'Brunch' -", Locale.ENGLISH);
                            mHeadTitle.setText(simpleDateFormat.format(item.getData().getDate()));
                        }
                    }
                }
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                smartRefreshLayout.finishRefresh();
                if (dataPresenter != null)
                    dataPresenter.getHomeInfo(1);
            }
        });
        mSearchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    val options = activity?.let {
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mSearchImage, mSearchImage.getTransitionName());
//                    }
//                startActivity(new Intent(getActivity(), SearchActivity.class), optionsCompat.toBundle());
//                } else {
//                    startActivity(Intent(activity, SearchActivity::class.java))
//                }

                ((MainActivity) getActivity()).getOperation().forward(SearchActivity.class, IBaseConstant.LEFT_RIGHT);
            }
        });
    }

    @Override
    public void loadDataOnce() {
        super.loadDataOnce();
        multipleStatusView.showLoading();
        if (ToolNetwork.isNetworkConnected(getContext())) {
            dataPresenter = new DataPresenter(getActivity().getApplication(), this);
            dataPresenter.getHomeInfo(1);
//            multipleStatusView.showEmpty();
        } else {
            multipleStatusView.showNoNetwork();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataPresenter.detachView();
    }

    @Override
    public void loginSuccess(BaseResult result, boolean isFirst) {
        if(isFirst){
            homeAdapter.setBannerSize(((HomeResult) result).getIssueList().get(0).getCount());
            homeAdapter.addItemData(((HomeResult) result), true);
        }else{
            multipleStatusView.showContent();
            homeAdapter.addItemData(((HomeResult) result), false);
            loadingMore = false;
        }

    }

    @Override
    public void loginFail() {
    }

    @Override
    public void loginException() {
        multipleStatusView.showError();
    }
}
