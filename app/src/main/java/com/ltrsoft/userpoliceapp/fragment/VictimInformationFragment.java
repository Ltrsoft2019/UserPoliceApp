package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class VictimInformationFragment extends Fragment {

    private EditText editTextFullName, editTextAddress, editTextPhoneNumber, editTextEmailAddress,
            editTextPassportNumber, editTextDriversLicense, editTextSocialSecurityNumber,
            editTextHeight, editTextWeight, editTextHairColor, editTextEyeColor,
            editTextDistinguishingFeatures, editTextOccupation, editTextEducationLevel,
            editTextMaritalStatus, editTextFamilyMembers, editTextComplaintId, editTextDescription;
    private Spinner spinnerGender, spinnerBuild, spinnerCountryId, spinnerStateId,
            spinnerDistrictId, spinnerCityId;
    private DatePicker datePickerDob;
    private CheckBox checkBoxIsVictim;
    private Button buttonPhoto, buttonSubmit;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.addcomplaintvictim, container, false);
       setId();
        String fullName = editTextFullName.getText().toString();
        String address = editTextAddress.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String emailAddress = editTextEmailAddress.getText().toString();
        String passportNumber = editTextPassportNumber.getText().toString();
        String driversLicense = editTextDriversLicense.getText().toString();
        String socialSecurityNumber = editTextSocialSecurityNumber.getText().toString();
        String height = editTextHeight.getText().toString();
        String weight = editTextWeight.getText().toString();
        String hairColor = editTextHairColor.getText().toString();
        String eyeColor = editTextEyeColor.getText().toString();
        String distinguishingFeatures = editTextDistinguishingFeatures.getText().toString();
        String occupation = editTextOccupation.getText().toString();
        String educationLevel = editTextEducationLevel.getText().toString();
        String maritalStatus = editTextMaritalStatus.getText().toString();
        String familyMembers = editTextFamilyMembers.getText().toString();
        String complaintId = editTextComplaintId.getText().toString();
        String description = editTextDescription.getText().toString();

        String selectedGender = spinnerGender.getSelectedItem().toString();
        String selectedBuild = spinnerBuild.getSelectedItem().toString();
        String selectedCountryId = spinnerCountryId.getSelectedItem().toString();
        String selectedStateId = spinnerStateId.getSelectedItem().toString();
        String selectedDistrictId = spinnerDistrictId.getSelectedItem().toString();
        String selectedCityId = spinnerCityId.getSelectedItem().toString();

        int day = datePickerDob.getDayOfMonth();
        int month = datePickerDob.getMonth() + 1; // Month is 0-indexed
        int year = datePickerDob.getYear();
        String dob = year + "-" + month + "-" + day;
        boolean isVictim = checkBoxIsVictim.isChecked();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (validData()){
                   Toast.makeText(getContext() , "all data is valid", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(getContext() , "all data is not valid", Toast.LENGTH_SHORT).show();
               }
           }
       });
        return view;
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextFullName,"full name");
        valid &= Validations.validateEditText(editTextAddress,"full name");
        valid &= Validations.validateEditText(editTextPhoneNumber,"full name");
        valid &= Validations.validateEditText(editTextEmailAddress,"full name");
        valid &= Validations.validateEditText(editTextPassportNumber,"full name");
        valid &= Validations.validateEditText(editTextDriversLicense,"full name");
        valid &= Validations.validateEditText(editTextSocialSecurityNumber,"full name");
        valid &= Validations.validateEditText(editTextHeight,"full name");
        valid &= Validations.validateEditText(editTextWeight,"full name");
        valid &= Validations.validateEditText(editTextHairColor,"full name");
        valid &= Validations.validateEditText(editTextEyeColor,"full name");
        valid &= Validations.validateEditText(editTextOccupation,"full name");
        valid &= Validations.validateEditText(editTextEducationLevel,"full name");
        valid &= Validations.validateEditText(editTextDistinguishingFeatures,"full name");
        valid &= Validations.validateEditText(editTextMaritalStatus,"full name");
        valid &= Validations.validateEditText(editTextFamilyMembers,"full name");
        valid &= Validations.validateEditText(editTextDistinguishingFeatures,"full name");
        return valid;
    }
    private void setId() {
        editTextFullName = view.findViewById(R.id.editTextFullName);
        editTextAddress = view.findViewById(R.id.editTextAddress);
        editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber);
        editTextEmailAddress = view.findViewById(R.id.editTextEmailAddress);
        editTextPassportNumber = view.findViewById(R.id.editTextPassportNumber);
        editTextDriversLicense = view.findViewById(R.id.editTextDriversLicense);
        editTextSocialSecurityNumber = view.findViewById(R.id.editTextSocialSecurityNumber);
        editTextHeight = view.findViewById(R.id.editTextHeight);
        editTextWeight = view.findViewById(R.id.editTextWeight);
        editTextHairColor = view.findViewById(R.id.editTextHairColor);
        editTextEyeColor = view.findViewById(R.id.editTextEyeColor);
        editTextDistinguishingFeatures = view.findViewById(R.id.editTextDistinguishingFeatures);
        editTextOccupation = view.findViewById(R.id.editTextOccupation);
        editTextEducationLevel = view.findViewById(R.id.editTextEducationLevel);
        editTextMaritalStatus = view.findViewById(R.id.editTextMaritalStatus);
        editTextFamilyMembers = view.findViewById(R.id.editTextFamilyMembers);
        editTextComplaintId = view.findViewById(R.id.editTextComplaintId);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        spinnerBuild = view.findViewById(R.id.spinnerBuild);
        spinnerCountryId = view.findViewById(R.id.editTextCountryId);
        spinnerStateId = view.findViewById(R.id.editTextStateId);
        spinnerDistrictId = view.findViewById(R.id.editTextDistrictId);
        spinnerCityId = view.findViewById(R.id.editTextCityId);
        datePickerDob = view.findViewById(R.id.datePickerDob);
        checkBoxIsVictim = view.findViewById(R.id.checkBoxIsVictim);
        buttonPhoto = view.findViewById(R.id.buttonPhoto);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
}
