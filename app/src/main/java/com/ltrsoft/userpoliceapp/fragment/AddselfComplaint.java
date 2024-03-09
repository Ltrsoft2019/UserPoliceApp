package com.ltrsoft.userpoliceapp.fragment;

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
import com.google.android.gms.location.LocationServices;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.helper.LocationHelper;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Complaint;
import com.ltrsoft.userpoliceapp.model.Permission;
import com.ltrsoft.userpoliceapp.utils.PermissionUtils;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddselfComplaint extends Fragment implements LocationHelper.LocationResultListener {
    private static final int REQUESTCODE = 1000;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static String lattitude ,longitude;
    DAO dao ;
    public AddselfComplaint() {
    }
   private  View view;

    private EditText editTextComplaintSubject,
            editTextComplaintDescription, editTextAgainst;

    private Spinner complaint_type,editTextStationId;

    private DatePicker datePickerDob, datePickerIncidentDate;

    private Button UserSubmit, ComplaintSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addselftcomplaintfragment, container, false);
        dao=new DAO(getContext());
         setid();
         setAdapter();
         LocationHelper helper = new LocationHelper(getContext());
         helper.getLastKnownLocation(this);
        ComplaintSubmit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (isValid()){
                Toast.makeText(getContext(), "all fields are valid", Toast.LENGTH_SHORT).show();
                //editTextStationId.getSelectedItem().toString()
               String date = datePickerIncidentDate.getDayOfMonth()+"/"+(datePickerIncidentDate.getMonth()+1)+"/"+datePickerIncidentDate.getYear()+"/";
                Complaint complaint = new Complaint("",editTextComplaintSubject.getText().toString(),
                        editTextComplaintDescription.getText().toString(),
                        editTextAgainst.getText().toString(),
                        date,"",lattitude,longitude,"1","1","1","1");
                complaintRegister(complaint);
            }
            else {
                Toast.makeText(getContext(), "all fields are not valid", Toast.LENGTH_SHORT).show();
            }
         }
     });

        return view;
    }

    private void setAdapter() {

//        dao.select(Complaint.class,"","",);

    }

    private void complaintRegister(Complaint complaint) {
        DAO dao = new DAO(getContext());
        dao.insertOrUpdate(complaint, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Resposne "+object, Toast.LENGTH_SHORT).show();
                System.out.println("resposne "+object);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty response", Toast.LENGTH_SHORT).show();
            }
        }, URLS.INSERTCOMPLAINT);
    }

    private boolean isValid() {
        boolean valid = true;
        valid &= Validations.validateEditText(editTextComplaintSubject,"Enter Subject");
        valid&= Validations.validateEditText(editTextComplaintDescription,"Enter Complaint Description");
        valid&= Validations.validateEditText(editTextAgainst,"Field is not null");
        valid&= Validations.validateSpinner(editTextStationId,"Select station");
                return valid;
    }

    private void getLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        LocationHelper helper = new LocationHelper(getContext());
        helper.getLastKnownLocation(this);
    }

    private void setid() {
        editTextComplaintSubject = view.findViewById(R.id.editTextComplaintSubject);
        editTextComplaintDescription = view.findViewById(R.id.editTextComplaintDescription);
        editTextAgainst = view.findViewById(R.id.editTextAgainst);
        datePickerDob = view.findViewById(R.id.datePickerDob);
        datePickerIncidentDate = view.findViewById(R.id.datePickerIncidentDate);
        complaint_type = view.findViewById(R.id.complaint_type);
        ComplaintSubmit = view.findViewById(R.id.ComplaintSubmit);
    }


    @Override
    public void onLocationAvailable(Location location) {
        Toast.makeText(getContext(), "lat = "+location.getLatitude(), Toast.LENGTH_SHORT).show();
        longitude = String.valueOf(location.getLongitude());
        lattitude = String.valueOf(location.getLatitude());
    }

    @Override
    public void onLocationUnavailable() {
        Toast.makeText(getContext(), "location is unavailable", Toast.LENGTH_SHORT).show();
    }

    @Override
        public void onPermissionDenied() {
        Toast.makeText(getContext(), "permisssions denied", Toast.LENGTH_SHORT).show();
        }
}
