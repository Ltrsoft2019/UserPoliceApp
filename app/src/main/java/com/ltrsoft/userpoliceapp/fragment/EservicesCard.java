package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.login.Login;
import com.ltrsoft.userpoliceapp.navigations.MainNavigation;

public class EservicesCard extends Fragment {
    private View view;
    private RelativeLayout charcter,tenant,weapon,clearance,domestichelp,emp_veri,passport_veri,
    noc,ampl_sound;
    private LinearLayout rally,festivals;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.eservices_layout, container, false);
        initilizeView();
        setClickListeners();
        return view;
    }

    private void setClickListeners() {

        charcter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Character_Certificate1());
            }
        });
        tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TenantVerification());
            }
        });
        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AddWeaponLicence1());
            }
        });
        clearance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        domestichelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        emp_veri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        passport_veri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        noc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ampl_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        festivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initilizeView() {

        charcter = view.findViewById(R.id.character_certificate);
        tenant = view.findViewById(R.id.tenant_verf);
        weapon = view.findViewById(R.id.weapon_veri);
        clearance = view.findViewById(R.id.clearance_cert);
        domestichelp = view.findViewById(R.id.domestic_help);
        emp_veri = view.findViewById(R.id.emp_veri);
        passport_veri = view.findViewById(R.id.passport_veri);
        noc = view.findViewById(R.id.noc_veri);
        ampl_sound = view.findViewById(R.id.license_amp_sound);
        rally = view.findViewById(R.id.rally_permisssion);
        festivals = view.findViewById(R.id.permisssion_festival);

    }

    private void loadFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_container2,fragment)
                .commit();
    }
}
