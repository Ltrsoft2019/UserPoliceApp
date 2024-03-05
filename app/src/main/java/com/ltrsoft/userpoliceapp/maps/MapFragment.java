package com.ltrsoft.userpoliceapp.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ltrsoft.userpoliceapp.R;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private View view;
    private List<LatLng> nearbyLocations;
    private List<LatLng> allloctions;

    GoogleMap map;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.map_fragment, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        allloctions = new ArrayList<>();
        allloctions.add(new LatLng(18.421488794807782, 76.57396003603935)); // Example nearby location 1
        allloctions.add(new LatLng(18.449754050985188, 76.54711045324802)); // Example nearby location 2
        allloctions.add(new LatLng(18.4134986799656, 76.56697321683456)); // Example
        allloctions.add(new LatLng(18.4134986799655, 76.56697321683456)); // Example
        allloctions.add(new LatLng(18.4134986799566, 76.56697321683456)); // Example
        allloctions.add(new LatLng(18.41349867995665, 76.56697321683168)); // Example
        allloctions.add(new LatLng(18.413498699656, 76.56697321683168)); // Example
        allloctions.add(new LatLng(18.4134986799, 76.5669732168316)); // Example

        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
    map=googleMap;
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            Toast.makeText(getContext(), "permission granted", Toast.LENGTH_SHORT).show();
            nearbyLocations = new MapUtils().findNearbyLocations(new LatLng(3234253,234235235),allloctions,1000);
            setLocations();
            setMapClickListener();

        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }
    }

    private void setLocations() {
        int i=0;
        for (LatLng latlang:nearbyLocations ) {
            map.addMarker(new MarkerOptions().position(latlang).title("Nearby Location no "+i)).setTag(i);
            i++;
        }
    }
    private void setMapClickListener() {

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                int position = (int) marker.getTag(); // Get the tag assigned to the marker
                Toast.makeText(getContext(), "Marker clicked: " + position, Toast.LENGTH_SHORT).show();
                if (position>=0) {
                    // Handle marker click based on its position or any other relevant data
                    Toast.makeText(getContext(), "Marker clicked: " + position, Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

//        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                if (isLocationInList(latLng)) {
//                    Toast.makeText(getContext(), "Clicked location is in the nearby locations list", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getContext(), "Clicked location is not in the nearby locations list", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    private boolean isLocationInList(LatLng latLng) {
        for (LatLng location : nearbyLocations) {
            if (location.latitude == latLng.latitude && location.longitude == latLng.longitude) {
                return true;
            }
        }
        return false;
    }

}
