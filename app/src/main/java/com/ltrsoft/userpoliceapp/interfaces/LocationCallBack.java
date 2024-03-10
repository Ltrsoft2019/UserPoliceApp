package com.ltrsoft.userpoliceapp.interfaces;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public interface LocationCallBack {
    public void onLocationGet(Location latLng);
    public void onError(String error);

}
