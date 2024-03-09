package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.CyberCrimemodel;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.ui.GetLists;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class CyberCrime extends Fragment {
    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement>elements;
    private static final String GENDER = "Gender";

    private static final String CATEGORY = "Cyber crime category";
    private static final String LOST_MONEY = "Does you lost your money";
    private static final String DATE_TIME = "Date and time";
    private static final String IS_DELAY = "Is there any delay";
    private static final String WHERE_OCCURE = "Where Does It Occure";
    private static final String EVIDENCE_PHOTO = "Evidence Photo";
    private static final String DESCRIPTION = "Description About Photo";
    private static final String STATION = "Station";
    private static final String DATE_PICKER = "Incidant Date";
    private static final String CYBER_CRIME_CATEGORY = "Select Cyber Category";

    public CyberCrime() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Cyber Crime");
        elements = new ArrayList<>();
        ArrayList<String>stationlist=new ArrayList<>();
        stationlist.add("latur");
        stationlist.add("fed");
        stationlist.add("lasdfur");
        stationlist.add("lafsdftur");
        stationlist.add("ladstur");
        stationlist.add("latfdsur");

        ArrayAdapter <String>adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,stationlist);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        formGenerator = new FormGenerator(layout,elements,this);

        Spinner spinner= formGenerator.generateSpinner(CYBER_CRIME_CATEGORY,stationlist, adapter, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner2= formGenerator.generateSpinner("Sub category",stationlist, adapter, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        elements.add(new FormElement(LOST_MONEY,FormElement.TYPE_CHECKBOX,"",R.drawable.cam2));
        elements.add(new FormElement(DATE_PICKER,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(IS_DELAY,FormElement.TYPE_CHECKBOX,"",R.drawable.mic2));
        elements.add(new FormElement(WHERE_OCCURE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.mic2));
        elements.add(new FormElement(DESCRIPTION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));

        elements.add(new FormElement(EVIDENCE_PHOTO,FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_TEXT,R.drawable.cam2));


        formGenerator.generateForm();

        Spinner spinner3= formGenerator.generateSpinner(STATION,stationlist, adapter, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (FormValidator.isFormValid(layout)){
                        Map<String,String> map = FormGenerator.getFormData(layout);
//                        Log.d(CATEGORY, Objects.requireNonNull(map.get(CATEGORY)));
//                        Log.d(LOST_MONEY, Objects.requireNonNull(map.get(LOST_MONEY)));
//                        Log.d(DATE_TIME,map.get(DATE_PICKER));
//                        Log.d(IS_DELAY,map.get(IS_DELAY));
//                        Log.d(WHERE_OCCURE,map.get(WHERE_OCCURE));
//                        Log.d(EVIDENCE_PHOTO,map.get(STATION));
//                        Log.d(DESCRIPTION,map.get(DESCRIPTION));
//                        Log.d(STATION, map.get(STATION));
//                        Log.d(CYBER_CRIME_CATEGORY, map.get(CYBER_CRIME_CATEGORY));

                        Log.d("Size", String.valueOf(map.size()));
                        CyberCrimemodel cyberCrime = new CyberCrimemodel();
                        cyberCrime.setCyber_crime_category_id(map.get(CYBER_CRIME_CATEGORY));
                        cyberCrime.setDate_time(map.get(DATE_PICKER));
                        cyberCrime.setIs_delay(map.get(IS_DELAY));
                        cyberCrime.setDescription(map.get(DESCRIPTION));
                        cyberCrime.setEvidance_photo(map.get(EVIDENCE_PHOTO));
                        cyberCrime.setLost_money(map.get(LOST_MONEY));
                        cyberCrime.setWhere_accure(map.get(WHERE_OCCURE));
                        cyberCrime.setStation_id(map.get(STATION));
                        cyberCrime.setCyber_crime_id(map.get(STATION));
                        cyberCrime.setStatus_id(map.get(STATION));

                        cyberCrime.setUser_id((new UserDataAccess().getUserId(getActivity())));
                        DAO dao = new DAO(getContext());

                        dao.insertOrUpdate(cyberCrime, new NewCallBack() {
                            @Override
                            public void onError(String error) {
                                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onSuccess(Object object) {
                                Toast.makeText(getContext(), "object type"+object, Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onEmpty() {
                                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                            }
                        }, URLS.CYBER_COMPLAINT_INSERT);
                    }
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        formGenerator.onActivityResult(requestCode,resultCode,data);
    }
}

