package com.example.demo.app.mvp.dagger.module;

import com.example.demo.app.mvp.base.MvpView;
import com.example.demo.app.mvp.dagger.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private MvpView mvpView;

    public ActivityModule(MvpView mvpView) {
        this.mvpView = mvpView;
    }

    @ActivityScope
    @Provides
    public MvpView getMvpView() {
        return mvpView;
    }
}
