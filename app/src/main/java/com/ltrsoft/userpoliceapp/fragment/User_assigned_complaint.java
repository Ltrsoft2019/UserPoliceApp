package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;

public class User_assigned_complaint extends Fragment {
    public User_assigned_complaint() {
    }

    private View view;
   CardView cardView;
    TextView complaintIdTextView,natureOfComplaintTextView,statusTextView,complaintDateTextView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_assigned_complaint, container, false);

        setid();
   return view;
    }

    private void setid() {
        cardView = view.findViewById(R.id.cardView);

        // Find the TextViews inside the CardView
        complaintIdTextView = cardView.findViewById(R.id.complaintIdTextView);
        natureOfComplaintTextView = cardView.findViewById(R.id.natureOfComplaintTextView);
        statusTextView = cardView.findViewById(R.id.statusTextView);
        complaintDateTextView = cardView.findViewById(R.id.complaintDateTextView);
    }
}
