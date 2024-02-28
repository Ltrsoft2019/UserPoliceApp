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
        editTextAddressProofDateOfIssue = view.findViewById(R.id.editTextAddressProofDateOfIssue);

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
}
