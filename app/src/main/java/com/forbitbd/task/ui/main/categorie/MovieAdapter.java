package com.forbitbd.task.ui.main.categorie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.task.R;
import com.forbitbd.task.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private List<Movie> movieList;
    private List<Movie> originalList;
    LayoutInflater inflater;
    private MovieClickListener listener;

    public MovieAdapter(Context context, MovieClickListener listener) {
        this.context = context;
        this.movieList = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public void addMovie(Movie movie){
        if(!exist(movie)){
            movieList.add(movie);
            int position = movieList.indexOf(movie);
            notifyItemInserted(position);
        }

    }

    public void clear(){
        this.movieList.clear();
        notifyDataSetChanged();
    }

    private boolean exist(Movie movie){
        for (Movie x: movieList){
            if(x.get_id().equals(movie.get_id())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Filter getFilter() {
        if(originalList==null){
            originalList = movieList;
        }

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                List<Movie> filteredList = new ArrayList<>();

                if(charString.isEmpty()){
                    filteredList = originalList;
                }else{
                    for (Movie x: originalList){
                        if(x.getTitle().toLowerCase().startsWith(charString.toLowerCase())){
                            filteredList.add(x);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values=filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                movieList = (List<Movie>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.MovieName);
            image = itemView.findViewById(R.id.MovieImage);
            itemView.setOnClickListener(this);
        }

        public void bind(Movie movie){
            name.setText(movie.getTitle());
            if(movie.getImage_url()!=null || !movie.getImage_url().equals("")){
                Picasso.get().load(movie.getImage_url()).into(image);
            }
        }

        @Override
        public void onClick(View v) {
            listener.onMovieClick(movieList.get(getAdapterPosition()));
        }
    }
}
