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

public class EmployeeVerification extends Fragment {

    private EditText editTextCompanyName, editTextCompanyAddress, editTextJobTitle,
            editTextJoiningDate, editTextSalary, editTextPreviousEmployerName,
            editTextDurationOfEmployment, editTextReasonForLeaving,
            editTextJobDescriptionResponsibilities, editTextIdentityProofDocNumber,
            editTextIdentityProofIssuingAuthority, editTextIdentityProofDateOfIssue,
            editTextIdentityProofDateOfExpiry, editTextAddressProofDocNumber,
            editTextAddressProofIssuingAuthority, editTextAddressProofDateOfIssue;
    private Button buttonSaveNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee_verification, container, false);
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
        editTextCompanyName = view.findViewById(R.id.editTextCompanyName);
        editTextCompanyAddress = view.findViewById(R.id.editTextCompanyAddress);
        editTextJobTitle = view.findViewById(R.id.editTextJobTitle);
        editTextJoiningDate = view.findViewById(R.id.editTextJoiningDate);
        editTextSalary = view.findViewById(R.id.editTextSalary);
        editTextPreviousEmployerName = view.findViewById(R.id.editTextPreviousEmployerName);
        editTextDurationOfEmployment = view.findViewById(R.id.editTextDurationOfEmployment);
        editTextReasonForLeaving = view.findViewById(R.id.editTextReasonForLeaving);
        editTextJobDescriptionResponsibilities = view.findViewById(R.id.editTextJobDescriptionResponsibilities);
        editTextIdentityProofDocNumber = view.findViewById(R.id.editTextIdentityProofDocNumber);
        editTextIdentityProofIssuingAuthority = view.findViewById(R.id.editTextIdentityProofIssuingAuthority);
        editTextIdentityProofDateOfIssue = view.findViewById(R.id.editTextIdentityProofDateOfIssue);
        editTextIdentityProofDateOfExpiry = view.findViewById(R.id.editTextIdentityProofDateOfExpiry);
        editTextAddressProofDocNumber = view.findViewById(R.id.editTextAddressProofDocNumber);
        editTextAddressProofIssuingAuthority = view.findViewById(R.id.editTextAddressProofIssuingAuthority);
        editTextAddressProofDateOfIssue = view.findViewById(R.id.editTextIdentityProofDateOfIssue);
        buttonSaveNext = view.findViewById(R.id.buttonSaveNext);

    }

    private void saveAndNext() {
        String companyName = editTextCompanyName.getText().toString();
        String companyAddress = editTextCompanyAddress.getText().toString();
        String jobTitle = editTextJobTitle.getText().toString();
        String joiningDate = editTextJoiningDate.getText().toString();
        String salary = editTextSalary.getText().toString();
        String previousEmployerName = editTextPreviousEmployerName.getText().toString();
        String durationOfEmployment = editTextDurationOfEmployment.getText().toString();
        String reasonForLeaving = editTextReasonForLeaving.getText().toString();
        String jobDescriptionResponsibilities = editTextJobDescriptionResponsibilities.getText().toString();
        String identityProofDocNumber = editTextIdentityProofDocNumber.getText().toString();
        String identityProofIssuingAuthority = editTextIdentityProofIssuingAuthority.getText().toString();
        String identityProofDateOfIssue = editTextIdentityProofDateOfIssue.getText().toString();
        String identityProofDateOfExpiry = editTextIdentityProofDateOfExpiry.getText().toString();
        String addressProofDocNumber = editTextAddressProofDocNumber.getText().toString();
        String addressProofIssuingAuthority = editTextAddressProofIssuingAuthority.getText().toString();
        String addressProofDateOfIssue = editTextAddressProofDateOfIssue.getText().toString();

    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextCompanyName,"Enter The Company Name ");
        valid &= Validations.validateEditText( editTextCompanyAddress,"Enter the  Company Address ");
        valid &= Validations.validateEditText(editTextJobDescriptionResponsibilities,"Enter The  Job Description Responsibilities");
       // valid &= Validations.validateEditText(editTextContactNumber,"Enter The Contact Number ");
        //valid &= Validations.isValidEmail(editTextEmailAddress," Enter Email");
        //valid &= Validations.validateEditText(editTextPreviousEmployer," Enter The Privious Employer");
        valid &= Validations.validateEditText(editTextReasonForLeaving," Enter The Reason For Leaving");
        //valid &= Validations.validateEditText(editTextIdentificationDocuments," Enter The Identification Documents");
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
