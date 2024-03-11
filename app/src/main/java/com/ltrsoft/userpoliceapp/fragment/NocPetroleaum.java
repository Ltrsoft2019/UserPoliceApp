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
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.List;

public class NocPetroleaum extends Fragment {

    private View view;
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private static String CERTIORLIC = "Certificate or license:";
    private static String FATHER = "Father name :";
    private static String PLACE_BIRTH = "Place of Birth:";
    private static String RESIDING_SINCE = "Residing Since :";
    private static String TYPEOFBLAS = "Type of blasting:";
    private static String FAX = "Fax :";
    private static String LICENSE_NOC = "License or certificate:";
    private static String WHICHPETROLEAUM = "Which Petroleaum:";
    private static String OFFICENUMVER = "Office Number :";
    private static String RESIDENCENO = "Residence Number :";
    private static String OCCUPATION = "Occupation :";
    private static String QUNATITY = "Quantity :";
    private static String BLASINGDETAIL = "Blasting Detail :";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Noc Petroleaum");
        submit.setText("Submit");
        initializeViews(view);

        return view;
    }

    private void initializeViews(View view) {

        elements.add(new FormElement(CERTIORLIC,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(FATHER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(PLACE_BIRTH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(FAX,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(TYPEOFBLAS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(RESIDING_SINCE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(LICENSE_NOC,FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(WHICHPETROLEAUM,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(OFFICENUMVER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(OFFICENUMVER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(OFFICENUMVER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(OFFICENUMVER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(OFFICENUMVER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
//        formGenerator=new FormGenerator(layout,elements,this);`
        formGenerator.generateForm();
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {

            }
        });
        formGenerator=new FormGenerator(layout,elements,this);
    }
}

