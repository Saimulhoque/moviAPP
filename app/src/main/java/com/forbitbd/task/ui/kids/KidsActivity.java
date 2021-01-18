package com.forbitbd.task.ui.kids;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;


import com.forbitbd.task.R;
import com.forbitbd.task.ui.livetv.LiveTvActivity;
import com.forbitbd.task.ui.main.MainActivity;
import com.forbitbd.task.ui.upcoming.UpcomingActivity;
import com.forbitbd.task.utils.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KidsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        setupToolBar(R.id.toolbar);

        //initialize and assign variable//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);
        //Set home selected//
        bottomNavigationView.setSelectedItemId(R.id.kids);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.upcoming:
                        startActivity(new Intent(getApplicationContext(), UpcomingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.livetv:
                        startActivity(new Intent(getApplicationContext(), LiveTvActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.kids:
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