package com.ltrsoft.userpoliceapp.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Location;
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
import android.widget.DatePicker;
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
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.interfaces.LocationCallBack;
import com.ltrsoft.userpoliceapp.interfaces.NewCallBack;
import com.ltrsoft.userpoliceapp.utils.EncodedImage;
import com.ltrsoft.userpoliceapp.utils.ImagePicker;
import com.ltrsoft.userpoliceapp.utils.LocationProvider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FormGenerator {
    private Intent data;
    private Context context;
    private LinearLayout formLayout;
    private List<FormElement> formElements;
    ArrayAdapter<String>changeAdapter;
    private ImagePicker picker;
    private Fragment fragment;

    public FormGenerator(LinearLayout layout, List<FormElement> list,Fragment fragment) {
        this.formLayout = layout;
        this.formElements = list;
        this.context = layout.getContext();
        this.picker = new ImagePicker(fragment);
        this.fragment = fragment;
    }
    public void generateForm() {

        for (FormElement element : formElements) {
            switch (element.getType()) {
                case FormElement.TYPE_EDIT_TEXT:
                    generateEditText(element.getLabel(), element.getSubType(), element.getImage());
                    break;
                case FormElement.TYPE_IMAGE_VIEW:
                    generateImageView(element.getLabel());
                    break;
                case FormElement.TYPE_BUTTON:
                    generateButton(element.getLabel(),element.getSubType());
                    break;
                case FormElement.TYPE_CHECKBOX:
                    generateCheckBox(element.getLabel());
                    break;
                case FormElement.TYPE_RADIO_GROUP:
                    generateRadioGroup(element.getLabel(), element.getOptions(element.getSubType()));
                    break;
            }
        }
    }
    private void generateEditText(String label, String subtype,int image) {
//        genratetextview(label);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Create EditText
        EditText editText = new EditText(context);
        setimageashint(image,editText);

        switch (subtype) {
            case FormElement.SUBTYPE_EMAIL:
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case FormElement.SUBTYPE_NUMBER:
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case FormElement.SYBTYPE_SEXT_TEXT:
                editText.setText(label);
                break;
            default:
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
        }

        // Apply background and padding to the EditText
        editText.setBackgroundResource(R.drawable.btn_border);
        int paddingInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, context.getResources().getDisplayMetrics());
        editText.setPadding(paddingInDp, 0, 0, 10);

        // Set layout parameters for the EditText
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, context.getResources().getDisplayMetrics()),
                1
        );

        editTextParams.gravity = Gravity.CENTER_VERTICAL;
        editTextParams.setMargins(0,20,0,20);
        editText.setLayoutParams(editTextParams);

         Typeface arialTypeface = Typeface.create("georgia", Typeface.NORMAL);
        editText.setTypeface(arialTypeface);
        editText.setTextSize(16); // Change 50 to your desired size in pixels
        editText.setPadding(5,2,0,0);
        editText.setHint("   "+label);

        editText.setTag(label);

        // Create ImageView
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics())
        );

        imageView.setImageResource(R.drawable.mic2);
        imageViewParams.setMargins(0,15,0,0);
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
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        Typeface arialTypeface = Typeface.create("georgia", Typeface.NORMAL);
        textView.setTypeface(arialTypeface);
        textView.setTextSize(16);
        textViewParams.gravity = Gravity.CENTER_HORIZONTAL; // Center horizontally
        textViewParams.setMargins(0, 20, 0, 0); // Set margin top to 10dp
        textView.setPadding(0,10,0,0);
        textView.setLayoutParams(textViewParams);
        textView.setText(label);
        formLayout.addView(textView);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.cam2);
        imageView.setTag(label);
        imageView.setDrawingCacheEnabled(true);

        // Adjust the layout parameters for the ImageView
        LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, context.getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, context.getResources().getDisplayMetrics())
        );
        imageLayoutParams.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL; // Center both vertically and horizontally
        imageLayoutParams.setMargins(0, 0, 0, 0); // Adjust margins as needed

        imageView.setLayoutParams(imageLayoutParams);
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

    private void generateButton(String label,String subtype) {
         Button button = new Button(context);

        LinearLayout.LayoutParams buttonparam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, context.getResources().getDisplayMetrics())
        );
        buttonparam.setMargins(0, 20, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()), 20);
         button.setLayoutParams(buttonparam);
        Typeface arialTypeface = Typeface.create("georgia", Typeface.NORMAL);
        button.setTypeface(arialTypeface);
        button.setForegroundGravity(View.TEXT_ALIGNMENT_CENTER);
        button.setTextSize(16);
        button.setTag(label);
        button.setText(label);
         if (subtype==FormElement.SUBTYPE_BUTTON_LOCATION){
             setimageashint(R.drawable.location,button);

         }
         else {
             setimageashint(R.drawable.calendar,button);
         }
         button.setPadding(8,2,0,0);
        button.setBackground(context.getResources().getDrawable(R.drawable.btn_border));
         button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (subtype==FormElement.SUBTYPE_BUTTON_LOCATION) {

                    LocationProvider.getCurrentLocation(context, new LocationCallBack() {
                        @Override
                        public void onLocationGet(Location latLng) {
//                            Toast.makeText(context, "lats"+latLng.getLatitude(), Toast.LENGTH_SHORT).show();
                            double lat = latLng.getLatitude();
                            double log = latLng.getLongitude();
                            button.setText(String.valueOf(lat)+","+String.valueOf(log));
                        }

                        @Override
                        public void onError(String error) {
                            Toast.makeText(context, "error please try again", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else{
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            context,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                                    // Handle the date selection or update the TextView
                                    String dateOfBirth = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                                    button.setText(dateOfBirth);
                                }
                            },
                            year,
                            month,
                            day);

                    // Show the date picker dialog
                    datePickerDialog.show();
                }
            }
        });
        formLayout.addView(button);
    }
    private void generateRadioGroup(String label, List<String> options) {
        // Create a new RadioGroup
     genratetextview(label+" :");

        RadioGroup radioGroup = new RadioGroup(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, context.getResources().getDisplayMetrics())
        );
        layoutParams.setMargins(0, 20, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()), 20);
         radioGroup.setLayoutParams(layoutParams);
        radioGroup.setBackgroundResource(R.drawable.btn_border);
        radioGroup.setPadding(0,10,0,10);
        Typeface arialTypeface = Typeface.create("georgia", Typeface.NORMAL);
          radioGroup.setOrientation(LinearLayout.HORIZONTAL); // Set orientation to vertical
        // Create RadioButtons based on the options provided
        for (int i = 0; i < options.size(); i++) {
            String gendername = options.get(i);
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(gendername);
            radioButton.setTextSize(16);
             radioButton.setTypeface(arialTypeface);
            radioGroup.addView(radioButton); // Add RadioButton to RadioGroup
        }
        radioGroup.setTag(label);
        formLayout.addView(radioGroup);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        picker.onActivityResult(requestCode,resultCode,data);
    }
    public static Map<String, String> getFormData(LinearLayout formLayout) {
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
                      formDataMap.put((String)editText.getTag(),editText.getText().toString());
                       System.out.println("editetxt "+(String) editText.getTag());
                   }
               }
           }
        if (childView instanceof RadioGroup) {
               RadioGroup radioGroup = (RadioGroup) childView;
               int radioButtonId = radioGroup.getCheckedRadioButtonId();
               System.out.println("radiogroup"+(String) radioGroup.getTag());
               if (radioButtonId != -1) {
                   RadioButton radioButton = radioGroup.findViewById(radioButtonId);
                   if (radioButton != null) {
                       formDataMap.put((String)radioGroup.getTag(), radioButton.getText().toString());
                   } else {
                       formDataMap.put((String)radioGroup.getTag(), "nul");
                   }
               }
           }
           else if (childView instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) childView;
                    formDataMap.put((String)checkBox.getTag(),checkBox.isChecked()?"true":"false");
                    System.out.println("checkbox"+(String)checkBox.getTag());
            } else if (childView instanceof Spinner) {
                Spinner spinner = (Spinner) childView;
                formDataMap.put((String)spinner.getTag(), String.valueOf(spinner.getSelectedItemPosition()+1));
                System.out.println("spinner item"+spinner.getSelectedItemPosition());
                /* Get selected item from spinner and add it to formDataMap */
            } else if (childView instanceof Button) {
                Button button = (Button) childView;
              formDataMap.put((String) button.getTag(),button.getText().toString());
                 System.out.println("button"+(String)button.getTag());
            /* Get selected item from spinner and add it to formDataMap */
          }
        else if (childView instanceof ImageView) {
            ImageView imageView = (ImageView) childView;
            Bitmap bitmap = imageView.getDrawingCache();
            if (!(bitmap==null)) {
                String encodedImage = EncodedImage.encodeImage(bitmap);
                formDataMap.put((String) imageView.getTag(),encodedImage);
            }else {
                Log.d("image","null bitmap");
               }
             }
        }
        return formDataMap;
    }
    public Spinner generateSpinner(String label, ArrayList<String> originallist, ArrayAdapter<String> adapter, AdapterView.OnItemSelectedListener selectedListener) {
       // genratetextview(label);

        Spinner spinner = new Spinner(context);
        LinearLayout.LayoutParams spinnerParams = new LinearLayout.LayoutParams(
                 ViewGroup.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, context.getResources().getDisplayMetrics())
                        );
        spinner.setTag(label);
        originallist.add(0, label); // Add selected item to the top

