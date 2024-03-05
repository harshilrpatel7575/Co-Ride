package com.example.transitmate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RateTripActivity extends AppCompatActivity {

    Button submit, cad5, cad10, cad15;
    ImageButton star1, star2, star3, star4, star5;
    EditText customTip, comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_trip);

        submit = (Button) findViewById(R.id.submitRatingButton);
        cad5 = (Button) findViewById(R.id.cad5);
        cad10 = (Button) findViewById(R.id.cad10);
        cad15 = (Button) findViewById(R.id.cad15);
        star1 = (ImageButton) findViewById(R.id.star1);
        star2 = (ImageButton) findViewById(R.id.star2);
        star3 = (ImageButton) findViewById(R.id.star3);
        star4 = (ImageButton) findViewById(R.id.star4);
        star5 = (ImageButton) findViewById(R.id.star5);
        customTip = (EditText) findViewById(R.id.customTip);
        comments = (EditText) findViewById(R.id.comments);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(Color.argb(255, 255, 255, 0));
                star2.setColorFilter(Color.argb(0, 255, 255, 0));
                star3.setColorFilter(Color.argb(0, 255, 255, 0));
                star4.setColorFilter(Color.argb(0, 255, 255, 0));
                star5.setColorFilter(Color.argb(0, 255, 255, 0));
            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(Color.argb(255, 255, 255, 0));
                star2.setColorFilter(Color.argb(255, 255, 255, 0));
                star3.setColorFilter(Color.argb(0, 255, 255, 0));
                star4.setColorFilter(Color.argb(0, 255, 255, 0));
                star5.setColorFilter(Color.argb(0, 255, 255, 0));
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(Color.argb(255, 255, 255, 0));
                star2.setColorFilter(Color.argb(255, 255, 255, 0));
                star3.setColorFilter(Color.argb(255, 255, 255, 0));
                star4.setColorFilter(Color.argb(0, 255, 255, 0));
                star5.setColorFilter(Color.argb(0, 255, 255, 0));
            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(Color.argb(255, 255, 255, 0));
                star2.setColorFilter(Color.argb(255, 255, 255, 0));
                star3.setColorFilter(Color.argb(255, 255, 255, 0));
                star4.setColorFilter(Color.argb(255, 255, 255, 0));
                star5.setColorFilter(Color.argb(0, 255, 255, 0));
            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(Color.argb(255, 255, 255, 0));
                star2.setColorFilter(Color.argb(255, 255, 255, 0));
                star3.setColorFilter(Color.argb(255, 255, 255, 0));
                star4.setColorFilter(Color.argb(255, 255, 255, 0));
                star5.setColorFilter(Color.argb(255, 255, 255, 0));
            }
        });

        cad5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customTip.setText("5");
            }
        });

        cad10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customTip.setText("10");
            }
        });

        cad15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customTip.setText("15");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateTripActivity.this, "Feedback Submitted. Trip Ended!", Toast.LENGTH_SHORT).show();
                Home.tripProgress = false;
                Messages.chatList.clear();
                startActivity(new Intent(RateTripActivity.this, MainActivity.class));
            }
        });

    }
}