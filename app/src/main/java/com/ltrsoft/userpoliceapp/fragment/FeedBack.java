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

public class FeedBack extends Fragment {

    private EditText editTextFeedbackQuestion1, editTextFeedbackQuestion2, editTextFeedbackQuestion3,
            editTextFeedbackQuestion4, editTextFeedbackQuestion5, editTextFeedbackQuestion6,
            editTextFeedbackDescription;
    private Button buttonSaveSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback, container, false);
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
        editTextFeedbackQuestion1 = view.findViewById(R.id.editTextFeedbackQuestion1);
        editTextFeedbackQuestion2 = view.findViewById(R.id.editTextFeedbackQuestion2);
        editTextFeedbackQuestion3 = view.findViewById(R.id.editTextFeedbackQuestion3);
        editTextFeedbackQuestion4 = view.findViewById(R.id.editTextFeedbackQuestion4);
        editTextFeedbackQuestion5 = view.findViewById(R.id.editTextFeedbackQuestion5);
        editTextFeedbackQuestion6 = view.findViewById(R.id.editTextFeedbackQuestion6);
        editTextFeedbackDescription = view.findViewById(R.id.editTextFeedbackDescription);
        buttonSaveSubmit = view.findViewById(R.id.buttonSaveSubmit);

    }

    private void saveAndSubmit() {
        String question1 = editTextFeedbackQuestion1.getText().toString();
        String question2 = editTextFeedbackQuestion2.getText().toString();
        String question3 = editTextFeedbackQuestion3.getText().toString();
        String question4 = editTextFeedbackQuestion4.getText().toString();
        String question5 = editTextFeedbackQuestion5.getText().toString();
        String question6 = editTextFeedbackQuestion6.getText().toString();
        String description = editTextFeedbackDescription.getText().toString();

        // Perform any further processing or validation on the retrieved data.
        // You can save the data to a database, send it to a server, or perform any other necessary action.
    }
//    private boolean validData() {
//        boolean valid =true;
//
//        valid &= Validations.validateEditText(editTextFeedbackQuestion1,"Enter The  Feedback Question 1 ");
//        valid &= Validations.validateEditText( editTextDateOfBirth,"Enter the Date of Birth ");
//        valid &= Validations.validateEditText(editTextPermanentAddress,"Enter The Permanant Address");
//        valid &= Validations.validateEditText(editTextContactNumber,"Enter The Contact Number ");
//        valid &= Validations.isValidEmail(editTextEmailAddress," Enter Email");
//        valid &= Validations.validateEditText(editTextPreviousEmployer," Enter The Privious Employer");
//        valid &= Validations.validateEditText(editTextReasonForLeaving," Enter The Reason For Leaving");
//        valid &= Validations.validateEditText(editTextIdentificationDocuments," Enter The Identification Documents");
//        valid &= Validations.validateEditText(editTextIdentityProofDocNumber," Enter The Identity Proof DocNumber");
//        valid &= Validations.validateEditText(editTextIdentityProofIssuingAuthority," Enter The Identity ProofIssuing Authority");
//        valid &= Validations.validateEditText(editTextIdentityProofDateOfIssue," Enter The Identity Proof Date Of Issue");
//        valid &= Validations.validateEditText(editTextIdentityProofDateOfExpiry," Enter The Identity Proof Date Of Expiry");
//        valid &= Validations.validateEditText(editTextAddressProofDocNumber," Enter The Address Proof DocNumber");
//        valid &= Validations.validateEditText(editTextAddressProofIssuingAuthority," Enter The Address Proof Issuing Authority");
//
////        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
////        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");
//
//        return valid;
//    }
}

