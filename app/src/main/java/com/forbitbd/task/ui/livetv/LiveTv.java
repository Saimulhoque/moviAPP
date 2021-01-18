package com.forbitbd.task.ui.livetv;

public class LiveTv {

    Integer TvImage;
    String TvName;

    public LiveTv(Integer movieImage, String movieName) {
        TvImage = movieImage;
        TvName = movieName;
    }

    public Integer getMovieImage() {
        return TvImage;
    }

    public void setMovieImage(Integer movieImage) {
        TvImage = movieImage;
    }

    public String getMovieName() {
        return TvName;
    }

    public void setMovieName(String movieName) {
        TvName = movieName;
    }
}
