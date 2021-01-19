package com.forbitbd.task.ui.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.forbitbd.myplayer.models.OnlineStatus;
import com.forbitbd.task.DialogFragment;
import com.forbitbd.task.R;
import com.forbitbd.task.ui.main.MainActivity;
import com.forbitbd.task.utils.Constant;

public class LauncherActivity extends AppCompatActivity implements LauncherContract.View {


    private LauncherPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        mPresenter = new LauncherPresenter(this);
        mPresenter.getOnlineStatus();

        }

    @Override
    public void updateStatus(OnlineStatus onlineStatus) {
        if (onlineStatus.isIs_active()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }else{
            DialogFragment dialogFragment = new DialogFragment();
            dialogFragment.show(getSupportFragmentManager(),"jjkjjj");
            dialogFragment.setCancelable(false);
        }
    }
}
