package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.model.SoundPermission;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.UserDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SoundPermission1 extends Fragment {
    public SoundPermission1() {}
    public LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    public static String EVENT_NAME = "Event Name";
    public static String PURPOSE = "Purpose of Event";
    public static String POSITION = "POsition in Event";
    public static String NO_STATION = "Number of Station include in event";
    public static String DATE = "Event Date";
    public static String FROM = "From";
    public static String TO = "To ";
    public static String Location = "Bedroom number ";
    public static String VILLAGE = "vilage";

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

        elements.add(new FormElement(EVENT_NAME,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(PURPOSE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(POSITION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(NO_STATION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.reminders));
        elements.add(new FormElement(DATE,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,R.drawable.reminders));
        elements.add(new FormElement(FROM,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(TO,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(Location,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(VILLAGE,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        formGenerator=new FormGenerator(layout,elements,this);

        formGenerator.generateForm();
        Adapters adapters = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {

            }
        });
        adapters.setAdapters();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.isFormValid(layout)){
                    Map <String,String> map = FormGenerator.getFormData(layout);
                    Sound_permission2 soundPermission2 = new Sound_permission2();
                    SoundPermission soundPermission =new SoundPermission("",map.get(EVENT_NAME),map.get(PURPOSE),"",map.get(POSITION),
                            map.get(DATE),map.get(FROM),map.get(TO),map.get(Location),"","","","",new UserDataAccess().getUserId(getActivity()),"","","","","",
                            "","","","");
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("parcel",soundPermission);
                    soundPermission2.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.main_container2,soundPermission2).commit();

                }
            }
        });
        return view;
    }
}
