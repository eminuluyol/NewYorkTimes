package com.taurus.newyorktimes.newsfeed.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.baseadapter.BaseAdapterDelegate;
import com.taurus.newyorktimes.baseadapter.model.GenericItem;
import com.taurus.newyorktimes.listener.OnItemClickListener;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;
import com.taurus.newyorktimes.newsfeed.adapter.viewholder.NewsFeedViewHolder;
import java.util.List;

/**
 * Created by eminuluyol on 02/07/2017.
 */

public class NewsFeedAdapterDelegate
    extends BaseAdapterDelegate<NewsFeedUIModel, GenericItem, NewsFeedViewHolder> {

  public NewsFeedAdapterDelegate(OnItemClickListener listener) {
    setOnItemClickListener(listener);
  }

  @Override
  protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
    return item instanceof NewsFeedUIModel;
  }

  @NonNull @Override protected NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
    return new NewsFeedViewHolder(parent, R.layout.news_feed_list_item, getOnItemClickListener());
  }

  @Override protected void onBindViewHolder(@NonNull NewsFeedUIModel item,
      @NonNull NewsFeedViewHolder viewHolder, @NonNull List<Object> payloads) {
    viewHolder.bind(item);
  }

}
