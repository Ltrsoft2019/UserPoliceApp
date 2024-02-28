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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class SuspectInformationFragment extends Fragment {
    public SuspectInformationFragment() {}
    private View view;
    private EditText editTextFullName, editTextAddress, editTextPhoneNumber,
            editTextEmailAddress, editTextPassportNumber, editTextDriversLicense,
            editTextSocialSecurityNumber, editTextHeight, editTextWeight,
            editTextHairColor, editTextEyeColor, editTextDistinguishingFeatures,
            editTextOccupation, editTextEducationLevel, editTextMaritalStatus,
            editTextFamilyMembers, editTextComplaintId, editTextDescription;
    private Spinner spinnerGender, spinnerBuild, spinnerCountryId, spinnerStateId,
            spinnerDistrictId, spinnerCityId;
    private DatePicker datePickerDob;
    private Button buttonPhoto, buttonComplaintSubmit;
    private CheckBox checkBoxIsSuspect;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addcomplaintsuspect, container, false);

        setId();

        buttonComplaintSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validData()){
                    Toast.makeText(getContext(), "all data is valid ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "data is not valid ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private boolean validData() {
        boolean valid = true;

        valid &= Validations.validateEditText(editTextFullName,"full name");
        valid &= Validations.validateEditText(editTextAddress,"full name");
        valid &= Validations.validateEditText(editTextPhoneNumber,"phone number ");
        valid &= Validations.validateEditText(editTextEmailAddress,"email address");
        valid &= Validations.validateEditText(editTextPassportNumber,"passport number ");
        valid &= Validations.validateEditText(editTextDriversLicense,"driving license");
        valid &= Validations.validateEditText(editTextSocialSecurityNumber,"social security number");
        valid &= Validations.validateEditText(editTextHeight,"height");
        valid &= Validations.validateEditText(editTextHairColor,"weight");
        valid &= Validations.validateEditText(editTextEyeColor,"weight");
        valid &= Validations.validateEditText(editTextDistinguishingFeatures,"weight");
        valid &= Validations.validateEditText(editTextOccupation,"weight");
        valid &= Validations.validateEditText(editTextEducationLevel,"weight");
        valid &= Validations.validateEditText(editTextMaritalStatus,"weight");
        valid &= Validations.validateEditText(editTextFamilyMembers,"weight");
        valid &= Validations.validateEditText(editTextDescription,"weight");
        valid &= Validations.validateEditText(editTextWeight,"weight");

        valid &= Validations.validateSpinner(spinnerGender,"please select gender");
        valid &= Validations.validateSpinner(spinnerBuild,"please select gender");
        valid &= Validations.validateSpinner(spinnerGender,"please select gender");
        valid &= Validations.validateSpinner(spinnerCountryId,"please select gender");
        valid &= Validations.validateSpinner(spinnerStateId,"please select gender");
        valid &= Validations.validateSpinner(spinnerDistrictId,"please select gender");
        valid &= Validations.validateSpinner(spinnerCityId,"please select gender");

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

        buttonPhoto = view.findViewById(R.id.buttonPhoto);
        buttonComplaintSubmit = view.findViewById(R.id.ComplaintSubmit);

        checkBoxIsSuspect = view.findViewById(R.id.checkBoxIsSuspect);

    }
}
