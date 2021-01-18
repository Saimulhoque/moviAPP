package com.forbitbd.task.ui.main.featured;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.myplayer.MyPlayerActivity;
import com.forbitbd.task.R;
import com.forbitbd.task.model.Movie;
import com.forbitbd.task.ui.main.popularVideos.ItemClickListener;
import com.forbitbd.task.ui.main.popularVideos.RecyclerviewAdapter;
import com.forbitbd.task.utils.Constant;

import java.util.List;


public class FeaturedFragment extends Fragment implements FeaturedContract.View, ItemClickListener {

    RecyclerviewAdapter recyclerviewAdapter;
    RecyclerView recyclerView;
    private TextView tvTitle;

    private FeaturedPresenter mPresenter;



    public FeaturedFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new FeaturedPresenter(this);
        recyclerviewAdapter = new RecyclerviewAdapter(getContext(),this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
        tvTitle = view.findViewById(R.id.title);

        mPresenter.getFeaturedMovies();
    }

    @Override
    public void renderMovies(List<Movie> movieList) {
        for (Movie x:movieList){
            recyclerviewAdapter.add(x);
        }
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(getContext(), MyPlayerActivity.class);
        intent.putExtra(Constant.VIDEO_URL, movie.getVideo_url());
        startActivity(intent);
    }
}