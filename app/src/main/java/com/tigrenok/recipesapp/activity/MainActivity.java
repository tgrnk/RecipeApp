package com.tigrenok.recipesapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tigrenok.recipesapp.R;
import com.tigrenok.recipesapp.fragment.CategoriesFragment;
import com.tigrenok.recipesapp.fragment.AddFragment;
import com.tigrenok.recipesapp.fragment.HomeFragment;
import com.tigrenok.recipesapp.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.navHome);
        } catch (Exception e) {
            Log.e("MainActivity", "Ошибка в onCreate()", e);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if (item.getItemId() == R.id.navHome) {
                    fragment = new HomeFragment();
                } else if(item.getItemId() == R.id.navCategories){
                    fragment = new CategoriesFragment();
                } else {
                    fragment = new ProfileFragment();
                }

                try {
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLayout, fragment).commit();
                } catch (Exception e) {
                    Log.e("MainActivity", "Ошибка в onNavigationItemSelected()", e);
                }

                return true;
            }
        });
    }
}