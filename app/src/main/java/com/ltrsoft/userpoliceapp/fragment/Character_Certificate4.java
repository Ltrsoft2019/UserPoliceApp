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

public class Character_Certificate4 extends Fragment {
    public Character_Certificate4() {
    }
    private View view;
    private EditText editTextPBuilding, editTextPStreet, editTextPLandmark, editTextPLocality,
            editTextPStateID, editTextPDistrictID, editTextPincode;
    private Button buttonSaveAndProceed;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate4, container, false);

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
        editTextPBuilding = view.findViewById(R.id.editTextPBuilding);
        editTextPStreet = view.findViewById(R.id.editTextPStreet);
        editTextPLandmark = view.findViewById(R.id.editTextPLandmark);
        editTextPLocality = view.findViewById(R.id.editTextPLocality);
        editTextPStateID = view.findViewById(R.id.editTextPStateID);
        editTextPDistrictID = view.findViewById(R.id.editTextPDistrictID);
        editTextPincode = view.findViewById(R.id.editTextPincode);
        buttonSaveAndProceed = view.findViewById(R.id.buttonSaveAndProceed);
    }
    private void saveAndProceed() {
        String building = editTextPBuilding.getText().toString();
        String street = editTextPStreet.getText().toString();
        String landmark = editTextPLandmark.getText().toString();
        String locality = editTextPLocality.getText().toString();
        String stateID = editTextPStateID.getText().toString();
        String districtID = editTextPDistrictID.getText().toString();
        String pincode = editTextPincode.getText().toString();

        // Now you can proceed with the entered data
        // For example, you can validate the data and proceed to the next step
    }
}
