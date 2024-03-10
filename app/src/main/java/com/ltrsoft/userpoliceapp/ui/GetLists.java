package com.ltrsoft.userpoliceapp.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.ltrsoft.userpoliceapp.dao.DAO;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.model.City;
import com.ltrsoft.userpoliceapp.model.Country;
import com.ltrsoft.userpoliceapp.model.District;
import com.ltrsoft.userpoliceapp.model.State;
import com.ltrsoft.userpoliceapp.model.Station;
import com.ltrsoft.userpoliceapp.utils.URLS;

import java.util.ArrayList;
public class GetLists {
    Context context;
    Adapters.CallBack callBack;
    private DAO dao;

    public GetLists(Context context, Adapters.CallBack callBack) {
        this.context = context;
        this.callBack = callBack;

    }
    public void getStation(Adapters.ListCallBack listCallBack){
        dao =new DAO(context);
        dao.select(Station.class, "", "", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<String>stations=new ArrayList<>();
                ArrayList<Station>stations1= (ArrayList<Station>) object;
                System.out.println("size "+stations1.size());
                for (Station s :stations1) {
                    stations.add(s.getPolice_station_name());
                }
                listCallBack.onSuccess(stations);
            }

            @Override
            public void onEmpty() {

            }
        },URLS.READSTATION);

    }
    public  void getCountry(Adapters.ListCallBack listCallBack){
        dao=new DAO(context);
        dao.select(Country.class, "", "", new NewCallBack() {
            @Override
            public void onError(String error) {
            callBack.onError(error);
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<String>country=new ArrayList<>();
                ArrayList<Country>countries= (ArrayList<Country>) object;
                    for (Country c :countries) {
                        country.add(c.getCountry_name());
                    }
                listCallBack.onSuccess(country);
                }
            @Override
            public void onEmpty() {
                callBack.onError("Empty Country");
            }
        }, URLS.COUNTY_GET);
    }

    public  void getStatesByCountry(String id, Adapters.ListCallBack listCallBack){
        dao=new DAO(context);
        dao.select(State.class, "country_id", id, new NewCallBack() {
            @Override
            public void onError(String error) {
                callBack.onError(error);
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<String>s=new ArrayList<>();
                ArrayList<State>states= (ArrayList<State>) object;
                for (State state :states) {
                    s.add(state.getState_name());
                }
                listCallBack.onSuccess(s);
            }

            @Override
            public void onEmpty() {
                callBack.onError("Empty Country");
            }
        }, URLS.STATES_GET);
    }
    public  void getDistrictByState(String id, Adapters.ListCallBack listCallBack){
        dao=new DAO(context);
        dao.select(District.class, "state_id", id, new NewCallBack() {
            @Override
            public void onError(String error) {
                callBack.onError(error);
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<String>s=new ArrayList<>();
                ArrayList<District>states= (ArrayList<District>) object;
                for (District state :states) {
                    s.add(state.getDistrict_name());
                }
                listCallBack.onSuccess(s);
            }
            @Override
            public void onEmpty() {
                callBack.onError("Empty Country");
            }
        }, URLS.DISTRICT_GET);
    }
    public  void getCityByDistrict(String id, Adapters.ListCallBack listCallBack){
        dao=new DAO(context);
        dao.select(City.class, "district_id", id, new NewCallBack() {
            @Override
            public void onError(String error) {
                callBack.onError(error);
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<String>s=new ArrayList<>();
                ArrayList<City>states= (ArrayList<City>) object;
                for (City city :states) {
                    s.add(city.getCity_name());
                }
                listCallBack.onSuccess(s);
            }
            @Override
            public void onEmpty() {
                callBack.onError("Empty Country");
            }
        }, URLS.CITY_GET);
    }
}
