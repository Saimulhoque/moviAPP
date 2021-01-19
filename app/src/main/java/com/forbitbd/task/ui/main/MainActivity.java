package com.forbitbd.task.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.forbitbd.task.R;
import com.forbitbd.task.ui.kids.KidsActivity;
import com.forbitbd.task.ui.livetv.LiveTvActivity;
import com.forbitbd.task.ui.upcoming.UpcomingActivity;
import com.forbitbd.task.utils.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {

    ViewPager viewPager;
    int images[] = { R.drawable.war, R.drawable.movieth,R.drawable.war,R.drawable.movieth};
    int currentPageCounter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.slideview);
        viewPager.setAdapter(new SliderAdapter(images, MainActivity.this));

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCounter == images.length) {
                    currentPageCounter = 0;
                }
                viewPager.setCurrentItem(currentPageCounter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(), KidsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    public void onBackPressed() {
        finishAffinity();
    }
}