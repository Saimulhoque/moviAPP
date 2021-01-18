package com.forbitbd.task.ui.upcoming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.forbitbd.task.R;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.MyViewHolder> {

    Context context;
    List<Upcoming> upcomingList;
    LayoutInflater inflater;

    public UpcomingAdapter(Context context, List<Upcoming> upcomingList) {
        this.context = context;
        this.upcomingList = upcomingList;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.trailerlayout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Upcoming upcoming = upcomingList.get(position);
        holder.name.setText(upcoming.getMovieName());
        holder.image.setImageResource(upcoming.getMovieImage());
    }

    @Override
    public int getItemCount() {
        return upcomingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.MovieName);
            image = itemView.findViewById(R.id.MovieImage);
        }
    }
}
