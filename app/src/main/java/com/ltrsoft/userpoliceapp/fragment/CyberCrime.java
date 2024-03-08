package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private List<FormElement>elements;
    private static final String CATEGORY = "cybe crime category";
    private static final String LOST_MONEY = "Does you lost your money";
    private static final String DATE_TIME = "Date and time";
    private static final String IS_DELAY = "Is there any delay";
    private static final String WHERE_OCCURE = "where does it occure";
    private static final String EVIDENCE_PHOTO = "Evidence Photo";
    private static final String DESCRIPTION = "Description About Photo";
    private static final String STATION = "Station";

    public CyberCrime() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);

        elements = new ArrayList<>();
        elements.add(new FormElement(CATEGORY,FormElement.TYPE_SPINNER,""));
        elements.add(new FormElement(LOST_MONEY,FormElement.TYPE_CHECKBOX,""));
        elements.add(new FormElement(DATE_TIME,FormElement.TYPE_DATE_PICKER,""));
        elements.add(new FormElement(IS_DELAY,FormElement.TYPE_CHECKBOX,""));
        elements.add(new FormElement(WHERE_OCCURE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT));
        elements.add(new FormElement(EVIDENCE_PHOTO,FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_TEXT));
        elements.add(new FormElement(DESCRIPTION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT));
        elements.add(new FormElement(STATION,FormElement.TYPE_SPINNER,FormElement.SUBTYPE_TEXT));
        formGenerator = new FormGenerator(layout,elements);
        formGenerator.generateForm();
        Adapters adapters=new Adapters(getContext(),layout,formGenerator);
        adapters.setAdapters();


        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (FormValidator.isFormValid(layout)){
                        Map<String,String> map = formGenerator.getFormData(layout);
//                        Log.d(CATEGORY,)
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

