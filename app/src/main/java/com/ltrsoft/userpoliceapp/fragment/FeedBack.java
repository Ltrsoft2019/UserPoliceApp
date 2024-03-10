package com.ltrsoft.userpoliceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.userpoliceapp.R;
import com.ltrsoft.userpoliceapp.ui.FormElement;
import com.ltrsoft.userpoliceapp.ui.FormGenerator;
import com.ltrsoft.userpoliceapp.utils.Validations;

import java.util.List;

public class FeedBack extends Fragment {
    private LinearLayout layout;
    private View view;
    private FormGenerator formGenerator;
    private List<FormElement> elements;

    private Button submit;
    private TextView heading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_form, container, false);
        layout = view.findViewById(R.id.layout123);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.button);
        heading.setText("Feedback");
        init(layout,submit);
        return view;
    }

    private void init(LinearLayout layout, Button submit) {
    }


}

