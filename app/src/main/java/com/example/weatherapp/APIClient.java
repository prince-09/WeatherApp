package com.example.weatherapp;

import android.os.strictmode.NonSdkApiUsedViolation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL="http://api.openweathermap.org/data/2.5/";
    public static APIClient instance;
    private Retrofit retrofit;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();
    private APIClient(){

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized APIClient getInstance(){

        if(instance==null){
            instance=new APIClient();
        }
        return instance;
    }
    public APIInterface getApi(){
        return retrofit.create(APIInterface.class);
    }
}
