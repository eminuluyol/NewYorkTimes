package com.taurus.newyorktimes.core.injection;

import android.app.Application;
import com.taurus.newyorktimes.network.NewYorkTimesApi;
import com.taurus.newyorktimes.network.retrofit.RetrofitNewYorkTimesApi;
import com.taurus.newyorktimes.repository.NewsRepository;
import com.taurus.newyorktimes.repository.local.NewsLocalDataSource;
import com.taurus.newyorktimes.repository.remote.NewsRemoteDataSource;
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

    @Provides
    @Singleton
    public NewsLocalDataSource provideLocalDataSource() {
        return new NewsLocalDataSource(application);
    }

    @Provides
    @Singleton
    public NewsRemoteDataSource provideRemoteDataSource(RetrofitNewYorkTimesApi newYorkTimesApi) {
        return new NewsRemoteDataSource(newYorkTimesApi);
    }

    @Provides
    @Singleton
    public NewsRepository providePlaceMarkerRepository(NewsLocalDataSource local,
        NewsRemoteDataSource remote) {
        return new NewsRepository(local, remote);
    }


}
