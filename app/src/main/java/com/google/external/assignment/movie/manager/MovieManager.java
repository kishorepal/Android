package com.google.external.assignment.movie.manager;

import android.util.Log;

import com.google.external.assignment.movie.api.IMovieDBApi;
import com.google.external.assignment.movie.callback.MovieManagerCallBack;
import com.google.external.assignment.movie.model.moviedb.Response;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MovieManager extends  BaseManager {

    private MovieManagerCallBack mCallBack;

    private static final String TAG = MovieManager.class.getSimpleName();

    private static final String QUERY_PARAM_API_KEY = "api_key";
    private static final String OPTION_POPULAR = "popular";
    private static final String OPTION_TOP_RATED = "top_rated";

    public MovieManager(MovieManagerCallBack callBack) {

        this.mCallBack = callBack;
    }



    @Override
    protected String getBaseAPIUrl() {
        return "https://api.themoviedb.org/3/";
    }

    @Override
    protected String getBaseAPIKey() {
        return "da61481c696b839e4db3c86449141754";
    }

    @Override
    protected Map<Object, Object> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(QUERY_PARAM_API_KEY, getBaseAPIKey());

        return (Map)queryParams;
    }

    public void getMovieInfo() throws Exception {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseAPIUrl())
                .addConverterFactory(getConverterFactory())
                .build();


        IMovieDBApi service = retrofit.create(IMovieDBApi.class);

        Call<Response> call = service.GetMovieList("popular", (Map)getQueryParams());

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.i(TAG, "API Calling successful");
                //Timber.i("API Calling successful");
                Response aResponse = response.body();
                mCallBack.onSuccess(aResponse);
                Log.i(TAG, response.message());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e(TAG, "The API Calling failed");
                mCallBack.onError(t);
                t.printStackTrace();
            }
        });



    }



}
