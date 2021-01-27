package com.forbitbd.task.ui.main.popularVideos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.forbitbd.myplayer.MyPlayerActivity;
import com.forbitbd.myplayer.fullScreen.FullScreenPlayerActivity;
import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.task.R;

import com.forbitbd.task.utils.Constant;

import java.util.List;


public class PopularVideosFragment extends Fragment implements PopularVideosContract.View , ItemClickListener {
    RecyclerviewAdapter recyclerviewAdapter;
    RecyclerView recyclerView;
    private TextView tvTitle;

    private PopularVideosPresenter mPresenter;

    public PopularVideosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PopularVideosPresenter(this);
        recyclerviewAdapter = new RecyclerviewAdapter(getContext(),this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_videos, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
        tvTitle = view.findViewById(R.id.title);

        mPresenter.getPopularMovies();




        return view;
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }



    @Override
    public void renderMovies(List<Movie> movieList) {
        for (Movie x: movieList){
            recyclerviewAdapter.add(x);
        }
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(getContext(),FullScreenPlayerActivity.class);
        intent.putExtra(Constant.MOVIE, movie);
        startActivity(intent);
    }
}
