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

public class AddtenantVerification1 extends Fragment {
    public AddtenantVerification1() {
    }
    private View view;
    private EditText editTextTypeOfProperty, editTextUnits, editTextBedroomsNumber,
            editTextFullNameTenant, editTextTenantContactNumber, editTextTenantEmail;

    private Button buttonSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addtenetvarification1, container, false);
        setId();

        return view;
    }

    private void setId() {
        editTextTypeOfProperty = view.findViewById(R.id.editTextTypeOfProperty);
        editTextUnits = view.findViewById(R.id.editTextUnits);
        editTextBedroomsNumber = view.findViewById(R.id.editTextBedroomsNumber);
        editTextFullNameTenant = view.findViewById(R.id.editTextFullNameTenant);
        editTextTenantContactNumber = view.findViewById(R.id.editTextTenantContactNumber);
        editTextTenantEmail = view.findViewById(R.id.editTextTenantEmail);

        // Find the Button
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
}
