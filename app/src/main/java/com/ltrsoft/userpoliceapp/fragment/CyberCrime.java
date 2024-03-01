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
import com.ltrsoft.userpoliceapp.utils.Validations;


public class CyberCrime extends Fragment {

    private EditText editTextLostMoney, editTextDateTime, editTextWhereOccurred, editTextDescription;
    private RadioGroup radioGroupIsDelay;
    private RadioButton radioButtonYesDelay, radioButtonNoDelay;
    private Button buttonSaveSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cyber_crime, container, false);
        initializeViews(view);
        buttonSaveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSubmitData();
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        editTextLostMoney = view.findViewById(R.id.editTextLostMoney);
        editTextDateTime = view.findViewById(R.id.editTextDateTime);
        editTextWhereOccurred = view.findViewById(R.id.editTextWhereOccurred);
        editTextDescription = view.findViewById(R.id.editTextDescription);

        radioGroupIsDelay = view.findViewById(R.id.radioGroupIsDelay);
        radioButtonYesDelay = view.findViewById(R.id.radioButtonYesDelay);
        radioButtonNoDelay = view.findViewById(R.id.radioButtonNoDelay);

        buttonSaveSubmit = view.findViewById(R.id.buttonSaveSubmit);

    }

    private void saveAndSubmitData() {
        // Get data from EditText fields
        String lostMoney = editTextLostMoney.getText().toString();
        String dateTime = editTextLostMoney.getText().toString();
        String whereOccurred = editTextWhereOccurred.getText().toString();
        String description = editTextDescription.getText().toString();

        // Get data from RadioGroup
        String isDelay = radioButtonYesDelay.isChecked() ? "Yes" : "No";


    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextLostMoney,"Enter The Lost Money ");
        valid &= Validations.validateEditText( editTextLostMoney,"Enter the Lost Money ");
        valid &= Validations.validateEditText(editTextWhereOccurred,"Enter The  Occured ");
        valid &= Validations.validateEditText(editTextDescription,"Enter The Description");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}

