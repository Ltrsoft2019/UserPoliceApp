package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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
import com.ltrsoft.userpoliceapp.model.Evidance;
import com.ltrsoft.userpoliceapp.model.EvidenceType;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class AddEvidence extends Fragment {
    public AddEvidence() {}
    private View view;
    LinearLayout layout;
    FormGenerator formGenerator;
    private List<FormElement> elements;
    Button button;
    TextView heading;
   private List<String>evidencelist=new ArrayList<>();
     private static String EVIDANCE_ID="Evidence Id",
            EVIDANCE_PHOTO="Evidance Photo",
            EVIDANCE_NUMBER="Evidence Dumber",
            COMPLAINT_ID="Complaint Id",
            SEIZURE_DATE_TIME="Date Time",
            EVIDANCE_TYPE="Evidance Type",
            ITEM_DESCRIPTION="Evidance Description",
            SERIAL_NUMBER="Serial Numbers Or Identifiers";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout=view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Add Evidance");
        button=view.findViewById(R.id.button);
        initialform(layout,button);
        return view;
    }

    private void initialform(LinearLayout layout, Button button) {


        evidencelist.add(" Physical Evidence");
        evidencelist.add("Documentary Evidence");
        evidencelist.add("Testimonial Evidence");
        evidencelist.add("Digital Evidence");
        evidencelist.add("Circumstantial Evidence");
        evidencelist.add("Forensic Evidence");
        evidencelist.add("Statistical Evidence");
        evidencelist.add("Analogical Evidence");
        evidencelist.add("Expert Evidence");

        elements=new ArrayList<>();
        formGenerator=new FormGenerator(layout,elements,this);

        ArrayAdapter adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,evidencelist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formGenerator.generateSpinner(EVIDANCE_TYPE, (ArrayList<String>) evidencelist,adapter, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        elements.add(new FormElement(EVIDANCE_NUMBER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.commerce));

        elements.add(new FormElement(EVIDANCE_PHOTO,FormElement.TYPE_IMAGE_VIEW,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(ITEM_DESCRIPTION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.clipboard));
         elements.add(new FormElement(SEIZURE_DATE_TIME,FormElement.TYPE_BUTTON,FormElement.SUBTYPE_BUTTON_DATEPICKER,1));
        elements.add(new FormElement(SERIAL_NUMBER,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.commerce));
         formGenerator.generateForm();


         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (FormValidator.isFormValid(layout)) {
                     Map<String,String>map=FormGenerator.getFormData(layout);
                     DAO dao=new DAO(getContext());
                     Evidance evidance=new Evidance("",map.get(EVIDANCE_NUMBER),"1",map.get(SEIZURE_DATE_TIME),
                             map.get(EVIDANCE_TYPE),map.get(ITEM_DESCRIPTION),map.get(SERIAL_NUMBER));
                      dao.insertOrUpdate(evidance, new NewCallBack() {
                          @Override
                          public void onError(String error) {
                              Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                          }

                          @Override
                          public void onSuccess(Object object) {
                              Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                          }

                          @Override
                          public void onEmpty() {

                          }
                      }, URLS.INSERTGRIVENCES);

                 }
                 else {
                     Toast.makeText(getContext(), "All Fields Are Mandtory", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }
}
