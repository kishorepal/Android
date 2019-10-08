package com.google.external.assignment.movie.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.external.assignment.movie.R;
import com.google.external.assignment.movie.adapter.MovieAdapter;
import com.google.external.assignment.movie.callback.MovieManagerCallBack;
import com.google.external.assignment.movie.manager.MovieManager;
import com.google.external.assignment.movie.model.moviedb.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private Button btnApiInvoke;

    private RecyclerView listMovie;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void init() {

        listMovie = (RecyclerView)findViewById(R.id.list_movie);
        MovieManager movieManager = new MovieManager(movieManagerCallBack);
        try {
            movieManager.getMovieInfo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }


    private  MovieManagerCallBack movieManagerCallBack = new MovieManagerCallBack() {
        @Override
        public void onSuccess(Response response) {
            Log.i(TAG, "OnSuccess Callback invoked");
            MovieAdapter aAdapter = new MovieAdapter(MainActivity.this.getApplicationContext(), response.getDetailsResult());
            listMovie.setAdapter(aAdapter);
            listMovie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }

        @Override
        public void onError(Throwable t) {

        }
    };
}
