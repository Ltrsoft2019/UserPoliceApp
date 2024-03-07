package com.ltrsoft.userpoliceapp.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class Adapters {
    private Context context;
    LinearLayout layout;
    FormGenerator formGenerator;

    public Adapters(Context context, LinearLayout layout,FormGenerator formGenerator) {
        this.context = context;
        this.layout=layout;
        this.formGenerator=formGenerator;
    }

    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String>adapter2;
    private ArrayAdapter<String>adapter3;
    private Spinner spinner1,spinner2,spinner3;

    public void setAdapters(){
        ArrayList<String> country = new ArrayList<>();
        country.add("india");
        country.add("usa");
        country.add("UK");
        country.add("Japan");

        ArrayList<String>state = new ArrayList<>();
        state.add("maharashtra");
        state.add("maharashtra");
        state.add("maharashtra");
        state.add("maharashtra");
        state.add("maharashtra");

        ArrayList<String>state2 = new ArrayList<>();
        state2.add("karnataka");
        state2.add("maharashtra");
        state2.add("maharashtra");
        state2.add("maharashtra");
        state2.add("maharashtra");

        adapter1 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,country);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner1= formGenerator.generateSpinner("country",adapter1, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "value "+country.get(position), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter1 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,country);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner2=formGenerator.generateSpinner("country",adapter1, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "value "+country.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
