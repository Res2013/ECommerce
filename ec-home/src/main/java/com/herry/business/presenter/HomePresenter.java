package com.herry.business.presenter;

import android.support.annotation.NonNull;

import com.herry.business.HomeContract;
import com.herry.business.data.HomeRepository;
import com.herry.core.base.BasePresenter;

import static com.google.common.base.Preconditions.checkNotNull;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter<HomeContract.View> {

    @NonNull
    private final HomeRepository mHomeRepository;

    public HomePresenter(@NonNull HomeRepository homeRepository) {
        super();
        mHomeRepository = checkNotNull(homeRepository, "homeRepository cannot be null!");
    }

    @Override
    public void loadData() {

    }

    @Override
    public void complete() {

    }
}
