package com.taurus.newyorktimes.newsfeeddetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.taurus.newyorktimes.R;
import com.taurus.newyorktimes.core.BaseFragment;
import com.taurus.newyorktimes.core.BaseSimpleFragment;
import com.taurus.newyorktimes.newsfeed.NewsFeedFragment;

/**
 * Created by eminuluyol on 02/07/2017.
 */

public class NewsFeedDetailFragment extends BaseSimpleFragment {

  private static final String EXTRA_WEB_URL = "web_url";
  private String webUrl;

  @BindView(R.id.newsFeedDetailWebView)
  WebView webView;

  @Override protected int getLayoutResId() {
    return R.layout.fragment_news_detail;
  }

  public static BaseFragment newInstance(String webUrl) {

    Bundle args = new Bundle();
    args.putString(NewsFeedDetailFragment.EXTRA_WEB_URL, webUrl);

    NewsFeedFragment fragment = new NewsFeedFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    getBundleFromArgs();

    webView.getSettings().setJavaScriptEnabled(true);
    webView.loadUrl(webUrl);
  }

  private void getBundleFromArgs() {

    Bundle args = getArguments();
    if (args == null) return;
    webUrl = args.getString(NewsFeedDetailFragment.EXTRA_WEB_URL);
  }

}
