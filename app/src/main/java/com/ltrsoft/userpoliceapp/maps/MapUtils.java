package com.ltrsoft.userpoliceapp.maps;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MapUtils  {
    public List<LatLng> findNearbyLocations(LatLng referenceLatLng, List<LatLng> allLatLngs, double thresholdDistance) {
        List<LatLng> nearbyLocations = new ArrayList<>();
        for (LatLng latLng : allLatLngs) {
            double distance = calculateDistance(referenceLatLng, latLng);
            if (distance <= thresholdDistance) {
                nearbyLocations.add(latLng);
            }
        }
        return nearbyLocations;
    }

    private double calculateDistance(LatLng latLng1, LatLng latLng2) {
        double earthRadius = 6371000; // Earth's radius in meters
        double dLat = Math.toRadians(latLng2.latitude - latLng1.latitude);
        double dLng = Math.toRadians(latLng2.longitude - latLng1.longitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(latLng1.latitude)) * Math.cos(Math.toRadians(latLng2.latitude)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

}
