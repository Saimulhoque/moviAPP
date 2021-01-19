package com.forbitbd.task.ui.main.featured;




import com.forbitbd.myplayer.models.Movie;

import java.util.List;

public interface FeaturedContract {

    interface Presenter{
        void getFeaturedMovies();
    }

    interface View{
        void renderMovies(List<Movie> movieList);
    }
}
