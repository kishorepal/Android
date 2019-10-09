package com.google.external.assignment.movie.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.external.assignment.movie.R;
import com.google.external.assignment.movie.common.utilities.PicassoUtility;
import com.google.external.assignment.movie.model.moviedb.Movie;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder> {


    private List<Movie> mItems = new ArrayList<>();
    private Context mContext;

    public MovieAdapter(Context context) {
        this.mContext = context;
       //this.mItems = items;
    }

    @NonNull
    @Override
    public MovieAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_row, viewGroup, false);
        return new MovieAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterHolder movieAdapterHolder, int position) {
        movieAdapterHolder.txtTitle.setText(mItems.get(position).getTitle());
        PicassoUtility.getInstance(mContext).loadImage(mItems.get(position).getPosterPath(), movieAdapterHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public void setMovies(List<Movie> movies) {
        this.mItems = movies;
        notifyDataSetChanged();
    }

    public class MovieAdapterHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        ImageView imageView;

        public MovieAdapterHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imageView = itemView.findViewById(R.id.img_poster);
        }
    }
}
