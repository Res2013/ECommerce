package com.herry.business.presenter;

import android.support.annotation.NonNull;

import com.herry.business.HomeContract;
import com.herry.business.data.HomeRepository;
import com.herry.core.base.BasePresenter;

import static com.google.common.base.Preconditions.checkNotNull;

public class HomePresenter extends BasePresenter implements HomeContract.Presenter {

    @NonNull
    private final HomeRepository mHomeRepository;
    @NonNull
    private final HomeContract.View mHomeView;

    public HomePresenter(@NonNull HomeRepository homeRepository, @NonNull HomeContract.View homeView) {
        mHomeRepository = checkNotNull(homeRepository, "homeRepository cannot be null!");
        mHomeView = checkNotNull(homeView, "homeView cannot be null!");
        mHomeView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void complete() {

    }
}
