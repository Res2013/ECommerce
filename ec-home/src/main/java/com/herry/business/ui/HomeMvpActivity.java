package com.herry.business.ui;

import android.os.Bundle;

import com.herry.business.HomeContract;
import com.herry.business.R;
import com.herry.business.presenter.HomePresenter;
import com.herry.core.base.BaseMvpActivity;
import com.herry.core.base.IBasePresenter;

/**
 * @author Herry
 */
public class HomeMvpActivity extends BaseMvpActivity implements HomeContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter createPresenter() {
        return null;
    }

    @Override
    public void setPresenter(IBasePresenter presenter) {

    }

    @Override
    public void showData() {

    }

    @Override
    public void onEmpty(Object tag) {

    }

    @Override
    public void onError(Object tag, String errorMsg) {

    }
}
