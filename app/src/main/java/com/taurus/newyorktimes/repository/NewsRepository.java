package com.taurus.newyorktimes.repository;

import com.taurus.newyorktimes.database.model.NewsEntity;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Singleton;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Singleton
public class NewsRepository implements NewsDataSource {

  private NewsDataSource remoteDataSource;
  private NewsDataSource localDataSource;


  @Override public Flowable<List<NewsEntity>> loadNews(boolean forceRemote) {
    return null;
  }

  @Override public void addPlaceMarker(NewsEntity newsDatabaseModel) {

  }

  @Override public void clearData() {

  }
}
