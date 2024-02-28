package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class Premises extends Fragment {

    private EditText editTextFullName, editTextOccupation, editTextPercentage,
            editTextNationality, editTextNativePlaces, editTextNameOfEstablishment,
            editTextNatureOfAmusement;
    private RadioGroup radioGroupAppliedFor, radioGroupApplicationSuspended;
    private RadioButton radioButtonYesAppliedFor, radioButtonNoAppliedFor,
            radioButtonYesApplicationSuspended, radioButtonNoApplicationSuspended;
    private Button buttonSaveAndSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.premises_1, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        editTextFullName = view.findViewById(R.id.editTextFullName);
        editTextOccupation = view.findViewById(R.id.editTextOccupation);
        editTextPercentage = view.findViewById(R.id.editTextPercentage);
        editTextNationality = view.findViewById(R.id.editTextNationality);
        editTextNativePlaces = view.findViewById(R.id.editTextNativePlaces);
        editTextNameOfEstablishment = view.findViewById(R.id.editTextNameOfEstablishment);
        editTextNatureOfAmusement = view.findViewById(R.id.editTextNatureOfAmusement);

        radioGroupAppliedFor = view.findViewById(R.id.radioGroupAppliedFor);
        radioButtonYesAppliedFor = view.findViewById(R.id.radioButtonYesAppliedFor);
        radioButtonNoAppliedFor = view.findViewById(R.id.radioButtonNoAppliedFor);

        radioGroupApplicationSuspended = view.findViewById(R.id.radioGroupApplicationSuspended);
        radioButtonYesApplicationSuspended = view.findViewById(R.id.radioButtonYesApplicationSuspended);
        radioButtonNoApplicationSuspended = view.findViewById(R.id.radioButtonNoApplicationSuspended);

        buttonSaveAndSubmit = view.findViewById(R.id.saveButton);
        buttonSaveAndSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSubmitData();
            }
        });
    }

    private void saveAndSubmitData() {
        // Retrieve data from views
        String fullName = editTextFullName.getText().toString();
        String occupation = editTextOccupation.getText().toString();
        String percentage = editTextPercentage.getText().toString();
        String nationality = editTextNationality.getText().toString();
        String nativePlaces = editTextNativePlaces.getText().toString();
        String nameOfEstablishment = editTextNameOfEstablishment.getText().toString();
        String natureOfAmusement = editTextNatureOfAmusement.getText().toString();
        String appliedFor = radioButtonYesAppliedFor.isChecked() ? "Yes" : "No";
        String applicationSuspended = radioButtonYesApplicationSuspended.isChecked() ? "Yes" : "No";
        String message = "Data saved and submitted successfully!";
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}

