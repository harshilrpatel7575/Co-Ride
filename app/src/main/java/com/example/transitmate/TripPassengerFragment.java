package com.example.transitmate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TripPassengerFragment extends Fragment {

    public static LatLng originLatLng, destinationLatLng;
    public static SearchView originSearch, destinationSearch;
    public static EditText dateEditText;
    public static EditText timeEditText;

    private Calendar selectedDate;
    private int selectedHour, selectedMinute;
    private Button searchDriversButton;
    private ImageButton backButton;
    private Geocoder originGeocoder, destGeocoder;
    private ImageButton originHome, originWork, originLast, destHome, destWork, destLast;
    private String homeAddress, workAddress, lastAddress;


    public TripPassengerFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trip_passenger, container, false);

        originSearch = (SearchView) view.findViewById(R.id.originSearch);
        destinationSearch = (SearchView) view.findViewById(R.id.destinationSearch);
        dateEditText = view.findViewById(R.id.editTextDate);
        timeEditText = view.findViewById(R.id.editTextTime);
        searchDriversButton = (Button) view.findViewById(R.id.searchDriversButton);
        backButton = (ImageButton) view.findViewById(R.id.backImageButtonPassenger);
        originHome = (ImageButton) view.findViewById(R.id.originHome);
        originWork = (ImageButton) view.findViewById(R.id.originWork);
        originLast = (ImageButton) view.findViewById(R.id.originLast);
        destHome = (ImageButton) view.findViewById(R.id.destHome);
        destWork = (ImageButton) view.findViewById(R.id.destWork);
        destLast = (ImageButton) view.findViewById(R.id.destLast);

        homeAddress = "935 Academy Way, Kelowna";
        workAddress = "1255 International Mews, Kelowna";
        lastAddress = "Queensway Exchange, Kelowna";

        originGeocoder = new Geocoder(getContext());
        destGeocoder = new Geocoder(getContext());

        originHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address home = null;
                try {
                    home = originGeocoder.getFromLocationName(homeAddress, 1).get(0);
                    originLatLng = new LatLng(home.getLatitude(), home.getLongitude());
                    String actualHomeAddress = home.getAddressLine(0);
                    originSearch.setQuery(actualHomeAddress, false);
                    Toast.makeText(getContext(), "Origin set to " + actualHomeAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) { e.printStackTrace(); }

            }
        });

        originWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address work = null;
                try {
                    work = originGeocoder.getFromLocationName(workAddress, 1).get(0);
                    originLatLng = new LatLng(work.getLatitude(), work.getLongitude());
                    String actualWorkAddress = work.getAddressLine(0);
                    originSearch.setQuery(actualWorkAddress, false);
                    Toast.makeText(getContext(), "Origin set to " + actualWorkAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) { e.printStackTrace(); }

            }
        });

        originLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address last = null;
                try {
                    last = originGeocoder.getFromLocationName(lastAddress, 1).get(0);
                    originLatLng = new LatLng(last.getLatitude(), last.getLongitude());
                    String actualLastAddress = last.getAddressLine(0);
                    originSearch.setQuery(actualLastAddress, false);
                    Toast.makeText(getContext(), "Origin set to " + actualLastAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) { e.printStackTrace(); }

            }
        });

        destHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address home = null;
                try {
                    home = destGeocoder.getFromLocationName(homeAddress, 1).get(0);
                    destinationLatLng = new LatLng(home.getLatitude(), home.getLongitude());
                    String actualHomeAddress = home.getAddressLine(0);
                    destinationSearch.setQuery(actualHomeAddress, false);
                    Toast.makeText(getContext(), "Destination set to " + actualHomeAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) { e.printStackTrace(); }

            }
        });

        destWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address work = null;
                try {
                    work = destGeocoder.getFromLocationName(workAddress, 1).get(0);
                    destinationLatLng = new LatLng(work.getLatitude(), work.getLongitude());
                    String actualWorkAddress = work.getAddressLine(0);
                    destinationSearch.setQuery(actualWorkAddress, false);
                    Toast.makeText(getContext(), "Destination set to " + actualWorkAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) { e.printStackTrace(); }

            }
        });

        destLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address last = null;
                try {
                    last = destGeocoder.getFromLocationName(lastAddress, 1).get(0);
                    destinationLatLng = new LatLng(last.getLatitude(), last.getLongitude());
                    String actualLastAddress = last.getAddressLine(0);
                    destinationSearch.setQuery(actualLastAddress, false);
                    Toast.makeText(getContext(), "Destination set to " + actualLastAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) { e.printStackTrace(); }

            }
        });

        originSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String originLocation = originSearch.getQuery().toString();
                List<Address> originAddressList = null;

                if (originLocation != null) {
                    try {
                        originAddressList = originGeocoder.getFromLocationName(originLocation, 1);
                        Address originAddress = originAddressList.get(0);
                        originLatLng = new LatLng(originAddress.getLatitude(), originAddress.getLongitude());
                        String actualOriginAddress = originAddress.getAddressLine(0);
                        originSearch.setQuery(actualOriginAddress, false);
                        Toast.makeText(getContext(), "Origin set to " + actualOriginAddress, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) { e.printStackTrace(); }
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        destinationSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String destLocation = destinationSearch.getQuery().toString();
                List<Address> destAddressList = null;
                if (destLocation != null) {
                    try {
                        destAddressList = destGeocoder.getFromLocationName(destLocation, 1);
                        Address destAddress = destAddressList.get(0);
                        destinationLatLng = new LatLng(destAddress.getLatitude(), destAddress.getLongitude());
                        String actualDestAddress = destAddress.getAddressLine(0);
                        destinationSearch.setQuery(actualDestAddress, false);
                        Toast.makeText(getContext(), "Destination set to " + actualDestAddress, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) { e.printStackTrace(); }
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToSNT = new Intent(getContext(), MainActivity.class);
                Bundle info = new Bundle();
                info.putString("fragment", "start_new_trip");
                backToSNT.putExtras(info);
                startActivity(backToSNT);
            }
        });

        searchDriversButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formCompleted()) startActivity(new Intent(getContext(), selectDriverActivity.class));
            }
        });

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        timeEditText.setOnClickListener(new View.OnClickListener() {
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
        dateEditText.setText(sdf.format(selectedDate.getTime()));
    }

    private void updateTimeEditText() {
        String timeFormat = String.format(Locale.US, "%02d:%02d", selectedHour, selectedMinute);
        timeEditText.setText(timeFormat);
    }

    private boolean formCompleted() {
        boolean formCompleted = false;
        if (originLatLng == null) Toast.makeText(getContext(), "Please Enter an Origin", Toast.LENGTH_SHORT).show();
        else if (destinationLatLng == null) Toast.makeText(getContext(), "Please Enter a Destination", Toast.LENGTH_SHORT).show();
        else if (dateEditText.getText().toString().length() < 1) Toast.makeText(getContext(), "Please Enter a Date of Travel", Toast.LENGTH_SHORT).show();
        else if (timeEditText.getText().toString().length() < 1) Toast.makeText(getContext(), "Please Enter a Time of Travel", Toast.LENGTH_SHORT).show();
        else formCompleted = true;
        return formCompleted;
    }
}
