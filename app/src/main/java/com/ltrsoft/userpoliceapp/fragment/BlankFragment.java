package com.ltrsoft.userpoliceapp.fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class BlankFragment extends Fragment {
    private boolean valid;
    private EditText editTextFirstName, editTextMiddleName, editTextLastName, editTextAddress,
            editTextEmail, editTextPassword, editTextMobile1, editTextMobile2, editTextAadhar,
            editTextPAN, editTextOccupation, editTextNationality, editTextDrivingLicense,
            editTextNotificationToken, editTextCountryId, editTextStateId, editTextDistrictId,
            editTextCityId, editTextComplaintSubject, editTextComplaintDescription, editTextAgainst,
            editTextSubtypeId, editTextLatitude, editTextLongitude;

    private Spinner spinnerGender;
    private DatePicker datePickerDob, datePickerIncidentDate;

    private Button buttonUserSubmit, buttonComplaintSubmit;
    private View view;
    public BlankFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addbehalfcomplaintfragment, container, false);
        setId();

        buttonUserSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle user submit button click
            }
        });

        buttonComplaintSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle complaint submit button click
            }
        });

        return view;
    }

    private boolean isAllFieldsValid() {
        boolean isValid = true;

        if (Validations.isFieldEmpty(editTextFirstName)) {
            editTextFirstName.setError("First name cannot be empty");
            isValid = false;

        }  if (Validations.isFieldEmpty(editTextMiddleName)) {
            editTextMiddleName.setError("First name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextLastName)) {
            editTextLastName.setError("Last name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextAddress)) {
            editTextAddress.setError("Last name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextMobile2)) {
            editTextMobile2.setError("Last name cannot be empty");
            isValid = false;
        }
        //editTextAadhar,
        //            editTextPAN, editTextOccupation, editTextNationality, editTextDrivingLicense,
        //            editTextNotificationToken, editTextCountryId, editTextStateId, editTextDistrictId,
        //            editTextCityId, editTextComplaintSubject, editTextComplaintDescription, editTextAgainst,
        //            editTextSubtypeId, editTextLatitude, editTextLongitude;
        if (Validations.isFieldEmpty(editTextAadhar)) {
            editTextAadhar.setError("Last name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextPAN)) {
            editTextPAN.setError("Last name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextOccupation)) {
            editTextOccupation.setError("Last name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextAddress)) {
            editTextAddress.setError("Last name cannot be empty");
            isValid = false;
        }

        if (Validations.isFieldEmpty(editTextAddress)) {
            editTextAddress.setError("Last name cannot be empty");
            isValid = false;
        }

        if (!Validations.isEmailValid(editTextEmail.getText().toString())) {
            editTextEmail.setError("Enter a valid email address");
            isValid = false;
        }

        if (!Validations.isPasswordValid(editTextPassword.getText().toString())) {
            editTextPassword.setError("Password must be at least 6 characters long");
            isValid = false;
        }

        if (!Validations.isPhoneNumberValid(editTextMobile1.getText().toString())) {
            editTextMobile1.setError("Enter a valid mobile number");
            isValid = false;
        }

        if (!Validations.isDateValid(datePickerDob)) {
            // Implement date validation logic
            Toast.makeText(getContext(), "Invalid date of birth", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        if (!Validations.isSpinnerItemSelected(spinnerGender)) {
            Toast.makeText(getContext(), "Please select gender", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        return isValid;
    }
    private void setId() {
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
        editTextNotificationToken = view.findViewById(R.id.editTextNotificationToken);
        editTextCountryId = view.findViewById(R.id.editTextCountryId);
        editTextStateId = view.findViewById(R.id.editTextStateId);
        editTextDistrictId = view.findViewById(R.id.editTextDistrictId);
        editTextCityId = view.findViewById(R.id.editTextCityId);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        datePickerDob = view.findViewById(R.id.datePickerDob);
        editTextComplaintSubject = view.findViewById(R.id.editTextComplaintSubject);
        editTextComplaintDescription = view.findViewById(R.id.editTextComplaintDescription);
        editTextAgainst = view.findViewById(R.id.editTextAgainst);
        datePickerIncidentDate = view.findViewById(R.id.datePickerIncidentDate);
        editTextSubtypeId = view.findViewById(R.id.editTextSubtypeId);
        editTextLatitude = view.findViewById(R.id.editTextLatitude);
        editTextLongitude = view.findViewById(R.id.editTextLongitude);
        buttonUserSubmit = view.findViewById(R.id.UserSubmit);
        buttonComplaintSubmit = view.findViewById(R.id.ComplaintSubmit);

    }
}