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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.TakingImage;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddQuickComplaint extends Fragment {
    public AddQuickComplaint() {
    }
    private View view;
    private ImageView imageView;
    private Button photoPathButton;
    private Button stationIdButton;
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
        imageView = view.findViewById(R.id.imageView);
        photoPathButton = view.findViewById(R.id.editTextPhotoPath);
        stationIdButton = view.findViewById(R.id.editTextStationId);
        descriptionEditText = view.findViewById(R.id.editTextDescription);
        addressEditText = view.findViewById(R.id.editTextAddress);
        submitButton = view.findViewById(R.id.buttonSubmit);
        TakingImage takingImage=new TakingImage();
        photoPathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    TakingImage.showImagesource(getActivity(), new TakingImage.Imagereturn() {
                        @Override
                        public void onimageready(Bitmap bitmap) {
                            imageView.setImageBitmap(bitmap);
                        }
                    });

             }
        });

        return view;
    }
    public  void onActivityresult(int requestcode,int resultcode,@Nullable Intent data){
        super.onActivityResult(requestcode,requestcode,data);
        TakingImage.onActivityResult(getActivity(), requestcode, resultcode, data, new TakingImage.Imagereturn() {
            @Override
            public void onimageready(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        });
    }


}
