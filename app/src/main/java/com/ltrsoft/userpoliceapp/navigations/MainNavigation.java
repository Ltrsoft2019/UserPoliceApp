package com.ltrsoft.userpoliceapp.navigations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.MainDashBoard;

public class MainNavigation extends Fragment  implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private View view;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_navigation, container, false);

      initilizeDrwer();
//      loadDefaultFragmnet();
        return view;
    }
    private void loadDefaultFragmnet() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_frame,new MainDashBoard())
                .commit();
    }

    private void initilizeDrwer() {


        drawerLayout = view.findViewById(R.id.drawerlayout);
        navigationView= view.findViewById(R.id.navigation);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,toolbar,  R.string.nav_open, R.string.nav_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getContext().getColor(R.color.black));
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        return false;
    }
}
