package com.taurus.newyorktimes.splash;

import android.util.Log;
import com.taurus.newyorktimes.core.BasePresenter;
import com.taurus.newyorktimes.core.injection.Injector;
import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.network.model.BaseRequest;
import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.articlelist.NewsFeedsRequest;
import com.taurus.newyorktimes.repository.NewsRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    NewsRepository newsRepository;

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

    void onNewsFeedsRequested(boolean onlineRequired) {

        compositeDisposable.add(newsRepository.loadNews(onlineRequired)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
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