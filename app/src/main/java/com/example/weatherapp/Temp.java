package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Temp {
    @SerializedName("temp")
    float temp;

    @SerializedName("temp_min")
    float temp_min;

    @SerializedName("temp_max")
    float temp_max;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}
