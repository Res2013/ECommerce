package com.herry.core;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@Deprecated
public class BaseClearPresenter {

    private Reference<Object> mViewRef;

    public void attachView(Object view) {
        mViewRef = new WeakReference<>(view);
    }

    @SuppressWarnings("unchecked")
    protected <T> T getView() {
        return (T) mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
