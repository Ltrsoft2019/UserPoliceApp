package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.List;

public class PeaceFullAssembly extends Fragment {


    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
     public static String Name="Name Of The Organization :",
             REGISTERED_ORG="is_organization_registered :",
             PROCESSION_REASON="Procession_Reason :",
             DATE ="Enter Date :",
             TYPE_OF_PROCESSION="Type Of Procession :",
             NUMBER_OF_PARTICOPANTS=" Number Of Participants :",
             FROM="Start Date  :",

             TO="End Date :" ,
             LOCATION=" Location :",
             VILLAGE=" Village :",
              TIME_FROM="Time From : ",
               TIME_UPTO  ="Time To :",
                MULTIPLE_STATION="Single Or Multiple Police Station",
                     status_id;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("PeaceFull Assembly");
        submit= view.findViewById(R.id.button);
        initializeViews(layout);
        return view;
    }

    private void initializeViews( LinearLayout layout) {
        elements=new ArrayList<>();
        elements.add(new FormElement(Name,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(REGISTERED_ORG,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(PROCESSION_REASON,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,R.drawable.calendar));
        elements.add(new FormElement(TYPE_OF_PROCESSION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(NUMBER_OF_PARTICOPANTS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(FROM,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,R.drawable.calendar));
        elements.add(new FormElement(TO,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,R.drawable.calendar));
        elements.add(new FormElement(LOCATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement( VILLAGE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(TIME_FROM,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(TIME_UPTO,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(MULTIPLE_STATION,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,R.drawable.align));
        formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters1 = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error while loading spinner", Toast.LENGTH_SHORT).show();
            }
        });
        adapters1.setAdapters();
 



    }

}

