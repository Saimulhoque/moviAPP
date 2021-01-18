package com.forbitbd.task.ui.main.featured;


import com.forbitbd.task.model.Movie;

import java.util.List;

public interface FeaturedContract {

    interface Presenter{
        void getFeaturedMovies();
    }

    interface View{
        void renderMovies(List<Movie> movieList);
    }
}
