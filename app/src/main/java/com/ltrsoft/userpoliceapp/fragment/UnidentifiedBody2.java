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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;

import java.util.ArrayList;
import java.util.List;

public class UnidentifiedBody2 extends Fragment {
    public UnidentifiedBody2() {}
    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private static String RARE_ETHNICITY = "Race and Ethnictiy";
    private static String HAIRCOLOR = "Hair Colour";
    private static String DISTINGUISH = "Distinguish features";
    private static String CLOTH = "Description of Clothing";
    private static String BODY_CONDITION = "Body condition";

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
        elements.add(new FormElement(RARE_ETHNICITY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(HAIRCOLOR,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(DISTINGUISH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(CLOTH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(CLOTH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));

        return view;
    }
}

