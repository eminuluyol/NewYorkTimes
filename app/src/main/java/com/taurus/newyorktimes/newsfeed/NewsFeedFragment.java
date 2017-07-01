package com.taurus.newyorktimes.newsfeed;

import android.os.Bundle;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.core.BaseFragment;
import com.taurus.newyorktimes.repository.NewsFeedUIModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedFragment extends BaseFragment<NewsFeedView,  NewsFeedPresenter>
        implements  NewsFeedView {

  private static final String EXTRA_NEWS_FEEDS = "news_feeds";

  private List<NewsFeedUIModel> newsFeeds;

  @Override protected int getLayoutResId() {
    return R.layout.fragment_news_feed;
  }

  public static NewsFeedFragment newInstance(List<NewsFeedUIModel> newsFeeds) {

    Bundle args = new Bundle();
    args.putParcelableArrayList(NewsFeedFragment.EXTRA_NEWS_FEEDS, (ArrayList<NewsFeedUIModel>) newsFeeds);

    NewsFeedFragment fragment = new NewsFeedFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public NewsFeedPresenter createPresenter() {
    return new NewsFeedPresenter();
  }

  private void getBundleFromArgs() {

    Bundle args = getArguments();
    if (args == null) return;
    newsFeeds = args.getParcelableArrayList(NewsFeedFragment.EXTRA_NEWS_FEEDS);

  }

  @Override public void showEmptyView() {

  }

  @Override public void hideEmptyView() {

  }
}
