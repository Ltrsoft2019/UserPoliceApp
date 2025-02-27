package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.Alertdialoge;

public class AddFragment extends Fragment {
    private RelativeLayout addComplaint, quickComplaint, unidentifiedObj, unidentifiedBody, addCyberCrime, addGrievance, addMissingPerson;
    public static final String cmp_frag_tag = "complaint";
    public static final String cyber_frag_tag = "cyber";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_complaints, container, false);
        initializeView(view);
        setClickListeners();
        return view;
    }

    private void initializeView(View view) {
        addComplaint = view.findViewById(R.id.complaints);
        quickComplaint = view.findViewById(R.id.quickcomplaints);
        unidentifiedObj = view.findViewById(R.id.unidentified_obj);
        unidentifiedBody = view.findViewById(R.id.unidentified_body);
        addCyberCrime = view.findViewById(R.id.cyber_complaints);
        addGrievance = view.findViewById(R.id.add_grievence);
        addMissingPerson = view.findViewById(R.id.add_missing_person);
    }

    private void setClickListeners() {
        addComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Alertdialoge alertdialoge=new Alertdialoge();
//                alertdialoge.showAlert("Add complant","Add Cyber Complaint",(AppCompatActivity) getActivity(),new CyberCrime(),cmp_frag_tag);
                loadFragment(new AddComplaintt());
            }


        });
        addCyberCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Alertdialoge alertdialoge=new Alertdialoge();
//                alertdialoge.showAlert("Add complant","Add Cyber Complaint",(AppCompatActivity) getActivity(),new CyberCrime(),cyber_frag_tag);

                loadFragment(new CyberCrime());
            }
        });
        addGrievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new GrievanceFragment());
            }
        });
        addMissingPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    loadFragment(new Miss);
            }
        });
       quickComplaint.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               loadFragment(new AddQuickComplaint());
           }
       });

       unidentifiedBody.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               loadFragment(new UnidentifiedBody1());
           }
       });
       unidentifiedObj.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               loadFragment(new UnidentifiedObjectFragment() );
           }
       });
     }


    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.main_container2, fragment);
        transaction.commit();
    }
}
 