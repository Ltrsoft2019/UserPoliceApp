package com.ltrsoft.userpoliceapp.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class ECalling extends Fragment {
    public ECalling() {
    }

    private RelativeLayout amb,women,fire,bomb,cyber,police,safety;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ecalling,container,false);
        amb=view.findViewById(R.id.ambulance);
        women=view.findViewById(R.id.womenhelpline);
        fire=view.findViewById(R.id.fire_brigade);
        bomb=view.findViewById(R.id.bomb);
        cyber=view.findViewById(R.id.cyber_crime);
        police=view.findViewById(R.id.police_station);
        safety=view.findViewById(R.id.safety_feature);
        amb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb="tel:"+"102";//102
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb="tel:"+"1091";//1091
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb="tel:"+"101";//101
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        bomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb="tel:"+"9212111";//9212111
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        cyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb="tel:"+"1930";//102
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amb="tel:"+"100";//100
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "This service is not available", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
