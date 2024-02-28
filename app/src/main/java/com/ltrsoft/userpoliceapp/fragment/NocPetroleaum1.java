package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class NocPetroleaum1 extends Fragment {

    private EditText editTextNocPetroleumId, editTextCharacterLicense,
            editTextFathersName, editTextPlaceOfBirth, editTextResidingSince,
            editTextFax, editTextTypesOfControlBlasting;
    private RadioGroup radioGroupLicenseNoc;
    private RadioButton radioButtonLicense, radioButtonNoc;
    private Button buttonSubmit;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.nocpetrolium1fragment, container, false);
        initializeViews(view);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitClicked();
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        editTextNocPetroleumId = view.findViewById(R.id.editTextNocPetroleumId);
        editTextCharacterLicense = view.findViewById(R.id.editTextCharacterLicense);
        editTextFathersName = view.findViewById(R.id.editTextFathersName);
        editTextPlaceOfBirth = view.findViewById(R.id.editTextPlaceOfBirth);
        editTextResidingSince = view.findViewById(R.id.editTextResidingSince);
        editTextFax = view.findViewById(R.id.editTextFax);
        editTextTypesOfControlBlasting = view.findViewById(R.id.editTextTypesOfControlBlasting);
        radioGroupLicenseNoc = view.findViewById(R.id.radioGroupLicenseNoc);
        radioButtonLicense = view.findViewById(R.id.radioButtonLicense);
        radioButtonNoc = view.findViewById(R.id.radioButtonNoc);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);


    }

    private void onSubmitClicked() {
        String nocPetroleumId = editTextNocPetroleumId.getText().toString();
        String characterLicense = editTextCharacterLicense.getText().toString();
        String fathersName = editTextFathersName.getText().toString();
        String placeOfBirth = editTextPlaceOfBirth.getText().toString();
        String residingSince = editTextResidingSince.getText().toString();
        String fax = editTextFax.getText().toString();
        String typesOfControlBlasting = editTextTypesOfControlBlasting.getText().toString();

        int selectedRadioButtonId = radioGroupLicenseNoc.getCheckedRadioButtonId();
        String selectedRadioButtonText = "";
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = view.findViewById(selectedRadioButtonId);
            selectedRadioButtonText = selectedRadioButton.getText().toString();
        }

        // Perform any further processing or validation on the retrieved data.
        // You can save the data to a database, send it to a server, or perform any other necessary action.
    }
}

