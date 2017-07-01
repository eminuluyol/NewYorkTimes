package com.taurus.newyorktimes.network.retrofit;

import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewYorkTimesService {

  @GET("/articlesearch.json") Observable<ArticleWrapper> getNewsFeeds(
      @Query("page") int page
  );
}
