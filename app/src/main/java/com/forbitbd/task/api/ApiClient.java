package com.forbitbd.task.api;

import com.forbitbd.task.model.Category;
import com.forbitbd.task.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("/movizo/categories")
    Call<List<Category>> getAllCategories();

    @GET("/movizo/categories/{cat_id}/movies")
    Call<List<Movie>> getCategorizedMovies(@Path("cat_id") String catId);

    @GET("/movizo/categories/{cat_id}/movies/{query}")
    Call<List<Movie>> getCategorizedQueryMovies(@Path("cat_id") String catId, @Path("query") String query);

    @GET("/movizo/categories/{cat_id}/movies/year/{year}")
    Call<List<Movie>> getCategorizedYearlyMovies(@Path("cat_id") String catId, @Path("year") int year);

    @GET("/movizo/movies/popular")
    Call<List<Movie>> getPopularMovies();

    @GET("/movizo/movies/featured")
    Call<List<Movie>> getFeaturedMovies();

    }

