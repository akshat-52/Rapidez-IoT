package com.example.rapidez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Performance_load_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_load);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(Performance_load_Activity.this, Driverss_performanceActivity.class);
                startActivity(i);
            }
        }, 5000);
    }
}