package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Weaher {
    @SerializedName("main")
    String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
