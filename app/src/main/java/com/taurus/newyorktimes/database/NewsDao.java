package com.taurus.newyorktimes.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.taurus.newyorktimes.database.model.NewsEntity;
import io.reactivex.Flowable;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Dao
public interface NewsDao {

  @Query("SELECT * FROM " + Config.NEWS_TABLE_NAME)
  Flowable<List<NewsEntity>> getAllNews();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(NewsEntity newsDataBaseModel);

  @Query("DELETE FROM " + Config.NEWS_TABLE_NAME)
  void deleteAll();

}
