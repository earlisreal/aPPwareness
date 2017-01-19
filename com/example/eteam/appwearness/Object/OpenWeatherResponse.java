package com.example.eteam.appwearness.Object;

import java.util.List;

public class OpenWeatherResponse {
    private String cod;
    private int count;
    private List<OpenWeatherItem> list;
    private String message;

    public OpenWeatherResponse(String message, String cod, int count, List<OpenWeatherItem> list) {
        this.message = message;
        this.cod = cod;
        this.count = count;
        this.list = list;
    }

    public List<OpenWeatherItem> getList() {
        return this.list;
    }

    public void setList(List<OpenWeatherItem> list) {
        this.list = list;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
