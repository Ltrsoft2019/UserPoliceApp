package com.ltrsoft.userpoliceapp.fragment.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.fragment.login.Login;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.PoliceStation;
import com.ltrsoft.userpoliceapp.utils.URLS;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.ArrayList;
import java.util.HashMap;

public class Registration extends Fragment
{
    private EditText userNameEditText;
    private Spinner station_spinner;
    private EditText userEmailEditText;
    private EditText userMobileEditText;
    private EditText userPasswordEditText;
    private EditText confirmPasswordEditText;
    private Button registerButton;
    private TextView loginTextView;
    private HashMap<Integer ,String>hashMap=new HashMap<>();
    private ArrayList<String>station_list = new ArrayList<>();
    View view;
    private DAO dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.registration, container, false);
       dao= new DAO(getContext());
        initilizeView();
        loadSpinner();
        return view;
    }

    private void loadSpinner() {

        dao.select(PoliceStation.class, "", "", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
//                Toast.makeText(getContext(), "success  "+object.getClass(), Toast.LENGTH_SHORT).show();
                int i = 0;
                for (PoliceStation policeStation: (ArrayList<PoliceStation>)object) {
                    station_list.add(policeStation.getPolice_station_name());
                    hashMap.put(i,policeStation.getPolice_station_id());
                    i++;
                }
                ArrayList<PoliceStation>policeStations = (ArrayList<PoliceStation>) object;
                for (int j = 0; j < policeStations.size(); j++) {
                    System.out.println("name"+policeStations.get(0).getPolice_station_name());
                }
                Toast.makeText(getContext(), "size   "+hashMap.get(0), Toast.LENGTH_SHORT).show();
                ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,station_list);
                adapter.setDropDownViewResource( android.R.layout.simple_list_item_1);
                station_spinner.setAdapter(adapter);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            }
        },URLS.READSTATION);

    }

    private void initilizeView() {
        station_spinner = view.findViewById(R.id.station_spinner);
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
                            Validations.isValidMobileNumber(userMobileEditText, "enter ") &&
                            Validations.validateSpinner(station_spinner, "select station ")) {
                                register(
                                        userNameEditText.getText().toString().trim()
                                        , userEmailEditText.getText().toString().trim()
                                        , userMobileEditText.getText().toString().trim()
                                        , userPasswordEditText.getText().toString().trim(),
                                        hashMap.get(station_spinner.getSelectedItemPosition()));
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

    private void register(String name, String email, String mobileno, String pass,String station) {

        HashMap<String,String> map = new HashMap<>();
        map.put("user_fname",name);
        map.put("user_email",email);
        map.put("user_mobile1",mobileno);
        map.put("user_password",pass);
        map.put("station_id",station);

        dao.getData(map, URLS.REGISTERURL, new NewCallBack() {
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
