package com.herry.business;

import com.herry.core.base.IBasePresenter;
import com.herry.core.base.IBaseView;

public interface HomeContract {

    interface View extends IBaseView {
        void showData();
    }

    interface Presenter extends IBasePresenter {
        void loadData();
        void complete();
    }
}
