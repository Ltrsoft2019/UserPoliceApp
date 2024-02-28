package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class AddEvidence extends Fragment {
    public AddEvidence() {}
    private View view;
    private EditText editTextEvidenceNumber, editTextItemDescription, editTextSerialNumbers,
            editTextPackagingDetails;
    private Spinner spinnerComplaintId, spinnerTextEvidenceTypeId;
    private DatePicker datePickerEvidenceSeizure;
    private Button buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addcomplaintevidance, container, false);
        setId();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validData()){
                    Toast.makeText(getContext(), "all data is valid", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "all data is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextEvidenceNumber,"number ");
        valid &= Validations.validateEditText(editTextItemDescription,"number ");
        valid &= Validations.validateEditText(editTextSerialNumbers,"number ");
        valid &= Validations.validateEditText(editTextPackagingDetails,"number ");

        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }

    private void setId() {
        editTextEvidenceNumber = view.findViewById(R.id.editTextEvidenceNumber);
        editTextItemDescription = view.findViewById(R.id.editTextItemDescription);
        editTextSerialNumbers = view.findViewById(R.id.editTextSerialNumbers);
        editTextPackagingDetails = view.findViewById(R.id.editTextPackagingDetails);
        spinnerComplaintId = view.findViewById(R.id.editTextComplaintId);
        spinnerTextEvidenceTypeId = view.findViewById(R.id.spTextEvidenceTypeId);
        datePickerEvidenceSeizure = view.findViewById(R.id.datePickerEvidenceSeizure);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
}
