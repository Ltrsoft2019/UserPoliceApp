package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class NocPetroleaum extends Fragment {

    private EditText editTextWhichPetroleum, editTextOfficeNumber, editTextResidenceNumber,
            editTextOccupation, editTextQuantity, editTextBlastingDetail;
    private Button buttonChooseStation, buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nocpetrolium2fragment, container, false);
        initializeViews(view);
        buttonChooseStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseStation();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        editTextWhichPetroleum = view.findViewById(R.id.editTextWhichPetroleum);
        editTextOfficeNumber = view.findViewById(R.id.editTextOfficeNumber);
        editTextResidenceNumber = view.findViewById(R.id.editTextResidenceNumber);
        editTextOccupation = view.findViewById(R.id.editTextOccupation);
        editTextQuantity = view.findViewById(R.id.editTextQuantity);
        editTextBlastingDetail = view.findViewById(R.id.editTextBlastingDetail);
        buttonChooseStation = view.findViewById(R.id.editTextStationId);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);


    }

    private void chooseStation() {
        // Implement your logic for choosing a station here
        Toast.makeText(getContext(), "Choose Station Button Clicked", Toast.LENGTH_SHORT).show();
    }

    private void submitForm() {
        String petroleum = editTextWhichPetroleum.getText().toString();
        String officeNumber = editTextOfficeNumber.getText().toString();
        String residenceNumber = editTextResidenceNumber.getText().toString();
        String occupation = editTextOccupation.getText().toString();
        String quantity = editTextQuantity.getText().toString();
        String blastingDetail = editTextBlastingDetail.getText().toString();

        // You can perform further actions with the retrieved data, such as validation or sending it to a server
    }
}

