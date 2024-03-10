package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.ltrsoft.userpoliceapp.ui.FormValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UnidentifiedObjectFragment extends Fragment {
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private View view;
    private String DATE = "Date And Time of of Recovery :";
    private String Location = "Location where the object was found :";
    private String Condition = "Condition of the Object :";
    private String IDENTIFY = "Any Identifying Marks of Features :";
    private String DESC = "Description of the Object :";
    private String STATION = "Select Station :";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.common_form, container, false);

        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Add UnIdentifird Body");
        elements=new ArrayList<>();
        submit=view.findViewById(R.id.button);

        initializeViews(layout);
        return view;
    }

    private void initializeViews(LinearLayout layout) {
        elements=new ArrayList<>();

        elements.add(new FormElement(DATE,FormElement.TYPE_BUTTON,FormElement.SYBTYPE_SEXT_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(Location,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(Condition,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(IDENTIFY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(DESC,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        elements.add(new FormElement(DESC,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.karnataka_police_logo));
        formGenerator = new FormGenerator(layout,elements,this);
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }
        });

        formGenerator.generateForm();
        adapters.setStation();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){
                    Map <String,String>map = FormGenerator.getFormData(layout);
                    Log.d(Condition, String.valueOf(map.size()));
//                    Log.d(FormElement.STATION,map.get(FormElement.STATION));
                }
            }
        });

    }

}

