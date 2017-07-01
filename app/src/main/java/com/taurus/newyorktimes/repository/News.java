package com.taurus.newyorktimes.repository;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class News implements Parcelable {

  private String webURL;

  private String snippet;

  private String imageURl;

  private String authorName;

  private String source;

  private String mainHeadline;

  public News() {
  }

  protected News(Parcel in) {
    webURL = in.readString();
    snippet = in.readString();
    imageURl = in.readString();
    authorName = in.readString();
    source = in.readString();
    mainHeadline = in.readString();
  }

  public static final Creator<News> CREATOR = new Creator<News>() {
    @Override public News createFromParcel(Parcel in) {
      return new News(in);
    }

    @Override public News[] newArray(int size) {
      return new News[size];
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

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
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
    parcel.writeString(authorName);
    parcel.writeString(source);
    parcel.writeString(mainHeadline);
  }
}
