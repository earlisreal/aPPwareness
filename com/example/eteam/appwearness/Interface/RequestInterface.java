package com.example.eteam.appwearness.Interface;

import com.example.eteam.appwearness.Object.Device;
import com.example.eteam.appwearness.Object.OpenWeatherForecast;
import com.example.eteam.appwearness.Object.OpenWeatherItem;
import com.example.eteam.appwearness.Object.OpenWeatherResponse;
import com.example.eteam.appwearness.Object.Report;
import com.example.eteam.appwearness.Object.ReportResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("report")
    Call<ReportResponse> getFloodReports();

    @GET("data/2.5/forecast")
    Call<OpenWeatherForecast> getForecast(@Query("lat") double d, @Query("lon") double d2, @Query("APPID") String str);

    @GET("test")
    Call<String> getTest();

    @GET("data/2.5/find")
    Call<OpenWeatherResponse> getWeather(@Query("lat") double d, @Query("lon") double d2, @Query("cnt") int i, @Query("APPID") String str);

    @GET("testing/{id}")
    Call<Integer> postTest(@Path("id") int i);

    @POST("report/store")
    Call<Integer> reportFlood(@Body Report report);

    @POST("device/store")
    Call<Integer> store(@Body Device device);

    @GET("data/2.5/weather")
    Call<OpenWeatherItem> weatherFind(@Query("id") int i, @Query("APPID") String str);
}
