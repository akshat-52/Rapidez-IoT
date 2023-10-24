package com.example.rapidez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.rapidez.databinding.ActivityLastlocationBinding;

public class LastlocationActivity extends AppCompatActivity {

    ActivityLastlocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLastlocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new MapsFragment());

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.fadein,
                        R.anim.fadeout

                )
                .replace(R.id.map_frame, fragment)
                .addToBackStack(null)
                .commit();
    }

}