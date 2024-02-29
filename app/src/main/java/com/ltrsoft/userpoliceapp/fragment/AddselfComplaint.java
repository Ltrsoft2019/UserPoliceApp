package com.ltrsoft.userpoliceapp.fragment;

import com.google.android.gms.location.LocationServices;
import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.helper.LocationHelper;
import com.ltrsoft.userpoliceapp.model.Complaint;
import com.ltrsoft.userpoliceapp.model.Permission;
import com.ltrsoft.userpoliceapp.utils.PermissionUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddselfComplaint extends Fragment implements LocationHelper.LocationResultListener {
    private static final int REQUESTCODE = 1000;
    private FusedLocationProviderClient fusedLocationProviderClient;
    public AddselfComplaint() {
    }
   private  View view;
    private EditText editTextFirstName, editTextMiddleName, editTextLastName,
            editTextAddress, editTextEmail, editTextPassword,
            editTextMobile1, editTextMobile2, editTextAadhar,
            editTextPAN, editTextOccupation, editTextNationality,
            editTextDrivingLicense,   editTextComplaintSubject,
            editTextComplaintDescription, editTextAgainst;

    private Spinner spinnerGender, editTextCountryId, editTextStateId, editTextDistrictId,
            editTextCityId, editTextSubtypeId,editTextStationId;

    private DatePicker datePickerDob, datePickerIncidentDate;

    private Button UserSubmit, ComplaintSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addselftcomplaintfragment, container, false);
     setid();
        UserSubmit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
//             PermissionUtils.requestPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
             if (!PermissionUtils.isPermissionGranted(getContext(),Manifest.permission.ACCESS_FINE_LOCATION)) {
                 PermissionUtils.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, REQUESTCODE);
             }
             else {
                 Toast.makeText(getContext(), "permission already granted", Toast.LENGTH_SHORT).show();
                getLocation();
             }

         }
     });
     Complaint complaint = createComplaintObject();
        return view;
    }

    private void getLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        LocationHelper helper = new LocationHelper(getContext());
        helper.getLastKnownLocation(this);
    }

    private void setid() {
        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextMiddleName = view.findViewById(R.id.editTextMiddleName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        editTextAddress = view.findViewById(R.id.editTextAddress);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextMobile1 = view.findViewById(R.id.editTextMobile1);
        editTextMobile2 = view.findViewById(R.id.editTextMobile2);
        editTextAadhar = view.findViewById(R.id.editTextAadhar);
        editTextPAN = view.findViewById(R.id.editTextPAN);
        editTextOccupation = view.findViewById(R.id.editTextOccupation);
        editTextNationality = view.findViewById(R.id.editTextNationality);
        editTextDrivingLicense = view.findViewById(R.id.editTextDrivingLicense);
        editTextComplaintSubject = view.findViewById(R.id.editTextComplaintSubject);
        editTextComplaintDescription = view.findViewById(R.id.editTextComplaintDescription);
        editTextAgainst = view.findViewById(R.id.editTextAgainst);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        editTextCountryId = view.findViewById(R.id.editTextCountryId);
        editTextStateId = view.findViewById(R.id.editTextStateId);
        editTextDistrictId = view.findViewById(R.id.editTextDistrictId);
        editTextCityId = view.findViewById(R.id.editTextCityId);
        editTextSubtypeId = view.findViewById(R.id.editTextSubtypeId);
        datePickerDob = view.findViewById(R.id.datePickerDob);
        datePickerIncidentDate = view.findViewById(R.id.datePickerIncidentDate);

        // Find all Buttons
        UserSubmit = view.findViewById(R.id.UserSubmit);
        ComplaintSubmit = view.findViewById(R.id.ComplaintSubmit);
    }

    private Complaint createComplaintObject() {
        String complaintSubject = editTextComplaintSubject.getText().toString();
        String complaintDescription = editTextComplaintDescription.getText().toString();
        String against = editTextAgainst.getText().toString();

        // Get incident date from DatePicker
        Calendar incidentDateCalendar = Calendar.getInstance();
        incidentDateCalendar.set(datePickerIncidentDate.getYear(),
                datePickerIncidentDate.getMonth(),
                datePickerIncidentDate.getDayOfMonth());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String incidentDate = sdf.format(incidentDateCalendar.getTime());

        // Retrieve other relevant data from your UI components
        String statusId = ""; // You need to retrieve status ID from somewhere
        String latitude = ""; // You need to retrieve latitude from somewhere
        String longitude = ""; // You need to retrieve longitude from somewhere
        String userId = ""; // You need to retrieve user ID from somewhere
        String complaintFirId = ""; // You need to retrieve FIR ID from somewhere
        String subtypeId = ""; // You need to retrieve subtype ID from somewhere

        return new Complaint("", complaintSubject, complaintDescription, against,
                incidentDate, statusId, latitude, longitude, userId, complaintFirId, subtypeId, "", "");
    }

    @Override
    public void onLocationAvailable(Location location) {
        if (location != null) {
            Toast.makeText(getContext(), "Latitude: " + location.getLatitude() + ", Longitude: " + location.getLongitude(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Location is null", Toast.LENGTH_SHORT).show();
        }    }

    @Override
    public void onLocationUnavailable() {
        Toast.makeText(getContext(), "location is unavailable", Toast.LENGTH_SHORT).show();
    }

    @Override
        public void onPermissionDenied() {
        Toast.makeText(getContext(), "permisssions denied", Toast.LENGTH_SHORT).show();
        }
}
