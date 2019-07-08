package com.herry.core.base;

import android.content.Context;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private Reference<V> mViewRef;
    private CompositeDisposable mCompositeDisposable;

    protected BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    @Override
    public V getView() {
        return isViewAttached() ? mViewRef.get() : null;
    }

    public Context getContext() {
        return getView().getContext();
    }

    private boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    public void detachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    @Override
    public void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
}
