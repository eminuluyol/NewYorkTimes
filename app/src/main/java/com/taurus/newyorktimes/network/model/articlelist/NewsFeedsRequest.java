package com.taurus.newyorktimes.network.model.articlelist;

import com.taurus.newyorktimes.network.model.BaseRequest;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedsRequest extends BaseRequest {

  private int page;

  public NewsFeedsRequest(int page) {
    this.page = page;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }
}
