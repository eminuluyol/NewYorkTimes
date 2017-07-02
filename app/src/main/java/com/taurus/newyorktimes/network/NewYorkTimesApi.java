package com.taurus.newyorktimes.network;

import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.BaseRequest;
import com.taurus.newyorktimes.network.model.articlelist.NewsFeedsRequest;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface NewYorkTimesApi {

    Flowable<ArticleWrapper> getNewsFeeds(NewsFeedsRequest request);
}
