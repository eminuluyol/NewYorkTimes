package com.taurus.newyorktimes.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.taurus.newyorktimes.database.model.NewsEntity;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Database(entities = NewsEntity.class, version = 1)
public abstract class NewsDb extends RoomDatabase {

  public abstract NewsDao newsDao();

}
