package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import com.ltrsoft.userpoliceapp.model.Grivence;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GrievanceFragment extends Fragment {


    @Nullable

    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;
    ArrayList<String>list;

     private String GRIVANCES_ID="Grievance Id",
            NATURE_OF_GRIEVANCES="Nature Of Grievance",
             DATE="Date",
             LOCATION="Location",
             DESCRIPTION="Description",

            PHOTO="Photo",
                    AUDIO="Audio Video",
                    ACTION_REQUIRED="Action Required",
                    OUTCOME="Outcome",
                    user_id, status_id, station_id;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
       layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Add Grievance");
        button=view.findViewById(R.id.button);
                initilizeform(layout,button);

        return view;
    }

    private void initilizeform(LinearLayout layout,Button button) {
        list=new ArrayList<>();

        list.add("Misconduct Allegations");
        list.add("Civil Rights Violations");
        list.add("Discrimination and Bias");
        list.add("Lack of Accountability and Transparency");
        list.add("Ineffective Communication and Community Relations");
        list.add("Procedural and Legal Issues");
        list.add("Workplace Environment and Internal Policies");
        list.add("Use of Technology and Surveillance");
        list.add("Response to Protests and Demonstrations");
        list.add("Cultural and Systemic Issues");
       elements=new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
         ArrayAdapter adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,list);

      Adapters adapters=new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
          @Override
          public void onError(String error) {
              Toast.makeText(getContext(), "their is a error", Toast.LENGTH_SHORT).show();
          }
      });
      adapters.setStation();
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formGenerator.generateSpinner("grievence", list,adapter, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        elements.add(new FormElement(DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.calendar));
        elements.add(new FormElement(LOCATION,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_LOCATION,R.drawable.mic2));
        elements.add(new FormElement(DESCRIPTION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_BUTTON_LOCATION,R.drawable.clipboard));
        elements.add(new FormElement(PHOTO,FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(ACTION_REQUIRED,FormElement.TYPE_CHECKBOX,FormElement.SUBTYPE_TEXT,1));
        elements.add(new FormElement(OUTCOME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.align));

        formGenerator=new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FormValidator.isFormValid(layout))
                {
                    Map<String,String>map=FormGenerator.getFormData(layout);
                    DAO dao=new DAO(getContext());
                    Grivence grivence=new Grivence("",map.get(NATURE_OF_GRIEVANCES),map.get(DATE),
                            map.get(LOCATION),map.get(LOCATION), "","",map.get(ACTION_REQUIRED),
                            map.get(OUTCOME),new UserDataAccess().getUserId(getActivity()),"",map.get(FormElement.STATION));
                        dao.insertOrUpdate(grivence, new NewCallBack() {
                            @Override
                            public void onError(String error) {

                            }

                            @Override
                            public void onSuccess(Object object) {

                            }

                            @Override
                            public void onEmpty() {

                            }
                        },  "");
                }
                else{
                    Toast.makeText(getContext(), "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }


}
