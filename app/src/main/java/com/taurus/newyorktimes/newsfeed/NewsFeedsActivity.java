package com.taurus.newyorktimes.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.core.BaseFragment;
import com.taurus.newyorktimes.core.BaseSimpleActivity;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedsActivity extends BaseSimpleActivity {

  private static final String EXTRA_NEWS_FEEDS = "news_feeds";

  private List<NewsFeedUIModel> newsFeeds;

  @Nullable
  @Override protected BaseFragment getContainedFragment() {
    return NewsFeedFragment.newInstance(newsFeeds);
  }

  public static Intent newIntent(Context context, List<NewsFeedUIModel> newsFeeds) {

    Intent intent = new Intent(context, NewsFeedsActivity.class);
    intent.putParcelableArrayListExtra(NewsFeedsActivity.EXTRA_NEWS_FEEDS, new ArrayList<>(newsFeeds));

    return intent;

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    getBundleArguments();
    super.onCreate(savedInstanceState);

    setTitle(R.string.news_feeds_title);

  }

  private void getBundleArguments() {

    Intent extras = getIntent();

    if (extras != null) {
      newsFeeds = extras.getParcelableArrayListExtra(NewsFeedsActivity.EXTRA_NEWS_FEEDS);
    }

  }

}
