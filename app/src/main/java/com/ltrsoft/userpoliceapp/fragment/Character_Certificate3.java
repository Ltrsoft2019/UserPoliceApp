package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.model.CharacterCertificate;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Character_Certificate3 extends Fragment {
    public Character_Certificate3() {
    }
    private View view;
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;
    private static  String
            VISIBLEMARK="Visible Mark",
            HAVEARRESTED="Have you ever arrested",
            ACTIVE_IN_POLOTCS="Have active in politics:",
            CRIMINAL="Is there any Crimnal offence registered against you :",
            C_RESIDE_ADDRES ="Adress of apllicant residing since";



    CharacterCertificate characterCertificate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Additional Information");
        button=view.findViewById(R.id.button);
        button.setText("Next");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            characterCertificate= getArguments().getParcelable("parcle", CharacterCertificate.class);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)) {
                    Map<String,String> map = FormGenerator.getFormData(layout);
//                    characterCertificate.setC
                    Character_Certificate4 certificate2 =new Character_Certificate4();
                    Bundle bundle = new Bundle();
                    characterCertificate.setVisible_mark(map.get(VISIBLEMARK));
                    characterCertificate.setActive_politics(map.get(ACTIVE_IN_POLOTCS));
                    characterCertificate.setHave_arrested(map.get(HAVEARRESTED));
                    characterCertificate.setIs_criminal(map.get(CRIMINAL));
                    characterCertificate.setIs_criminal(map.get(CRIMINAL));
                    bundle.putParcelable("parcle",characterCertificate);
                    certificate2.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container2,certificate2).addToBackStack(null).commit();
                }
            }
        });

        initialform(layout,button);
        return view;
    }

    private void initialform(LinearLayout layout, Button button) {
        elements=new ArrayList<>();
        elements.add(new FormElement(VISIBLEMARK,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(HAVEARRESTED,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(ACTIVE_IN_POLOTCS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(CRIMINAL,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(C_RESIDE_ADDRES,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        formGenerator=new FormGenerator(layout,elements,this);
        formGenerator.generateForm();

    }
}
