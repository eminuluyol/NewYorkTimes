package com.taurus.newyorktimes.newsfeed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import butterknife.BindView;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.baseadapter.RecyclerAdapter;
import com.taurus.newyorktimes.baseadapter.model.GenericItem;
import com.taurus.newyorktimes.core.BaseFragment;
import com.taurus.newyorktimes.customview.EndlessRecyclerView;
import com.taurus.newyorktimes.listener.OnItemClickListener;
import com.taurus.newyorktimes.newsfeed.adapter.delegate.NewsFeedAdapterDelegate;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedFragment extends BaseFragment<NewsFeedView,  NewsFeedPresenter>
        implements  NewsFeedView, EndlessRecyclerView.OnEndReachedListener, OnItemClickListener {

  private static final String EXTRA_NEWS_FEEDS = "news_feeds";

  @BindView(R.id.newsFeedRecyclerView)
  EndlessRecyclerView newsFeedRecyclerView;

  @BindView(R.id.emptyView)
  NestedScrollView emptyView;

  private List<GenericItem> newsFeeds;
  private RecyclerAdapter newsFeedAdapter;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_news_feed;
  }

  public static NewsFeedFragment newInstance(List<NewsFeedUIModel> newsFeeds) {

    Bundle args = new Bundle();
    args.putParcelableArrayList(NewsFeedFragment.EXTRA_NEWS_FEEDS, (ArrayList<NewsFeedUIModel>) newsFeeds);

    NewsFeedFragment fragment = new NewsFeedFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public NewsFeedPresenter createPresenter() {
    return new NewsFeedPresenter();
  }


  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    getBundleFromArgs();

    if(newsFeeds.size() > 0 && newsFeeds != null) {

      newsFeedRecyclerView.setOnEndReachedListener(this);
      newsFeedRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      newsFeedAdapter = RecyclerAdapter.with(new NewsFeedAdapterDelegate(this));
      newsFeedRecyclerView.setAdapter(newsFeedAdapter);
      newsFeedAdapter.swapItems(newsFeeds);
      newsFeedRecyclerView.setLoading(false);

    }

  }

  private void getBundleFromArgs() {

    Bundle args = getArguments();
    if (args == null) return;
    newsFeeds = args.getParcelableArrayList(NewsFeedFragment.EXTRA_NEWS_FEEDS);

  }

  @Override
  public void showEmptyView() {
    emptyView.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideEmptyView() {
    emptyView.setVisibility(View.GONE);
  }

  @Override
  public void showGetNewsFeedDataSuccess(List<GenericItem> newsFeeds) {

    newsFeedRecyclerView.setLoading(false);
    newsFeedAdapter.addAll(newsFeeds);

  }

  @Override
  public void onEndReached() {

    newsFeedRecyclerView.setLoading(true);
    getPresenter().onNewsFeedListRequested();

  }

  @Override
  public void onItemClick(View view) {

  }
}
