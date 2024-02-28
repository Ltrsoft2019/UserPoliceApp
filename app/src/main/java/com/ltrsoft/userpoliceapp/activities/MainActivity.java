package com.ltrsoft.userpoliceapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.AddComplaintOnBehalf;
import com.ltrsoft.userpoliceapp.fragment.AddQuickComplaint;
import com.ltrsoft.userpoliceapp.fragment.SuspectInformationFragment;
import com.ltrsoft.userpoliceapp.fragment.VictimInformationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.main_container,new AddQuickComplaint()).commit();

    }
}