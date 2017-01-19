package com.example.eteam.appwearness.Object;

import com.example.eteam.appwearness.Object.OpenWeather.Clouds;
import com.example.eteam.appwearness.Object.OpenWeather.Coord;
import com.example.eteam.appwearness.Object.OpenWeather.Main;
import com.example.eteam.appwearness.Object.OpenWeather.Rain;
import com.example.eteam.appwearness.Object.OpenWeather.Snow;
import com.example.eteam.appwearness.Object.OpenWeather.Sys;
import com.example.eteam.appwearness.Object.OpenWeather.Weather;
import com.example.eteam.appwearness.Object.OpenWeather.Wind;
import java.util.List;

public class OpenWeatherItem {
    private String base;
    private Clouds clouds;
    private String cod;
    private Coord coord;
    private String dt;
    private int id;
    private Main main;
    private String name;
    private Rain rain;
    private Snow snow;
    private Sys sys;
    private List<Weather> weather;
    private Wind wind;

    public OpenWeatherItem(Coord coord, List<Weather> weather, String base, Main main, Wind wind, Clouds clouds, Rain rain, Snow snow, String dt, Sys sys, int id, String name, String cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.rain = rain;
        this.snow = snow;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return this.main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return this.wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return this.rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return this.snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public String getDt() {
        return this.dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return this.sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
