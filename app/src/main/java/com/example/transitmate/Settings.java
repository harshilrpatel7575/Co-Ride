package com.example.transitmate;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        backButton = (ImageButton) findViewById(R.id.backImageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    }
