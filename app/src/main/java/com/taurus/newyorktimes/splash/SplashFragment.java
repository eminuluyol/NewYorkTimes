package com.taurus.newyorktimes.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.core.BaseFragment;

public class SplashFragment extends BaseFragment<SplashView, SplashPresenter> implements SplashView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_splash;
    }

    @NonNull
    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getPresenter().onProgressBarShow();
        getPresenter().onNewsFeedsRequested();

    }

    @Override
    public void showLoading() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {

        progressBar.setVisibility(View.GONE);

    }
}
