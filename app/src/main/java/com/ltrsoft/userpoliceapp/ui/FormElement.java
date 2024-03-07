package com.ltrsoft.userpoliceapp.ui;

import java.util.ArrayList;
import java.util.List;

public class FormElement {

    public static final String TYPE_EDIT_TEXT = "edit_text";
    public static final String TYPE_IMAGE_VIEW = "image_view";
    public static final String TYPE_BUTTON = "button";
    public static final String TYPE_DATE_PICKER = "date_picker";
    public static final String TYPE_CHECKBOX = "checkbox";
    public static final String TYPE_SPINNER = "spinner";

    public static final String SUBTYPE_EMAIL = "email";
    public static final String SUBTYPE_NUMBER = "number";
    public static final String SUBTYPE_TEXT = "text";
    public static final String TYPE_RADIO_GROUP = "radiogroup";


    private String label;
    private String type;
    private String subType;


    public FormElement(String label, String type, String subType) {
        this.label = label;
        this.type = type;
        this.subType = subType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public List<String> getOptions() {
        ArrayList<String>gender_list = new ArrayList<>();
        gender_list.add("others");
        gender_list.add("male");
        gender_list.add("female");
        return gender_list;
    }
}
