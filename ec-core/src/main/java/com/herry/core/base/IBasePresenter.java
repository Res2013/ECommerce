package com.herry.core.base;

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

    V getView();
}
