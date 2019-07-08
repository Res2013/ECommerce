package com.herry.business.view;


import com.herry.business.HomeContract;
import com.herry.core.base.BaseMvpFragment;
import com.herry.core.base.IBasePresenter;

public class HomeFragment extends BaseMvpFragment<HomeContract.Presenter> implements HomeContract.View {

    private HomeContract.Presenter mPresenter;

    @Override
    public void showData() {

    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }

    @Override
    public void onEmpty(Object tag) {

    }

    @Override
    public void onError(Object tag, String errorMsg) {

    }

    @Override
    protected HomeContract.Presenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }
}
