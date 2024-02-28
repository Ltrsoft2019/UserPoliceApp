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

public class UnidentifiedBody2 extends Fragment {

    private EditText editTextRaceEthnicity, editTextHairColorStyle, editTextEyeColor,
            editTextDistinguishingFeatures, editTextClothingDescription;
    private Spinner spinnerBodyCondition,buttonStationId;
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unidentifybodies2, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        editTextRaceEthnicity = view.findViewById(R.id.editTextRaceEthnicity);
        editTextHairColorStyle = view.findViewById(R.id.editTextHairColorStyle);
        editTextEyeColor = view.findViewById(R.id.editTextEyeColor);
        editTextDistinguishingFeatures = view.findViewById(R.id.editTextDistinguishingFeatures);
        editTextClothingDescription = view.findViewById(R.id.editTextClothingDescription);
        spinnerBodyCondition = view.findViewById(R.id.editTextBodyCondition);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
        buttonStationId = view.findViewById(R.id.editTextStationId);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonClick();
            }
        });

        buttonStationId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChooseStationButtonClick();
            }
        });
    }

    private void onSubmitButtonClick() {
        // Retrieve all the data and perform actions as needed
        String raceEthnicity = editTextRaceEthnicity.getText().toString();
        String hairColorStyle = editTextHairColorStyle.getText().toString();
        String eyeColor = editTextEyeColor.getText().toString();
        String distinguishingFeatures = editTextDistinguishingFeatures.getText().toString();
        String clothingDescription = editTextClothingDescription.getText().toString();
        String bodyCondition = spinnerBodyCondition.getSelectedItem().toString();
    }

    private void onChooseStationButtonClick() {
    }
}

