package com.herry.core.base;

import android.content.Context;

public interface IBaseView {

    void showLoading();

    void dismissLoading();

    void onEmpty(Object tag);

    void onError(Object tag, String errorMsg);

    Context getContext();

    void setPresenter(IBasePresenter presenter);
}
