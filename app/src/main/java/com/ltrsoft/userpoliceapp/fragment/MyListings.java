package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ltrsoft.userpoliceapp.R;

public class MyListings extends Fragment {
    private View view;
    private RelativeLayout mycomplaints,myfir,myservices,mygrievence,mycyber;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_listings, container, false);
        initilizeView();
        setClickListeners();
        return view;
    }

    private void setClickListeners() {
    mycomplaints.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadFragment(new AddEvidence());
        }
    });


    }

    private void initilizeView() {
        // mycomplaints,myfir,myservices,mygrievence,mycyber;
        mycomplaints = view.findViewById(R.id.mycomplaints);
        myfir = view.findViewById(R.id.myfir);
        myservices = view.findViewById(R.id.myservices);
        mygrievence = view.findViewById(R.id.mygrievence);
        mycyber = view.findViewById(R.id.mycyber);
    }
    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.main_container2, fragment);
        transaction.commit();
    }
}
