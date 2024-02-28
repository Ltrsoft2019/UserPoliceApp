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

public class UnidentifiedBody1 extends Fragment {

    private EditText editTextDiscoveryDateTime, editTextLocationFound, editTextGender,
            editTextAgeEstimate, editTextHeight, editTextWeight, editTextBuild;
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unidentifybodies1, container, false);
        initializeViews(view);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndNext();
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        editTextDiscoveryDateTime = view.findViewById(R.id.editTextDiscoveryDateTime);
        editTextLocationFound = view.findViewById(R.id.editTextLocationFound);
        editTextGender = view.findViewById(R.id.editTextGender);
        editTextAgeEstimate = view.findViewById(R.id.editTextAgeEstimate);
        editTextHeight = view.findViewById(R.id.editTextHeight);
        editTextWeight = view.findViewById(R.id.editTextWeight);
        editTextBuild = view.findViewById(R.id.editTextBuild);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }

    private void saveAndNext() {
        String discoveryDateTime = editTextDiscoveryDateTime.getText().toString();
        String locationFound = editTextLocationFound.getText().toString();
        String gender = editTextGender.getText().toString();
        String ageEstimate = editTextAgeEstimate.getText().toString();
        String height = editTextHeight.getText().toString();
        String weight = editTextWeight.getText().toString();
        String build = editTextBuild.getText().toString();
    }
}
