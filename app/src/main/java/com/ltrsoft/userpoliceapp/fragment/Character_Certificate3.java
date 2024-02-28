package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class Character_Certificate3 extends Fragment {
    public Character_Certificate3() {
    }
    private View view;
    private EditText editTextVisibleMark;
    private RadioGroup radioGroupHaveArrested, radioGroupActivePolitics, radioGroupIsCriminal;
    private Button buttonSaveSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.character_certificate3, container, false);

        setid();
        buttonSaveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndSubmit();
            }
        });
        return view;
    }

    private void setid() {
        editTextVisibleMark = view.findViewById(R.id.editTextVisibleMark);
        radioGroupHaveArrested = view.findViewById(R.id.radioGroupHaveArrested);
        radioGroupActivePolitics = view.findViewById(R.id.radioGroupActivePolitics);
        radioGroupIsCriminal = view.findViewById(R.id.radioGroupIsCriminal);
        buttonSaveSubmit = view.findViewById(R.id.buttonSaveSubmit);
    }
    private void saveAndSubmit() {
        String visibleMark = editTextVisibleMark.getText().toString();

         boolean haveArrested = radioGroupHaveArrested.getCheckedRadioButtonId() == R.id.radioButtonYesArrested;
        boolean activePolitics = radioGroupActivePolitics.getCheckedRadioButtonId() == R.id.radioButtonYesActivePolitics;
        boolean isCriminal = radioGroupIsCriminal.getCheckedRadioButtonId() == R.id.radioButtonYesCriminal;


    }
}
