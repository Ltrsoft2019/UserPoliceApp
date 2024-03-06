package com.ltrsoft.userpoliceapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
public class ImagePicker {

    public static final int REQUEST_IMAGE_PICKER = 1001;

    private Activity activity;
    private OnImagePickedListener listener;

    public ImagePicker(Activity activity) {
        this.activity = activity;
    }

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_IMAGE_PICKER);
    }

    public void setOnImagePickedListener(OnImagePickedListener listener) {
        this.listener = listener;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_PICKER && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), selectedImageUri);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (listener != null) {
                listener.onImagePicked(bitmap);
            }
            else {
                System.out.println("listener null");
            }
        }
    }

    public interface OnImagePickedListener {
        void onImagePicked(Bitmap bitmap);
    }
}