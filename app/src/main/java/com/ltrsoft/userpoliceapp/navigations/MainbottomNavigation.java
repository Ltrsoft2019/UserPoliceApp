package com.ltrsoft.userpoliceapp.navigations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.AddComplaintt;
import com.ltrsoft.userpoliceapp.fragment.AddFragment;
import com.ltrsoft.userpoliceapp.fragment.UserDashBoard;
import com.ltrsoft.userpoliceapp.fragment.login.Login;

public class MainbottomNavigation extends Fragment {
    View view;
    private BottomNavigationView navigationView;
    public MainbottomNavigation() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_navigation, container, false);
        loadBadeFragmemt(new UserDashBoard());
        navigationView = view.findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id== R.id.dashboard){
                    Toast.makeText(getContext(), "dashboard clicked", Toast.LENGTH_SHORT).show();
                    loadBadeFragmemt(new UserDashBoard());
                } else if (id==R.id.my_complaint) {
                    loadBadeFragmemt(new UserDashBoard());
                    Toast.makeText(getContext(), "my complaints clicked", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.add) {
                    loadBadeFragmemt(new AddFragment());
                    Toast.makeText(getContext(), "add clicked", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.eservices) {
                    loadBadeFragmemt(new UserDashBoard());
                    Toast.makeText(getContext(), "eservices clicked", Toast.LENGTH_SHORT).show();
                }
                else if (id==R.id.emergency_calling) {
                    loadBadeFragmemt(new UserDashBoard());
                    Toast.makeText(getContext(), "emergency clicked", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        return view;
    }

    private void loadBadeFragmemt(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container2,fragment)
                .commit();
    }


}
