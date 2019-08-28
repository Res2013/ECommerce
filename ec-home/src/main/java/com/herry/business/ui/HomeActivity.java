package com.herry.business.ui;

import android.os.Bundle;

import com.herry.business.HomeContract;
import com.herry.business.R;
import com.herry.business.presenter.HomePresenter;
import com.herry.core.base.BaseMvpActivity;

/**
 * @author Herry
 */
public class HomeActivity extends BaseMvpActivity<HomePresenter> implements HomeContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter createPresenter() {
        return null;
    }

    @Override
    public void showData() {

    }
}
