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
}

