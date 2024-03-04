package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.fragment.login.Login;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.HashMap;

public class Registration extends Fragment
{
    private EditText userNameEditText;
    private EditText userEmailEditText;
    private EditText userMobileEditText;
    private EditText userPasswordEditText;
    private EditText confirmPasswordEditText;
    private Button registerButton;
    private TextView loginTextView;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.registration, container, false);
        initilizeView();
        return view;
    }

    private void initilizeView() {

        userNameEditText = view.findViewById(R.id.user_name);
        userEmailEditText = view.findViewById(R.id.user_email);
        userMobileEditText = view.findViewById(R.id.user_mobile);
        userPasswordEditText = view.findViewById(R.id.user_password);
        confirmPasswordEditText = view.findViewById(R.id.con_password);
        registerButton = view.findViewById(R.id.register);
        loginTextView = view.findViewById(R.id.login_text);

        // Set onClickListener for "Register" Button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userPasswordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString())) {
                    if (Validations.validateEditText(userNameEditText,"Enter Name") &&
                            Validations.isValidEmail(userEmailEditText, "enter valid email") &&
                            Validations.validateEditText(userNameEditText, "Enterr user name") &&
                            Validations.isValidMobileNumber(userMobileEditText, "enter ")) {
                                register(
                                        userNameEditText.getText().toString().trim()
                                        , userEmailEditText.getText().toString().trim()
                                        , userMobileEditText.getText().toString().trim()
                                        , userPasswordEditText.getText().toString().trim()
                                        , confirmPasswordEditText.getText().toString().trim());
                    }
                    else {
                        Toast.makeText(getContext(), "all fields are compulsory", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    confirmPasswordEditText.setText("");
                    confirmPasswordEditText.setError("Enter Same Pass word here");
                }
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().
                        getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container,new Login())
                        .commit();
            }
        });

    }

    private void register(String name, String email, String mobileno, String pass, String confirmpass) {

        DAO dao = new DAO(getContext());

        HashMap<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        map.put("mobileno",mobileno);
        map.put("password",pass);
        dao.getData(map, URLS.LOGINURL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "response "+(String) object, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Result Empty", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
