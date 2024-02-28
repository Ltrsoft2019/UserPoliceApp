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

public class Character_Certificate1 extends Fragment {
    public Character_Certificate1() {
    }


    private View view;
    private EditText editTextBuilding, editTextStreet, editTextLandmark,
            editTextLocality, editTextStateID, editTextDistrictID, editTextPincode;
    private Button buttonSaveSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate, container, false);

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
        String stateID = editTextStateID.getText().toString();
        String districtID = editTextDistrictID.getText().toString();
        int pincode = Integer.parseInt(editTextPincode.getText().toString());

        // Create an instance of LocationData class
        
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
}
