package com.ltrsoft.userpoliceapp.ui;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ltrsoft.userpoliceapp.R;

public class FormValidator {

    public static boolean isFormValid(LinearLayout formLayout) {
        for (int i = 0; i < formLayout.getChildCount(); i++) {
            View childView = formLayout.getChildAt(i);
            if (childView instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) childView;
//                if (radioGroup.) {
//                    radioButton.setError("select any ");
//                    return true; // At least one RadioButton is selected
//                }
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                if(! (radioButtonId != -1)){
                    Toast.makeText(formLayout.getContext(), "select gender", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else if (childView instanceof ImageView) {
                ImageView imageView = (ImageView) childView;
                if (imageView.getDrawable() .equals(R.drawable.ic_launcher_background) ){
                    Toast.makeText(formLayout.getContext(), "please select image", Toast.LENGTH_SHORT).show();
                    return false; // ImageView does not contain an image
                }
            } else if (childView instanceof Spinner) {
                Spinner spinner = (Spinner) childView;
                if (spinner.getSelectedItemPosition() <0) {
                    Toast.makeText(formLayout.getContext(), "select "+spinner.getTag().toString(), Toast.LENGTH_SHORT).show();
                    return false; // Spinner has no item selected
                }
            }
            else if (childView instanceof LinearLayout) {
                LinearLayout layout = (LinearLayout) childView;
                for (int j = 0; j < layout.getChildCount(); j++) {
                    View childView2 = layout.getChildAt(j);
                        if (childView2 instanceof EditText) {
                            EditText editText = (EditText) childView2;
                            if (TextUtils.isEmpty(editText.getText())) {
                                editText.setError("field is required");
                                return false;
                            } else {
//                                Toast.makeText(editText.getContext(), "fiedl is not setting", Toast.LENGTH_SHORT).show();
                            }
                        }
                }

            }
            // Add validation for other types of form elements if needed
        }
        return true; // All views are valid
    }
}

