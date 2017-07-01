package com.taurus.newyorktimes.repository;

import com.taurus.newyorktimes.database.model.NewsEntity;
import io.reactivex.Flowable;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public interface NewsDataSource {

  Flowable<List<NewsEntity>> loadNews(boolean forceRemote);

  void addPlaceMarker(NewsEntity newsDatabaseModel);

  void clearData();
}
