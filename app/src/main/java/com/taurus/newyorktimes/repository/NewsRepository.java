package com.taurus.newyorktimes.repository;

import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.repository.local.NewsLocalDataSource;
import com.taurus.newyorktimes.repository.remote.NewsRemoteDataSource;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Singleton
public class NewsRepository implements NewsDataSource {

  private NewsDataSource remoteDataSource;
  private NewsDataSource localDataSource;

  @Inject
  public NewsRepository(NewsLocalDataSource localDataSource, NewsRemoteDataSource remoteDataSource) {
    this.localDataSource = localDataSource;
    this.remoteDataSource = remoteDataSource;
  }

  @Override
  public Flowable<List<NewsEntity>> loadNews(boolean forceRemote) {

    if (forceRemote) {

      return remoteDataSource.loadNews(true).doOnEach(notification -> {
        // Save new data to local data source
        List<NewsEntity> list = notification.getValue();
        if (list != null && !list.isEmpty()) {
          saveDataToLocal(list);
        }
      });

    } else {
      return localDataSource.loadNews(false);
    }

  }

  @Override
  public void addPlaceMarker(NewsEntity newsDatabaseModel) {

  }

  @Override
  public void clearData() {

  }

  // A helper method to save data in database after fetching new data from remote source.
  private void saveDataToLocal(List<NewsEntity> newsEntities) {
    // Clear old data
    localDataSource.clearData();
    for (NewsEntity newsEntity : newsEntities) {
      localDataSource.addPlaceMarker(newsEntity);
    }
  }


}
