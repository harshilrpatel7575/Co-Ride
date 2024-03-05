package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Home extends Fragment {

    TextView homeTitle;
    ImageButton settingsButton;
    Button tripProgressButton;
    static boolean tripProgress = false;

    public Home(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeTitle = (TextView) view.findViewById(R.id.homeTitle);
        settingsButton = (ImageButton) view.findViewById(R.id.settingsButton);
        tripProgressButton = (Button) view.findViewById(R.id.currentTripButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Settings.class);
                startActivity(intent);
            }
        });

        if (!tripProgress)
            tripProgressButton.setVisibility(View.INVISIBLE);
        else tripProgressButton.setVisibility(View.VISIBLE);

        tripProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tripProgressButton.getVisibility() == View.VISIBLE) {
                    Intent goToTripProgress = new Intent(getContext(), TripProgressActivity.class);
                    goToTripProgress.putExtras(MainActivity.bundle);
                    startActivity(goToTripProgress);
                }
            }
        });

        return view;
    }
}



