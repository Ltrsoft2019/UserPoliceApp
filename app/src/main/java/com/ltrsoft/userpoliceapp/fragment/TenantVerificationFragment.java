package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.ltrsoft.userpoliceapp.model.TenantVerification2;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TenantVerificationFragment extends Fragment {
    public TenantVerificationFragment() {}
    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private static String TYPE_PROPRTY = "Type of property";
    private static String TOCCUPATION = "Tenant occupation";
    private static String START_DATE = "Start Date";
    private static String END_DATE = "End Date";
    private static String PURPOSE = "Purpose of Tenancy";
    private static String UNIT = "Number of units ";
    private static String BEDNUM = "Bedroom number ";
    private static String FNMAEOFTEN = "Full name of Tenant ";
    private static String TCONTACT = "Tenant contact number";
    private static String TEMAIL = "Tenant Email";
    private static String IMAGE = "signature Image";
    private static String TADDRESS = "Address";
    private static String RENTAL_PRPERTY_ID = "Enter Rental property id :";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("UnIdentified Body");
        submit.setText("Next");
        elements = new ArrayList<>();

        elements.add(new FormElement(RENTAL_PRPERTY_ID,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(TYPE_PROPRTY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(TOCCUPATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(START_DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.reminders));
        elements.add(new FormElement(END_DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.reminders));
        elements.add(new FormElement(PURPOSE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(UNIT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(BEDNUM,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(FNMAEOFTEN,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(TCONTACT,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(TEMAIL,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(IMAGE,FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(TADDRESS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        formGenerator=new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {

            }
        });
        adapters.setStation();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){
                    Map <String,String>map = FormGenerator.getFormData(layout);
                    TenantVerification2 tenantVerification = new TenantVerification2("1",
                            new UserDataAccess().getUserId(getActivity()),map.get(RENTAL_PRPERTY_ID),map.get(TYPE_PROPRTY),
                            map.get(UNIT),map.get(RENTAL_PRPERTY_ID),map.get(FNMAEOFTEN),map.get(TCONTACT),map.get(TEMAIL),
                            map.get(TADDRESS), map.get(TOCCUPATION),map.get(START_DATE),map.get(END_DATE),map.get(PURPOSE), map.get(IMAGE),
                            map.get(FormElement.STATION),"1","");

                            DAO dao = new DAO(getContext());
                            dao.insertOrUpdate(tenantVerification, new NewCallBack() {
                                @Override
                                public void onError(String error) {
                                    Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
                                }
                                @Override
                                public void onSuccess(Object object) {
                                    Toast.makeText(getContext(), "response "+object, Toast.LENGTH_SHORT).show();
                                }
                                @Override
                                public void onEmpty() {
                                    Toast.makeText(getContext(), "Empty ", Toast.LENGTH_SHORT).show();
                                }
                            }, URLS.INSRT_TENANT_VERIFICATION);
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

