package com.example.testmoviedb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public ArrayList<MovieModel> movieModels;
    Context context;

    public MovieAdapter(ArrayList<MovieModel> movieModels, Context context) {
        this.movieModels = movieModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvOriginalTitle.setText(movieModels.get(position).getOriginal_title());
        holder.tvRealeseDate.setText(movieModels.get(position).getRelease_date());
        String url = movieModels.get(position).getPoster_path();
        Glide.with(context)
                .load(url)
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return (movieModels != null) ? movieModels.size() : 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvOriginalTitle, tvRealeseDate;
        CardView cvMovie;
        ImageView ivPoster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOriginalTitle = itemView.findViewById(R.id.tv_original_title);
            tvRealeseDate = itemView.findViewById(R.id.tv_realese_date);
            cvMovie = itemView.findViewById(R.id.cv_movie);
            ivPoster = itemView.findViewById(R.id.iv_poster);
        }
    }
}
