package com.forbitbd.task.ui.main.categorie;

import com.forbitbd.task.model.Category;
import com.forbitbd.task.model.Movie;

import java.util.List;

public interface CategoryContract {

    interface Presenter{
        void getCategorizedMovies(Category category);
        void getCategorizedQueryMovies(Category category, String query);
        void getCategorizedYearlyMovies(Category category, int year);
    }

    interface View{
        void renderMovies(List<Movie> movieList);
        void clearAndRenderMovies(List<Movie> movieList);
        void showProgressDialog();
        void hideProgressDialog();


    }
}
