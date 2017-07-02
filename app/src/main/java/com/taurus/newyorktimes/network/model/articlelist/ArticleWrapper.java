
package com.taurus.newyorktimes.network.model.articlelist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.taurus.newyorktimes.database.model.NewsEntity;
import com.taurus.newyorktimes.network.ApiConstants;
import com.taurus.newyorktimes.newsfeed.adapter.model.NewsFeedUIModel;
import com.taurus.newyorktimes.util.ListConverter;
import java.util.List;

public class ArticleWrapper {

    @SerializedName("response")
    @Expose
    private Response response;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("copyright")
    @Expose
    private String copyright;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public static List<NewsFeedUIModel> createUIList(ArticleWrapper articleWrapper) {
        return ListConverter.convert(articleWrapper.getResponse().getDocs(), item -> createUIFeeds(item));
    }

    private static NewsFeedUIModel createUIFeeds(Doc item) {

        final NewsFeedUIModel model = new NewsFeedUIModel();

        model.setWebURL(item.getWebUrl());
        model.setSnippet(item.getSnippet());
        model.setImageURl(addImageUrl(item));
        model.setSource(item.getSource());
        model.setMainHeadline(item.getHeadline().getMain());

        return model;
    }

    public static List<NewsEntity> createList(ArticleWrapper articleWrapper) {
        return ListConverter.convert(articleWrapper.getResponse().getDocs(), item -> create(item));
    }

    private static NewsEntity create(Doc item) {

        final NewsEntity model = new NewsEntity();

        model.setWebURL(item.getWebUrl());
        model.setSnippet(item.getSnippet());
        model.setImageURl(addImageUrl(item));
        model.setSource(item.getSource());
        model.setMainHeadline(item.getHeadline().getMain());

        return model;
    }

    private static String addImageUrl(Doc item) {

        if(item.getMultimedia().size() > 0) {

           String url = item.getMultimedia().get(0).getUrl();

            return ApiConstants.IMAGE_ENDPOINT_PREFIX + url;

        }

        return null;
    }
}
