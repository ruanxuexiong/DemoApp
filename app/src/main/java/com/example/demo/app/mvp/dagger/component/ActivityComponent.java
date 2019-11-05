package com.example.demo.app.mvp.dagger.component;


import com.example.demo.app.mvp.dagger.module.ActivityModule;
import com.example.demo.app.mvp.dagger.scope.ActivityScope;
import com.zftlive.android.library.base.ui.BaseActivity;

import dagger.Component;

@ActivityScope

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    //    Activity activity();\
     void inject(BaseActivity mainActivity);
}
