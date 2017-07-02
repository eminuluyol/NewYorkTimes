package com.taurus.newyorktimes.newsfeed;

import com.taurus.newyorktimes.core.BasePresenter;
import com.taurus.newyorktimes.core.injection.Injector;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedPresenter extends BasePresenter<NewsFeedView> {

  NewsFeedPresenter() {
    Injector.getInstance().getActivityComponent().inject(this);
  }

  void showEmptyView() {

    if(isViewAttached()) {
      getView().showEmptyView();
    }
  }

  void hideEmptyView() {

    if(isViewAttached()) {
      getView().hideEmptyView();
    }
  }

  void onNewsFeedListRequested() {


  }
}
