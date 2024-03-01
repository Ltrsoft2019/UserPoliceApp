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

public class Character_Certificate5 extends Fragment {

    public Character_Certificate5() {
    }

    private View view;
    private EditText editTextCBuilding, editTextCStreet, editTextCLandmark, editTextCLocality,
              editTextCPincode;
    private Button buttonSaveAndProceed;
    private Spinner editTextStateID,editTextDistrictID;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate5, container, false);

        setid();
        buttonSaveAndProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndProceed();
            }
        });
        return view;
    }

    private void setid() {
        editTextCBuilding = view.findViewById(R.id.editTextCBuilding);
        editTextCStreet = view.findViewById(R.id.editTextCStreet);
        editTextCLandmark = view.findViewById(R.id.editTextCLandmark);
        editTextCLocality = view.findViewById(R.id.editTextCLocality);
        editTextStateID = view.findViewById(R.id.editTextCStateID);
        editTextDistrictID = view.findViewById(R.id.editTextCDistrictID);
        editTextCPincode = view.findViewById(R.id.editTextCPincode);
        buttonSaveAndProceed = view.findViewById(R.id.buttonSaveAndProceed);


    }
    private void saveAndProceed() {
        String building = editTextCBuilding.getText().toString();
        String street = editTextCStreet.getText().toString();
        String landmark = editTextCLandmark.getText().toString();
        String locality = editTextCLocality.getText().toString();
        // String stateID = editTextStateID.getText().toString();
        //String districtID = editTextDistrictID.getText().toString();
        String pincode = editTextCPincode.getText().toString();

        // Now you can proceed with the entered data
        // For example, you can validate the data and proceed to the next step
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextCBuilding,"Enter The Permanant Building ");
        valid &= Validations.validateEditText( editTextCStreet,"Enter the Permanant Street ");
        valid &= Validations.validateEditText(editTextCLandmark,"Enter The Permanant Landmark ");
        valid &= Validations.validateEditText(editTextCLocality,"Enter The Permanant Locality ");
        valid &= Validations.validateSpinner(editTextDistrictID," Enter District");
        valid &= Validations.validateSpinner(editTextStateID," Enter State ");
        valid &= Validations.validateEditText(editTextCPincode," Enter The Pincode");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}
