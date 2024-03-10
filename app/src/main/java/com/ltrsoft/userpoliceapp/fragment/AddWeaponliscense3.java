package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.ArmLicenses;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddWeaponliscense3 extends Fragment {
    public AddWeaponliscense3() {
    }
  private View view;
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;
    private static String
            NEED_FOR_LICENSE = "Need for License",
    ARMS_TYPE = "Arms Type",
    AMMUNITION_DESC = "Ammunition Description",
    AREA_OF_ARM_CARRY = "Area of Arm Carry",
    SPECIAL_CONSIDERATION = "Special Consideration",
    DETAIL_FOR_FORM_IV = "Detail for Form IV",
    PLACE_OF_BIRTH = "Place of Birth",
    DOB_IN_WORDS = "Date of Birth in Words",
    STATUS_ID = "Status ID",
    PERMISSION_ID = "Permission ID";

   ArmLicenses armLicenses;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Add Weapon Licence");
        button=view.findViewById(R.id.button);
        button.setText("Next");
        Bundle bundle=getArguments();
        if (bundle!=null){
            armLicenses=bundle.getParcelable("armLicenses");
        }
        initform(layout,button);
        return view;
    }

    private void initform(LinearLayout layout, Button button) {
        elements=new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);

        elements.add(new FormElement(NEED_FOR_LICENSE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(ARMS_TYPE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(AMMUNITION_DESC,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(AREA_OF_ARM_CARRY,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(SPECIAL_CONSIDERATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(DETAIL_FOR_FORM_IV,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(PLACE_OF_BIRTH,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(NEED_FOR_LICENSE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(PERMISSION_ID,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        formGenerator.generateForm();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FormValidator.isFormValid(layout)){
                    Map<String,String>map=FormGenerator.getFormData(layout);
                              armLicenses.setArms_type(map.get(ARMS_TYPE));
                              armLicenses.setAmmunition_desc(map.get(AMMUNITION_DESC));
                              armLicenses.setArea_of_arm_carry(map.get(AREA_OF_ARM_CARRY));
                            armLicenses.setSpecial_consideration(map.get(SPECIAL_CONSIDERATION));
                            armLicenses.setDetail_for_form_IV(map.get(DETAIL_FOR_FORM_IV));
                            armLicenses.setPlace_of_birth(map.get(PLACE_OF_BIRTH));
                            armLicenses.setDob_in_words(map.get(DOB_IN_WORDS));
                            armLicenses.setPermission_id(PERMISSION_ID);
                    armLicenses.setNeed_for_license(map.get(NEED_FOR_LICENSE));
                    DAO dao=new DAO(getContext());
                    dao.insertOrUpdate(armLicenses, new NewCallBack() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onEmpty() {

                        }
                    }, URLS.CREATEWEAPONLISCENSE);
                }
            }
        });
    }


}
