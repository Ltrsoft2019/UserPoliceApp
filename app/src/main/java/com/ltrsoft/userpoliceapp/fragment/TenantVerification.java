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

public class TenantVerification extends Fragment {

    private EditText editTextTypeOfProperty, editTextUnits, editTextBedroomsNumber,
            editTextFullNameTenant, editTextTenantContactNumber, editTextTenantEmail;
    private Button buttonSubmit;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.addtenetvarification1, container, false);

     setId();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeOfProperty = editTextTypeOfProperty.getText().toString();
                String units = editTextUnits.getText().toString();
                String bedroomsNumber = editTextBedroomsNumber.getText().toString();
                String fullNameTenant = editTextFullNameTenant.getText().toString();
                String tenantContactNumber = editTextTenantContactNumber.getText().toString();
                String tenantEmail = editTextTenantEmail.getText().toString();

            }
        });

        return view;
    }
    private void setId() {
        editTextTypeOfProperty = view.findViewById(R.id.editTextTypeOfProperty);
        editTextUnits = view.findViewById(R.id.editTextUnits);
        editTextBedroomsNumber = view.findViewById(R.id.editTextBedroomsNumber);
        editTextFullNameTenant = view.findViewById(R.id.editTextFullNameTenant);
        editTextTenantContactNumber = view.findViewById(R.id.editTextTenantContactNumber);
        editTextTenantEmail = view.findViewById(R.id.editTextTenantEmail);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

    }
}

