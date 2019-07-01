package com.herry.business.presenter;

import android.support.annotation.NonNull;

import com.herry.business.HomeContract;
import com.herry.business.data.HomeRepository;

import io.reactivex.disposables.CompositeDisposable;

import static com.google.common.base.Preconditions.checkNotNull;

public class HomePresenter implements HomeContract.Presenter {

    @NonNull
    private final HomeRepository mHomeRepository;
    @NonNull
    private final HomeContract.View mHomeView;
    @NonNull
    private CompositeDisposable mCompositeDisposable;

    public HomePresenter(@NonNull HomeRepository homeRepository, @NonNull HomeContract.View homeView) {
        mHomeRepository = checkNotNull(homeRepository, "homeRepository cannot be null!");
        mHomeView = checkNotNull(homeView, "homeView cannot be null!");
        mCompositeDisposable = new CompositeDisposable();
        mHomeView.setPresenter(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
