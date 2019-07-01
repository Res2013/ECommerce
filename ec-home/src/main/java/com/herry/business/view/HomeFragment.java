package com.herry.business.view;

import android.support.v4.app.Fragment;

import com.herry.business.HomeContract;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter mPresenter;

    @Override
    public void showData() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
