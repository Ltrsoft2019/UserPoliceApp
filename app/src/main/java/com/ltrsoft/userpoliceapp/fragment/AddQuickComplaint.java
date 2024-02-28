package com.ltrsoft.userpoliceapp.fragment;



import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
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
import com.ltrsoft.userpoliceapp.utils.TakingImage;

import java.io.ByteArrayOutputStream;

public class AddQuickComplaint extends Fragment {
    public AddQuickComplaint() {
    }
    private View view;
    private ImageView imageView;
    private Button photoPathButton;
    private Spinner stationIdButton;
    private EditText descriptionEditText;
    private EditText addressEditText;
    private Button submitButton;
    private static final int CAMERA_REQ_CODE = 104;
    private static final int GALLERY_REQ_CODE = 105;
    private Bitmap bitmap;
    private String encodeImage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addquickcomplaint, container, false);
      setid();
        TakingImage takingImage=new TakingImage();
        photoPathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             }
        });
        String description = descriptionEditText.getText().toString();
        String address = addressEditText.getText().toString();
//        String stationId = stationIdButton.getSelectedItem().toString();
        return view;
    }

    private void setid() {
        imageView = view.findViewById(R.id.imageView);
        photoPathButton = view.findViewById(R.id.editTextPhotoPath);
        stationIdButton = view.findViewById(R.id.editTextStationId);
        descriptionEditText = view.findViewById(R.id.editTextDescription);
        addressEditText = view.findViewById(R.id.editTextAddress);
        submitButton = view.findViewById(R.id.buttonSubmit);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        ImageSelectionUtil.handleActivityResult(requestCode,resultCode,data,imageView,getContext());

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == ImageSelectionUtil.PERMISSION_REQUEST_CODE) {
//            // Check if all permissions are granted
//            boolean allPermissionsGranted = true;
//            for (int grantResult : grantResults) {
//                if (grantResult != PackageManager.PERMISSION_GRANTED) {
//                    allPermissionsGranted = false;
//                    break;
//                }
//            }
//            if (allPermissionsGranted) {
//                // Permissions granted, proceed with image selection
//                ImageSelectionUtil.selectImage(getActivity(), imageView);
//            } else {
//                Toast.makeText(getActivity(), "Permissions required for image selection", Toast.LENGTH_SHORT).show();
//            }
//        }
    }
}
