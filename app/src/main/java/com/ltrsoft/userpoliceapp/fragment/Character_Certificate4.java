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
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.CharacterCertificate;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Character_Certificate4 extends Fragment {
    public Character_Certificate4() {
    }
    private View view;
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;
    CharacterCertificate characterCertificate=null ;
    private static  String
            FROM="From",
            TO="To",
            PINCODE="pincode",
            C_RESIDE_ADDRES ="Adress of apllicant residing since";    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Recent Places that you have visited");
        button=view.findViewById(R.id.button);
        button.setText("Submit");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            characterCertificate= getArguments().getParcelable("parcle", CharacterCertificate.class);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)) {
//                    Map<String,String> map = FormGenerator.getFormData(layout);
//                    characterCertificate.(map.get(VISIBLEMARK));
//                    characterCertificate.setActive_politics(map.get(ACTIVE_IN_POLOTCS));
//                    characterCertificate.setHave_arrested(map.get(HAVEARRESTED));
//                    characterCertificate.setIs_criminal(map.get(CRIMINAL));
//                    characterCertificate.setIs_criminal(map.get(CRIMINAL));
                        DAO dao = new DAO(getContext());
                        dao.insertOrUpdate(characterCertificate, new NewCallBack() {
                            @Override
                            public void onError(String error) {
                                Toast.makeText(getContext(), "response "+error, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onSuccess(Object object) {
                                Toast.makeText(getContext(), "response "+object, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onEmpty() {
                                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                            }
                        }, URLS.INSERT_CHARCTER);

                }
            }
        });
        initializeView();
        return view;
    }

    private void initializeView() {
                elements = new ArrayList<>();
                elements.add(new FormElement(C_RESIDE_ADDRES,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
                elements.add(new FormElement(FROM,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
                elements.add(new FormElement(TO,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
                elements.add(new FormElement(PINCODE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.location));
                formGenerator=new FormGenerator(layout,elements,this);
                formGenerator.generateForm();

    }
}
