package com.taurus.newyorktimes.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.taurus.newyorktimes.core.BaseFragment;
import com.taurus.newyorktimes.core.BaseSimpleActivity;

public class SplashActivity extends BaseSimpleActivity {


    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return SplashFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setupStatusBar();

    }

}