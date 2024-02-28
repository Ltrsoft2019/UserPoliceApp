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

public class AddtenanrVerification2 extends Fragment {
    public AddtenanrVerification2() {
    }
    private View view;
    private EditText editTextTenantPAddress, editTextTenantOccupation,
            editTextStartDate, editTextEndDate, editTextPurposeOfTenancy;

    private ImageView imageViewSignaturePhoto;

    private Button editTextStationId, buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addtenentvarification2, container, false);


        setid();
        return view;
    }

    private void setid() {
        editTextTenantPAddress = view.findViewById(R.id.editTextTenantPAddress);
        editTextTenantOccupation = view.findViewById(R.id.editTextTenantOccupation);
        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        editTextEndDate = view.findViewById(R.id.editTextEndDate);
        editTextPurposeOfTenancy = view.findViewById(R.id.editTextPurposeOfTenancy);

        // Find the ImageView
        imageViewSignaturePhoto = view.findViewById(R.id.imageViewSignaturePhoto);

        // Find the Button
        editTextStationId = view.findViewById(R.id.editTextStationId);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
}
