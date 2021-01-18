package com.forbitbd.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnentry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnentry = findViewById(R.id.entry);
        btnentry.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "You are not connected in this Network", Toast.LENGTH_SHORT).show();
    }
}