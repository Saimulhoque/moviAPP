package com.forbitbd.task.ui.main.popularVideos;




import com.forbitbd.myplayer.models.Movie;

import java.util.List;

public interface PopularVideosContract {

    interface Presenter{
        void getPopularMovies();
    }

    interface View{
        void renderMovies(List<Movie> movieList);

    }
}
