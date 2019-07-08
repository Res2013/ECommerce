package com.herry.core.base;

public interface IBasePresenter<V> {

    void attachView(V view);

    void detachView();

    V getView();

    void subscribe();

    void unSubscribe();
}
