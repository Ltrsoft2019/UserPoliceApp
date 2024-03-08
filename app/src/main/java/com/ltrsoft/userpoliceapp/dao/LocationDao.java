package com.ltrsoft.userpoliceapp.dao;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.Country;
import com.ltrsoft.userpoliceapp.model.District;
import com.ltrsoft.userpoliceapp.model.State;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class LocationDao {
    private Context context;
    private  HashMap<Integer,String>map;
    private  HashMap<Integer,String>map2;
    private  HashMap<Integer,String>map3;
    public ArrayAdapter<String>adapter;
    public LocationDao(Context context) {
        this.context = context;
        map=new HashMap<>();
    }
    public  void getCountryAdapter(NewCallBack callBack){
        DAO dao = new DAO(context);
        dao.select(Country.class, "", "", new NewCallBack() {
            @Override
            public void onError(String error) {
            callBack.onError(error);
            }

            @Override
            public void onSuccess(Object object) {
            ArrayList<Country>list = (ArrayList<Country>) object;
            ArrayList<String>countrylist = new ArrayList<>();

                for (int i = 0; i < list.size(); i++) {
                    Country country = list.get(i);
                    countrylist.add(country.getCountry_name());
                    map.put(i,country.getCountry_id());
                }
                adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,countrylist);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

                if (adapter!=null){
                    adapter=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,countrylist);
                }
                callBack.onSuccess(adapter);
            }

            @Override
            public void onEmpty() {
                callBack.onEmpty();
            }
        },Country.GETCOUNTRY);

    }



    public void getState(NewCallBack callBack , String country_id){
        DAO dao = new DAO(context);
        dao.select(State.class, "country_id", country_id, new NewCallBack() {
            @Override
            public void onError(String error) {
                callBack.onError(error);
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<State>list = (ArrayList<State>) object;
                ArrayList<String>statelist = new ArrayList<>();
                map2=new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    State country = list.get(i);
                    statelist.add(country.getState_name());
                    map2.put(i,country.getState_id());
                }

                adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,statelist);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

                if (adapter!=null){
                    adapter=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,statelist);
                }
                callBack.onSuccess(adapter);
            }

            @Override
            public void onEmpty() {
                callBack.onEmpty();
            }
        },State.GETSTATE);
    }


    public void getDistrict(NewCallBack callBack , String state_id){
        DAO dao = new DAO(context);
        dao.select(District.class, "state_id", state_id, new NewCallBack() {
            @Override
            public void onError(String error) {
                callBack.onError(error);
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<District>list = (ArrayList<District>) object;
                ArrayList<String>districtclass = new ArrayList<>();
                map3=new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    District country = list.get(i);
                    districtclass.add(country.getDistrict_name());
                    map3.put(i,country.getDistrict_id());
                }

                adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,districtclass);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

                if (adapter!=null){
                    adapter=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,districtclass);
                }
                callBack.onSuccess(adapter);
            }

            @Override
            public void onEmpty() {
                callBack.onEmpty();
            }
        },District.GETSISTRICT);
    }



}
