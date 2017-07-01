package com.taurus.newyorktimes.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRestClient {

    private static final String BASE_URL = "https://api.nytimes.com/svc/search/v2/RequestInterceptor";
    private static final int CONNECT_TIME_OUT = 10;
    private static final int READ_TIME_OUT = 15;

    public APIRestClient() {
    }

    static synchronized Retrofit getInstanceRx() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // client
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new RequestInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

    }

}