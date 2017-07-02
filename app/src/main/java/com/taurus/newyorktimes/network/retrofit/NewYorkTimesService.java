package com.taurus.newyorktimes.network.retrofit;

import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewYorkTimesService {

  @GET("svc/search/v2/articlesearch.json")
  Flowable<ArticleWrapper> getNewsFeeds(
      @Query("page") int page
  );
}
