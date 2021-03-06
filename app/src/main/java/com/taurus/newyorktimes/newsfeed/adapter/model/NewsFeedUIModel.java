package com.taurus.newyorktimes.newsfeed.adapter.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taurus.newyorktimes.baseadapter.model.GenericItem;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class NewsFeedUIModel extends GenericItem implements Parcelable {

  private String webURL;

  private String snippet;

  private String imageURl;

  private String source;

  private String mainHeadline;

  public NewsFeedUIModel() {
  }

  protected NewsFeedUIModel(Parcel in) {
    webURL = in.readString();
    snippet = in.readString();
    imageURl = in.readString();
    source = in.readString();
    mainHeadline = in.readString();
  }

  public static final Creator<NewsFeedUIModel> CREATOR = new Creator<NewsFeedUIModel>() {
    @Override public NewsFeedUIModel createFromParcel(Parcel in) {
      return new NewsFeedUIModel(in);
    }

    @Override public NewsFeedUIModel[] newArray(int size) {
      return new NewsFeedUIModel[size];
    }
  };

  public String getWebURL() {
    return webURL;
  }

  public void setWebURL(String webURL) {
    this.webURL = webURL;
  }

  public String getSnippet() {
    return snippet;
  }

  public void setSnippet(String snippet) {
    this.snippet = snippet;
  }

  public String getImageURl() {
    return imageURl;
  }

  public void setImageURl(String imageURl) {
    this.imageURl = imageURl;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getMainHeadline() {
    return mainHeadline;
  }

  public void setMainHeadline(String mainHeadline) {
    this.mainHeadline = mainHeadline;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(webURL);
    parcel.writeString(snippet);
    parcel.writeString(imageURl);
    parcel.writeString(source);
    parcel.writeString(mainHeadline);
  }
}
