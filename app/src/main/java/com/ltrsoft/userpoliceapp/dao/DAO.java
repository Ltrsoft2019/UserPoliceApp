package com.ltrsoft.userpoliceapp.dao;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.ltrsoft.userpoliceapp.helper.ObjToMap;
import com.ltrsoft.userpoliceapp.interfaces.ErrorListener;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DAO<T> {
    Context context;
    RequestQueue queue;
    Class c;
    Object object;
    ArrayList<Object> list=new ArrayList<>();
    private HashMap<String,String> hashMap;
    public DAO(Context context) {
        this.context = context;
        queue= Volley.newRequestQueue(context);
    }
    public void select(Class<T>clas,String key,String values, NewCallBack callBack,String url) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response = "+response);
                        if (response.length() > 1) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    Gson gson = new Gson();
                                    object = gson.fromJson(jsonObject.toString(), clas);
                                    list.add(object);
                                }
                            } catch (JSONException e) {
                                callBack.onError(e.toString());
                                throw new RuntimeException(e);
                            }
                            callBack.onSuccess(list);
                        }
                        else {
                            callBack.onEmpty();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callBack.onError(error.toString());
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                if (!key.isEmpty()){
                    map.put(key,values);
                }
                return map;
            }
        };
        queue.add(request);
    }
    public void insertOrUpdate(Object o, NewCallBack callBack,String url){
        hashMap = ObjToMap.convertObjectToHashMap(o, new ErrorListener() {
            @Override
            public void Error(String error) {
               callBack.onError(error.toString());
            }
        });

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            callBack.onError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return hashMap;
            }
        };
        queue.add(request);
    }
    public void delete(String key,String values, NewCallBack callBack,String url) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response = "+response);
                        callBack.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callBack.onError(error.toString());
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                    map.put(key,values);
                return map;
            }
        };
        queue.add(request);
    }
    public void  getData(HashMap<String,String>map, String url ,NewCallBack callBack){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(request);
    }

}
