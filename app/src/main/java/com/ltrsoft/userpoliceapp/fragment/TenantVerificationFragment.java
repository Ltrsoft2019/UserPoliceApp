package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class TenantVerificationFragment extends Fragment {

    private EditText editTextTenantPAddress, editTextTenantOccupation, editTextStartDate,
            editTextEndDate, editTextPurposeOfTenancy;
    private ImageView imageViewSignaturePhoto;
    private Button buttonSubmit;
    private Spinner editTextStationId;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.addtenentvarification2, container, false);

      setId();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from EditText, ImageView, and Button
                String tenantPAddress = editTextTenantPAddress.getText().toString();
                String tenantOccupation = editTextTenantOccupation.getText().toString();
                String startDate = editTextStartDate.getText().toString();
                String endDate = editTextEndDate.getText().toString();
                String purposeOfTenancy = editTextPurposeOfTenancy.getText().toString();
                String stationId = editTextStationId.getSelectedItem().toString();


            }
        });

        return view;
    }

    private void setId() {

        // Find views by their IDs
        editTextTenantPAddress = view.findViewById(R.id.editTextTenantPAddress);
        editTextTenantOccupation = view.findViewById(R.id.editTextTenantOccupation);
        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        editTextEndDate = view.findViewById(R.id.editTextEndDate);
        editTextPurposeOfTenancy = view.findViewById(R.id.editTextPurposeOfTenancy);
        editTextStationId = view.findViewById(R.id.editTextStationId);
        imageViewSignaturePhoto = view.findViewById(R.id.imageViewSignaturePhoto);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
}

