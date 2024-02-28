package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class Sound_permission3 extends Fragment {

    public Sound_permission3() {
    }

    private View view;
    private EditText editTextClosingTime, editTextSpeakerContractorName,
            editTextContractorAddress, editTextLicenseNo, editTextFees, editTextTermsConditions;
    private Button buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.soundpermission3, container, false);

        setid();
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
        String closingTime = editTextClosingTime.getText().toString();
        String contractorName = editTextSpeakerContractorName.getText().toString();
        String contractorAddress = editTextContractorAddress.getText().toString();
        String licenseNumber = editTextLicenseNo.getText().toString();
        String fees = editTextFees.getText().toString();
        String termsConditions = editTextTermsConditions.getText().toString();

        // You can perform further operations here, such as validation,
        // sending data to a database, or navigating to the next screen.
    }




    private void setid() {
        editTextClosingTime = view.findViewById(R.id.editTextClosingTime);
        editTextSpeakerContractorName = view.findViewById(R.id.editTextSpeakerContractorName);
        editTextContractorAddress = view.findViewById(R.id.editTextContractorAddress);
        editTextLicenseNo = view.findViewById(R.id.editTextLicenseNo);
        editTextFees = view.findViewById(R.id.editTextFees);
        editTextTermsConditions = view.findViewById(R.id.editTextTermsConditions);

        // Initialize the submit button
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
}
