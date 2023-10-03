package com.example.rapidez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.rapidez.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            replaceFragment(new HomeFragment());

            binding.btm.setOnItemSelectedListener(item -> {

                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.profile:
                        replaceFragment(new ProfileFragment());
                        break;
                    case R.id.support:
                        replaceFragment(new SupportFragment());
                        break;
                    case R.id.settings:
                        replaceFragment(new SettingsFragment());
                        break;
                }

                return true;
            });
        } catch (Exception e) {
            Toast.makeText(MainActivity.this,"Fragment Error",Toast.LENGTH_SHORT).show();
        }

    }
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.fadein,
                        R.anim.fadeout

                )
                .replace(R.id.Frg_1, fragment)
                .addToBackStack(null)
                .commit();
    }
}