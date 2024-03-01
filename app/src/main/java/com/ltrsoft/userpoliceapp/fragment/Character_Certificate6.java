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
import com.ltrsoft.userpoliceapp.utils.Validations;

public class Character_Certificate6 extends Fragment {
    public Character_Certificate6() {
    }
    private View view;
    private EditText editTextAddress, editTextFrom, editTextTo, editTextPlacePincode;
    private Button buttonSaveAndSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate6, container, false);

        setid();
        buttonSaveAndSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSubmit();
            }
        });

        return view;
    }
    private void saveAndSubmit() {
        String address = editTextAddress.getText().toString();
        String from = editTextFrom.getText().toString();
        String to = editTextTo.getText().toString();
        String placePincode = editTextPlacePincode.getText().toString();

        // Now you can proceed with the entered data
        // For example, you can validate the data and proceed to the next step
    }

    private void setid() {
        editTextAddress = view.findViewById(R.id.editTextAddress);
        editTextFrom = view.findViewById(R.id.editTextFrom);
        editTextTo = view.findViewById(R.id.editTextTo);
        editTextPlacePincode = view.findViewById(R.id.editTextPlacePincode);
        buttonSaveAndSubmit = view.findViewById(R.id.buttonSaveAndSubmit);

    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextAddress,"Enter The Address ");
        valid &= Validations.validateEditText( editTextFrom,"Enter the  From ");
        valid &= Validations.validateEditText(editTextTo,"Enter The To ");
        valid &= Validations.validateEditText(editTextPlacePincode,"Enter The Pincode ");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}
