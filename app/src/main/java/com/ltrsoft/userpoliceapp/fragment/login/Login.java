package com.ltrsoft.userpoliceapp.fragment.login;

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
import com.ltrsoft.userpoliceapp.fragment.Registration;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.navigations.MainNavigation;
import com.ltrsoft.userpoliceapp.utils.SessionManager;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.HashMap;

public class Login extends Fragment {
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;
    private Button loginButton;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initizilise();
         return view;
    }

    private void initizilise() {

        emailEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);
        forgotPasswordTextView =view. findViewById(R.id.forgot_password);
        signUpTextView = view.findViewById(R.id.registration);
        loginButton =view. findViewById(R.id.loginbtn);


        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container,new Registration())
                        .commit();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Validations.isValidEmail(emailEditText,"Enter Valid Email") &&
                Validations.validateEditText(passwordEditText,"password is null")) {

                    Toast.makeText(getContext(), "all fields are valid", Toast.LENGTH_SHORT).show();
                    new SessionManager(getContext()).setLogin(true);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .remove(new Login())
                            .replace(R.id.main_container,new MainNavigation())
                            .commit();

                }else {
                    Toast.makeText(getContext(), "Null values ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginUser(String email,String password) {
        DAO dao = new DAO(getContext());

        HashMap<String,String>map = new HashMap<>();
        map.put("email",email);
        map.put("password",password);
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
