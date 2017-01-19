package com.example.eteam.appwearness.Global;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    public static final String OPEN_WEATHER = "http://api.openweathermap.org/";
    public static final String OPEN_WEATHER_API = "393bc4bfc5a70aa31c7e571e825c5265";
    public static final String SERVER = "https://laravel-test.mybluemix.net/api/";
    public static final String TAG = "EARL IS REAL";

    public static Retrofit getClient(String baseUrl) {
        return new Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
