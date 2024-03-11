package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.DomesticWorkers;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DomesticHelp extends Fragment {


    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private List<FormElement> elements;

    private Button submit;
    private TextView heading;
    private String DOMESTIC_ID = "Domestic ID",
            USER_ID = "User ID",
            FULL_NAME_OF_DOMESTIC_HELP = "Full Name of Domestic Help",
            GENDER = "Gender",
            DATE_OF_BIRTH = "Date of Birth",
            PERMANENT_ADDRESS = "Permanent Address",
            CONTACT_NUMBER = "Contact Number",
            EMAIL_ADDRESS = "Email Address",
            NAME_OF_PREVIOUS_EMPLOYER = "Name of Previous Employer",
            DURATION_OF_EMPLOYMENT = "Duration of Employment",
            REASON_FOR_LEAVING = "Reason for Leaving",
            IDENTIFICATION_DOCUMENTS_SUBMITTED = "Identification Documents Submitted",
            IDENTITY_PROOF_DOC_NUMBER = "Identity Proof Doc Number",
            IDENTITY_PROOF_ISSUING_AUTHORITY = "Identity Proof Issuing Authority",
            IDENTITY_PROOF_DATE_OF_ISSUE = "Identity Proof Date of Issue",
            IDENTITY_PROOF_DATE_OF_EXPIRY = "Identity Proof Date of Expiry",
            ADDRESS_PROOF_DOC_NUMBER = "Address Proof Doc Number",
            ADDRESS_PROOF_ISSUING_AUTHORITY = "Address Proof Issuing Authority",
            ADDRESS_PROOF_DATE_OF_ISSUE = "Address Proof Date of Issue",
            PURPOSE_OF_EMPLOYMENT = "Purpose of Employment",
            JOB_TITLE_OR_ROLE = "Job Title or Role",
            START_DATE_OF_EMPLOYMENT = "Start Date of Employment",
            SALARY_OR_COMPENSATION_DETAILS = "Salary or Compensation Details",
            ADDITIONAL_INFORMATION_ABOUT_EMPLOYMENT = "Additional Information About Employment",
            STATION_ID = "Station ID",
            STATUS_ID = "Status ID",
            PERMISSION_ID = "Permission ID";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Domestic Help");
        init(layout,submit);
        return view;
    }

    private void init(LinearLayout layout, Button submit) {
        elements = new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);
        elements.add(new FormElement(FULL_NAME_OF_DOMESTIC_HELP,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
         elements.add(new FormElement(GENDER, FormElement.TYPE_RADIO_GROUP, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(DATE_OF_BIRTH, FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement(PERMANENT_ADDRESS, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(CONTACT_NUMBER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.call));
        elements.add(new FormElement(EMAIL_ADDRESS, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_EMAIL, R.drawable.location));
        elements.add(new FormElement(NAME_OF_PREVIOUS_EMPLOYER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(DURATION_OF_EMPLOYMENT, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(REASON_FOR_LEAVING, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(IDENTIFICATION_DOCUMENTS_SUBMITTED, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_DOC_NUMBER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_NUMBER, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_ISSUING_AUTHORITY, FormElement.TYPE_IMAGE_VIEW, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_DATE_OF_ISSUE, FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement(IDENTITY_PROOF_DATE_OF_EXPIRY, FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement(ADDRESS_PROOF_DOC_NUMBER, FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement("ADDRESS_PROOF_ISSUING_AUTHORITY", FormElement.TYPE_IMAGE_VIEW, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement("ADDRESS_PROOF_DATE_OF_ISSUE", FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement("PURPOSE_OF_EMPLOYMENT", FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement("JOB_TITLE_OR_ROLE", FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement("START_DATE_OF_EMPLOYMENT", FormElement.TYPE_BUTTON, FormElement.SUBTYPE_BUTTON_DATEPICKER, R.drawable.location));
        elements.add(new FormElement("SALARY_OR_COMPENSATION_DETAILS", FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement("ADDITIONAL_INFORMATION_ABOUT_EMPLOYMENT", FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        // elements.add(new FormElement("STATUS_ID", FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
        elements.add(new FormElement("PERMISSION_ID", FormElement.TYPE_EDIT_TEXT, FormElement.SUBTYPE_TEXT, R.drawable.location));
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
                Map<String,String>map=FormGenerator.getFormData(layout);
                DAO dao=new DAO(getContext());
                DomesticWorkers domesticWorkers=new DomesticWorkers("",
                         "",
                         map.get(FULL_NAME_OF_DOMESTIC_HELP),

                        map.get(GENDER),
                        map.get(DATE_OF_BIRTH),
                        map.get(PERMANENT_ADDRESS),
                        map.get(CONTACT_NUMBER),

                        map.get(EMAIL_ADDRESS),
                        map.get(NAME_OF_PREVIOUS_EMPLOYER),

                        map.get(DURATION_OF_EMPLOYMENT),
                        map.get(REASON_FOR_LEAVING),
                        map.get(IDENTIFICATION_DOCUMENTS_SUBMITTED),
                        map.get(IDENTITY_PROOF_DOC_NUMBER),
                        map.get(IDENTITY_PROOF_ISSUING_AUTHORITY),
                        map.get(IDENTITY_PROOF_DATE_OF_ISSUE),
                        map.get(IDENTITY_PROOF_DATE_OF_EXPIRY),
                        map.get(ADDRESS_PROOF_DOC_NUMBER),
                        map.get(ADDRESS_PROOF_ISSUING_AUTHORITY),
                        map.get(ADDRESS_PROOF_DATE_OF_ISSUE),
                        map.get(PURPOSE_OF_EMPLOYMENT),
                        map.get(JOB_TITLE_OR_ROLE),
                        map.get(START_DATE_OF_EMPLOYMENT),
                        map.get(SALARY_OR_COMPENSATION_DETAILS),
                        map.get(ADDITIONAL_INFORMATION_ABOUT_EMPLOYMENT),
                         map.get(map.get(FormElement.STATION)),
                        "",
                        map.get(PERMISSION_ID));

                dao.insertOrUpdate(domesticWorkers, new NewCallBack() {
                    @Override
                    public void onError(String error) {
                        Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(Object object) {
                        Toast.makeText(getContext(), "response "+object, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {
                        Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                    }
                }, URLS.INSERT_DOMESTIC);

            }
            else {
                Toast.makeText(getContext(), "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
            }
        }
    });

    }


}

