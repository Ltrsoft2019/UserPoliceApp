package com.ltrsoft.userpoliceapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.MainDashBoard;
import com.ltrsoft.userpoliceapp.fragment.login.Login;
import com.ltrsoft.userpoliceapp.navigations.MainNavigation;
import com.ltrsoft.userpoliceapp.utils.SessionManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.isLoggedIn()){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.main_container,new MainNavigation())
                            .commit();
        }
        else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_container,new Login())
                    .commit();
        }

    }
}