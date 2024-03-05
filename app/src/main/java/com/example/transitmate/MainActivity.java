package com.example.transitmate;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    static Bundle bundle;
    String selectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bundle = getIntent().getExtras();

        if (bundle != null) {
            selectFragment = bundle.getString("fragment", "home");
            if (selectFragment.equals("messages")) {
                bottomNavigationView.setSelectedItemId(R.id.messages);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, messages)
                        .commit();
            }
            else if (selectFragment.equals("start_new_trip")) {
                bottomNavigationView.setSelectedItemId(R.id.new_trip);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, newTrip)
                        .commit();
            }
        }

    }

    Messages messages = new Messages();
    Home home = new Home();
    NewTrip newTrip = new NewTrip();
    Profile profile = new Profile();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int pageID = item.getItemId();
        if (pageID == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, home)
                    .commit();
            return true;
        }
        else if (pageID == R.id.messages) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, messages)
                    .commit();
            return true;
        }
        else if (pageID == R.id.profile) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, profile)
                    .commit();
            return true;
        }
        else if (pageID == R.id.new_trip) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, newTrip)
                    .commit();
            return true;
        }
        return false;
    }
}