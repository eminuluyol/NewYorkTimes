package com.taurus.newyorktimes.repository.remote;

import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.network.NewYorkTimesApi;
import com.taurus.newyorktimes.network.model.BaseRequest;
import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.articlelist.NewsFeedsRequest;
import com.taurus.newyorktimes.network.retrofit.RetrofitNewYorkTimesApi;
import com.taurus.newyorktimes.repository.NewsDataSource;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Singleton
public class NewsRemoteDataSource implements NewsDataSource {

  private RetrofitNewYorkTimesApi newYorkTimesApi;

  @Inject
  public NewsRemoteDataSource(RetrofitNewYorkTimesApi newYorkTimesApi) {
    this.newYorkTimesApi = newYorkTimesApi;
  }

  @Override
  public Flowable<List<NewsEntity>> loadNews(boolean forceRemote) {

    final NewsFeedsRequest request = new NewsFeedsRequest(0);

    return newYorkTimesApi.getNewsFeeds(request).map(ArticleWrapper::createList);

  }

  @Override
  public void addPlaceMarker(NewsEntity newsDatabaseModel) {
    //Currently, we do not need this for remote source.
    throw new UnsupportedOperationException("Unsupported operation");

  }

  @Override
  public void clearData() {
    //Currently, we do not need this for remote source.
    throw new UnsupportedOperationException("Unsupported operation");
  }
}
