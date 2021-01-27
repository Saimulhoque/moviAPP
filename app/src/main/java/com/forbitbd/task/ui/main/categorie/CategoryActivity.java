package com.forbitbd.task.ui.main.categorie;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.myplayer.MyPlayerActivity;
import com.forbitbd.myplayer.fullScreen.FullScreenPlayerActivity;
import com.forbitbd.myplayer.models.Category;
import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.task.R;

import com.forbitbd.task.utils.BaseActivity;
import com.forbitbd.task.utils.Constant;

import java.util.Calendar;
import java.util.List;


public class CategoryActivity extends BaseActivity implements MovieClickListener, CategoryContract.View , SearchView.OnQueryTextListener {

    private RadioGroup radioGroup;
    MovieAdapter adapter;
    RecyclerView recyclerView;
    private Category category;
    private CategoryPresenter mPresenter;

    private SearchView mSearchView;
    private int prevLength=0;
    private int checkedId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_category);

        mPresenter = new CategoryPresenter(this);
        this.category = (Category) getIntent().getSerializableExtra(Constant.CATEGORY);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MovieAdapter(this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        setupToolBar(R.id.toolbar);
        getSupportActionBar().setTitle(category.getName());



        radioGroup = findViewById(R.id.radio_group);
//        int year = new Date().getYear();
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);

        for (int i = 0; i < 100; i++) {
            RadioButton radioButton = new RadioButton(this);
            if (i == 0) {
                radioButton.setText("ALL");
                radioButton.setChecked(true);
            } else {
                radioButton.setText(String.valueOf(year + 1 - i));
            }

            radioButton.setGravity(Gravity.CENTER);
            radioButton.setId(i);
            radioButton.setTypeface(radioButton.getTypeface(), Typeface.BOLD);
            radioButton.setTextSize(15f);

            radioButton.setBackground(getDrawable(R.drawable.radiobutton_selector));
            radioButton.setButtonDrawable(null);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
            );
            params.rightMargin=10;
            radioButton.setLayoutParams(params);
            radioButton.setMinimumWidth(150);
            if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
                //code
                radioButton.setTextColor(getResources().getColor(R.color.black,null));
            }else{
                radioButton.setTextColor(getResources().getColor(R.color.black));
            }

            radioGroup.addView(radioButton);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CategoryActivity.this.checkedId = checkedId;

                if(checkedId!=0){
                    int y = year+1-checkedId;
                    mPresenter.getCategorizedYearlyMovies(category,y);
                }
            }
        });
        mPresenter.getCategorizedMovies(category);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search); // get my MenuItem with placeholder submenu
        mSearchView = (SearchView) item.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onMovieClick(Movie movie) {
        Intent intent = new Intent(getApplicationContext(), FullScreenPlayerActivity.class);
        intent.putExtra(Constant.MOVIE, movie);
        startActivity(intent);
    }

    @Override
    public void renderMovies(List<Movie> movieList) {
        for (Movie x : movieList) {
            adapter.addMovie(x);
        }
    }

    @Override
    public void clearAndRenderMovies(List<Movie> movieList) {
        adapter.clear();
        renderMovies(movieList);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if(prevLength==0 && checkedId==0 && newText.length()==1){
            mPresenter.getCategorizedQueryMovies(category,newText);
        }else{
            adapter.getFilter().filter(newText);
        }
        prevLength = newText.length();
        return false;
    }


}
