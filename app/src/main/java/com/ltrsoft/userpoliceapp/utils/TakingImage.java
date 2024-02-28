package com.ltrsoft.userpoliceapp.utils;


import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TakingImage extends AppCompatActivity  {
    private static final int GALLERY_REQUEST_CODE = 104;
    private static final int CAMERA_REQ_CODE = 105;

    //    public interface imagehandl/er
    public interface Imagereturn {
        void onimageready(Bitmap bitmap);
    }

    public static void showImagesource(Activity activity, Imagereturn imagereturn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity)
                .setTitle("select")
                .setPositiveButton("camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        opencamera(activity);
                    }
                })
                .setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openGallery(activity);
                    }


                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private static void openGallery(Activity activity) {

        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }


    private static void opencamera(Activity activity) {

            Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activity.startActivityForResult(cameraintent, CAMERA_REQ_CODE);

    }

    public static void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data, Imagereturn listener) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQ_CODE) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Log.d("bitmap", bitmap.toString());
                listener.onimageready(bitmap);
            } else if (requestCode == GALLERY_REQUEST_CODE) {
                if (data != null && data.getData() != null) {
                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), selectedImageUri);
                        listener.onimageready(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //bitmap = BitmapFactory.decodeStream(inputStream);
                }
            }
        }


    }
}
