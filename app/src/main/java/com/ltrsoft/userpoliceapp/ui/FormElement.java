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
    public static final String TYPE_RADIO_GROUP = "radiogroup";


    public static final String SUBTYPE_EMAIL = "email";
    public static final String SUBTYPE_NUMBER = "number";
    public static final String SUBTYPE_TEXT = "text";
    public static final String SYBTYPE_SPINNER_STATION = "stations";
    public static final String SYBTYPE_SEXT_TEXT = "stations";
    public static final String SUBTYPE_BUTTON_LOCATION= "location picker";
    public static final String SUBTYPE_BUTTON_DATEPICKER= "datepicker button";
    public static final String SUBTYPE_RADIO_YES_NO= "radigroup of yes or no";


    public static final String COUNTRY = "Select Country";
    public static final String STATION = "Select Station";

    public static final String STATE = "Select State";
    public static final String DISTRICT = "Select District";
    public static final String CITY = "selct city";
    private String label;
    private String type;
    private String subType;
    private int image;

    public FormElement(String label, String type, String subType, int image) {
        this.label = label;
        this.type = type;
        this.subType = subType;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<String> getOptions(String subtype) {
        if (subtype==SUBTYPE_RADIO_YES_NO){
            ArrayList<String>options = new ArrayList<>();
            options.add("Yes");
            options.add("No");
            return options;
        }else {
            ArrayList<String> gender_list = new ArrayList<>();
            gender_list.add("male");
            gender_list.add("female");
            gender_list.add("others");
            return gender_list;
        }
    }

}
