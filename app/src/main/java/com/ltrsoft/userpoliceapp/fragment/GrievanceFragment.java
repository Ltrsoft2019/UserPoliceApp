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
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.List;

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

            PHOTP="Photo",
                    AUDIO="Audio Video", ACTION_REQUIRED="Action Required",
                    OUTCOME="Outcome",
                    user_id, status_id, station_id;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
       layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        button=view.findViewById(R.id.button);

        initilizeform(layout);
        return view;
    }

    private void initilizeform(LinearLayout layout) {
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
      // elements.add(new FormElement(NATURE_OF_GRIEVANCES,FormElement.TYPE_SPINNER,FormElement.SUBTYPE_TEXT,R.drawable.call));
        ArrayAdapter adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,list);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formGenerator.generateSpinner("grievence", list,adapter , new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
