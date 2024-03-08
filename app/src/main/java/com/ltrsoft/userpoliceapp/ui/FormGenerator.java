package com.ltrsoft.userpoliceapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.utils.ImagePicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormGenerator {

    private Context context;
    private LinearLayout formLayout;
    private List<FormElement> formElements;
    ArrayAdapter<String>changeAdapter;
    private ImagePicker picker;

    public FormGenerator(LinearLayout layout, List<FormElement> list) {
        this.formLayout = layout;
        this.formElements = list;
        this.context = layout.getContext();
        this.picker = new ImagePicker((Activity) context);
    }
    public void generateForm() {

        for (FormElement element : formElements) {
            switch (element.getType()) {
                case FormElement.TYPE_EDIT_TEXT:
                    generateEditText(element.getLabel(), element.getSubType());
                    break;
                case FormElement.TYPE_IMAGE_VIEW:
                    generateImageView(element.getLabel());
                    break;
                case FormElement.TYPE_BUTTON:
                    generateButton(element.getLabel());
                    break;
                case FormElement.TYPE_CHECKBOX:
                    generateCheckBox(element.getLabel());
                    break;
                case FormElement.TYPE_RADIO_GROUP:
                    generateRadioGroup(element.getLabel(), element.getOptions());
                    break;
            }
        }
    }
    private  void generateEditText(String label,String subtype) {

        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, context.getResources().getDisplayMetrics())
        );
        textView.setLayoutParams(textViewParams);
        textView.setText(label);
        textView.setPadding(5, 20, 0, 0);
        formLayout.addView(textView);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        System.out.println("label"+label);
        // Create EditText
        EditText editText = new EditText(context);
        switch (subtype){
            case FormElement.SUBTYPE_EMAIL:
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case FormElement.SUBTYPE_NUMBER:
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            default:
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
        }
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1
        );
        editText.setBackground(context.getResources().getDrawable(R.drawable.btn_border));
        editText.setLayoutParams(editTextParams);
        editText.setTag(label);


        // Create ImageView
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, context.getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics())
        );
        imageView.setImageResource(R.drawable.mic2);
        imageView.setLayoutParams(imageViewParams);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "on clister", Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED) {
                    int REQUEST_RECORD_AUDIO_PERMISSION = 1000;
                    ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.RECORD_AUDIO},
                            REQUEST_RECORD_AUDIO_PERMISSION);
                }
                else {
                    Toast.makeText(context.getApplicationContext(), " granted", Toast.LENGTH_SHORT).show();
                    SpeechListener listener = new SpeechListener(editText);
                    listener.startListening();
                }
            }
        });

        // Add EditText and ImageView to the LinearLayout
        linearLayout.addView(editText);
        linearLayout.addView(imageView);

        // Add the LinearLayout to the parent formLayout
        formLayout.addView(linearLayout);

    }
    private void generateImageView(String label) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.cam2);
        imageView.setTag(label);

        // Adjust the layout parameters for the ImageView
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, context.getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, context.getResources().getDisplayMetrics())
        );
        layoutParams.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL; // Center both vertically and horizontally
        layoutParams.setMargins(0, 20, 0, 0); // Adjust margins as needed/ Adjust margins as needed


        imageView.setLayoutParams(layoutParams);
        picker.setOnImagePickedListener(new ImagePicker.OnImagePickedListener() {
            @Override
            public void onImagePicked(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.pickImage();
            }
        });
        formLayout.addView(imageView);
    }
    private void generateButton(String label) {
        Button button = new Button(context);
        button.setTag(label);
        button.setText(label);
        button.setTag(label);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        formLayout.addView(button);
    }
    private void generateRadioGroup(String label, List<String> options) {
        // Create a new RadioGroup
        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL); // Set orientation to vertical
        // Create RadioButtons based on the options provided
        for (int i = 0; i < options.size(); i++) {
            String gendername = options.get(i);
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(gendername);
            radioGroup.addView(radioButton); // Add RadioButton to RadioGroup
        }{

        }
        radioGroup.setTag(label);
        formLayout.addView(radioGroup);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        picker.onActivityResult(requestCode,resultCode,data);
    }
    public Map<String, String> getFormData(LinearLayout formLayout) {
        Map<String, String> formDataMap = new HashMap<>();
        for (int i = 0; i < formLayout.getChildCount(); i++) {
            View childView = formLayout.getChildAt(i);
           if (childView instanceof LinearLayout) {
//               Log.d("radio ","checkred");
               LinearLayout layout = (LinearLayout) childView;
               for (int j = 0; j < layout.getChildCount(); j++) {
                   View childView2 = layout.getChildAt(j);
                   if (childView2 instanceof EditText) {
                       EditText editText = (EditText) childView2;
                      formDataMap.put(editText.getTag().toString(),editText.getText().toString());
                   }
               }
           }
          if (childView instanceof RadioGroup) {
               RadioGroup radioGroup = (RadioGroup) childView;
               int radioButtonId = radioGroup.getCheckedRadioButtonId();
               Log.d("id",String.valueOf(radioButtonId));
               if (radioButtonId != -1) {
                   RadioButton radioButton = radioGroup.findViewById(radioButtonId);
                   if (radioButton != null) {
                       formDataMap.put(radioGroup.getTag().toString(), radioButton.getText().toString());
                   } else {
                       formDataMap.put(radioGroup.getTag().toString(), "nul");
                   }
               }
           }
           else if (childView instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) childView;
                    formDataMap.put(checkBox.getText().toString(),checkBox.isChecked()?"true":"false");
            } else if (childView instanceof Spinner) {
                Spinner spinner = (Spinner) childView;
                formDataMap.put(spinner.getTag().toString(), spinner.getSelectedItem().toString());
                /* Get selected item from spinner and add it to formDataMap */
            }

            // Add handling for other types of form elements
        }
        return formDataMap;
    }
    public Spinner generateSpinner(String label, ArrayList<String> originallist, ArrayAdapter<String> adapter, AdapterView.OnItemSelectedListener selectedListener) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, context.getResources().getDisplayMetrics())
        );
        textView.setLayoutParams(textViewParams);
        textView.setText(label);
        textView.setPadding(5, 20, 0, 0);
        formLayout.addView(textView);

        Spinner spinner = new Spinner(context);
        LinearLayout.LayoutParams spinnerParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, context.getResources().getDisplayMetrics())
        );
        spinner.setTag(label);
        spinner.setLayoutParams(spinnerParams);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(selectedListener);
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Searchviews.showCustomDropdown(formLayout, context, originallist, adapter, new NewCallBack() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Object object) {
                            String selected = (String) object;
                            originallist.remove(selected); // Remove selected item from the list
                            originallist.add(0, selected); // Add selected item to the top
                            adapter.notifyDataSetChanged(); // Notify the adapter of the change
                            spinner.setSelection(0); // Set the selection to the top
                        }

                        @Override
                        public void onEmpty() {
                            // Handle empty callback if needed
                        }
                    });
                    return true; // Consume the touch event
                }
                return false;
            }
        });
        formLayout.addView(spinner);
        return spinner;
    }

    private  void generateCheckBox(String label) {
        CheckBox checkBox = new CheckBox(context);
        checkBox.setText(label);
        checkBox.setTag(label);
        formLayout.addView(checkBox);
    }
}
