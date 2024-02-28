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

public class SoundPermission1 extends Fragment {
    public SoundPermission1() {
    }
    private View view;
    private EditText editTextEventName, editTextPurpose, editTextNoOfSpeaker,
            editTextPositionInEvent, editTextDate, editTextFrom, editTextTo, editTextLocation;
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.soundpermission1, container, false);

        setid();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonClicked();
            }
        });

        return view;
    }

    private void onSubmitButtonClicked() {
        // Retrieve the entered data from EditText fields
        String eventName = editTextEventName.getText().toString();
        String purpose = editTextPurpose.getText().toString();
        String noOfSpeaker = editTextNoOfSpeaker.getText().toString();
        String positionInEvent = editTextPositionInEvent.getText().toString();
        String date = editTextDate.getText().toString();
        String from = editTextFrom.getText().toString();
        String to = editTextTo.getText().toString();
        String location = editTextLocation.getText().toString();

        // You can perform further operations here, such as validation,
        // sending data to a database, or navigating to the next screen.
    }


    private void setid() {
        editTextEventName = view.findViewById(R.id.editTextEventName);
        editTextPurpose = view.findViewById(R.id.editTextPurpose);
        editTextNoOfSpeaker = view.findViewById(R.id.editTextNoOfSpeaker);
        editTextPositionInEvent = view.findViewById(R.id.editTextPositionInEvent);
        editTextDate = view.findViewById(R.id.editTextDate);
        editTextFrom = view.findViewById(R.id.editTextFrom);
        editTextTo = view.findViewById(R.id.editTextTo);
        editTextLocation = view.findViewById(R.id.editTextLocation);

        // Initialize the submit button
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

    }
}
