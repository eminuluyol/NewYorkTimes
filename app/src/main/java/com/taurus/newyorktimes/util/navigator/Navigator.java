package com.taurus.newyorktimes.util.navigator;

import android.app.Activity;
import com.taurus.newyorktimes.core.injection.ActivityScope;
import com.taurus.newyorktimes.newsfeed.NewsFeedsActivity;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;
import com.taurus.newyorktimes.newsfeeddetail.NewsFeedDetailActivity;
import java.util.List;

@ActivityScope
public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public Navigation toNewsFeedActivity(List<NewsFeedUIModel> newsFeeds) {
        return new Navigation(activity, NewsFeedsActivity.newIntent(activity, newsFeeds));
    }

    public Navigation toNewsFeedSDetailActivity(String webUrl) {
        return new Navigation(activity, NewsFeedDetailActivity.newIntent(activity, webUrl));
    }
}
