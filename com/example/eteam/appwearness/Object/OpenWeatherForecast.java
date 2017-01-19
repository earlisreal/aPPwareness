package com.example.eteam.appwearness.Object;

import com.example.eteam.appwearness.Object.OpenWeather.City;
import java.util.List;

public class OpenWeatherForecast {
    private City city;
    private int cnt;
    private String code;
    private List<OpenWeatherItem> list;
    private String message;

    public OpenWeatherForecast(String code, String message, City city, int cnt, List<OpenWeatherItem> list) {
        this.code = code;
        this.message = message;
        this.city = city;
        this.cnt = cnt;
        this.list = list;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCnt() {
        return this.cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<OpenWeatherItem> getList() {
        return this.list;
    }

    public void setList(List<OpenWeatherItem> list) {
        this.list = list;
    }
}
