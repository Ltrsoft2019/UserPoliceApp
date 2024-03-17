package com.ltrsoft.userpoliceapp.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.utils.ImagePicker;

import java.util.List;

public class HistoryGenerator {
    private Context context;
    private LinearLayout formLayout;
    private List<HistoryElements> historyElements;
    private Fragment fragment;

    public HistoryGenerator(List<HistoryElements> list, LinearLayout formLayout, Fragment fragment) {
        this.historyElements = list;
        this.formLayout = formLayout;
        this.context = formLayout .getContext();

        this.fragment = fragment;
    }
    public void generatecard(String label) {
         CardView cardView = new CardView(context);
        genratetextview(label +" :");

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(30, 20, 30, 20);
        cardView.setLayoutParams(layoutParams);
        cardView.setCardBackgroundColor(Color.WHITE);
        cardView.setRadius(15);
       // cardView.setContentPadding(20, 20, 20, 20);
        cardView.setCardElevation(2);
        //cardView.setBackgroundResource(R.drawable.history_border);

        LinearLayout linearLayout1 = new LinearLayout(context);
        linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));


        linearLayout1.setOrientation(LinearLayout.VERTICAL);

        for (HistoryElements element : historyElements) {
            switch (element.getType()) {
                case HistoryElements.TYPE_TEXTVIEW:
                    LinearLayout linearLayout2=new LinearLayout(context);
                    linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT
                            ,
                    ViewGroup.LayoutParams.WRAP_CONTENT


                    ));
                    linearLayout2.setBackgroundResource(R.drawable.history_border);


                    TextView textView = new TextView(context);
                    LinearLayout.LayoutParams textviewparams = new LinearLayout.LayoutParams(
                            0,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            1
                    );
                     textView.setText("   "+element.getHistorylabel() );
                    textView.setTextSize(18);
                    textviewparams.setMargins(0,0,0,15);
                     textView.setLayoutParams(textviewparams);
                    textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

                    textView.setPadding( 0, 15, 0, 17);
                    linearLayout2.addView(textView);

                    TextView textView1=new TextView(context);
                    LinearLayout.LayoutParams layoutParams1=new LinearLayout.LayoutParams(
                            0,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            1
                    );
                    textView1.setText(":   "+element.getValue());
                    layoutParams1.setMargins(0,0,0,17);
                     textView1.setTextSize(18);
                    textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

                    textView1.setLayoutParams(layoutParams1);
                    textView.setPadding( 0, 15, 0, 15);
                    linearLayout2.addView(textView1);
                    linearLayout1.addView(linearLayout2);

                    break;

            }
        }

       cardView.addView(linearLayout1);
        formLayout.addView(cardView);
    }

    public void generatehistoryform(){
        for (HistoryElements element:historyElements){
            switch (element.getType()){
                case HistoryElements.TYPE_TEXTVIEW:
                    generatetextview(element.getHistorylabel(),element.getImage(),element.getValue());
                     break;

                case FormElement.TYPE_IMAGE_VIEW:
                     generateImageViewhistory(element.getHistorylabel(),element.getImage(),element.getValue());
                     break;
            }
        }
    }

    private void generatetextview(String label, int image,String value) {
        genratetextview(label+" :");
        TextView textView=new TextView(context);
        LinearLayout.LayoutParams textviewparams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, context.getResources().getDisplayMetrics())

        );
        textviewparams.setMargins(50,0,50,0);
        textView.setTag(label);
        textView.setText("  "+value);
        textView.setTextSize(18);
        setimageashint(image,textView);
         textView.setBackgroundResource(R.drawable.history_border);
        textView.setLayoutParams(textviewparams);
        textView.setPadding(15,15,0,0);
       // textView.setBackgroundResource(R.drawable.btn_border);
        formLayout.addView(textView);


    }
    private void generateImageViewhistory(String label,int image,String value) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        Typeface arialTypeface = Typeface.create("georgia", Typeface.NORMAL);
        textView.setTypeface(arialTypeface);
        textView.setTextSize(18);
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

        formLayout.addView(imageView);


    }
    private void genratetextview(String label){
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, context.getResources().getDisplayMetrics())
        );
        textView.setTextSize(16);
        textViewParams.setMargins(40,10,0,0);
        textView.setLayoutParams(textViewParams);
        textView.setText(label);

        textView.setPadding(0, 20, 0, 0);
        formLayout.addView(textView);
    }
    private void genratetextviewoncard(String label ,CardView cardView){
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, context.getResources().getDisplayMetrics())
        );
        textView.setTextSize(16);
        textViewParams.setMargins(40,10,0,0);
        textView.setLayoutParams(textViewParams);
        textView.setText(label);

        textView.setPadding(0, 20, 0, 0);
        cardView.addView(textView);
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

// Scale the drawable
        drawable.setBounds(0, 0, widthPx, heightPx);
        if (view instanceof EditText)
        {
            ((EditText)view).setCompoundDrawables(drawable, null, null, null);

        } else if (view instanceof Button) {
            ((Button) view).setCompoundDrawables(drawable,null,null,null);

        } else if (view instanceof TextView) {
            ((TextView)view).setCompoundDrawables(drawable,null,null,null);
        }

// Set the compound drawable to the EditText

    }



}
