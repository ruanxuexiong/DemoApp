package com.example.demo.app.mvp.base;


import com.example.demo.app.mvp.dagger.component.ActivityComponent;
import com.example.demo.app.mvp.dagger.component.DaggerActivityComponent;
import com.example.demo.app.mvp.dagger.module.ActivityModule;
import com.zftlive.android.library.base.ui.BaseActivity;

public abstract class CommonBaseActivity extends BaseActivity implements MvpView {
    private ActivityComponent mActivityComponent;

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .build();

        }
        return mActivityComponent;
    }
}
