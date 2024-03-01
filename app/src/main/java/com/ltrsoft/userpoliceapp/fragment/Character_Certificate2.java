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

public class Character_Certificate2 extends Fragment {
    public Character_Certificate2() {
    }

    private View view;
    private EditText editTextBuilding, editTextStreet, editTextLandmark,
            editTextLocality,   editTextPincode;
    private Button buttonSaveSubmit;
    private Spinner editTextStateID,editTextDistrictID;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate2, container, false);

        setid();
        buttonSaveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
        return view;

    }

    private void submit() {
        String building = editTextBuilding.getText().toString();
        String street = editTextStreet.getText().toString();
        String landmark = editTextLandmark.getText().toString();
        String locality = editTextLocality.getText().toString();
       // String stateID = editTextStateID.getText().toString();
        //String districtID = editTextDistrictID.getText().toString();
        String pincode = editTextPincode.getText().toString();

    }

    private void setid() {
        editTextBuilding = view.findViewById(R.id.editTextBuilding);
        editTextStreet = view.findViewById(R.id.editTextStreet);
        editTextLandmark = view.findViewById(R.id.editTextLandmark);
        editTextLocality = view.findViewById(R.id.editTextLocality);
        editTextStateID = view.findViewById(R.id.editTextStateID);
        editTextDistrictID = view.findViewById(R.id.editTextDistrictID);
        editTextPincode = view.findViewById(R.id.editTextPincode);
        buttonSaveSubmit = view.findViewById(R.id.buttonSaveSubmit);
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextBuilding,"Enter The Building ");
        valid &= Validations.validateEditText( editTextStreet,"Enter the Street ");
        valid &= Validations.validateEditText(editTextLandmark,"Enter The Landmark ");
        valid &= Validations.validateEditText(editTextLocality,"Enter The Locality ");
        valid &= Validations.validateSpinner(editTextDistrictID," Enter District");
        valid &= Validations.validateSpinner(editTextStateID," Enter State ");
        valid &= Validations.validateEditText(editTextPincode," Enter The Pincode");

//        valid &= Validations.validateSpinner(spinnerComplaintId,"complaint type");
//        valid &= Validations.validateSpinner(spinnerTextEvidenceTypeId,"evidenece type");

        return valid;
    }
}
