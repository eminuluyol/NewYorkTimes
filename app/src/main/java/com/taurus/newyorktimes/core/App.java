package com.taurus.newyorktimes.core;

import android.app.Application;
import com.taurus.newyorktimes.core.injection.Injector;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Injector.getInstance().createApplicationScope(this);

  }
}
