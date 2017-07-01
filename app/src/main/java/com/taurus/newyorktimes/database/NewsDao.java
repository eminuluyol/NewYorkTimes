package com.taurus.newyorktimes.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import retrofit2.http.Query;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Dao
public interface NewsDao {

  @Query("SELECT * FROM " + Config.PLACE_MARKER_TABLE_NAME)
  Flowable<List<PlaceMarkerEntity>> getAllPlaceMarkers();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(PlaceMarkerEntity placeMarkerDatabaseModel);

  @Query("DELETE FROM " + Config.PLACE_MARKER_TABLE_NAME)
  void deleteAll();

}
