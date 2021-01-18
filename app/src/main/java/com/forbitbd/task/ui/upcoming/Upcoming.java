package com.forbitbd.task.ui.upcoming;

public class Upcoming {
    Integer MovieImage;
    String MovieName;

    public Upcoming(Integer movieImage, String movieName) {
        MovieImage = movieImage;
        MovieName = movieName;
    }

    public Integer getMovieImage() {
        return MovieImage;
    }

    public void setMovieImage(Integer movieImage) {
        MovieImage = movieImage;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }
}
