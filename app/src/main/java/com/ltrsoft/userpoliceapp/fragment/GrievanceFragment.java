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

public class GrievanceFragment extends Fragment {

    private EditText editTextNatureOfGrievance, editTextDate, editTextLocation,
            editTextDescription, editTextActionRequired, editTextOutcome;
    private Button buttonSaveSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grivence, container, false);
        initializeViews(view);
        buttonSaveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSubmit();
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        editTextNatureOfGrievance = view.findViewById(R.id.editTextNatureOfGrievance);
        editTextDate = view.findViewById(R.id.editTextDate);
        editTextLocation = view.findViewById(R.id.editTextLocation);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        editTextActionRequired = view.findViewById(R.id.editTextActionRequired);
        editTextOutcome = view.findViewById(R.id.editTextOutcome);
        buttonSaveSubmit = view.findViewById(R.id.buttonSaveSubmit);

    }

    private void saveAndSubmit() {
        String natureOfGrievance = editTextNatureOfGrievance.getText().toString();
        String date = editTextDate.getText().toString();
        String location = editTextLocation.getText().toString();
        String description = editTextDescription.getText().toString();
        String actionRequired = editTextActionRequired.getText().toString();
        String outcome = editTextOutcome.getText().toString();
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextNatureOfGrievance,"Enter The Nature Of Grievance ");
        valid &= Validations.validateEditText( editTextDate,"Enter the Date ");
        valid &= Validations.validateEditText(editTextLocation,"Enter The Location");
        valid &= Validations.validateEditText(editTextDescription,"Enter The Description ");
        valid &= Validations.isValidEmail(editTextActionRequired," Enter The ActionRequired");
        valid &= Validations.validateEditText(editTextOutcome," Enter The Outcome");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}
