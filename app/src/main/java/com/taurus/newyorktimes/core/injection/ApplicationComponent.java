package com.taurus.newyorktimes.core.injection;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);
}

