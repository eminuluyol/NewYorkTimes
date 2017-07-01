package com.taurus.newyorktimes.newsfeed;

import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.core.BaseFragment;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedFragment extends BaseFragment<NewsFeedView,  NewsFeedPresenter>
        implements  NewsFeedView {

  @Override protected int getLayoutResId() {
    return R.layout.fragment_news_feed;
  }

  @Override public NewsFeedPresenter createPresenter() {
    return new NewsFeedPresenter();
  }
}
