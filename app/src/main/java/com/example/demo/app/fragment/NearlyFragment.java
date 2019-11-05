package com.example.demo.app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.demo.app.R;
import com.zftlive.android.library.base.ui.BaseFragmentV4;

public class NearlyFragment extends BaseFragmentV4 {
    private static NearlyFragment nearlyFragment;

    public static NearlyFragment getInstance() {
        if (nearlyFragment == null)
            nearlyFragment = new NearlyFragment();
        return nearlyFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_nearly;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        Log.e("tag","===NearlyFragment====initView======");

    }
}
