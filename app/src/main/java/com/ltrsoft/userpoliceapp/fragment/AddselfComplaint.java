package com.ltrsoft.userpoliceapp.fragment;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
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
import com.ltrsoft.userpoliceapp.model.ComplaintSubType;
import com.ltrsoft.userpoliceapp.model.ComplaintType;
import com.ltrsoft.userpoliceapp.model.Permission;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.PermissionUtils;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AddselfComplaint extends Fragment {
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private View view;


    public String COMPLAINT_SUBJECT = "Complaint Subject :";
    public String COMPLAINT_DESC = "Complaint Description :";
    public String AGAINST = "Complaint Against:";
    public String CMPT_TYPE = "select complaint type :";
    public String CMPT_DATE = "Date of incident :";
    public String CMPT_SUB_TYPE= "select Sub complaint type:";
    public String CMP_LOACTION= "Complaint Location :";
    public String STATIONS = "Select station :";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Submit");
        submit= view.findViewById(R.id.button);
        heading.setVisibility(View.GONE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){
                    Map <String,String> map =FormGenerator.getFormData(layout);
                    String alllatlang = map.get(CMP_LOACTION);
                    String lat="";
                    String longs="";

                    System.out.println("latlang"+alllatlang);
                    if (!alllatlang.equals(CMP_LOACTION)) {
                        String[] latlang = alllatlang.split(",");
                         lat = latlang[0];
                         longs = latlang[1];
                    }

                    Complaint complaint = new Complaint("1",map.get(COMPLAINT_SUBJECT),map.get(COMPLAINT_DESC),map.get(AGAINST),
                            map.get(CMPT_DATE),"",lat,longs,"1","","",
                            "1","12km","omline");

                    Complaint complaint1 = new Complaint("12","sub ","wef","wer",
                            "2003/12/23","1","1231234","asd","1","1","1",
                            "1","ad","online");
                    Log.d("Complaint", "ID: " + complaint.getComplaint_id());
                    Log.d("Complaint", "Subject: " + complaint.getComplaint_subject());
                    Log.d("Complaint", "Description: " + complaint.getComplaint_description());
                    Log.d("Complaint", "Against: " + complaint.getAgainst());
                    Log.d("Complaint", "Date: " + complaint.getIncident_date());
                    Log.d("Complaint", "Latitude: " + complaint.getLatitude());
                    Log.d("Complaint", "Longitude: " + complaint.getLongitude());
                    Log.d("Complaint", "User ID: " + complaint.getUser_id());
                    Log.d("Complaint", "Sub Type: " + complaint.getSubtype_id());
                    Log.d("Complaint", "Type: " + complaint.getStatus_id());

                    DAO dao = new DAO(getContext()   );
                    dao.insertOrUpdate(complaint, new NewCallBack() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "response  "+object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onEmpty() {
                            Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                        }
                    },URLS.INSERTCOMPLAINT);
                }else {
                    Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                }
            }
        });
        initView();
        return view;
    }

    private void initView() {
        elements=new ArrayList<>();
        elements.add(new FormElement(COMPLAINT_SUBJECT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.complaint));
        elements.add(new FormElement(COMPLAINT_DESC,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.complaint));
        elements.add(new FormElement(AGAINST,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.complaint));
        elements.add(new FormElement(CMPT_DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.complaint));
        elements.add(new FormElement(CMP_LOACTION,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_LOCATION,R.drawable.complaint));
        formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        setCmpType();
        setCmpSubType();
        Adapters adapters1 = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error while loading spinner", Toast.LENGTH_SHORT).show();
            }
        });
        adapters1.setStation();
    }

    private void setCmpSubType() {
        DAO dao = new DAO(getContext());
        dao.select(ComplaintSubType.class, "", "", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "type"+object.getClass(), Toast.LENGTH_SHORT).show();
                ArrayList<ComplaintSubType>list= (ArrayList<ComplaintSubType>) object;
                ArrayList<String>listc = new ArrayList<>();
                for (ComplaintSubType c:list) {
                    listc.add(c.getSubtype_name());
                }
                ArrayAdapter<String>adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,listc);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                Spinner spinner = formGenerator.generateSpinner(CMPT_SUB_TYPE, listc, adapter, new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
            }
        },URLS.GET_CMP_SUB_TYPE);
    }

    private void setCmpType() {
        DAO dao = new DAO(getContext());
        dao.select(ComplaintType.class, "", "", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<ComplaintType>list= (ArrayList<ComplaintType>) object;
                ArrayList<String>listc = new ArrayList<>();
                for (ComplaintType c:list) {
                    listc.add(c.getType_name());
                }
                ArrayAdapter<String>adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,listc);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                Spinner spinner = formGenerator.generateSpinner(CMPT_SUB_TYPE, listc, adapter, new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
            }
        },URLS.GET_CMP_TYPE);
    }
}
