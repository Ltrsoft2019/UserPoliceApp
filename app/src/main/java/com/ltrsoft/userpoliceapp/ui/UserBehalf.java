package com.ltrsoft.userpoliceapp.ui;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Users;
import com.ltrsoft.userpoliceapp.utils.URLS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserBehalf {
    Context context;
    LinearLayout layout;

    public UserBehalf(Context context, LinearLayout layout) {
        this.context = context;
        this.layout = layout;
    }
    private List<FormElement> elements;
    private FormGenerator formGenerator;


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
    public void getneateUserOnBehalf(Fragment fragment, Button submit, Fragment fragment2){
        elements=new ArrayList<>();
        elements.add(new FormElement(USERFNAME, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT, R.drawable.cam2));
        elements.add(new FormElement(USERMNAME, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERLNAME, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERDATEOFBIRTH, FormElement.TYPE_BUTTON,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERADDRESS, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USEREMAIL, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_EMAIL,R.drawable.cam2));
//        elements.add(new FormElement(USERPASSWORD, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_EMAIL,R.drawable.cam2));
        elements.add(new FormElement(USERGENDER, FormElement.TYPE_RADIO_GROUP,FormElement.SUBTYPE_EMAIL,R.drawable.cam2));
        elements.add(new FormElement(USERMOBILE1, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.cam2));
        elements.add(new FormElement(USERMOBILE2, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.cam2));
        elements.add(new FormElement(USERADHAR, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_NUMBER,R.drawable.cam2));
        elements.add(new FormElement(USERPAN, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USEROCCUPATION, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERNATIONALITY, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        elements.add(new FormElement(USERDRIVING, FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.cam2));
        formGenerator = new FormGenerator(layout,elements,fragment);
        formGenerator.generateForm();
        Adapters adapters = new Adapters(context, layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {

            }
        });
        adapters.setAdapters();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FormValidator.isFormValid(layout)) {
                    fragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container2,fragment2).commit();
                    Toast.makeText(context, "form is valid", Toast.LENGTH_SHORT).show();
                    Map<String,String> map=FormGenerator.getFormData(layout);
                    DAO dao = new DAO(context);
                    Users users = new Users("1", map.get(USERFNAME), map.get(USERMNAME), map.get(USERLNAME), map.get(USERADDRESS)
                            ,"", map.get(FormElement.COUNTRY), map.get(FormElement.STATE),
                            map.get(FormElement.DISTRICT), map.get(FormElement.CITY), map.get(USEREMAIL),
                            "s", map.get(USERGENDER), map.get(USERDATEOFBIRTH),
                            map.get(USERMOBILE1), map.get(USERMOBILE2), map.get(USERADHAR), map.get(USERPAN),
                            map.get(USEROCCUPATION), map.get(USERNATIONALITY), map.get(USERDRIVING), "",
                            map.get(USERGENDER), map.get(USERGENDER), "1");

                        dao.insertOrUpdate(users, new NewCallBack() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(context, "errro "+error, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(context, "response "+object, Toast.LENGTH_SHORT).show();
//                        layout.removeAllViews();
//                        createCompalint();

                        }

                        @Override
                        public void onEmpty() {
                            Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show();
                        }
                    }, URLS.INSERT_USER);
                }
                else {
                    Toast.makeText(context, "form is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
