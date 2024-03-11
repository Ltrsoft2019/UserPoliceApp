package com.ltrsoft.userpoliceapp.fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Users;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.ui.FormValidator;
import com.ltrsoft.userpoliceapp.ui.UserBehalf;
import com.ltrsoft.userpoliceapp.ui.UserSelf;
import com.ltrsoft.userpoliceapp.utils.URLS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddComplaintOnBehalf extends Fragment {
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private View view;
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
    public String USERPAN = "Enter pan :";
    public String USEROCCUPATION = "Enter Occupation :";
    public String USERNATIONALITY = "Enter Nationality :";
    public String USERDRIVING = "Enter Driving License no:";
    public AddComplaintOnBehalf() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Next");
        submit= view.findViewById(R.id.button);
        heading.setVisibility(View.GONE);
        intiForm(layout);
        AddComplaintOnBehalf addComplaintOnBehalf=new AddComplaintOnBehalf();
//        UserBehalf userBehalf =new UserBehalf(getContext(),layout);
//        userBehalf.getneateUserOnBehalf(this,submit,new AddComplainbehalf2());
//        UserSelf userSelf = new UserSelf(getContext(),layout);
//        userSelf.generateUserSelf(this,submit,new AddComplainbehalf2());
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
        elements.add(new FormElement(USERPAN, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USEROCCUPATION, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERNATIONALITY, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERDRIVING, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        formGenerator = new FormGenerator(layout,elements,this);
        formGenerator.generateForm();
        Adapters adapters1 = new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error while loading spinner", Toast.LENGTH_SHORT).show();
            }
        });
        adapters1.setAdapters();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               CreateUser();
            }
        });
    }

    private void  CreateUser(){
            if (FormValidator.isFormValid(layout)){
                Map<String,String> map=FormGenerator.getFormData(layout);
                Log.d(USERDRIVING,map.get(USERDRIVING));
                Log.d(USERDATEOFBIRTH,map.get(USERDATEOFBIRTH));
                DAO dao = new DAO(getContext());
                Users users = new Users("1", map.get(USERFNAME), map.get(USERMNAME), map.get(USERLNAME), map.get(USERADDRESS)
                        ,"", map.get(FormElement.COUNTRY), map.get(FormElement.STATE),
                        map.get(FormElement.DISTRICT), map.get(FormElement.CITY), map.get(USEREMAIL),
                        map.get(USERPASSWORD), map.get(USERGENDER), map.get(USERDATEOFBIRTH),
                        map.get(USERMOBILE1), map.get(USERMOBILE2), map.get(USERADHAR), map.get(USERPAN),
                        map.get(USEROCCUPATION), map.get(USERNATIONALITY), map.get(USERDRIVING), "",
                        map.get(USERGENDER), map.get(USERGENDER), "1");
                dao.insertOrUpdate(users, new NewCallBack() {
                    @Override
                    public void onError(String error) {
                        Toast.makeText(getContext(), "errro "+error, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onSuccess(Object object) {
                        Toast.makeText(getContext(), "response "+object, Toast.LENGTH_SHORT).show();
                        loadFragment("1");
                    }
                    @Override
                    public void onEmpty() {
                        Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                    }
                }, URLS.INSERT_USER);
            }
    }

    private void loadFragment(String user_id) {
        AddselfComplaint complaint = new AddselfComplaint();
        Bundle bundle = new Bundle();
        bundle.putString("user_id",user_id);
        complaint.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container2,complaint).addToBackStack(null).commit();
    }
    private void createCompalint() {
        submit.setText("Submit Complaint");
        formGenerator.generateForm();
    }
}