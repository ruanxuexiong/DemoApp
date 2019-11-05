package com.example.demo.app.mvp.presenter.base;

import com.example.demo.app.mvp.base.MvpView;

import rx.subscriptions.CompositeSubscription;


public class RxMvpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }
}
