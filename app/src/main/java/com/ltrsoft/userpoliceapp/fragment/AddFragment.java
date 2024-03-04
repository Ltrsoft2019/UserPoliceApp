package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class AddFragment extends Fragment {
    private View view;
    private RelativeLayout addComplaint,quickComplaint,unidentifiedObj,unidentifiedbody,addcybercrime,addgrievence,addmissingperson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_complaints, container, false);
        inisilizeView();

        return view;
    }

    private void inisilizeView() {
        //    private RelativeLayout addComplaint,quickComplaint,unidentifiedObj,unidentifiedbody,addcybercrime,addgrievence,addmissingperson
        addComplaint = view.findViewById(R.id.complaints);
        quickComplaint = view.findViewById(R.id.quickcomplaints);
        unidentifiedObj = view.findViewById(R.id.unidentified_obj);
        unidentifiedbody = view.findViewById(R.id.unidentified_body);
        addcybercrime = view.findViewById(R.id.cyber_complaints);
        addgrievence = view.findViewById(R.id.add_grievence);
        addmissingperson = view.findViewById(R.id.add_missing_person);

        addComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFramnet();
            }
        });



    }

    private void loadFramnet() {

    }
}
