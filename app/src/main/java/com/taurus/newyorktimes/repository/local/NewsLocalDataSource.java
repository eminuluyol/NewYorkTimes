package com.taurus.newyorktimes.repository.local;

import android.arch.persistence.room.Room;
import android.content.Context;
import com.taurus.newyorktimes.database.Config;
import com.taurus.newyorktimes.database.NewsDao;
import com.taurus.newyorktimes.database.NewsDb;
import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.repository.NewsDataSource;
import io.reactivex.Flowable;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsLocalDataSource implements NewsDataSource {

  private NewsDao newsDao;

  public NewsLocalDataSource(Context context) {

    NewsDb newsDb = Room.databaseBuilder(context, NewsDb.class, Config.DATABASE_NAME).build();
    this.newsDao = newsDb.newsDao();

  }

  @Override public Flowable<List<NewsEntity>> loadNews(boolean forceRemote) {
    return newsDao.getAllNews();

  }

  @Override public void addPlaceMarker(NewsEntity newsDatabaseModel) {
    newsDao.insert(newsDatabaseModel);
  }

  @Override public void clearData() {
    newsDao.deleteAll();
  }
}
