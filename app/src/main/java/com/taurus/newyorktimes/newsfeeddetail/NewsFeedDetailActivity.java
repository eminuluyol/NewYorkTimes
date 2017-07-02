package com.taurus.newyorktimes.newsfeeddetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.core.BaseFragment;
import com.taurus.newyorktimes.core.BaseSimpleActivity;


/**
 * Created by eminuluyol on 02/07/2017.
 */

public class NewsFeedDetailActivity extends BaseSimpleActivity {

  private static final String EXTRA_WEB_URL = "web_url";
  private String webUrl;

  @Nullable
  @Override
  protected BaseFragment getContainedFragment() {
    return NewsFeedDetailFragment.newInstance(webUrl);
  }

  public static Intent newIntent(Context context, String webUrl) {

    Intent intent = new Intent(context, NewsFeedDetailActivity.class);
    intent.putExtra(NewsFeedDetailActivity.EXTRA_WEB_URL, webUrl);

    return intent;
    
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    getBundleArguments();
    super.onCreate(savedInstanceState);

    setTitle(R.string.news_detail);
    setHomeAsUpEnabled(true);

  }

  private void getBundleArguments() {

    Intent extras = getIntent();

    if (extras != null) {
      webUrl = extras.getStringExtra(NewsFeedDetailActivity.EXTRA_WEB_URL);
    }

  }

}
