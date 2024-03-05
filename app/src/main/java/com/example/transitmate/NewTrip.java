package com.example.transitmate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NewTrip extends Fragment {

    TextView newTripTitle;

    Button passengerButton;
    Button drivButton;
    public NewTrip(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_trip, container, false);

        newTripTitle = (TextView) view.findViewById(R.id.newTripTitle);
        passengerButton=view.findViewById(R.id.passengerButton);
        drivButton=view.findViewById(R.id.button666);

        passengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the new method to navigate to TripPassengerFragment
                TripPassengerFragment tripPassengerFragment = new TripPassengerFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, tripPassengerFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        drivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DriverFragment dr = new DriverFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, dr);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



        return view;
    }


}


