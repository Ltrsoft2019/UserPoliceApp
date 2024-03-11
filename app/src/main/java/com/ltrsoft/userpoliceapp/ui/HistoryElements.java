package com.ltrsoft.userpoliceapp.ui;

public class HistoryElements {
    public static final String TYPE_TEXTVIEW="text_view";
    public static final String TYPE_IMAGE_VIEW = "image_view";
    private String historylabel;
    private String value;
    private int image;
    private String type;


    public HistoryElements(String historylabel, String value, int image,String type) {
        this.historylabel = historylabel;
        this.value = value;
        this.image = image;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHistorylabel() {
        return historylabel;
    }

    public void setHistorylabel(String historylabel) {
        this.historylabel = historylabel;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
