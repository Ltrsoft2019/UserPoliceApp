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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.model.ArmLicenses;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddWeaponLiscense2 extends Fragment {
    public AddWeaponLiscense2() {
    }
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;
    ArmLicenses armLicenses;
   private View view;
   private static String
    OFFICE_OR_BUSINESS_ADDRESS = "Office Or Business Address",
    ADDITIONAL_PARTICULARS = "Additional Particulars",
    AREA_OR_LAND_OF_CULTIVATION = "Area or Land of Cultivation",
    LOCATION_OF_CULTIVATION = "Location of Cultivation",
    WHETHER_APPLICANT_CONVICTED = "Whether Applicant Convicted",
    WHETHER_APPLICANT_ORDERED_TO_CONVICTED = "Whether Applicant Ordered to Convicted",
    WHETHER_APPLICANT_PROHIBITED = "Whether Applicant Prohibited",
    WHETHER_APPLICANT_APPLIED_BEFORE = "Whether Applicant Applied Before",
    WHETHER_APPLICANT_FAMILY_MEMBER_SUSPENDED_FOR_USING_WEAPON = "Whether Applicant Family Member Suspended for Using Weapon",

    WHETHER_APPLICANT_SUSPENDED = "Whether Applicant Suspended",
    HAS_SAFE_PLACE_TO_KEEP_ARM = "Has Safe Place to Keep Arm",
    HAS_TRAINING = "Has Training";


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
             armLicenses= bundle.getParcelable("armliscense1");
        }
        initform(layout,button);
        return view;
    }

    private void initform(LinearLayout layout, Button button) {
        elements=new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);

        elements.add(new FormElement(OFFICE_OR_BUSINESS_ADDRESS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(LOCATION_OF_CULTIVATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(AREA_OR_LAND_OF_CULTIVATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
        elements.add(new FormElement(ADDITIONAL_PARTICULARS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
         elements.add(new FormElement(WHETHER_APPLICANT_CONVICTED,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(WHETHER_APPLICANT_ORDERED_TO_CONVICTED,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(WHETHER_APPLICANT_PROHIBITED,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(WHETHER_APPLICANT_APPLIED_BEFORE,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(WHETHER_APPLICANT_FAMILY_MEMBER_SUSPENDED_FOR_USING_WEAPON,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(WHETHER_APPLICANT_SUSPENDED,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(HAS_SAFE_PLACE_TO_KEEP_ARM,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(HAS_TRAINING,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        formGenerator.generateForm();
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(FormValidator.isFormValid(layout)) {
                  Map<String,String>map=FormGenerator.getFormData(layout);
                             armLicenses.setWhether_applicant_prohibited(map.get(WHETHER_APPLICANT_PROHIBITED));
                             armLicenses.setWhether_applicant_applied_before(map.get(WHETHER_APPLICANT_APPLIED_BEFORE));

                             armLicenses.setWhether_applicant_family_member_suspended_for_using_weapon(map.get(WHETHER_APPLICANT_FAMILY_MEMBER_SUSPENDED_FOR_USING_WEAPON));
                           armLicenses.setWhether_applicant_suspended(map.get(WHETHER_APPLICANT_SUSPENDED));
                            armLicenses.setHas_safe_place_to_keep_arm(map.get(HAS_SAFE_PLACE_TO_KEEP_ARM));
                           armLicenses.setHas_training(map.get(HAS_TRAINING));
                           armLicenses.setWhether_applicant_ordered_to_convicted(map.get(WHETHER_APPLICANT_ORDERED_TO_CONVICTED));
                           armLicenses.setWhether_applicant_convicted(map.get(WHETHER_APPLICANT_CONVICTED));
                           armLicenses.setOffice_or_business_address(map.get(OFFICE_OR_BUSINESS_ADDRESS));
                           armLicenses.setAdditional_particulars(map.get(ADDITIONAL_PARTICULARS));
                           armLicenses.setArea_or_land_of_cultivation(map.get(AREA_OR_LAND_OF_CULTIVATION));
                          armLicenses.setLocation_of_cultivation(map.get(LOCATION_OF_CULTIVATION));
                          Bundle bundle=new Bundle();
                          bundle.putParcelable("armLicenses",armLicenses);

                          AddWeaponliscense3 addWeaponliscense3=new AddWeaponliscense3();
                          addWeaponliscense3.setArguments(bundle);
                           getFragmentManager().beginTransaction().replace(R.id.main_container2, new AddWeaponliscense3()).commit();
              }
              else {

              }
          }
      });
    }


}
