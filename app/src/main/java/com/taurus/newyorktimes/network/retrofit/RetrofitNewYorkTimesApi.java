package com.taurus.newyorktimes.network.retrofit;

import com.taurus.newyorktimes.network.ApiConstants;
import com.taurus.newyorktimes.network.NewYorkTimesApi;
import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.articlelist.NewsFeedsRequest;
import io.reactivex.Flowable;

public class RetrofitNewYorkTimesApi implements NewYorkTimesApi {

    public RetrofitNewYorkTimesApi() {
    }

    @Override
    public Flowable<ArticleWrapper> getNewsFeeds(NewsFeedsRequest request) {

        NewYorkTimesService endpoints = APIRestClient.getInstanceRx().create(NewYorkTimesService.class);
        return endpoints.getNewsFeeds(request.getPage());

    }
}
