package com.google.external.assignment.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.external.assignment.movie.R;
import com.google.external.assignment.movie.model.moviedb.Movie;

import org.w3c.dom.Text;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder> {

    private List<Movie> mItems;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> items) {
        this.mContext = context;
        this.mItems = items;
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
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class MovieAdapterHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;

        public MovieAdapterHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
