package com.taurus.newyorktimes.core.injection;
import com.taurus.newyorktimes.core.NoOpPresenter;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

}