//
        spinner.setLayoutParams(spinnerParams);
        spinnerParams.setMargins(0, 20, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()), 20);
//
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
                            Toast.makeText(context, ""+selected, Toast.LENGTH_SHORT).show();
                           //// originallist.remove(selected); // Remove selected item from the list
                           // originallist.add(0, selected); // Add selected item to the top
                            //adapter.notifyDataSetChanged(); // Notify the adapter of the change
                            spinner.setSelection(originallist.indexOf(object)); // Set the selection to the top
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
        spinner.setBackground(context.getResources().getDrawable(R.drawable.btn_border));

        formLayout.addView(spinner);
        return spinner;
    }

    private  void generateCheckBox(String label) {
        CheckBox checkBox = new CheckBox(context);
        LinearLayout.LayoutParams checkparam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
         );
        checkparam.setMargins(0,15,0,15);
        checkBox.setLayoutParams(checkparam);

        // Apply bold style to the SpannableString
      //  spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
// Load the Cambria font from the assets folder
        Typeface arialTypeface = Typeface.create("georgia", Typeface.NORMAL);
        checkBox.setTypeface(arialTypeface);

//        Typeface cambriaTypeface = Typeface.createFromAsset( context.getAssets(), "Arial");

// Apply the Cambria font to your TextView or any other UI element
//        checkBox.setTypeface(cambriaTypeface);

        // Set the SpannableString as the text of the CheckBox
        checkBox.setText(" "+label);
