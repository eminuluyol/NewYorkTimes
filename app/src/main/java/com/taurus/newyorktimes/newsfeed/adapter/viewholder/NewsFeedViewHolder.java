package com.taurus.newyorktimes.newsfeed.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.baseadapter.viewholder.BaseViewHolder;
import com.taurus.newyorktimes.listener.OnItemClickListener;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;

/**
 * Created by eminuluyol on 02/07/2017.
 */

public class NewsFeedViewHolder extends BaseViewHolder {

  @BindView(R.id.newsFeedImageViewHeader)
  ImageView imageViewHeader;

  @BindView(R.id.newsFeedTextViewSource)
  TextView textViewSource;

  @BindView(R.id.newsFeedTextViewMainHeadLine)
  TextView textViewMainHeadLine;

  @BindView(R.id.newsFeedTextViewSnippet)
  TextView textViewSnippet;

  private OnItemClickListener listener;
  private NewsFeedUIModel item;

  public NewsFeedViewHolder(@NonNull ViewGroup parentView, int layoutId, OnItemClickListener listener) {
    super(parentView, layoutId);

    this.listener = listener;

  }

  public void bind(NewsFeedUIModel item) {

    this.item = item;

    if(item.getImageURl() != null) {

      imageViewHeader.setVisibility(View.VISIBLE);

      Glide.with(itemView.getContext())
          .load(item.getImageURl())
          .placeholder(R.drawable.placeholder)
          .crossFade()
          .into(imageViewHeader);

      textViewSource.setVisibility(View.VISIBLE);
      textViewSource.setText(item.getSource());

    } else {

      imageViewHeader.setVisibility(View.GONE);
      textViewSource.setVisibility(View.GONE);

    }

    textViewMainHeadLine.setText(item.getMainHeadline());
    textViewSnippet.setText(item.getSnippet());

  }

  @OnClick(R.id.newsFeedLinearLayoutContainer)
  public void onViewClicked(View view) {
    view.setTag(item);
    listener.onItemClick(view);
  }
}
