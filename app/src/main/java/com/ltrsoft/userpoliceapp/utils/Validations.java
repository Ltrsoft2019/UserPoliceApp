package com.ltrsoft.userpoliceapp.utils;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Validations {

    public static boolean validateEditText(EditText editText, String fieldName) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            editText.setError(fieldName + " is required");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validateSpinner(Spinner spinner, String fieldName) {
//        String selectedItem = spinner.getSelectedItem().toString();
//        if (selectedItem.isEmpty() || selectedItem.equals("Select")) { // Change "Select" according to your default selection
//            // Show error message or handle validation failure as needed
//            // For spinners, you can't set an error directly, you might use a TextView to display the error message
//            return false;
//        }
//        return true;
        return true;
    }

}
