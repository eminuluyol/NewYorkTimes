package com.taurus.newyorktimes.splash;

import com.taurus.newyorktimes.core.BasePresenter;
import com.taurus.newyorktimes.core.injection.Injector;
import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.network.model.BaseRequest;
import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.articlelist.NewsFeedsRequest;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class SplashPresenter extends BasePresenter<SplashView> {

    SplashPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    void onProgressBarShow() {

        if(isViewAttached()) {

            getView().showLoading();
        }
    }

    void onProgressBarHide() {

        if(isViewAttached()) {

            getView().hideLoading();
        }
    }

    void onNewsFeedsRequested() {

        final NewsFeedsRequest request = new NewsFeedsRequest(0);

        compositeDisposable.add(getApi().getNewsFeeds(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ArticleWrapper::createList)
                .subscribe(this::handleResponse, this::handleError));

    }

    private void handleResponse(List<NewsEntity> news) {

        onNewsFeedsActivityRequested(news);

    }


    private void onNewsFeedsActivityRequested(List<NewsEntity> news) {
        getNavigator().toPlaceMarkerActivity(NewsEntity.createList(news)).clearBackStack().navigate();
    }


    private void handleError(Throwable throwable) {

        onProgressBarHide();
        getView().showError(throwable.getMessage());

    }

}