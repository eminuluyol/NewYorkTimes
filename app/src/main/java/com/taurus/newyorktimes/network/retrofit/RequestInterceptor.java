package com.taurus.newyorktimes.network.retrofit;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by eminuluyol on 01/07/2017.
 */

public class RequestInterceptor implements Interceptor {

  private final String API_KEY = "d7d008858ee64d3fa5f8d8b6a839b435";

  @Override public Response intercept(Chain chain) throws IOException {

    Request originalRequest = chain.request();
    HttpUrl originalHttpUrl = originalRequest.url();

    HttpUrl url = originalHttpUrl.newBuilder()
        .addQueryParameter("apikey", API_KEY)
        .build();

    Request request = originalRequest.newBuilder().url(url).build();

    return chain.proceed(request);

  }
}
