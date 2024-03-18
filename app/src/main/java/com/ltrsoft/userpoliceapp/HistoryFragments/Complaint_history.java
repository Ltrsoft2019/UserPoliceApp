package com.ltrsoft.userpoliceapp.HistoryFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.userpoliceapp.R;

public class Complaint_history extends Fragment {



    public Complaint_history() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=inflater.inflate(R.layout.complaint_history, container, false);

    return view;
    }
}