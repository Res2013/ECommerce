package com.herry.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseMvpFragment<P extends IBasePresenter> extends BaseFragment {

    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract P createPresenter();
}
