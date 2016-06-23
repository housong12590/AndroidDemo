package com.iiseeu.demo.data.remote.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: housong
 * Date: 2016/6/22 10:14
 */
public class HttpService {

    public static final String BASE_URL = "http://gank.io/api/search/query/listview/";

    public static HttpApi newHttpApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(HttpApi.class);
    }
}
