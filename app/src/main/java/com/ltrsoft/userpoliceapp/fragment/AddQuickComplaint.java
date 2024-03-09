package com.ltrsoft.userpoliceapp.fragment;



import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.QuickComplaint;
import com.ltrsoft.userpoliceapp.ui.Adapters;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.utils.TakingImage;
import com.ltrsoft.userpoliceapp.utils.URLS;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AddQuickComplaint extends Fragment {
    public AddQuickComplaint() {
    }
    private View view;
    private LinearLayout layout;
    private FormGenerator formGenerator;
    private Button submit;
    private TextView heading;
    private List<FormElement> elements;
    private Adapters adapters;
    public String PHOTO="Select Photo";
    public String DESCRIPTION="Add Discription About Photo";
    public String ADDRESS ="Add Address ";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        heading.setText("Add Quick Complaint");
        elements=new ArrayList<>();
        initialform(layout);
        formGenerator=new FormGenerator(layout,elements,this);
        submit= view.findViewById(R.id.button);
        adapters=new Adapters(getContext(), layout, formGenerator, new Adapters.CallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        adapters.setStation();
     return view;
    }

    private void initialform(LinearLayout layout) {
     elements.add(new FormElement(PHOTO,FormElement.TYPE_IMAGE_VIEW,"",R.drawable.cam2));
     elements.add(new FormElement(DESCRIPTION,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.reminders));
        elements.add(new FormElement(ADDRESS,FormElement.TYPE_EDIT_TEXT,FormElement.SUBTYPE_TEXT,R.drawable.logout));



        formGenerator = new FormGenerator(layout,elements,this);

        formGenerator.generateForm();    }
}
