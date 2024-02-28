package com.ltrsoft.userpoliceapp.model;

public class State {
    public static final String GETSTATE = "https://rj.ltr-soft.com/public/police_api/country/select_country.php";
    private String id,name,country_id;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

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
