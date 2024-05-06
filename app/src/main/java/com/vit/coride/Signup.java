package com.vit.coride;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button buttonSignup = findViewById(R.id.buttonSignup);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        EditText editTextBirthDate = findViewById(R.id.editTextBirthDate);
        TextView textViewLoginLink = findViewById(R.id.textViewLoginLink);

        sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String gender = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                String birthDate = editTextBirthDate.getText().toString();
                String password = editTextPassword.getText().toString();
                saveSignupData(name, email, gender, birthDate, password);
            }
        });

        textViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void saveSignupData(String name, String email, String gender, String birthDate, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("gender", gender);
        editor.putString("birthDate", birthDate);
        editor.putString("password", password);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();

        startActivity(new Intent(Signup.this, LoginActivity.class));
        finish();
    }
}
