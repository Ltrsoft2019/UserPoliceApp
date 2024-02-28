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

public class Character_Certificate7 extends Fragment {
    public Character_Certificate7() {
    }

    private View view;
    private EditText editTextName, editTextPersonAddress, editTextPersonMobile;
    private Button buttonSaveAndSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate7, container, false);

        setid();

        buttonSaveAndSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSubmit();
            }
        });

        return view;
    }

    private void saveAndSubmit() {
        String name = editTextName.getText().toString();
        String address = editTextPersonAddress.getText().toString();
        String mobile = editTextPersonMobile.getText().toString();

        // Now you can proceed with the entered data
        // For example, you can validate the data and proceed to the next step
    }



    private void setid() {
        editTextName = view.findViewById(R.id.editTextName);
        editTextPersonAddress = view.findViewById(R.id.editTextPersonAddress);
        editTextPersonMobile = view.findViewById(R.id.editTextPersonMobile);
        buttonSaveAndSubmit = view.findViewById(R.id.buttonSaveAndSubmit);
    }
}
