package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Users;
import com.ltrsoft.userpoliceapp.ui.HistoryElements;
import com.ltrsoft.userpoliceapp.ui.HistoryGenerator;
import com.ltrsoft.userpoliceapp.utils.URLS;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends Fragment {
    public UserProfile() {
    }
    private View view;
    HistoryGenerator historyGenerator;
    private List<HistoryElements> element;
    private LinearLayout layout;
    private TextView heading,imageheading;
    private Button button;
    private ImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.common_history_form, container, false);
       layout=view.findViewById(R.id.layout123);
       button=view.findViewById(R.id.button);
       heading=view.findViewById(R.id.heading);
        button.setText("Download");
        heading.setText("User Detail");
         imageheading=view.findViewById(R.id.imageheading);
         imageView=view.findViewById(R.id.imageview);
         imageView.setImageResource(R.drawable.cam2);
         imageView.setVisibility(View.GONE);
         imageheading.setText("Person name");
         imageheading.setVisibility(View.GONE);
         element=new ArrayList<HistoryElements>();
        DAO dao=new DAO(getContext());
        dao.select(Users.class, "user_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<Users>list= (ArrayList<Users>) object;
                Users user=list.get(0);


                element.add(new HistoryElements("User ID", user.getUser_id(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("First Name", user.getUser_fname(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("Middle Name", user.getUser_mname(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("Last Name", user.getUser_lname(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("Address", user.getUser_address(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
           historyGenerator=new HistoryGenerator(element, layout, UserProfile.this);
                historyGenerator.generatecard("Personal Detail");
                element.clear();
                //element.add(new HistoryElements("User Photo:", user.getUser_photo(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("Country Name", user.getCountry_id(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("State Name", user.getState_id(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("District name", user.getDistrict_id(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("City Name", user.getCity_id(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                element.add(new HistoryElements("User Email", user.getUser_email(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
                historyGenerator=new HistoryGenerator(element, layout, UserProfile.this);

                historyGenerator.generatecard("Address Detail");
               // element.add(new HistoryElements("Password:", user.getPassword(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Gender:", user.getGender(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Date of Birth:", user.getUser_dob(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Mobile 1:", user.getUser_mobile1(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Mobile 2:", user.getUser_mobile2(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("User Adhar:", user.getUser_adhar(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("User Pan:", user.getUser_pan(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Occupation:", user.getOccupation(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Nationality:", user.getNationality(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Driving Licence:", user.getDriving_licence(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//               // element.add(new HistoryElements("Notification Token:", user.getn(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                //element.add(new HistoryElements("Latitude:", user.gel(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//               // element.add(new HistoryElements("Longitude:", user.getLongitude(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));
//                element.add(new HistoryElements("Station ID:", user.getStation_id(), R.drawable.cam2, HistoryElements.TYPE_TEXTVIEW));



            }

            @Override
            public void onEmpty() {

            }
        }, URLS.READONEUSERS);


//        historyGenerator.generatehistoryform();

        return view;
    }


}
