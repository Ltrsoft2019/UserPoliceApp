package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class PeaceFullAssembly extends Fragment {

    private EditText editTextNameOfOrganization, editTextDesignation, editTextProcessionReason,
            editTextDate, editTextNumberOfParticipants, editTextFrom, editTextTo,
            editTextLocation, editTextCountry, editTextState, editTextDistrict, editTextVillageCity,
            editTextTimeFrom, editTextTimeTo;
    private Spinner spinnerTypeOfProcession;
    private RadioGroup radioGroupIsRegistered, radioGroupPoliceStation;
    private RadioButton radioButtonYes, radioButtonNo, radioButtonSingle, radioButtonMultiple;
    private Button buttonSaveAndSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.peaceful_assembly, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        editTextNameOfOrganization = view.findViewById(R.id.editTextNameOfOrganization);
        editTextDesignation = view.findViewById(R.id.editTextDesignation);
        editTextProcessionReason = view.findViewById(R.id.editTextProcessionReason);
        editTextDate = view.findViewById(R.id.editTextDate);
        editTextNumberOfParticipants = view.findViewById(R.id.editTextNumberOfParticipants);
        editTextFrom = view.findViewById(R.id.editTextFrom);
        editTextTo = view.findViewById(R.id.editTextTo);
        editTextLocation = view.findViewById(R.id.editTextLocation);
        editTextCountry = view.findViewById(R.id.editTextCountry);
        editTextState = view.findViewById(R.id.editTextState);
        editTextDistrict = view.findViewById(R.id.editTextDistrict);
        editTextVillageCity = view.findViewById(R.id.editTextVillageCity);
        editTextTimeFrom = view.findViewById(R.id.editTextTimeFrom);
        editTextTimeTo = view.findViewById(R.id.editTextTimeTo);

        spinnerTypeOfProcession = view.findViewById(R.id.spinnerTypeOfProcession);

        radioGroupIsRegistered = view.findViewById(R.id.radioGroupIsRegistered);
        radioButtonYes = view.findViewById(R.id.radioButtonYes);
        radioButtonNo = view.findViewById(R.id.radioButtonNo);

        radioGroupPoliceStation = view.findViewById(R.id.radioGroupPoliceStation);
        radioButtonSingle = view.findViewById(R.id.radioButtonSingle);
        radioButtonMultiple = view.findViewById(R.id.radioButtonMultiple);

        buttonSaveAndSubmit = view.findViewById(R.id.buttonSaveAndSubmit);

        buttonSaveAndSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSubmitData();
            }
        });
    }

    private void saveAndSubmitData() {
        // Retrieve data from views and perform necessary actions
        String nameOfOrganization = editTextNameOfOrganization.getText().toString();
        String designation = editTextDesignation.getText().toString();
        String processionReason = editTextProcessionReason.getText().toString();
        String date = editTextDate.getText().toString();
        String numberOfParticipants = editTextNumberOfParticipants.getText().toString();
        String from = editTextFrom.getText().toString();
        String to = editTextTo.getText().toString();
        String location = editTextLocation.getText().toString();
        String country = editTextCountry.getText().toString();
        String state = editTextState.getText().toString();
        String district = editTextDistrict.getText().toString();
        String villageCity = editTextVillageCity.getText().toString();
        String timeFrom = editTextTimeFrom.getText().toString();
        String timeTo = editTextTimeTo.getText().toString();

        // Retrieve selected radio button values
        String isRegistered = radioButtonYes.isChecked() ? "Yes" : "No";
        String policeStationType = radioButtonSingle.isChecked() ? "Single" : "Multiple";

        // Retrieve selected spinner value
        String typeOfProcession = spinnerTypeOfProcession.getSelectedItem().toString();

        // Perform actions with the retrieved data, such as validation or sending it to a server
        // For demonstration, let's display a toast message
        String message = "Data saved and submitted successfully!";
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}

