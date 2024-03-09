package com.ltrsoft.userpoliceapp.fragment.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;

import java.util.ArrayList;
import java.util.List;

public class Profile extends Fragment {
    public Profile() {
    }
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    public String USERFNAME = "Enter User first name :";
    public String USERMNAME = "Enter User middle name :";
    public String USERLNAME = "Enter User last name :";
    public String USERADDRESS = "Enter User Adress :";
    public String USEREMAIL= "Enter User Email :";
    public String USERPASSWORD= "Enter User password :";
    public String USERGENDER= "Select gender";
    public String USERDATEOFBIRTH = "Select date of birth :";
    public String USERMOBILE1 = "Enter mobile number 1 :";
    public String USERMOBILE2 = "Enter mobile number 2 :";
    public String USERADHAR = "Enter adhaar :";
    private View view;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("User Profile");
        submit= view.findViewById(R.id.button);
        intiForm(layout);

        return view;
    }

    private void intiForm(LinearLayout layout) {
        elements=new ArrayList<>();
        elements.add(new FormElement(USERFNAME, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERMNAME, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERLNAME, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERDATEOFBIRTH, FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERADDRESS, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USEREMAIL, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_EMAIL,R.drawable.cam2));
        elements.add(new FormElement(USERPASSWORD, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_EMAIL,R.drawable.cam2));
        elements.add(new FormElement(USERGENDER, FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_EMAIL,R.drawable.cam2));
        elements.add(new FormElement(USERMOBILE1, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.cam2));
        elements.add(new FormElement(USERMOBILE2, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.cam2));
        elements.add(new FormElement(USERADHAR, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();

    }
}
