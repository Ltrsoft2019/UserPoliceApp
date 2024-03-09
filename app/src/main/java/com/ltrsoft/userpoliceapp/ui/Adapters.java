package com.ltrsoft.userpoliceapp.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapters extends GetLists{
    private Context context;
    LinearLayout layout;
    FormGenerator formGenerator;
    CallBack callBack;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String>adapter2;
    public ArrayAdapter<String>adapter3;
    public ArrayAdapter<String>adapter4;
    public ArrayAdapter<String>adapter5;

    private Spinner spinner1,spinner2,spinner3,spinner4;

    public Adapters(Context context, LinearLayout layout,FormGenerator formGenerator,CallBack callBack) {
        super(context,callBack);
        this.context = context;
        this.layout=layout;
        this.formGenerator=formGenerator;
        this.callBack =callBack;
    }
    public void setAdapters(){

        setCountry();

        // Set states after 100 milliseconds
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setStates("1");
            }
        }, 200);

        // Set district after 200 milliseconds
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setDistrict("1");
            }
        }, 300);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setCity("1");
            }
        }, 500);

    }
    public void setStation(){
      getStation(new ListCallBack() {
          @Override
          public void onSuccess(ArrayList<String> list) {
              for (String item :list){
                  Log.d("ListItem", item);
                 adapter5=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                 adapter5.setDropDownViewResource(android.R.layout.simple_list_item_1);
                 spinner4=formGenerator.generateSpinner(FormElement.STATION, list, adapter5, new AdapterView.OnItemSelectedListener() {
                     @Override
                     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                         Toast.makeText(context, ""+list.get(position), Toast.LENGTH_SHORT).show();
                     }

                     @Override
                     public void onNothingSelected(AdapterView<?> parent) {

                     }
                 });

              }
          }
      });
    }
    private void setCountry() {
        getCountry(new ListCallBack() {
            @Override
            public void onSuccess(ArrayList<String> list) {
                Log.d("size", String.valueOf(list.size()));
                for (String item : list) {
                    Log.d("ListItem", item);
                }
                adapter1 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spinner1= formGenerator.generateSpinner(FormElement.COUNTRY, list, adapter1,new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(context, "item"+list.get(i), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });
    }
    private void setStates(String number) {
        getStatesByCountry(number,new  ListCallBack() {
            @Override
            public void onSuccess(ArrayList<String> list) {
                Log.d("size", String.valueOf(list.size()));
                for (String item : list) {
                    Log.d("ListItem", item);
                }
                adapter2 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                adapter2.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spinner2= formGenerator.generateSpinner(FormElement.STATE, list, adapter2,new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(context, "item"+list.get(i), Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });
    }
    private void setDistrict(String number) {
        getDistrictByState(number,new  ListCallBack() {
            @Override
            public void onSuccess(ArrayList<String> list) {
                Log.d("size", String.valueOf(list.size()));
                for (String item : list) {
                    Log.d("ListItem", item);
                }
                adapter3 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                adapter3.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spinner3= formGenerator.generateSpinner(FormElement.DISTRICT, list, adapter3,new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(context, "item"+list.get(i), Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });
    }
    private void setCity(String number) {
       getCityByDistrict(number,new  ListCallBack() {
            @Override
            public void onSuccess(ArrayList<String> list) {
                Log.d("size", String.valueOf(list.size()));
                for (String item : list) {
                    Log.d("ListItem", item);
                }
                adapter4 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                adapter4.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spinner3= formGenerator.generateSpinner(FormElement.CITY, list, adapter4,new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(context, "item"+list.get(i), Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });
    }

    public interface CallBack {
        public void onError(String error);
    }
    public interface ListCallBack {
        public void onSuccess(ArrayList<String>list);
    }
}
