package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

    public CyberCrime() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Cyber Crime");
        elements = new ArrayList<>();
        elements.add(new FormElement(CATEGORY,FormElement.TYPE_SPINNER,""));
        elements.add(new FormElement(WHERE_OCCURE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT));
         elements.add(new FormElement(STATION,FormElement.TYPE_SPINNER,FormElement.SUBTYPE_TEXT));
        elements.add(new FormElement(DATE_PICKER,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT));
        elements.add(new FormElement(GENDER,FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_TEXT));



        elements.add(new FormElement(EVIDENCE_PHOTO,FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_TEXT));
        elements.add(new FormElement(DESCRIPTION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT));

        elements.add(new FormElement(LOST_MONEY,FormElement.TYPE_CHECKBOX,""));
        elements.add(new FormElement(IS_DELAY,FormElement.TYPE_CHECKBOX,""));
         formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters=new Adapters(getContext(),layout,formGenerator);
        adapters.setAdapters();

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (FormValidator.isFormValid(layout)){
                        Map<String,String> map = formGenerator.getFormData(layout);
//                        Log.d(CATEGORY,map.get(CATEGORY));
//                        Log.d(LOST_MONEY,map.get(LOST_MONEY));
//                        Log.d(DATE_TIME,map.get(DATE_TIME));
//                        Log.d(IS_DELAY,map.get(IS_DELAY));
//                        Log.d(WHERE_OCCURE,map.get(WHERE_OCCURE));
//                        Log.d(EVIDENCE_PHOTO,map.get(EVIDENCE_PHOTO));
//                        Log.d(DESCRIPTION,map.get(DESCRIPTION));
//                        Log.d(STATION,map.get(STATION));
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

