package com.taurus.newyorktimes.util.navigator;

import android.app.Activity;
import com.taurus.newyorktimes.core.injection.ActivityScope;
import com.taurus.newyorktimes.newsfeed.NewsFeedsActivity;
import com.taurus.newyorktimes.repository.NewsFeedUIModel;
import java.util.List;

@ActivityScope
public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public Navigation toPlaceMarkerActivity(List<NewsFeedUIModel> newsFeeds) {
        return new Navigation(activity, NewsFeedsActivity.newIntent(activity, newsFeeds));
    }
}
