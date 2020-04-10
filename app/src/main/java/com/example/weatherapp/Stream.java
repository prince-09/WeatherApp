package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stream {
    @SerializedName("main")
    Temp temp;

    @SerializedName("weather")
    List<Weaher> weaher;

    public List<Weaher> getWeaher() {
        return weaher;
    }

    public void setWeaher(List<Weaher> weaher) {
        this.weaher = weaher;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }
}
