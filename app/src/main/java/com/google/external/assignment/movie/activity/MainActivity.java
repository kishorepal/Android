package com.google.external.assignment.movie.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.external.assignment.movie.R;
import com.google.external.assignment.movie.adapter.MovieAdapter;
import com.google.external.assignment.movie.callback.MovieManagerCallBack;
import com.google.external.assignment.movie.fragments.BaseFragment;
import com.google.external.assignment.movie.fragments.MovieFragment;
import com.google.external.assignment.movie.manager.MovieManager;
import com.google.external.assignment.movie.model.moviedb.Movie;
import com.google.external.assignment.movie.model.moviedb.Response;
import com.google.external.assignment.movie.viewmodel.MovieViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    public static final String MOVIES_FRAGMENT_TAG = "MOVIE_CONTAINER";


    private RecyclerView listMovie;
    private MovieViewModel movieViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        BaseFragment mFragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(MOVIES_FRAGMENT_TAG);
        if (mFragment == null)
            replaceFragment(new MovieFragment());
    }

    private void init() {

//        listMovie = (RecyclerView)findViewById(R.id.list_movie);
//        listMovie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        listMovie.setHasFixedSize(true);
//        final MovieAdapter aAdapter = new MovieAdapter(MainActivity.this.getApplicationContext());
//        listMovie.setAdapter(aAdapter);
//        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
//        movieViewModel.getMovieList().observe(this, new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(List<Movie> movies) {
//                aAdapter.setMovies(movies);
//            }
//        });
//
//        movieViewModel.getSortOption().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String option) {
//                 getSupportActionBar().setTitle(option);
//            }
//        });

     }

    public void replaceFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.movies_container, fragment, MOVIES_FRAGMENT_TAG)
                .commit();
    }


    @Override
    public void onBackPressed() {

        BaseFragment f = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.movies_container);
        if (f instanceof MovieFragment ) {//the fragment on which you want to handle your back press
            Log.i("BACK PRESSED", "BACK PRESSED");
        }else{
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
}
