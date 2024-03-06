package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.model.CyberCrimemodel;
import com.ltrsoft.userpoliceapp.utils.ImagePicker;
import com.ltrsoft.userpoliceapp.utils.Validations;


public class CyberCrime extends Fragment {

    private EditText editTextLostMoney, editTextDateTime, editTextWhereOccurred, editTextDescription;
    private RadioGroup radioGroupIsDelay;
    private TextView imagetaking;
    private RadioButton radioButtonYesDelay, radioButtonNoDelay;
    private Button buttonSaveSubmit;
    private ImagePicker picker;
    String encodeImage=null;

    private ImageView evidance_photo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cyber_crime, container, false);
        initializeViews(view);
         picker = new ImagePicker(getActivity());
         evidance_photo.setImageResource(R.drawable.complaint);
        picker.setOnImagePickedListener(new ImagePicker.OnImagePickedListener() {
            @Override
            public void onImagePicked(Bitmap bitmap) {
                evidance_photo.setImageBitmap(bitmap);
            }
        });

        imagetaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.pickImage();

            }
        });
        buttonSaveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lostMoney = editTextLostMoney.getText().toString();
                String dateTime = editTextLostMoney.getText().toString();
                String whereOccurred = editTextWhereOccurred.getText().toString();
                String description = editTextDescription.getText().toString();

                // Get data from RadioGroup
                String isDelay = radioButtonYesDelay.isChecked() ? "Yes" : "No";


                //saveAndSubmitData();
                if (validData()){
                    insertdata(lostMoney,dateTime,whereOccurred,description,isDelay,encodeImage);

                }else {
                    Toast.makeText(getContext(), "All fields are Compulsory", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    private void insertdata(String lostMoney, String dateTime,
                            String whereOccurred, String description, String isDelay,
                            String encodeImage)
    {
        DAO dao=new DAO(getContext());
        CyberCrimemodel cyberCrimemodel =new CyberCrimemodel();
        // dao.insertOrUpdate();
    }

    private void initializeViews(View view) {
        editTextLostMoney = view.findViewById(R.id.editTextLostMoney);
        editTextDateTime = view.findViewById(R.id.editTextDateTime);
        editTextWhereOccurred = view.findViewById(R.id.editTextWhereOccurred);
        editTextDescription = view.findViewById(R.id.editTextDescription);

        radioGroupIsDelay = view.findViewById(R.id.radioGroupIsDelay);
        radioButtonYesDelay = view.findViewById(R.id.radioButtonYesDelay);
        radioButtonNoDelay = view.findViewById(R.id.radioButtonNoDelay);
        imagetaking=view.findViewById(R.id.imagetaking);
        buttonSaveSubmit = view.findViewById(R.id.buttonSaveSubmit);
        evidance_photo = view.findViewById(R.id.evidance_photo);

    }

    private void saveAndSubmitData() {
        // Get data from EditText fields

    }
    private boolean validData() {
        boolean valid =true;

        valid &= Validations.validateEditText(editTextLostMoney,"Enter The Lost Money ");
        valid &= Validations.validateEditText( editTextLostMoney,"Enter the Lost Money ");
        valid &= Validations.validateEditText(editTextWhereOccurred,"Enter The  Occured ");
        valid &= Validations.validateEditText(editTextDescription,"Enter The Description");
        return valid;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        picker.onActivityResult(requestCode,resultCode,data);
    }
}

