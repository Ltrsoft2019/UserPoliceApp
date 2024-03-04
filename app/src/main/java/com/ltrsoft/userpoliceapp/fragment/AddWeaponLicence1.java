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
import com.ltrsoft.userpoliceapp.utils.Validations;

public class AddWeaponLicence1 extends Fragment  {
    public AddWeaponLicence1() {
    }
    private View view;
    private EditText editTextParentOrSpouseName, editTextVillage, editTextPresentAddress,
            editTextResidingSince, editTextOfficeNumber, editTextResidenceNumber;

    private Button   buttonSubmit;
    private Spinner editTextStationId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addweapenlicence1, container, false);
        setid();

        String parentOrSpouseName, village, presentAddress, residingSince, officeNumber, residenceNumber;

        // Retrieve the text from EditText fields
        parentOrSpouseName = editTextParentOrSpouseName.getText().toString();
        village = editTextVillage.getText().toString();
        presentAddress = editTextPresentAddress.getText().toString();
        residingSince = editTextResidingSince.getText().toString();
        officeNumber = editTextOfficeNumber.getText().toString();
        residenceNumber = editTextResidenceNumber.getText().toString();
        return view;
    }

    private void setid() {

        editTextParentOrSpouseName = view.findViewById(R.id.editTextParentOrSpouseName);
        editTextVillage = view.findViewById(R.id.editTextVillage);
        editTextPresentAddress = view.findViewById(R.id.editTextPresentAddress);
        editTextResidingSince = view.findViewById(R.id.editTextResidingSince);
        editTextOfficeNumber = view.findViewById(R.id.editTextOfficeNumber);
        editTextResidenceNumber = view.findViewById(R.id.editTextResidenceNumber);

        // Find the Button
        editTextStationId = view.findViewById(R.id.editTextStationId);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextParentOrSpouseName,"Enter ParentOrSpouseName ");
        valid &= Validations.validateEditText( editTextVillage,"Enter the Village ");
        valid &= Validations.validateEditText(editTextPresentAddress,"Enter The PresentAddress ");
        valid &= Validations.validateEditText(editTextResidingSince,"Enter The ResidingSince ");
        valid &= Validations.validateEditText(editTextOfficeNumber," Enter TextOfficeNumber");
        valid &= Validations.validateEditText(editTextResidenceNumber," Enter The Residence Number");
        valid &= Validations.validateSpinner(editTextStationId,"Select Station Id ");
        return valid;
    }
}
