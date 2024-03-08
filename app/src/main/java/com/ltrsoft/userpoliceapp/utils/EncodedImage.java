package com.ltrsoft.userpoliceapp.utils;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class EncodedImage {
    public static String encodeImage(Bitmap bitmap){
        String encodeImage;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        encodeImage = Base64.encodeToString(bytes, Base64.DEFAULT);
        return encodeImage;
    }
}
