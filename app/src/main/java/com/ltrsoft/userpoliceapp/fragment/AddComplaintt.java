package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ltrsoft.userpoliceapp.R;

public class AddComplaintt extends Fragment {
    public AddComplaintt() {}
    private View view;
    private BottomNavigationView navigationView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addcompalint, container, false);
        navigationView = view.findViewById(R.id.topnav);

        getChildFragmentManager().beginTransaction().add(R.id.complaint_container,new AddComplaintt()).commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
               if (id==R.id.self){
                   getChildFragmentManager().beginTransaction().add(R.id.complaint_container,new AddComplaintOnBehalf()).commit();
               } else if (id==R.id.onbehalf) {
                   getChildFragmentManager().beginTransaction().add(R.id.complaint_container,new AddComplaintOnBehalf()).commit();
               }
                return false;
            }
        });

        return view;
    }
}
