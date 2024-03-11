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
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Unidentified_Bodies;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnidentifiedBody1 extends Fragment {
    public UnidentifiedBody1() {}

    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private static String DATE = "Date and Time of Recovery";
    private static String LOCATION = "Location where the body found";
    private static String GENDER = "Select Gender";
    private static String AGE = "Enter Esimated Age";
    private static String HEIGHT = "Height";
    private static String WEIGHT = "Weight ";
    private static String BUILD = "Build ";
    private static String RARE_ETHNICITY = "Race and Ethnictiy";
    private static String HAIRCOLOR = "Hair Colour";
    private static String EYECOLOR = "Eye Colour";
    private static String DISTINGUISH = "Distinguish features";
    private static String CLOTH = "Description of Clothing";
    private static String BODY_CONDITION = "Body condition";
    private static String LATLONG = "Map Location";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("UnIdentified Body");
        submit.setText("Next");
        elements = new ArrayList<>();

        elements.add(new FormElement(DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.reminders));
        elements.add(new FormElement(LOCATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(GENDER,FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.reminders));
        elements.add(new FormElement(AGE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(HEIGHT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(WEIGHT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(BUILD,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(RARE_ETHNICITY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(HAIRCOLOR,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(EYECOLOR,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(DISTINGUISH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(CLOTH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(BODY_CONDITION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(LATLONG,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_LOCATION,R.drawable.karnataka_police_logo));
        formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "something goes wrong "+error, Toast.LENGTH_SHORT).show();
            }
        });
        adapters.setStation();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)) {
                    Map <String,String> map = FormGenerator.getFormData(layout);
//                    UnidentifiedBody2 fragment = new UnidentifiedBody2();
//                    Bundle bundle = new Bundle();
                    String alllatlang = map.get(LATLONG);
                    String [] latlang = alllatlang.split(",");
                    String lat=latlang[0];
                    String longs=latlang[1];

                    Unidentified_Bodies parcle = new Unidentified_Bodies("1",
                            map.get(DATE),map.get(LOCATION),  map.get(GENDER),  map.get(AGE),  map.get(HEIGHT),  map.get(WEIGHT),  map.get(BUILD),
                            map.get(RARE_ETHNICITY),  map.get(HAIRCOLOR),  map.get(EYECOLOR),  map.get(DISTINGUISH),  map.get(CLOTH),  map.get(BODY_CONDITION),
                            lat,longs,map.get(FormElement.STATION),new UserDataAccess().getUserId(getActivity()));

                    DAO dao = new DAO(getContext());
                    dao.insertOrUpdate(parcle, new NewCallBack() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "succsess "+object, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onEmpty() {
                            Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();

                        }
                    }, URLS.INSRT_UNIDENTIFIED_DEAD_BODY);
//                    bundle.putParcelable("class",parcle);
//                    fragment.setArguments(bundle);
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container2,fragment).addToBackStack(null).commit();
                }
            }
        });
        return view;
    }
}
