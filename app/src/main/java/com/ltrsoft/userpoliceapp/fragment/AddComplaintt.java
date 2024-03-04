package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.adapters.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddComplaintt extends Fragment {
    public AddComplaintt() {}
    private View view;
    private BottomNavigationView navigationView;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addcompalint, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tablayout);
        MyPagerAdapter adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),getActivity().getLifecycle());
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();
//        navigationView = view.findViewById(R.id.topnav);

//        getChildFragmentManager().beginTransaction().add(R.id.complaint_container,new AddComplaintt()).commit();

//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//               if (id==R.id.self){
//                   getChildFragmentManager().beginTransaction().add(R.id.complaint_container,new AddComplaintOnBehalf()).commit();
//               } else if (id==R.id.onbehalf) {
//                   getChildFragmentManager().beginTransaction().add(R.id.complaint_container,new AddComplaintOnBehalf()).commit();
//               }
//                return false;
//            }
//        });

        return view;
    }
}
