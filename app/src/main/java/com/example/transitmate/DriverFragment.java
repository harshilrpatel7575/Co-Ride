package com.example.transitmate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class DriverFragment extends Fragment {

    ImageButton backButton, originHome, originWork, originLast, destHome, destWork, destLast;
    Button submit;
    String homeAddress, workAddress, lastAddress;
    EditText origin, dest, date, time;
    private Calendar selectedDate;
    private int selectedHour, selectedMinute;


    public DriverFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driverprofile, container, false);

        backButton = (ImageButton) view.findViewById(R.id.backImageButtonDriver);
        submit = (Button) view.findViewById(R.id.submitTripButton);
        originHome = (ImageButton) view.findViewById(R.id.originHome);
        originWork = (ImageButton) view.findViewById(R.id.originWork);
        originLast = (ImageButton) view.findViewById(R.id.originLast);
        destHome = (ImageButton) view.findViewById(R.id.destHome);
        destWork = (ImageButton) view.findViewById(R.id.destWork);
        destLast = (ImageButton) view.findViewById(R.id.destLast);
        origin = (EditText) view.findViewById(R.id.origin);
        dest = (EditText) view.findViewById(R.id.dest);
        date = (EditText) view.findViewById(R.id.editTextDate2);
        time = (EditText) view.findViewById(R.id.editTextTime2);

        homeAddress = "935 Academy Way, Kelowna";
        workAddress = "1255 International Mews, Kelowna";
        lastAddress = "Queensway Exchange, Kelowna";

        originHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origin.setText(homeAddress);
            }
        });

        originWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origin.setText(workAddress);
            }
        });

        originLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origin.setText(lastAddress);
            }
        });

        destHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest.setText(homeAddress);
            }
        });

        destWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest.setText(workAddress);
            }
        });

        destLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest.setText(lastAddress);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSNT = new Intent(getContext(), MainActivity.class);
                Bundle info = new Bundle();
                info.putString("fragment", "start_new_trip");
                goToSNT.putExtras(info);
                startActivity(goToSNT);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(formCompleted()) {
                    Toast.makeText(getContext(), "Trip Posted to TransitMate", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), MainActivity.class));
                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        return view;
    }

    private void showDatePickerDialog() {
        final Calendar currentDate = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        selectedDate = Calendar.getInstance();
                        selectedDate.set(Calendar.YEAR, year);
                        selectedDate.set(Calendar.MONTH, month);
                        selectedDate.set(Calendar.DAY_OF_MONTH, day);

                        updateDateEditText();
                    }
                },
                currentDate.get(Calendar.YEAR),
                currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        selectedHour = hourOfDay;
                        selectedMinute = minute;

                        updateTimeEditText();
                    }
                },
                currentHour,
                currentMinute,
                false
        );
        timePickerDialog.show();
    }

    private void updateDateEditText() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        date.setText(sdf.format(selectedDate.getTime()));
    }

    private void updateTimeEditText() {
        String timeFormat = String.format(Locale.US, "%02d:%02d", selectedHour, selectedMinute);
        time.setText(timeFormat);
    }

    private boolean formCompleted() {
        boolean formCompleted = false;
        if (origin.getText().toString() == null) Toast.makeText(getContext(), "Please Enter an Origin", Toast.LENGTH_SHORT).show();
        else if (dest.getText().toString()  == null) Toast.makeText(getContext(), "Please Enter a Destination", Toast.LENGTH_SHORT).show();
        else if (date.getText().toString().length() < 1) Toast.makeText(getContext(), "Please Enter a Date of Travel", Toast.LENGTH_SHORT).show();
        else if (time.getText().toString().length() < 1) Toast.makeText(getContext(), "Please Enter a Time of Travel", Toast.LENGTH_SHORT).show();
        else formCompleted = true;
        return formCompleted;
    }
}


