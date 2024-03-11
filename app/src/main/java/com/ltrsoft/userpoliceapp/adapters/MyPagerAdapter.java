package com.ltrsoft.userpoliceapp.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ltrsoft.userpoliceapp.fragment.AddComplaintOnBehalf;
import com.ltrsoft.userpoliceapp.fragment.AddselfComplaint;

public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        System.out.println("position "+position);
        if (position==0){
            return new AddselfComplaint();
        } else if (position==1) {
            AddComplaintOnBehalf addComplaintOnBehalf = new AddComplaintOnBehalf();
            return addComplaintOnBehalf;
        }
        else {
            return new AddselfComplaint();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

