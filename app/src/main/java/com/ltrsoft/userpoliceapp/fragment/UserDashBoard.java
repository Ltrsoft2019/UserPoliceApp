package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.maps.MapFragment;

public class UserDashBoard  extends Fragment {
private View view;
    private TextView totalComplaintTextView;
    private TextView solvedComplaintTextView;
    private TextView idTextView;
    private TextView ongoingInvestigationTextView;
    private TextView responseTimeTextView;
    private TextView clearanceTimeTextView;
    private TextView appliedTextView;
    private TextView grantedTextView;
    private TextView rejectedTextView;
    private TextView pendingTextView;
    private FloatingActionButton  map,chatbot;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_dashboard, container, false);
        map=view.findViewById(R.id.map);
        chatbot=view.findViewById(R.id.chatbot);
        intilizeView();

        totalComplaintTextView.setText("24");
        solvedComplaintTextView.setText("15");
        idTextView.setText("5");
        ongoingInvestigationTextView.setText("6");
        responseTimeTextView.setText("2 Days");
        clearanceTimeTextView.setText("20 Days");
        appliedTextView.setText("4");
        grantedTextView.setText("1");
        rejectedTextView.setText("2");
        pendingTextView.setText("2");
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().
                        getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.main_container2,new MapFragment())
                        .commit();
            }
        });

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.main_container2,new MapFragment())
                        .commit();
            }
        });

        return view;
    }
    private void intilizeView() {
        totalComplaintTextView = view.findViewById(R.id.total_complaint);
        solvedComplaintTextView = view.findViewById(R.id.solved_complant);
        idTextView = view.findViewById(R.id.id);
        ongoingInvestigationTextView = view.findViewById(R.id.ongoint_invst);
        responseTimeTextView = view.findViewById(R.id.response_time);
        clearanceTimeTextView = view.findViewById(R.id.clearance_time);
        appliedTextView = view.findViewById(R.id.applied);
        grantedTextView = view.findViewById(R.id.granted);
        rejectedTextView = view.findViewById(R.id.rejected);
        pendingTextView = view.findViewById(R.id.pending);
    }
}
;