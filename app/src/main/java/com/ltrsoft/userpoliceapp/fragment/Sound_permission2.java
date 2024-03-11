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
import com.ltrsoft.userpoliceapp.model.SoundPermission;
import com.ltrsoft.userpoliceapp.model.Users;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sound_permission2 extends Fragment {
    public Sound_permission2() {}
    private View view;
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private static String CLOSING_TIME = "Closing Time :";
    private static String INITIATION_TIME = "Initiation Time :";
    private static String CONTRACTOR_NAME = "Speaker/Contractor Name :";
    private static String CONTRACTOR_ADDRESS = "Contractor Address :";
    private static String LICENSE_NUMBER = "License Number :";
    private static String FEES = "Fees :";
    private static String TERM_CONDITION = "Terms and Condition :";
    private  SoundPermission parcle=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Sound Permission");
        submit.setText("Submit");
        Bundle bundle = getArguments();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
           parcle = bundle.getParcelable("parcel", SoundPermission.class);
            Toast.makeText(getContext(), "event name "+parcle.getEvent_name(), Toast.LENGTH_SHORT).show();
        }
        intiView();

        return view;
    }

    private void intiView() {
        elements = new ArrayList<>();

        elements.add(new FormElement(INITIATION_TIME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(CLOSING_TIME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(CONTRACTOR_NAME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(CONTRACTOR_ADDRESS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(LICENSE_NUMBER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(FEES,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(TERM_CONDITION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));

        formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){

                    Map<String,String> map = FormGenerator.getFormData(layout);
                        parcle.setTime_of_initiation(map.get(INITIATION_TIME));
                        parcle.setClosing_time(map.get(CLOSING_TIME));
                        parcle.setContractor_address(map.get(CONTRACTOR_ADDRESS));
                        parcle.setSpeaker_contractor_name(map.get(CONTRACTOR_NAME));
                        parcle.setLicense_no(map.get(LICENSE_NUMBER));
                        parcle.setFees(map.get(FEES));
                        parcle.setTerms_condition(map.get(TERM_CONDITION));

                    DAO dao = new DAO<>(getContext());
                    dao.insertOrUpdate(parcle, new NewCallBack() {
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
                    }, URLS.INSRT_SOUND_PREM);

                }
            }
        });
    }
}
