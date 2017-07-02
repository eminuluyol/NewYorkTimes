package com.taurus.newyorktimes.core;

import android.app.Application;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.taurus.newyorktimes.network.retrofit.RetrofitNewYorkTimesApi;
import com.taurus.newyorktimes.repository.NewsRepository;
import com.taurus.newyorktimes.util.navigator.Navigator;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

  @Inject
  Application application;

  @Inject
  RetrofitNewYorkTimesApi api;

  @Inject
  Navigator navigator;

  @Inject
  NewsRepository repository;

  protected CompositeDisposable compositeDisposable;

  public BasePresenter() {
    compositeDisposable = new CompositeDisposable();
  }

  public Application getApplication() {
    return application;
  }

  public RetrofitNewYorkTimesApi getApi() {
    return api;
  }

  public NewsRepository getRepository() {
    return repository;
  }

  public Navigator getNavigator() {
    return navigator;
  }

  public void clearCompositeDisposable() {

    if (compositeDisposable != null) {

      compositeDisposable.clear();
    }
  }
}
