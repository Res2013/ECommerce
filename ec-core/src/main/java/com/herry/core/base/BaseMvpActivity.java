package com.herry.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public abstract class BaseMvpActivity extends BaseActivity implements IBaseView {

    protected IBasePresenter mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {
        showLoading("");
    }

    public void showLoading(String msg) {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
            if (!TextUtils.isEmpty(msg)) {
                mLoadingDialog.setTitleText(msg);
            }
            mLoadingDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    protected abstract IBasePresenter createPresenter();
}
