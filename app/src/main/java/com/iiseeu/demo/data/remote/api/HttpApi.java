package com.iiseeu.demo.data.remote.api;

import com.iiseeu.demo.model.Gank;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author: housong
 * Date: 2016/6/22 10:07
 */
public interface HttpApi {

    @GET("category/{type}/count/{count}/page/{page}")
    Observable<Gank> getMeizi(@Path("type") String type, @Path("count") int count, @Path("page") int page);
}
