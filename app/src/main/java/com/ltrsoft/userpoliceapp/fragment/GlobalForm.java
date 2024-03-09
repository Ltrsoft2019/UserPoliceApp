package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GlobalForm extends Fragment {

    public GlobalForm() {}
    private LinearLayout layout;
    private FormGenerator generator;
    private View view;
    private FormGenerator formGenerator;
    private Button submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.common_form, container, false);
        submit = view.findViewById(R.id.button);
        layout = view.findViewById(R.id.layout123);
        List<FormElement>list = new ArrayList<>();
        list.add(new FormElement("User Name",FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        list.add(new FormElement("User Address",FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        list.add(new FormElement("Gender",FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        list.add(new FormElement("Is Ever Criminal",FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        list.add(new FormElement("Image",FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        formGenerator= new FormGenerator(layout,list,this);
        formGenerator.generateForm();
//        Adapters adapters = new Adapters(getContext(),layout,formGenerator);
//        adapters.setAdapters();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)) {
//                    Toast.makeText(getContext(), "all data is valid", Toast.LENGTH_SHORT).show();
                    Map<String,String>map=formGenerator.getFormData(layout);
                    String userName = map.get("User Name");
                    if (userName != null) {
                        Log.d("username", userName);
                    } else {
                        Log.d("data", "User Name is null");
                    }
                    Log.d("adress",map.get("User Address"));
                    String gender = map.get("Gender");
                    Log.d("gender",gender);
                    Toast.makeText(getContext(), "gender "+map.get("Gender"), Toast.LENGTH_SHORT).show();
                    Log.d("is criminal",map.get("Is Ever Criminal"));
//                    Log.d("data",map.get("Image"));
                }
                else {
//                    Toast.makeText(getContext(), "all dat is not valid", Toast.LENGTH_SHORT).show();
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