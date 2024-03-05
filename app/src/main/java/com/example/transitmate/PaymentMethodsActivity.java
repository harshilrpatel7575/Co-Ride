package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethodsActivity  extends AppCompatActivity {

    TextView tripCostText;
    Bundle drInfo;
    Button paymentButton, backButton;
    RadioGroup paymentOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_method_layout);

        tripCostText = (TextView) findViewById(R.id.tripCostText);
        paymentButton = (Button) findViewById(R.id.paymentButton);
        backButton = (Button) findViewById(R.id.backButton);
        paymentOptions = findViewById(R.id.paymentOptions);
        drInfo = getIntent().getExtras();
        tripCostText.setText("CAD " + drInfo.getString("cost", "84.89"));

        // TODO: don't let user press continue without selecting one of the payment options

        paymentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(PaymentMethodsActivity.this, "Payment Initiated. Trip Confirmed!", Toast.LENGTH_SHORT).show();
//                Home.tripProgress = true;
//                Intent goHome = new Intent(PaymentMethodsActivity.this, MainActivity.class);
//                goHome.putExtras(drInfo);
//                startActivity(goHome);
//                Toast.makeText(PaymentMethodsActivity.this, "You can now view Trip Progress info from the Home Screen", Toast.LENGTH_SHORT).show();
//            }

            @Override
            public void onClick(View v) {
                int selectedPaymentId = paymentOptions.getCheckedRadioButtonId();

                if (selectedPaymentId == -1) {
                    // No payment option selected
                    Toast.makeText(PaymentMethodsActivity.this, "Please select a payment option", Toast.LENGTH_SHORT).show();
                } else {
                    // Payment option selected
                  //  RadioButton selectedPaymentOption = findViewById(selectedPaymentId);
                    Toast.makeText(PaymentMethodsActivity.this, "Payment Initiated. Trip Confirmed!", Toast.LENGTH_SHORT).show();
                    Home.tripProgress = true;
                    Intent goHome = new Intent(PaymentMethodsActivity.this, MainActivity.class);
                    goHome.putExtras(drInfo);
                    startActivity(goHome);
                    Toast.makeText(PaymentMethodsActivity.this, "You can now view Trip Progress info from the Home Screen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToConfirm = new Intent(PaymentMethodsActivity.this, ConfirmTripActivity.class);
                backToConfirm.putExtras(drInfo);
                startActivity(backToConfirm);
            }
        });

    }
}
