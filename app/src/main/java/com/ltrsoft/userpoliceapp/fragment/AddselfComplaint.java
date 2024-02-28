package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class AddselfComplaint extends Fragment {
    public AddselfComplaint() {
    }
   private  View view;
    private EditText editTextFirstName, editTextMiddleName, editTextLastName,
            editTextAddress, editTextEmail, editTextPassword,
            editTextMobile1, editTextMobile2, editTextAadhar,
            editTextPAN, editTextOccupation, editTextNationality,
            editTextDrivingLicense,   editTextComplaintSubject,
            editTextComplaintDescription, editTextAgainst;

    private Spinner spinnerGender, editTextCountryId, editTextStateId, editTextDistrictId,
            editTextCityId, editTextSubtypeId,editTextStationId;

    private DatePicker datePickerDob, datePickerIncidentDate;

    private Button UserSubmit, ComplaintSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addselftcomplaintfragment, container, false);

     setid();
        return view;
    }

    private void setid() {
        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextMiddleName = view.findViewById(R.id.editTextMiddleName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        editTextAddress = view.findViewById(R.id.editTextAddress);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextMobile1 = view.findViewById(R.id.editTextMobile1);
        editTextMobile2 = view.findViewById(R.id.editTextMobile2);
        editTextAadhar = view.findViewById(R.id.editTextAadhar);
        editTextPAN = view.findViewById(R.id.editTextPAN);
        editTextOccupation = view.findViewById(R.id.editTextOccupation);
        editTextNationality = view.findViewById(R.id.editTextNationality);
        editTextDrivingLicense = view.findViewById(R.id.editTextDrivingLicense);
        // editTextStationId = view.findViewById(R.id.editTextStationId);
        editTextComplaintSubject = view.findViewById(R.id.editTextComplaintSubject);
        editTextComplaintDescription = view.findViewById(R.id.editTextComplaintDescription);
        editTextAgainst = view.findViewById(R.id.editTextAgainst);

        // Find all Spinners
        spinnerGender = view.findViewById(R.id.spinnerGender);
        editTextCountryId = view.findViewById(R.id.editTextCountryId);
        editTextStateId = view.findViewById(R.id.editTextStateId);
        editTextDistrictId = view.findViewById(R.id.editTextDistrictId);
        editTextCityId = view.findViewById(R.id.editTextCityId);
        editTextSubtypeId = view.findViewById(R.id.editTextSubtypeId);

        // Find all DatePickers
        datePickerDob = view.findViewById(R.id.datePickerDob);
        datePickerIncidentDate = view.findViewById(R.id.datePickerIncidentDate);

        // Find all Buttons
        UserSubmit = view.findViewById(R.id.UserSubmit);
        ComplaintSubmit = view.findViewById(R.id.ComplaintSubmit);
    }
}
