package com.example.transitmate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class selectDriverActivity extends AppCompatActivity {

    private static final float MIN_DISTANCE = 250;
    float x1, x2;
    int i;
    Context context;
    Bundle textInfo;
    boolean swapped = false;
    DriverProfile d1, d2, d3;
    TextView driverReviews, subtitleDriver, driverName, passDriven, tripsDriver, startLocText, endLocText, dateTimeText, carTypeText, seatsText, costText, homeLocText, genderText, musicText, talksText, occupationText, i1, i2, i3, i4, i5, q1, q2, a1, a2, bio, purposeOfTravel;
    ImageView driverImageView;
    DriverProfile[] drivers;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_driver);

        back = (ImageButton) findViewById(R.id.backButtonSelectDriver);
        driverImageView = (ImageView) findViewById(R.id.driverImageView);
        driverReviews = (TextView) findViewById(R.id.driverReviews);
        subtitleDriver = (TextView) findViewById(R.id.subtitleDriver);
        driverName = (TextView) findViewById(R.id.driverName);
        passDriven = (TextView) findViewById(R.id.passDriven);
        tripsDriver = (TextView) findViewById(R.id.tripsDriver);
        startLocText = (TextView) findViewById(R.id.startLocText);
        endLocText = (TextView) findViewById(R.id.endLocText);
        dateTimeText = (TextView) findViewById(R.id.dateTimeText);
        carTypeText = (TextView) findViewById(R.id.carTypeText);
        seatsText = (TextView) findViewById(R.id.seatsText);
        costText = (TextView) findViewById(R.id.costText);
        homeLocText = (TextView) findViewById(R.id.homeLocText);
        genderText = (TextView) findViewById(R.id.genderText);
        musicText = (TextView) findViewById(R.id.musicText);
        talksText = (TextView) findViewById(R.id.talksText);
        occupationText = (TextView) findViewById(R.id.occupationText);
        i1 = (TextView) findViewById(R.id.Interest1);
        i2 = (TextView) findViewById(R.id.Interest2);
        i3 = (TextView) findViewById(R.id.Interest3);
        i4 = (TextView) findViewById(R.id.Interest4);
        i5 = (TextView) findViewById(R.id.Interest5);
        q1 = (TextView) findViewById(R.id.q1);
        q2 = (TextView) findViewById(R.id.q2);
        a1 = (TextView) findViewById(R.id.a1);
        a2 = (TextView) findViewById(R.id.a2);
        bio = (TextView) findViewById(R.id.Bio);
        purposeOfTravel = (TextView) findViewById(R.id.purposeOfTrip);
        context = this.getApplicationContext();
        i = 0;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToPassenger = new Intent(selectDriverActivity.this, MainActivity.class);
                Bundle info = new Bundle();
                info.putString("fragment", "start_new_trip");
                backToPassenger.putExtras(info);
                startActivity(backToPassenger);
            }
        });

        d1 = new DriverProfile(
                "Rio Asher",
                "lenny",
                "1255 International Mews, Kelowna",
                "919 Burrard St, Vancouver",
                TripPassengerFragment.dateEditText.getText().toString(),
                "4:00 pm",
                "Toyota Corolla",
                "Kelowna, BC",
                "Male",
                "Just a dad who loves going on trips and surfing!",
                "Need to meet relatives who just moved to Vancouver from the US.",
                "What is your favouite quote?",
                "You are never wrong to do the right thing.",
                "What's your favourite band?",
                "Queen",
                "Kareoke",
                "Hiking",
                "Surfing",
                "Movies",
                "Chess",
                "2021",
                "Manager at Walmart",
                4,
                104,
                84,
                122,
                4,
                75,
                true,
                true
        );
        d2 = new DriverProfile(
                "Marlin Kutler",
                "marlin",
                "1255 International Mews, Kelowna",
                "1420, Prince Edward St, Vancouver",
                TripPassengerFragment.dateEditText.getText().toString(),
                "1:00 pm",
                "Tesla Model S",
                "Kelowna, BC",
                "Male",
                "Love travelling, hiking, and listening to music. I can cook you a mean turkey dinner. Ask me about my playlists!",
                "Just visiting Vancouver for a vacation from Kelowna - I need some night life!",
                "Who is your favourite celebrity",
                "I have to go with the King of Bollywood - Shah Rukh Khan",
                "What is your dream house?",
                "I would love to live in a farmhouse surrounded by animals. I love RDJ's house!",
                "Cooking",
                "Painting",
                "Films",
                "Birds",
                "Cats",
                "2021",
                "Software Engineer at Google",
                4,
                67,
                80,
                89,
                3,
                80,
                false,
                true
        );
        d3 = new DriverProfile(
                "Irena Drago",
                "irena",
                "935 Academic Way, Kelowna",
                "1455 Quebec St, Vancouver",
                TripPassengerFragment.dateEditText.getText().toString(),
                "1:30 pm",
                "Toyota Prius",
                "Kelowna, BC",
                "Other",
                "Singing my heart out! Music lover, aspiring artist, and all-around dreamer. Tag along for the ride!",
                "Need to attend an important family event",
                "What is your favourite quote?",
                "Be the change you want to see in the world",
                "Who is your favourite celebrity?",
                "Taylor Swift moves me.",
                "Singing",
                "Drives",
                "Cooking",
                "Soccer",
                "Piano",
                "2023",
                "Tutor at UBCO",
                4,
                22,
                23,
                30,
                4,
                60,
                true,
                true
        );
        drivers = new DriverProfile[]{d1, d2, d3};

        setDriverProfile(i);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        this.onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (swapped) {
            swapped = false;
            return super.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (i >= drivers.length) {
                        showCustomDialog(i);
                    }
                    else {
                        if (deltaX > 0) {
                            Toast.makeText(this, "Driver Rejected", Toast.LENGTH_SHORT).show();
                        }
                        else  {
                            Toast.makeText(this, "Driver Selected", Toast.LENGTH_SHORT).show();
                            DriverProfile D = drivers[i];
                            if (!Messages.chatNames.contains(D.name)) {
                                ChatItem newDriver = new ChatItem(D.name,
                                        D.imgRes,
                                        D.tripStart,
                                        D.tripEnd,
                                        D.tripDate+", "+D.tripTime,
                                        String.valueOf((float) (D.seatPrice*1.05)));
                                Messages.chatList.add(newDriver);
                                Messages.chatNames.add(newDriver.name);
                            }
                            showCustomDialog(i);
                        }
                        i++;
                        if (i < drivers.length) {
                            setDriverProfile(i);
                        }
                    }
                    swapped = true;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setDriverProfile(int i) {
        DriverProfile d = drivers[i];
        driverImageView.setImageResource(context.getResources().getIdentifier("drawable/" + d.imgRes, null, context.getPackageName()));
        driverReviews.setText(d.rating + " Star Average based on " + d.reviews + " Reviews");
        subtitleDriver.setText("TransitMate member since " + d.memberSince);
        driverName.setText(d.name);
        passDriven.setText(d.passDriven + " Passengers\nDriven");
        tripsDriver.setText(d.tripsAsDriver + " Trips\nas Driver");
        startLocText.setText(d.tripStart);
        endLocText.setText(d.tripEnd);
        dateTimeText.setText(d.tripDate + ", " + d.tripTime);
        carTypeText.setText(d.carModel);
        seatsText.setText(d.seatsLeft + "Seats Left");
        costText.setText("$" + d.seatPrice + " per Seat");
        homeLocText.setText(d.location);
        genderText.setText(d.gender);
        musicText.setText(d.likesMusic? "Likes Music": "No Music");
        talksText.setText(d.talks? "Likes Talking": "Silent Driver");
        occupationText.setText("Works as a " + d.occupation);
        i1.setText(d.i1);
        i2.setText(d.i2);
        i3.setText(d.i3);
        i4.setText(d.i4);
        i5.setText(d.i5);
        q1.setText(d.q1);
        q2.setText(d.q2);
        a1.setText(d.a1);
        a2.setText(d.a2);
        bio.setText(d.bio);
        purposeOfTravel.setText(d.travelPurpose);
    }

    public void showCustomDialog(int i) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom_layout);

        TextView dialogTitle = (TextView) dialog.findViewById(R.id.dialogTitle);
        Button dialogButton1 = (Button) dialog.findViewById(R.id.dialogButton1);
        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButton2);

        if (i >= drivers.length) {
            dialogTitle.setText("No More Drivers Available");
            dialogButton1.setText("Go to Home");
            dialogButton2.setText("Go to Messages");
            dialogButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(selectDriverActivity.this, MainActivity.class));
                }
            });
            dialogButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToMessages = new Intent(selectDriverActivity.this, MainActivity.class);
                    Bundle info = new Bundle();
                    info.putString("fragment", "messages");
                    goToMessages.putExtras(info);
                    startActivity(goToMessages);
                }
            });
        }

        else {
            dialogTitle.setText("Driver Selected: " + drivers[i].name + "!");
            dialogButton1.setText("Choose Alternate Drivers");
            dialogButton2.setText("Message " + drivers[i].name);
            dialogButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialogButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent messageDriver = new Intent(selectDriverActivity.this, ChatActivity.class);
                    Bundle info = new Bundle();
                    DriverProfile D = drivers[i];
                    info.putString("Name", D.name);
                    info.putString("ImgResource", D.imgRes);
                    info.putString("Origin", D.tripStart);
                    info.putString("Dest", D.tripEnd);
                    info.putString("DandT", D.tripDate + ", " + D.tripTime);
                    info.putString("Cost", String.valueOf((float) (D.seatPrice*1.05)));
                    messageDriver.putExtras(info);
                    startActivity(messageDriver);
                }
            });

        }

        dialog.show();
    }

}
