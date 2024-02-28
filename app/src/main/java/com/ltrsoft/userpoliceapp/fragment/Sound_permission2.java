package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class Sound_permission2 extends Fragment {

    public Sound_permission2() {
    }
    
    private View view;
    private EditText editTextVillage, editTextTimeOfInitiation;
    private Spinner spinnerCity, spinnerDistrict, spinnerState, spinnerCountry;
    private Button buttonStationId, buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.soundpermission2, container, false);

        setid();
        buttonStationId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for choosing a station ID
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonClicked();
            }
        });

        return view;
    }

    private void onSubmitButtonClicked() {
        // Retrieve the entered data from EditText fields
        String village = editTextVillage.getText().toString();
        String timeOfInitiation = editTextTimeOfInitiation.getText().toString();

        // Retrieve selected items from Spinners
        String selectedCity = spinnerCity.getSelectedItem().toString();
        String selectedDistrict = spinnerDistrict.getSelectedItem().toString();
        String selectedState = spinnerState.getSelectedItem().toString();
        String selectedCountry = spinnerCountry.getSelectedItem().toString();

        // You can perform further operations here, such as validation,
        // sending data to a database, or navigating to the next screen.
    }


    private void setid() {
        editTextVillage = view.findViewById(R.id.editTextVillage);
        editTextTimeOfInitiation = view.findViewById(R.id.editTextTimeOfInitiation);

        // Initialize Spinners
        spinnerCity = view.findViewById(R.id.editTextCity);
        spinnerDistrict = view.findViewById(R.id.editTextDistrict);
        spinnerState = view.findViewById(R.id.editTextState);
        spinnerCountry = view.findViewById(R.id.editTextCountry);

        // Initialize Buttons
        buttonStationId = view.findViewById(R.id.editTextStationId);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

    }
}
