package com.ltrsoft.userpoliceapp.navigations;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.login.Login;
import com.ltrsoft.userpoliceapp.maps.MapFragment;
import com.ltrsoft.userpoliceapp.utils.SessionManager;

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
      loadFragmnet(new MainbottomNavigation());
        return view;
    }
    private void loadFragmnet(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame,fragment)
                .commit();
    }
    private void initilizeDrwer() {
        drawerLayout = view.findViewById(R.id.drawerlayout);
        navigationView= view.findViewById(R.id.navigation);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("this is user app");
        toolbar.setTitleTextAppearance(getContext(),R.style.ToolbarTitleText);
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,toolbar,  R.string.nav_open, R.string.nav_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getContext().getColor(R.color.black));
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.dashboard){
            loadFragmnet(new MainbottomNavigation());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (id==R.id.profile){
            loadFragmnet(new MainbottomNavigation());
        }
        else if (id==R.id.setting){
            loadFragmnet(new MainbottomNavigation());
        }
        else if (id==R.id.notice){
            loadFragmnet(new MainbottomNavigation());
        }
        else if (id==R.id.feedback){
            loadFragmnet(new MainbottomNavigation());
        }
        else if (id==R.id.contact_us){
            loadFragmnet(new MapFragment());

        }
        else if (id==R.id.logout){
            showDialogue();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Logout Dailoge");
        builder.setMessage("Do You Want To Logout?");
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SessionManager sessionManager = new SessionManager(getContext());
                sessionManager.setLogin(false);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container,new Login())
                        .commit();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
