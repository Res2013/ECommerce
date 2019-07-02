package com.herry.core.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.herry.core.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract  class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder;
//    private ViewStub mEmptyView;
    protected Context mContext;
    protected ImmersionBar mImmersionBar;
    protected LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        if (isActionBar()) {
//            setContentView(R.layout.activity_base);
//            ((ViewGroup) findViewById(R.id.fl_content)).addView(getLayoutInflater().inflate(getLayoutId(), null));
        } else {
            setContentView(getLayoutId());
        }
        //初始化ButterKnife
        mUnbinder = ButterKnife.bind(this);

//        //沉浸式状态栏
//        initImmersionBar(R.color.blue);

//        //加入Activity管理器
//        BaseApplication.getApplication().getActivityManage().addActivity(this);
        mLoadingDialog = new LoadingDialog(mContext);

    }


    /**
     * 沉浸栏颜色
     */
    protected void initImmersionBar(int color) {
        mImmersionBar = ImmersionBar.with(this);
        if (color != 0) {
            mImmersionBar.statusBarColor(color);
        }
        mImmersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        //防止内存泄漏
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
//        //将Activity从管理器移除
//        BaseApplication.getApplication().getActivityManage().removeActivity(this);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    /**
     * 空页面
     * @param text
     */
    protected void showEmptyView(String text) {
//        showEmptyOrErrorView(text, R.drawable.bg_no_data);
    }

    protected void showEmptyView() {
//        showEmptyView(getString(R.string.no_data));
    }

    protected void showErrorView(String text) {
//        showEmptyOrErrorView(text, R.drawable.bg_no_net);
    }

    protected void showErrorView() {
//        showErrorView(getString(R.string.error_data));
    }

    public void showEmptyOrErrorView(String text, int img) {
//        if (mEmptyView == null) {
//            mEmptyView = findViewById(R.id.vs_empty);
//        }
//        mEmptyView.setVisibility(View.VISIBLE);
//        findViewById(R.id.iv_empty).setBackgroundResource(img);
//        ((TextView) findViewById(R.id.tv_empty)).setText(text);
//        findViewById(R.id.ll_empty).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onPageClick();
//            }
//        });
    }

    protected void hideEmptyView() {
//        if (mEmptyView != null) {
//            mEmptyView.setVisibility(View.GONE);
//        }
    }

    /**
     * 空页面被点击
     */
    protected void onPageClick() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //如果有未授权权限则跳转设置页面
        if (!requestPermissionsResult(grantResults)) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    /**
     * 判断授权结果
     */
    private boolean requestPermissionsResult(int[] grantResults) {
        for (int code : grantResults) {
            if (code == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否需要ActionBar
     */
    protected boolean isActionBar() {
        return false;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
