package com.example.demo.app.mvp.presenter.base;

import android.support.annotation.UiThread;


public interface MvpPresenter<V> {
    @UiThread
    void attachView(V view);

    @UiThread
    void detachView();
}
