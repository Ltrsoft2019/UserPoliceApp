package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.RallyPermissions;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RallyPermission extends Fragment {
    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private List<FormElement> elements;

    private Button submit;
    private TextView heading;
    private static final String ORGANIZATION_GROUP_NAME = "Organization/Group Nname";
    private static final String ADDRESS = "Address";
    private static final String EVENT_DETAILS = "Event Details";
    private static final String RALLY_NAME = "Rally name";
    private static final String RALLY_DATE = "Rally date";
    private static final String RALLY_TIME = "Rally time";
    private static final String PROPOSED_ROUTE_LOCATION = "Proposed Route Location";
    private static final String EXPECTED_PARTICIPANTS = "Expected Participants";
    private static final String PURPOSE_OBJECTIVE = "Purpose Objective";
    private static final String SAFETY_SECURITY_MEASURES = "Safety Security Measures";
    private static final String CROWD_MANAGEMENT_PLAN = "Crowd Management Plan";
    private static final String FIRST_AID_FACILITIES_PROVISION = "First Aid facilities provision";
    private static final String EMERGENCY_SERVICES_COORDINATION = "Emergency Services Cordination";
    private static final String ADDITIONAL_SAFETY_MEASURES = "Additional Safety Measures";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Rally Permission");
        initializeViews(layout,submit);
        return view;
    }

    private void initializeViews(LinearLayout layout, Button submit) {
        elements=new ArrayList<>();
        elements.add(new FormElement(ORGANIZATION_GROUP_NAME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(ADDRESS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(EVENT_DETAILS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(RALLY_NAME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(RALLY_DATE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(RALLY_TIME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(PROPOSED_ROUTE_LOCATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(EXPECTED_PARTICIPANTS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(PURPOSE_OBJECTIVE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(SAFETY_SECURITY_MEASURES,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(CROWD_MANAGEMENT_PLAN,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(FIRST_AID_FACILITIES_PROVISION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(EMERGENCY_SERVICES_COORDINATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        elements.add(new FormElement(ADDITIONAL_SAFETY_MEASURES,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.location));
        formGenerator=new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {

            }
        });
        adapters.setStation();
        submit.setText("Submit");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){
                    Map <String,String>map =FormGenerator.getFormData(layout);
                    RallyPermissions permission = new RallyPermissions("",map.get(ORGANIZATION_GROUP_NAME),
                            new UserDataAccess().getUserId(getActivity()),map.get(ADDRESS),map.get(EVENT_DETAILS),map.get(RALLY_NAME),
                            map.get(RALLY_DATE),map.get(RALLY_TIME),map.get(PROPOSED_ROUTE_LOCATION),map.get(EXPECTED_PARTICIPANTS),
                            map.get(PURPOSE_OBJECTIVE),map.get(SAFETY_SECURITY_MEASURES),map.get(FormElement.STATION),map.get(CROWD_MANAGEMENT_PLAN),
                            map.get(FIRST_AID_FACILITIES_PROVISION),map.get(EMERGENCY_SERVICES_COORDINATION),"" +
                            map.get(ADDITIONAL_SAFETY_MEASURES),"");
                    DAO dao = new DAO(getContext());
                    dao.insertOrUpdate(permission, new NewCallBack() {
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
                            Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                        }
                    }, URLS.INSERT_RALLY);
                }
            }
        });
    }
}
