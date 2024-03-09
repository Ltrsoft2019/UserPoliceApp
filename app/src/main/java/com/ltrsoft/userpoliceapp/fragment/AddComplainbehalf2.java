package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;

import java.util.ArrayList;
import java.util.List;

public class AddComplainbehalf2 extends Fragment {
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private View view;
    public String C_SUB = "Enter Complaint Subject:";
    public String C_DESC = "Enter Complaint Description:";
    public String C_AGNST = "Complaint Aganinst:";
    public String INCDNT_DATE = "Incident date:";
    public String CMP_TYPE = "Complaint Type:";
    public String CMP_SUB_TYPE = "Complaint sub Type:";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Register Complaint");
        submit= view.findViewById(R.id.button);
        intiForm(layout);
        return view;
    }

    private void intiForm(LinearLayout layout) {
        formGenerator.generateForm();
        List<FormElement >newElements = new ArrayList<>();
        newElements.add(new FormElement(C_SUB,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,1));
        newElements.add(new FormElement(C_DESC,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,1));
        newElements.add(new FormElement(C_AGNST,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,1));
        newElements.add(new FormElement(INCDNT_DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,1));
        newElements.add(new FormElement(INCDNT_DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,1));

    }
}
