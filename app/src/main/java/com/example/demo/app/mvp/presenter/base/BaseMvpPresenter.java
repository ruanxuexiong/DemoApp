package com.example.demo.app.mvp.presenter.base;


public class BaseMvpPresenter<V> implements MvpPresenter<V> {
    private V mMvpView;

    @Override
    public void attachView(V view) {
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {

        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkMvpViewAttached() {
        if (!isViewAttached())
            throw new MvpViewNoAttached();
    }

    public static class MvpViewNoAttached extends RuntimeException {
        public MvpViewNoAttached() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
