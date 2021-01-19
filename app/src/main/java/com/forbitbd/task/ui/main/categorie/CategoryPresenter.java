package com.forbitbd.task.ui.main.categorie;

import android.util.Log;


import com.forbitbd.myplayer.models.Category;
import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.task.api.ApiClient;
import com.forbitbd.task.api.ServiceGenerator;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mView;

    public CategoryPresenter(CategoryContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getCategorizedMovies(Category category) {
        mView.showProgressDialog();
        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getCategorizedMovies(category.get_id())
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        mView.hideProgressDialog();
                        if(response.isSuccessful()){
                            mView.renderMovies(response.body());

                            Log.d("UUUUUUU",response.body().size()+"");
                        }else {
                            Log.d("UUUUUUU","Errror");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        mView.hideProgressDialog();
                        Log.d("UUUUUUU","Errror "+t.getMessage());
                    }
                });
    }

    @Override
    public void getCategorizedQueryMovies(Category category, String query) {
        mView.showProgressDialog();

        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        client.getCategorizedQueryMovies(category.get_id(),query)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        mView.hideProgressDialog();
                        if(response.isSuccessful()){
                            mView.renderMovies(response.body());
                        }else {
                            Log.d("UUUUUUU","Errror");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        mView.hideProgressDialog();
                    }
                });

    }

    @Override
    public void getCategorizedYearlyMovies(Category category, int year) {
        mView.showProgressDialog();

        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        client.getCategorizedYearlyMovies(category.get_id(),year)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        mView.hideProgressDialog();

                        if(response.isSuccessful()){
                            Log.d("HHHHHHH",response.body().size()+"");
                            mView.clearAndRenderMovies(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        mView.hideProgressDialog();
                    }
                });

    }
}
