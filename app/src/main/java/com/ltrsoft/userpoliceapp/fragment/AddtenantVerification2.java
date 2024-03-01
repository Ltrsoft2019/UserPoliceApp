package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class AddtenantVerification2 extends Fragment {
    public AddtenantVerification2() {
    }
    private View view;
    private EditText editTextTenantPAddress, editTextTenantOccupation,
            editTextStartDate, editTextEndDate, editTextPurposeOfTenancy;

    private ImageView imageViewSignaturePhoto;
    private Spinner editTextStationId;

    private Button   buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addtenentvarification2, container, false);
        setid();

        String tenantPAddress = editTextTenantPAddress.getText().toString();
        String tenantOccupation = editTextTenantOccupation.getText().toString();
        String startDate = editTextStartDate.getText().toString();
        String endDate = editTextEndDate.getText().toString();
        String purposeOfTenancy = editTextPurposeOfTenancy.getText().toString();


        return view;
    }

    private void setid() {
        editTextTenantPAddress = view.findViewById(R.id.editTextTenantPAddress);
        editTextTenantOccupation = view.findViewById(R.id.editTextTenantOccupation);
        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        editTextEndDate = view.findViewById(R.id.editTextEndDate);
        editTextPurposeOfTenancy = view.findViewById(R.id.editTextPurposeOfTenancy);

        // Find the ImageView
        imageViewSignaturePhoto = view.findViewById(R.id.imageViewSignaturePhoto);

        // Find the Button
        editTextStationId = view.findViewById(R.id.editTextStationId);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextTenantPAddress,"Enter Tenant Permanat Address ");
        valid &= Validations.validateEditText( editTextTenantOccupation,"Enter the Tenant Occupation ");
        valid &= Validations.validateEditText(editTextStartDate,"Enter The StartDate ");
        valid &= Validations.validateEditText(editTextEndDate,"Enter The EndDate ");
        valid &= Validations.validateEditText(editTextPurposeOfTenancy," Enter Purpose Of Tenancy");
        valid &= Validations.validateSpinner(editTextStationId,"Select Station Id ");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}
