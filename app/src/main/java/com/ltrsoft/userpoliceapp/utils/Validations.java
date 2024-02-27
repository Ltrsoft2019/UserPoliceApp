package com.ltrsoft.userpoliceapp.utils;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Validations {
    public static boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static  boolean isPhoneNumberValid(String phoneNumber) {
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }

    public static  boolean isPasswordValid(String password) {
        return password.length() >= 6; // Minimum 6 characters
    }

    public static  boolean isFieldEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    public static  boolean isDateValid(DatePicker datePicker) {
       datePicker.isEnabled();
        return true;
    }
    public static  boolean isSpinnerItemSelected(Spinner spinner) {
        return spinner.getSelectedItemPosition() > 0;
    }


}
