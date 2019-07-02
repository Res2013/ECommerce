package com.herry.core.base;

public interface IBasePresenter {

    void attachView(IBaseView view);

    void detachView();

    IBaseView getView();

    void subscribe();

    void unSubscribe();
}
