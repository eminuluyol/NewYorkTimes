package com.taurus.newyorktimes.splash;

import com.taurus.newyorktimes.core.BasePresenter;
import com.taurus.newyorktimes.core.injection.Injector;
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

    void onCardFeedsRequested() {

        final BaseRequest request = new BaseRequest();

        compositeDisposable.add(getApi().getCarFeeds(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PlaceMarkerDatabaseModel::createList)
                .subscribe(this::handleResponse, this::handleError));

    }

    private void handleResponse(List<PlaceMarkerDatabaseModel> placeMarkers) {

        if(placeMarkers.size() > 0) {

            compositeDisposable.add(Observable.fromCallable(() -> getDatabaseHandler().addAllPlaceMarkers(placeMarkers))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleDBResponse, this::handleError));

        }

    }

    private void handleDBResponse(List<PlaceMarkerDatabaseModel> placeMarkers) {

        onProgressBarHide();
        onPlaceMarkerActivityRequested(placeMarkers);

    }

    private void onPlaceMarkerActivityRequested(List<PlaceMarkerDatabaseModel> placeMarkers) {
        getNavigator().toPlaceMarkerActivity(placeMarkers).clearBackStack().navigate();
    }


    private void handleError(Throwable throwable) {

        onProgressBarHide();
        List<PlaceMarkerDatabaseModel> placeMarkers = getDatabaseHandler().getAllPlaceMarkers();

        if(placeMarkers.size() > 0) {
            getNavigator().toPlaceMarkerActivity(placeMarkers).clearBackStack().navigate();
        } else {

            if(isViewAttached()) {
                getView().showError(throwable.getMessage());
            }

        }

    }

}