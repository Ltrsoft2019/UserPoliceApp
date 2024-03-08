package com.ltrsoft.userpoliceapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;

import java.util.ArrayList;
import java.util.List;

public class Searchviews {

   public static   void showCustomDropdown(LinearLayout layout1, Context context, ArrayList<String> originallist, ArrayAdapter<String> adapter1, NewCallBack callBack){
       LinearLayout layout = new LinearLayout(context);

       layout.setLayoutParams(new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
       layout.setOrientation(LinearLayout.VERTICAL);

       // Create SearchView
       SearchView searchView = new SearchView(context);
       searchView.setLayoutParams(new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
       searchView.setIconifiedByDefault(false);
       searchView.setQueryHint("Search");

       // Create ListView
       final ListView listView = new ListView(context);
     final ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
               android.R.layout.simple_list_item_1, originallist);
       listView.setAdapter(adapter);

       // Add SearchView and ListView to the layout
       layout.addView(searchView);
       layout.addView(listView);

       // Create AlertDialog with the custom layout
       AlertDialog.Builder builder = new AlertDialog.Builder(context);
       builder.setView(layout);
       final AlertDialog dialog = builder.create();
       dialog.show();

       // Set a listener to handle item click in the ListView
       // Set a listener to handle item click in the ListView
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String selectedItem = originallist.get(position);
               // Remove the selected item from its current position
               originallist.remove(position);
               // Add the selected item to the top
               originallist.add(0, selectedItem);
               // Notify the adapter of the data change
              // adapter1.notifyDataSetChanged();
               // Call onSuccess callback with the selected item
               callBack.onSuccess(selectedItem);
               // Dismiss the dialog
               dialog.dismiss();
           }
       });



       // Set a listener to handle query text changes in the SearchView
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               adapter.getFilter().filter(newText);
               return true;
           }
       });
     }
}
