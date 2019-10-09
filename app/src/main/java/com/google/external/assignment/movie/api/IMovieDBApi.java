package com.google.external.assignment.movie.api;

import android.database.Observable;

import com.google.external.assignment.movie.model.moviedb.Response;

import java.util.Map;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface IMovieDBApi {

    /**
     *
     * This will be used to invoke API
     *
     * @param option popular|
     * @param queryParams
     * @return
     */
    @GET("movie/{option}")
    Call<Response> GetMovieList(@Path("option") String option,
                                      @QueryMap Map<String, String> queryParams);

}
