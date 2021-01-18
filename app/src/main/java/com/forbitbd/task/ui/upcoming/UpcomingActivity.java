package com.forbitbd.task.ui.upcoming;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.forbitbd.task.R;
import com.forbitbd.task.ui.kids.KidsActivity;
import com.forbitbd.task.ui.livetv.LiveTvActivity;
import com.forbitbd.task.ui.main.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class UpcomingActivity extends AppCompatActivity {
    UpcomingAdapter upcomingAdapter;
    RecyclerView recyclerView;
    List<Upcoming> upcomingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);

        upcomingList = new ArrayList<>();
        for (int i=0;i<0;i++){
            upcomingList.add(new Upcoming(R.drawable.slide1, "Movie "+String.valueOf(i+1)));
        }

        recyclerView = findViewById(R.id.recyclerView);
        upcomingAdapter = new UpcomingAdapter(this,upcomingList);
        recyclerView.setAdapter(upcomingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setSelectedItemId(R.id.upcoming);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.upcoming:
                        return true;

                    case R.id.livetv:
                        startActivity(new Intent(getApplicationContext(), LiveTvActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.kids:
                        startActivity(new Intent(getApplicationContext(), KidsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });
    }

    public void onBackPressed() {
        this.startActivity(new Intent(this, MainActivity.class));
        return;
    }
}