package com.ltrsoft.userpoliceapp.fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.LocationDao;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
public class AddComplaintOnBehalf extends Fragment {
    private boolean valid;
    private EditText editTextFirstName, editTextMiddleName, editTextLastName, editTextAddress,
            editTextEmail, editTextPassword, editTextMobile1, editTextMobile2, editTextAadhar,
            editTextPAN, editTextOccupation, editTextNationality, editTextDrivingLicense,
            editTextNotificationToken,  editTextStateId, editTextDistrictId,
            editTextCityId, editTextComplaintSubject, editTextComplaintDescription, editTextAgainst,
             editTextLatitude, editTextLongitude;
    private Spinner spinnerGender,editTextSubtypeId,editTextCountryId,spinnersationId;
    private DatePicker datePickerDob, datePickerIncidentDate;
    private Button buttonUserSubmit, buttonComplaintSubmit;
    private ArrayAdapter<String>adapter;
    private View view;
    public AddComplaintOnBehalf() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addbehalfcomplaintfragment, container, false);
        setId();
        setUpAdapter();

        buttonComplaintSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(validateForm()){
                  Toast.makeText(getContext(), " all form is validate ", Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(getContext(), "form is not validate ", Toast.LENGTH_SHORT).show();
              }
            }
        });
        return view;
    }

    private void setUpAdapter() {

        LocationDao locationDao = new LocationDao(getContext());
        locationDao.getCountryAdapter(new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext() , "error "+error, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(Object object) {
                adapter = (ArrayAdapter<String>) object;
                editTextCountryId.setAdapter(adapter);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setId() {
        spinnersationId = view.findViewById(R.id.spinnerstation);
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
        editTextNotificationToken = view.findViewById(R.id.editTextNotificationToken);
        editTextCountryId = view.findViewById(R.id.editTextCountryId);
        editTextStateId = view.findViewById(R.id.editTextStateId);
        editTextDistrictId = view.findViewById(R.id.editTextDistrictId);
        editTextCityId = view.findViewById(R.id.editTextCityId);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        datePickerDob = view.findViewById(R.id.datePickerDob);
        editTextComplaintSubject = view.findViewById(R.id.editTextComplaintSubject);
        editTextComplaintDescription = view.findViewById(R.id.editTextComplaintDescription);
        editTextAgainst = view.findViewById(R.id.editTextAgainst);
        datePickerIncidentDate = view.findViewById(R.id.datePickerIncidentDate);
        editTextSubtypeId = view.findViewById(R.id.editTextSubtypeId);
        editTextLatitude = view.findViewById(R.id.editTextLatitude);
        editTextLongitude = view.findViewById(R.id.editTextLongitude);
        buttonUserSubmit = view.findViewById(R.id.UserSubmit);
        buttonComplaintSubmit = view.findViewById(R.id.ComplaintSubmit);

    }

    private boolean validateForm() {
        boolean isValid = true;

        isValid &= validateEditText(editTextFirstName, "First Name");
        isValid &= validateEditText(editTextMiddleName, "Middle Name");
        isValid &= validateEditText(editTextLastName, "Last Name");
        isValid &= validateEditText(editTextAddress, "Address");
        isValid &= validateEditText(editTextEmail, "Email");
        isValid &= validateEditText(editTextPassword, "Password");
        isValid &= validateEditText(editTextMobile1, "Mobile Number 1");
        isValid &= validateEditText(editTextMobile2, "Mobile Number 2");
        isValid &= validateEditText(editTextAadhar, "Aadhar Number");
        isValid &= validateEditText(editTextPAN, "PAN Number");
        isValid &= validateEditText(editTextOccupation, "Occupation");
        isValid &= validateEditText(editTextNationality, "Nationality");
        isValid &= validateEditText(editTextDrivingLicense, "Driving License");
//        isValid &= validateEditText(editTextCountryId, "Country");
        isValid &= validateEditText(editTextStateId, "State");
        isValid &= validateEditText(editTextDistrictId, "District");
        isValid &= validateEditText(editTextCityId, "City");
        isValid &= validateEditText(editTextComplaintSubject, "Complaint Subject");
        isValid &= validateEditText(editTextComplaintDescription, "Complaint Description");
        isValid &= validateEditText(editTextAgainst, "Against");

        return isValid;
    }
    private boolean validateEditText(EditText editText, String fieldName) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            editText.setError(fieldName + " is required");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateSpinner(Spinner spinner, String fieldName) {
//        String selectedItem = spinner.getSelectedItem().toString();
//        if (selectedItem.isEmpty() || selectedItem.equals("Select")) { // Change "Select" according to your default selection
//            // Show error message or handle validation failure as needed
//            // For spinners, you can't set an error directly, you might use a TextView to display the error message
//            return false;
//        }
//        return true;
        return true;
    }

}