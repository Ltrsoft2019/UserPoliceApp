package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class UnidentifiedObjectFragment extends Fragment {

    private EditText editTextDiscoveryDateTime, editTextLocationFound, editTextObjectCondition,
            editTextObjectFeatures, editTextObjectDescription, editTextLocation;
    private ImageView imageViewObjectPhoto;
    private Button buttonSubmit, buttonStationId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unidentifyobject, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        editTextDiscoveryDateTime = view.findViewById(R.id.editTextDiscoveryDateTime);
        editTextLocationFound = view.findViewById(R.id.editTextLocationFound);
        editTextObjectCondition = view.findViewById(R.id.editTextObjectCondition);
        editTextObjectFeatures = view.findViewById(R.id.editTextObjectFeatures);
        editTextObjectDescription = view.findViewById(R.id.editTextObjectDescription);
        editTextLocation = view.findViewById(R.id.editTextLocation);
        imageViewObjectPhoto = view.findViewById(R.id.imageViewObjectPhoto);
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
        String discoveryDateTime = editTextDiscoveryDateTime.getText().toString();
        String locationFound = editTextLocationFound.getText().toString();
        String objectCondition = editTextObjectCondition.getText().toString();
        String objectFeatures = editTextObjectFeatures.getText().toString();
        String objectDescription = editTextObjectDescription.getText().toString();
        String location = editTextLocation.getText().toString();

        // You can also get the image from imageViewObjectPhoto if needed

        // Perform actions with the retrieved data, such as saving to a database or displaying it
    }

    private void onChooseStationButtonClick() {
        // Handle choose station button click event
    }
}

