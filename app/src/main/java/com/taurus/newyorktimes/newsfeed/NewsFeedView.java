package com.taurus.newyorktimes.newsfeed;

import com.taurus.newyorktimes.baseadapter.model.GenericItem;
import com.taurus.newyorktimes.core.BaseView;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public interface NewsFeedView extends BaseView {

  void showEmptyView();

  void hideEmptyView();

  void showGetNewsFeedDataSuccess(List<GenericItem> newsFeeds);

}
