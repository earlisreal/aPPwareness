package com.example.eteam.appwearness.Object.OpenWeather;

import com.google.gson.annotations.SerializedName;

public class Rain {
    @SerializedName("3h")
    private double volume;

    public Rain(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
