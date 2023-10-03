package com.example.rapidez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Load_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(Load_Activity.this, MainActivity.class);
                startActivity(i);
            }
        }, 6000);
    }
}