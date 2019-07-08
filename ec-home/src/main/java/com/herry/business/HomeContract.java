package com.herry.business;

import com.herry.core.base.IBasePresenter;
import com.herry.core.base.IBaseView;

public interface HomeContract {

    interface View extends IBaseView {
        void showData();
    }

    interface Presenter<V extends IBaseView> extends IBasePresenter<V> {
        void loadData();
        void complete();
    }
}
