package com.ltrsoft.userpoliceapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.fragment.AddComplaintOnBehalf;
import com.ltrsoft.userpoliceapp.fragment.AddFragment;
import com.ltrsoft.userpoliceapp.ui.UserBehalf;

public class Alertdialoge {
    public void showAlert(String title, String Massage, AppCompatActivity activity,Fragment fragment,String tag)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(Massage);
        builder.setCancelable(false); // Prevent dismissing dialog by clicking outside of it or pressing back button

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Code to handle OK button click
                Toast.makeText( activity, "OK button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Add On Someone Behalfy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Bundle bundle=new Bundle();
                bundle.putString("fragment", tag);
               AddComplaintOnBehalf addComplaintOnBehalf= new AddComplaintOnBehalf();
//             add
                addComplaintOnBehalf.setArguments(bundle);
                FragmentTransaction transaction =    activity.getSupportFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_container2, addComplaintOnBehalf );
                transaction.commit();
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
