package com.taurus.newyorktimes.core.injection;
import com.taurus.newyorktimes.core.NoOpPresenter;
import com.taurus.newyorktimes.splash.SplashPresenter;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

    void inject(SplashPresenter splashPresenter);

}
