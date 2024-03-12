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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Premisess;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Premises extends Fragment {

    private View view;
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private static String FNMAE = "Full Name :";
    private static String OCCUPATION = "Occupation:";
    private static String PERCENTAGE = "Enter Percentage :";
    private static String NATIONALITY = "Nationality :";
    private static String NATIVE_PLACES = "Enter Native Places:";
    private static String ESTABLISHMENT = "Name of Establishment :";
    private static String WHETHER = "Whether Application Applied for:";
    private static String WHETHER_SUSPENDE = "Whether Application Suspend:";
    private static String NAME_OF_AMUSEMENT = "Name of Amusement:";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Sound Permission");
        submit.setText("Submit");
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        elements=new ArrayList<>();

        elements.add(new FormElement(FNMAE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(OCCUPATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(PERCENTAGE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(NATIONALITY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(NATIVE_PLACES,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(ESTABLISHMENT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(WHETHER,FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_RADIO_YES_NO,R.drawable.reminders));
        elements.add(new FormElement(WHETHER_SUSPENDE,FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_RADIO_YES_NO,R.drawable.reminders));
        elements.add(new FormElement(NAME_OF_AMUSEMENT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));

        formGenerator=new FormGenerator(layout,elements,this);

        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error while laoding station"+error, Toast.LENGTH_SHORT).show();
            }
        });
        formGenerator.generateForm();
        adapters.setStation();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){
                    Map <String,String> map = FormGenerator.getFormData(layout);
                    Premisess premises = new Premisess(map.get(FormElement.STATION),map.get(FNMAE),map.get(OCCUPATION),map.get(PERCENTAGE),map.get(NATIONALITY),map.get(NATIVE_PLACES),map.get(ESTABLISHMENT),map.get(WHETHER),map.get(WHETHER_SUSPENDE),map.get(NAME_OF_AMUSEMENT),new UserDataAccess().getUserId(getActivity()),"");
                    DAO dao = new DAO(getContext());
                    dao.insertOrUpdate(premises, new NewCallBack() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(getContext(), "error ="+error, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "response ="+object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onEmpty() {
                            Toast.makeText(getContext(), "Empty Ressponse", Toast.LENGTH_SHORT).show();
                        }
                    }, URLS.INSERT_PREMISES);
                }
            }
        });
    }
}

