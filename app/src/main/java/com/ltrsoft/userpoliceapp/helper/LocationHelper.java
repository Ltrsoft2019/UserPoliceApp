package com.ltrsoft.userpoliceapp.helper;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;


public class LocationHelper {
    private Context context;
    private FusedLocationProviderClient fusedLocationProviderClient;

    public LocationHelper(Context context) {
        this.context = context;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }
    public void getLastKnownLocation(LocationResultListener listener) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            listener.onPermissionDenied();
            return;
        }

        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        listener.onLocationAvailable(location);
                    } else {
                        listener.onLocationUnavailable();
                    }
                });
    }

    public interface LocationResultListener {
        void onLocationAvailable(Location location);

        void onLocationUnavailable();

        void onPermissionDenied();
    }
}

