package com.forbitbd.task.ui.main.popularVideos;


import com.forbitbd.task.model.Movie;

import java.util.List;

public interface PopularVideosContract {

    interface Presenter{
        void getPopularMovies();
    }

    interface View{
        void renderMovies(List<Movie> movieList);

    }
}
