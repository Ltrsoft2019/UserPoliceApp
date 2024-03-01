package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Validations;

public class DomesticHelp extends Fragment {

    private EditText editTextFullName, editTextDateOfBirth, editTextPermanentAddress,
            editTextContactNumber, editTextEmailAddress, editTextPreviousEmployer,
            editTextDurationOfEmployment, editTextReasonForLeaving, editTextIdentificationDocuments,
            editTextIdentityProofDocNumber, editTextIdentityProofIssuingAuthority,
            editTextIdentityProofDateOfIssue, editTextIdentityProofDateOfExpiry,
            editTextAddressProofDocNumber, editTextAddressProofIssuingAuthority;
    private Spinner spinnerGender;
    private Button buttonSaveNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.domestic_help, container, false);
        initializeViews(view);
        buttonSaveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndNext();
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        editTextFullName = view.findViewById(R.id.editTextFullName);
        editTextDateOfBirth = view.findViewById(R.id.editTextDateOfBirth);
        editTextPermanentAddress = view.findViewById(R.id.editTextPermanentAddress);
        editTextContactNumber = view.findViewById(R.id.editTextContactNumber);
        editTextEmailAddress = view.findViewById(R.id.editTextEmailAddress);
        editTextPreviousEmployer = view.findViewById(R.id.editTextPreviousEmployer);
        editTextDurationOfEmployment = view.findViewById(R.id.editTextDurationOfEmployment);
        editTextReasonForLeaving = view.findViewById(R.id.editTextReasonForLeaving);
        editTextIdentificationDocuments = view.findViewById(R.id.editTextIdentificationDocuments);
        editTextIdentityProofDocNumber = view.findViewById(R.id.editTextIdentityProofDocNumber);
        editTextIdentityProofIssuingAuthority = view.findViewById(R.id.editTextIdentityProofIssuingAuthority);
        editTextIdentityProofDateOfIssue = view.findViewById(R.id.editTextIdentityProofDateOfIssue);
        editTextIdentityProofDateOfExpiry = view.findViewById(R.id.editTextIdentityProofDateOfExpiry);
        editTextAddressProofDocNumber = view.findViewById(R.id.editTextAddressProofDocNumber);
        editTextAddressProofIssuingAuthority = view.findViewById(R.id.editTextAddressProofIssuingAuthority);

        spinnerGender = view.findViewById(R.id.spinnerGender);

        buttonSaveNext = view.findViewById(R.id.buttonSaveNext);

    }

    private void saveAndNext() {
        String fullName = editTextFullName.getText().toString();
        String dateOfBirth = editTextDateOfBirth.getText().toString();
        String permanentAddress = editTextPermanentAddress.getText().toString();
        String contactNumber = editTextContactNumber.getText().toString();
        String emailAddress = editTextEmailAddress.getText().toString();
        String previousEmployer = editTextPreviousEmployer.getText().toString();
        String durationOfEmployment = editTextDurationOfEmployment.getText().toString();
        String reasonForLeaving = editTextReasonForLeaving.getText().toString();
        String identificationDocuments = editTextIdentificationDocuments.getText().toString();
        String identityProofDocNumber = editTextIdentityProofDocNumber.getText().toString();
        String identityProofIssuingAuthority = editTextIdentityProofIssuingAuthority.getText().toString();
        String identityProofDateOfIssue = editTextIdentityProofDateOfIssue.getText().toString();
        String identityProofDateOfExpiry = editTextIdentityProofDateOfExpiry.getText().toString();
        String addressProofDocNumber = editTextAddressProofDocNumber.getText().toString();
        String addressProofIssuingAuthority = editTextAddressProofIssuingAuthority.getText().toString();
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextFullName,"Enter The Name ");
        valid &= Validations.validateEditText( editTextDateOfBirth,"Enter the Date of Birth ");
        valid &= Validations.validateEditText(editTextPermanentAddress,"Enter The Permanant Address");
        valid &= Validations.validateEditText(editTextContactNumber,"Enter The Contact Number ");
        valid &= Validations.isValidEmail(editTextEmailAddress," Enter Email");
        valid &= Validations.validateEditText(editTextPreviousEmployer," Enter The Privious Employer");
        valid &= Validations.validateEditText(editTextReasonForLeaving," Enter The Reason For Leaving");
        valid &= Validations.validateEditText(editTextIdentificationDocuments," Enter The Identification Documents");
        valid &= Validations.validateEditText(editTextIdentityProofDocNumber," Enter The Identity Proof DocNumber");
        valid &= Validations.validateEditText(editTextIdentityProofIssuingAuthority," Enter The Identity ProofIssuing Authority");
        valid &= Validations.validateEditText(editTextIdentityProofDateOfIssue," Enter The Identity Proof Date Of Issue");
        valid &= Validations.validateEditText(editTextIdentityProofDateOfExpiry," Enter The Identity Proof Date Of Expiry");
        valid &= Validations.validateEditText(editTextAddressProofDocNumber," Enter The Address Proof DocNumber");
        valid &= Validations.validateEditText(editTextAddressProofIssuingAuthority," Enter The Address Proof Issuing Authority");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}

