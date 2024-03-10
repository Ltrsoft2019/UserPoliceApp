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
import com.ltrsoft.userpoliceapp.model.ArmLicenses;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddWeaponLicence1 extends Fragment  {
    public AddWeaponLicence1() {
    }
    private View view;
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;

    private static  String
            ARMED_LICENSE_ID="Arm License Id",
            PARENT_OR_SPOUSE_NAME="Parent Or Spouse Name",
            VILLAGE="Village",
            PARENT_ADDRESS="Present Address",
            RESIDING_SINCE="Residing Since",
            OFFICE_NO="Office No",

            RESIDANCE_NO="Residence No",

             STATION_ID="Station Id",
            OFFICE_OR_BUSINESS_ADDRESS="Office Or Business Address",
            ADDITIONAL_PARTICULARS="Additional Particulars";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Add Weapon Licence");
        button=view.findViewById(R.id.button);
        button.setText("Next");
       initialform(layout,button);

        return view;
    }

    private void initialform(LinearLayout layout, Button button)
    {
        elements=new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);
        elements.add(new FormElement(PARENT_OR_SPOUSE_NAME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(VILLAGE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(PARENT_ADDRESS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(RESIDING_SINCE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));
        elements.add(new FormElement(OFFICE_NO,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.call));
        elements.add(new FormElement(RESIDANCE_NO,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.call));

        Adapters adapters=new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "their is a error", Toast.LENGTH_SHORT).show();
            }
        });
        adapters.setStation();
        formGenerator.generateForm();

     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {


             if (FormValidator.isFormValid(layout))
             {
                 Map<String,String>map=FormGenerator.getFormData(layout);

                 ArmLicenses armLicense = new ArmLicenses("", map.get(PARENT_OR_SPOUSE_NAME), map.get(VILLAGE),
                         map.get(PARENT_ADDRESS), map.get(RESIDING_SINCE),map.get(OFFICE_NO), map.get(RESIDANCE_NO),
                         map.get(FormElement.STATION),"","","",
                         "","","","",
                         "","","",
                         "","","","","","",
                         "","","","","","");


              Bundle bundle=new Bundle();
              AddWeaponLiscense2 addWeaponLiscense2=new AddWeaponLiscense2();
              bundle.putParcelable("armliscense1",armLicense);
               addWeaponLiscense2.setArguments(bundle);

                 getFragmentManager().beginTransaction().replace(R.id.main_container2,addWeaponLiscense2).commit();


             }
             else {
                 Toast.makeText(getContext(), "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
             }
         }
         });
    }


}
