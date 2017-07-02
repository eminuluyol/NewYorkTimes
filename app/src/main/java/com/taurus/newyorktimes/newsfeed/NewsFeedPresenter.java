package com.taurus.newyorktimes.newsfeed;

import com.taurus.newyorktimes.baseadapter.model.GenericItem;
import com.taurus.newyorktimes.core.BasePresenter;
import com.taurus.newyorktimes.core.injection.Injector;
import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.network.model.BaseRequest;
import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.articlelist.NewsFeedsRequest;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedPresenter extends BasePresenter<NewsFeedView> {

  private int PAGE_NUMBER = 1;

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

      NewsFeedsRequest request = new NewsFeedsRequest(PAGE_NUMBER);

      getView().showProgress();

      compositeDisposable.add(getApi().getNewsFeeds(request)
          .subscribeOn(Schedulers.newThread())
          .observeOn(AndroidSchedulers.mainThread())
          .map(ArticleWrapper::createUIList)
          .subscribe(this::handleResponse, this::handleError));

  }

  private void handleResponse(List<NewsFeedUIModel> newsEntities) {


    PAGE_NUMBER++;

    if(isViewAttached()) {

      getView().dismissProgress();

    }

    if(newsEntities.size() > 0) {

      List<GenericItem> detailList = new ArrayList<>(newsEntities);

      getView().showGetNewsFeedDataSuccess(detailList);

    }

  }

  private void handleError(Throwable throwable) {

     if(isViewAttached()) {

       getView().dismissProgress();
       getView().showError(throwable.getMessage());

     }

  }
}
