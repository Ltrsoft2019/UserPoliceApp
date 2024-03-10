package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeVerification extends Fragment {

    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private List<FormElement> elements;

    private Button submit;
    private TextView heading;
    private static String
             EMPLOYEE_VERIFICATION_ID = "Employee Verification Id",
            COMPANY_NAME = "Company Name",
            COMPANY_ADDRESS = "Company Address",
            JOB_TITLE = "Job Title",
            JOINING_DATE = "Joining Date",
            SALARY = "Salary",
            PREVIOUS_EMPLOYER_NAME = "Previous Employer Name",
            DURATION_OF_EMPLOYER = "Duration of Employment",
            REASON_FOR_LEAVING = "Reason for Leaving",
            JOB_DESCRIPTION_RESPONSIBILITIES = "Job Description Responsibilities",
            USER_ID = "User Id",
            STATION_ID = "Station Id",
            IDENTITY_PROOF_DOC_NUMBER = "Identity Proof Document Number",
            IDENTITY_PROOF_ISSUING_AUTHORITY = "Identity Proof Issuing Authority",
            IDENTITY_PROOF_DATE_OF_ISSUE = "Identity Proof Date of Issue",
            IDENTITY_PROOF_DATE_OF_EXPIRY = "Identity Proof Date of Expiry",
            ADDRESS_PROOF_DOC_NUMBER = "Address Proof Document Number",
            ADDRESS_PROOF_ISSUING_AUTHORITY = "Address Proof Issuing Authority",
            ADDRESS_PROOF_DATE_OF_ISSUE = "Address Proof Date of Issue",
            PURPOSE_OF_EMPLOYMENT = "Purpose of Employment",
            STATUS_ID = "Status Id",
            PERMISSION_Id = "Permission Id";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);

        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Domestic Help");
        initializeViews(layout,submit);

        return view;
    }

    private void initializeViews(LinearLayout layout, Button submit) {
        elements = new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);
         elements.add(new FormElement(COMPANY_NAME, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(COMPANY_ADDRESS, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(JOB_TITLE, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(JOINING_DATE, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(SALARY, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(PREVIOUS_EMPLOYER_NAME, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(DURATION_OF_EMPLOYER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(REASON_FOR_LEAVING, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(JOB_DESCRIPTION_RESPONSIBILITIES, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        //elements.add(new FormElement(USER_ID, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
       // elements.add(new FormElement(STATION_ID, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_DOC_NUMBER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_ISSUING_AUTHORITY, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_DATE_OF_ISSUE, FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_DATE_OF_EXPIRY, FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement(ADDRESS_PROOF_DOC_NUMBER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(ADDRESS_PROOF_ISSUING_AUTHORITY, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(ADDRESS_PROOF_DATE_OF_ISSUE, FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement(PURPOSE_OF_EMPLOYMENT, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
       // elements.add(new FormElement(STATUS_ID, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(PERMISSION_Id, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        Adapters adapters=new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "their is a error", Toast.LENGTH_SHORT).show();
            }
        });
        adapters.setStation();
        formGenerator.generateForm();
      submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (FormValidator.isFormValid(layout)){
                  Map<String,String> map=FormGenerator.getFormData(layout);
                  com.ltrsoft.userpoliceapp.model.EmployeeVerification employeeVerification=new com.ltrsoft.userpoliceapp.model.EmployeeVerification(
                          "",
                          map.get(COMPANY_NAME),
                          map.get(COMPANY_ADDRESS),
                          map.get(JOB_TITLE),
                          map.get(JOINING_DATE),
                          map.get(SALARY),
                          map.get(PREVIOUS_EMPLOYER_NAME),
                          map.get(DURATION_OF_EMPLOYER),
                          map.get(REASON_FOR_LEAVING),
                          map.get(JOB_DESCRIPTION_RESPONSIBILITIES),
                          map.get(USER_ID),
                          map.get(STATION_ID),
                          map.get(IDENTITY_PROOF_DOC_NUMBER),
                          map.get(IDENTITY_PROOF_ISSUING_AUTHORITY),
                          map.get(IDENTITY_PROOF_DATE_OF_ISSUE),
                          map.get(IDENTITY_PROOF_DATE_OF_EXPIRY),
                          map.get(ADDRESS_PROOF_DOC_NUMBER),
                          map.get(ADDRESS_PROOF_ISSUING_AUTHORITY),
                          map.get(ADDRESS_PROOF_DATE_OF_ISSUE),
                          map.get(PURPOSE_OF_EMPLOYMENT),
                          map.get(STATUS_ID),
                          map.get(PERMISSION_Id)

                  );
              }
              else {
                  Toast.makeText(getContext(), "All Fields Are Compulsory", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }


}
