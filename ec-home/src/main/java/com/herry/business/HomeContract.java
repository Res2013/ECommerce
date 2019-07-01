package com.herry.business;

import com.herry.core.BasePresenter;
import com.herry.core.BaseView;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showData();
        void showEmpty();
    }

    interface Presenter extends BasePresenter {
        void loadData();
        void complete();
    }
}
