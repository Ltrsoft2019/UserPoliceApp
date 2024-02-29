package com.ltrsoft.userpoliceapp.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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

    public boolean isValidMobileNumber(EditText editText, String errorMessage) {
        String mobileNumber = editText.getText().toString().trim();

        // Check if the mobile number is not null and has exactly 10 digits
        if (mobileNumber.length() == 10) {
            // Check if all characters in the mobile number are digits
            for (int i = 0; i < mobileNumber.length(); i++) {
                if (!Character.isDigit(mobileNumber.charAt(i))) {
                    // Display error message
                    editText.setError(errorMessage);
                    // Return false if any character is not a digit
                    return false;
                }
            }
            // All characters are digits, so the mobile number is valid
            return true;
        } else {
            // Display error message
            editText.setError(errorMessage);
            // Mobile number is not 10 digits
            return false;
        }
    }


    public boolean isValidEmail(EditText editText, String errorMessage) {
        String email = editText.getText().toString().trim();

        // Regular expression pattern for email validation
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        // Check if the email matches the pattern
        if (email.matches(emailPattern)) {
            // Email is valid
            return true;
        } else {
            // Display error message
            editText.setError(errorMessage);
            // Email is not valid
            return false;
        }
    }

    public boolean isValidSpinnerSelection(Spinner spinner, String errorMessage) {
        // Get the selected item position from the Spinner
        int selectedItemPosition = spinner.getSelectedItemPosition();

        // Check if a valid item is selected (position >= 0)
        if (selectedItemPosition >= 0) {
            // Selection is valid
            return true;
        } else {
            // Display error message
            TextView errorText = (TextView) spinner.getSelectedView();
            errorText.setError(errorMessage);
            errorText.setTextColor(Color.RED); // Change text color to indicate error
            // Selection is not valid
            return false;
        }
    }
    public boolean isValidImageView(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        return drawable != null; // Return true if the ImageView has a valid image resource set
    }

}
