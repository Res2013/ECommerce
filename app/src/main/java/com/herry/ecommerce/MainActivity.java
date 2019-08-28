package com.herry.ecommerce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.herry.core.base.BaseActivity;
import com.herry.core.base.BaseMvpActivity;
import com.herry.core.base.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Herry
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.content_layout)
    FrameLayout mContentLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }
}
