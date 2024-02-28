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

public class Character_Certificate5 extends Fragment {

    public Character_Certificate5() {
    }

    private View view;
    private EditText editTextCBuilding, editTextCStreet, editTextCLandmark, editTextCLocality,
            editTextCStateID, editTextCDistrictID, editTextCPincode;
    private Button buttonSaveAndProceed;

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
        editTextCStateID = view.findViewById(R.id.editTextCStateID);
        editTextCDistrictID = view.findViewById(R.id.editTextCDistrictID);
        editTextCPincode = view.findViewById(R.id.editTextCPincode);
        buttonSaveAndProceed = view.findViewById(R.id.buttonSaveAndProceed);


    }
    private void saveAndProceed() {
        String building = editTextCBuilding.getText().toString();
        String street = editTextCStreet.getText().toString();
        String landmark = editTextCLandmark.getText().toString();
        String locality = editTextCLocality.getText().toString();
        String stateID = editTextCStateID.getText().toString();
        String districtID = editTextCDistrictID.getText().toString();
        String pincode = editTextCPincode.getText().toString();

        // Now you can proceed with the entered data
        // For example, you can validate the data and proceed to the next step
    }
}