//         checkBox.setText(" " +label);
        checkBox.setTag(label);


        checkBox.setPadding(0,6,0,0);
        checkBox.setTextSize(16);
       // checkBox.setBackground(ContextCompat.getDrawable(context, R.drawable.btn_border));

        formLayout.addView(checkBox);
    }

    private void genratetextview(String label){
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, context.getResources().getDisplayMetrics())
        );
        textView.setTextSize(16);
         textViewParams.setMargins(10,10,0,0);
        textView.setLayoutParams(textViewParams);
        textView.setText(label);

        textView.setPadding(5, 20, 0, 0);
        formLayout.addView(textView);
    }
    private int dpToPx(int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
        public void setimageashint(int image,View view){
        Drawable drawable = context.getResources().getDrawable(image);
// Calculate the scaled width and height in pixels
        int widthPx = dpToPx(30);
        int heightPx = dpToPx(30);

        drawable.setBounds(0, 0, widthPx, heightPx);
        if (view instanceof EditText)
        {
            ((EditText)view).setCompoundDrawables(drawable, null, null, null);

        } else if (view instanceof Button) {
            ((Button) view).setCompoundDrawables(drawable,null,null,null);

        } else if (view instanceof TextView) {
            ((TextView)view).setCompoundDrawables(drawable,null,null,null);
        }
    }
}