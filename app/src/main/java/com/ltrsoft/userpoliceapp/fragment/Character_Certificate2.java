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
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Character_Certificate2 extends Fragment {
    public Character_Certificate2() {
    }

    private View view;
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;

    private static  String
            BUILDING="Previous Building",
            STREET="Previous Street Name",
            LANDMARK="Previous Landmark :",
            LOCALITY="Previous Locality :";
    CharacterCertificate characterCertificate;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Previous Resedential Address");
        button=view.findViewById(R.id.button);
        button.setText("Next");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
           characterCertificate= getArguments().getParcelable("parcle", CharacterCertificate.class);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)) {
                    Map <String,String> map = FormGenerator.getFormData(layout);
                    String building = map.get(BUILDING);
                    String street = map.get(STREET);
                    String landmark = map.get(LANDMARK);
                    String locality = map.get(LOCALITY);
                    characterCertificate.setCbuilding(building);
                    characterCertificate.setClandmark(landmark);
                    characterCertificate.setCstreet(street);
                    characterCertificate.setClocality(locality);
                    characterCertificate.setCpincode("");
                    characterCertificate.setCstate_id(map.get(FormElement.STATE));
                    characterCertificate.setCdistrict_id(map.get(FormElement.DISTRICT));
                    characterCertificate.setVisible_mark(landmark);
//                    characterCertificate.setC
                    Character_Certificate3 certificate2 =new Character_Certificate3();
                    Bundle bundle = new Bundle();
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
        elements.add(new FormElement(BUILDING,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(STREET,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(LANDMARK,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(LOCALITY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        formGenerator=new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }
        });
        adapters.setAdapters();
    }
}
