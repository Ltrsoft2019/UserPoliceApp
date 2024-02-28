package com.ltrsoft.userpoliceapp.model;

public class Country {
 public static final String GETCOUNTRY = "https://rj.ltr-soft.com/public/police_api/country/select_country.php";
    private String id,name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
