package com.herry.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herry.core.R;
import com.herry.core.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements IBaseView {

    private Unbinder mUnbinder;
    private View mRootView;
    //    private ViewStub mEmptyView;
    protected Context mContext;
    protected LoadingDialog mLoadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mLoadingDialog = new LoadingDialog(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_base_layout, container, false);
        ((ViewGroup) mRootView.findViewById(R.id.fl_content)).addView(getLayoutInflater().inflate(getLayoutId(), null));
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    public void showLoading() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    public void dismissLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    protected void showEmptyView() {
//        showEmptyOrErrorView(getString(R.string.no_data), R.drawable.bg_no_data);
    }


    protected void showErrorView() {
//        showEmptyOrErrorView(getString(R.string.error_data), R.drawable.bg_no_net);
    }

    public void showEmptyOrErrorView(String text, int img) {
//        mEmptyView = mRootView.findViewById(R.id.vs_empty);
//
//        if (mEmptyView != null) {
//            mEmptyView.setVisibility(View.VISIBLE);
//            mRootView.findViewById(R.id.iv_empty).setBackgroundResource(img);
//            ((TextView) mRootView.findViewById(R.id.tv_empty)).setText(text);
//            mRootView.findViewById(R.id.ll_empty).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onEmptyViewClick();
//                }
//            });
//        }
    }

    protected void hideEmptyView() {
//        if (emptyView != null) {
//            emptyView.setVisibility(View.GONE);
//        }
    }

    /**
     * 空页面被点击
     */
    protected void onEmptyViewClick() {

    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
