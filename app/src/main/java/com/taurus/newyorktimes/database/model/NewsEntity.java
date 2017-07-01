package com.taurus.newyorktimes.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.taurus.newyorktimes.database.Config;
import com.taurus.newyorktimes.network.model.articlelist.ArticleWrapper;
import com.taurus.newyorktimes.network.model.articlelist.Doc;
import com.taurus.newyorktimes.repository.NewsFeedUIModel;
import com.taurus.newyorktimes.util.ListConverter;
import java.util.List;

/**
 * Created by eminuluyol on 01/07/2017.
 */

@Entity(tableName = Config.NEWS_TABLE_NAME)
public class NewsEntity {

  @PrimaryKey(autoGenerate = true)
  private int id;

  private String webURL;

  private String snippet;

  private String imageURl;

  private String authorName;

  private String source;

  private String mainHeadline;

  public NewsEntity() {
  }

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

  public static List<NewsFeedUIModel> createList(List<NewsEntity> news) {
    return ListConverter.convert(news, item -> create(item));
  }

  private static NewsFeedUIModel create(NewsEntity item) {

    final NewsFeedUIModel model = new NewsFeedUIModel();

    model.setWebURL(item.getWebURL());
    model.setSnippet(item.getSnippet());
    model.setImageURl(item.getImageURl());
    model.setAuthorName(item.getAuthorName());
    model.setSource(item.getSource());
    model.setMainHeadline(item.getMainHeadline());

    return model;
  }

}
