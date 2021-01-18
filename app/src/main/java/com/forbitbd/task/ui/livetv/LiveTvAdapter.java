package com.forbitbd.task.ui.livetv;

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

public class LiveTvAdapter extends RecyclerView.Adapter<LiveTvAdapter.MyViewHolder> {
    private Context context;
    private List<LiveTv> liveTvList;
    LayoutInflater inflater;

    public LiveTvAdapter(Context context, List<LiveTv> liveTvList) {
        this.context = context;
        this.liveTvList = liveTvList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LiveTv liveTv = liveTvList.get(position);
        holder.name.setText(liveTv.getMovieName());
        holder.image.setImageResource(liveTv.getMovieImage());
    }

    @Override
    public int getItemCount() {
        return liveTvList.size();
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
