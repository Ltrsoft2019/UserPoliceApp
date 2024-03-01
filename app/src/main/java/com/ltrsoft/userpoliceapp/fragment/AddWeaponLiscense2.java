package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class AddWeaponLiscense2 extends Fragment {
    public AddWeaponLiscense2() {
    }
   private View view;
    private EditText editTextOfficeOrBusinessAddress, editTextAdditionalParticulars,
            editTextAreaOrLandOfCultivation, editTextLocationOfCultivation;

    private CheckBox checkBoxApplicantConvicted, checkBoxApplicantOrderedToBeConvicted,
            checkBoxApplicantProhibited;

    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addweapenlicence2, container, false);

        setid();

        // Define variables to hold the data
        String officeOrBusinessAddress, additionalParticulars, areaOrLandOfCultivation, locationOfCultivation;
        boolean isApplicantConvicted, isApplicantOrderedToBeConvicted, isApplicantProhibited;

        // Retrieve the text from EditText fields
        officeOrBusinessAddress = editTextOfficeOrBusinessAddress.getText().toString();
        additionalParticulars = editTextAdditionalParticulars.getText().toString();
        areaOrLandOfCultivation = editTextAreaOrLandOfCultivation.getText().toString();
        locationOfCultivation = editTextLocationOfCultivation.getText().toString();

        // Retrieve the state from CheckBoxes
        isApplicantConvicted = checkBoxApplicantConvicted.isChecked();
        isApplicantOrderedToBeConvicted = checkBoxApplicantOrderedToBeConvicted.isChecked();
        isApplicantProhibited = checkBoxApplicantProhibited.isChecked();
        return view;
    }

    private void setid() {
        editTextOfficeOrBusinessAddress = view.findViewById(R.id.editTextOfficeOrBusinessAddress);
        editTextAdditionalParticulars = view.findViewById(R.id.editTextAdditionalParticulars);
        editTextAreaOrLandOfCultivation = view.findViewById(R.id.editTextAreaOrLandOfCultivation);
        editTextLocationOfCultivation = view.findViewById(R.id.editTextLocationOfCultivation);

        // Find all CheckBoxes
        checkBoxApplicantConvicted = view.findViewById(R.id.checkBoxApplicantConvicted);
        checkBoxApplicantOrderedToBeConvicted = view.findViewById(R.id.checkBoxApplicantOrderedToBeConvicted);
        checkBoxApplicantProhibited = view.findViewById(R.id.checkBoxApplicantProhibited);

        // Find the Button
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextOfficeOrBusinessAddress,"Enter The Office Or BusinessAddress ");
        valid &= Validations.validateEditText( editTextAdditionalParticulars,"Enter the AdditionalParticulars ");
        valid &= Validations.validateEditText(editTextAreaOrLandOfCultivation,"Enter The Area Or LandOfCultivation ");
        valid &= Validations.validateEditText(editTextLocationOfCultivation,"Enter The LocationOfCultivation ");



        return valid;
    }
}
