package com.taurus.newyorktimes.core.injection;

import android.app.Application;
import com.taurus.newyorktimes.network.retrofit.RetrofitNewYorkTimesApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public RetrofitNewYorkTimesApi provideNewYorkTimesApi() {
        return new RetrofitNewYorkTimesApi();
    }

}
