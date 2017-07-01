package com.taurus.newyorktimes.core;

import android.app.Application;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.taurus.newyorktimes.network.retrofit.RetrofitNewYorkTimesApi;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    @Inject
    Application application;

    @Inject RetrofitNewYorkTimesApi api;

    protected CompositeDisposable compositeDisposable;

    public BasePresenter(){
        compositeDisposable = new CompositeDisposable();
    }

    public Application getApplication() {
        return application;
    }

    public RetrofitNewYorkTimesApi getApi() {
        return api;
    }

    public void clearCompositeDisposable() {

        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
    }

}
