package com.example.demo.app.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.app.R;
import com.example.demo.app.event.MainEvent;
import com.zftlive.android.library.base.ui.BaseFragmentV4;

import org.greenrobot.eventbus.EventBus;

public class NotLoggedFragment extends BaseFragmentV4 {
    private static NotLoggedFragment notLoggedFragment;

    public static NotLoggedFragment getInstance() {
        if (notLoggedFragment == null) {
            notLoggedFragment = new NotLoggedFragment();
        }
        return notLoggedFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_not_logged;

    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        Button mBtnLogin = view.findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PreferenceUtil.saveLogin(true);
                EventBus.getDefault().post(new MainEvent(false));
            }
        });

    }
}
