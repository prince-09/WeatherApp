package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    //coder=9a22b4363f3ef502d3ed1c52c9f48fb8
    //default=6eef6e4d32741b61f84430ba292b8fc3
    @GET("weather")
    Call<Stream> getWeather(
            @Query("q") String city,
            @Query("appid") String token
    );
}
